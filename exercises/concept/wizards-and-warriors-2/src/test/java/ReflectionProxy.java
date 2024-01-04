import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;

import static java.lang.Class.forName;

public abstract class ReflectionProxy {

    /**
     * An instance of the target class (if found)
     */
    private final Object target;

    /**
     * A constructor to instantiate the target class with parameters
     *
     * @param args An array of parameters matching the constructor from the target class
     */
    protected ReflectionProxy(Object... args) {
        this.target = instantiateTarget(args);
    }

    /**
     * Abstract method that defines the fully qualified name of the target class
     *
     * @return The fully qualified name of the target class
     */
    public abstract String getTargetClassName();

    /**
     * Getter for the target instance
     *
     * @return The target instance
     */
    public Object getTarget() {
        return target;
    }

    /**
     * Gets the target class
     *
     * @return The target class if it exists, null otherwise
     */
    public Class<?> getTargetClass() {
        try {
            return forName(this.getTargetClassName());
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /**
     * Checks if the target class has a specific method
     *
     * @param name           The name of the method to find
     * @param parameterTypes The list of parameter types
     * @return True if the method is found, false otherwise
     */
    public boolean hasMethod(String name, Class<?>... parameterTypes) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null || name == null) {
            return false;
        }
        try {
            Method m = targetClass.getDeclaredMethod(name, parameterTypes);
            return m != null;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }


    /**
     * Checks if a method from the target class is public
     *
     * @param name           The name of the method
     * @param parameterTypes A list of method parameters
     * @return True if the method exists and is public, false otherwise
     */
    public boolean isMethodPublic(String name, Class<?>... parameterTypes) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null || name == null) {
            return false;
        }
        try {
            Method m = targetClass.getDeclaredMethod(name, parameterTypes);
            return Modifier.isPublic(m.getModifiers());
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    /**
     * Checks if a method from the target class returns the correct type
     *
     * @param returnType     The type of return value
     * @param name           The name of the method
     * @param parameterTypes The list of method parameters
     * @return
     */
    public boolean isMethodReturnType(Class<?> returnType, String name, Class<?>... parameterTypes) {
        return isMethodReturnType(returnType, null, name, parameterTypes);
    }

    /**
     * Invokes a method from the target instance
     *
     * @param methodName      The name of the method
     * @param parameterTypes  The list of parameter types
     * @param parameterValues The list with values for the method parameters
     * @param <T>             The result type we expect the method to be
     * @return The value returned by the method
     */
    protected <T> T invokeMethod(String methodName, Class<?>[] parameterTypes, Object... parameterValues) {
        if (target == null) {
            return null;
        }
        try {
            // getDeclaredMethod is used to get protected/private methods
            Method method = target.getClass().getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return (T) method.invoke(target, parameterValues);
        } catch (NoSuchMethodException e) {
            try {
                // try getting it from parent class, but only public methods will work
                Method method = target.getClass().getMethod(methodName, parameterTypes);
                method.setAccessible(true);
                return (T) method.invoke(target, parameterValues);
            } catch (Exception ex) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Creates an instance of the target class
     *
     * @param args The list of constructor parameters
     * @return An instance of the target class, if found, or null otherwise
     */
    private Object instantiateTarget(Object... args) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null) {
            return null;
        }
        Constructor<?>[] constructors = getAllConstructors();
        for (Constructor<?> c : constructors) {
            if (c.getParameterCount() == args.length) {
                try {
                    return c.newInstance(args);
                } catch (Exception e) {
                    // do nothing;
                }
            }
        }
        return null;
    }

    /**
     * Gets a list with all the constructors defined by the target class
     *
     * @return A list with all constructor definitions
     */
    private Constructor<?>[] getAllConstructors() {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null) {
            return new Constructor<?>[]{};
        }
        return targetClass.getConstructors();
    }

    /**
     * Checks if a method from the target class returns a correct parameterized collection (Generics)
     *
     * @param returnType        The return type we expect (eg. List)
     * @param parameterizedType The parameterized type we expect (eg. String)
     * @param name              The name of the method
     * @param parameterTypes    A list of method parameter types
     * @return True if the method returns the correct parameterized collection, false otherwise
     */
    public boolean isMethodReturnType(Class<?> returnType, Class<?> parameterizedType,
                                      String name, Class<?>... parameterTypes) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null || name == null) {
            return false;
        }
        try {
            Method m = targetClass.getDeclaredMethod(name, parameterTypes);
            if (!m.getReturnType().equals(returnType)) {
                return false;
            }
            if (parameterizedType == null) {
                return true;
            }
            if (!(m.getGenericReturnType() instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType pType = (ParameterizedType) m.getGenericReturnType();
            return pType.getActualTypeArguments()[0].equals(parameterizedType);
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    /**
     * Proxy for the 'equals' method
     *
     * @param obj The ReflexionProxy object you want to compare against
     * @return True if both targets are equal, false otherwise
     */
    public boolean equals(Object obj) {
        if (target == null || !(obj instanceof ReflectionProxy)) {
            return false;
        }
        try {
            Method method = target.getClass().getMethod("equals", Object.class);
            method.setAccessible(true);
            return (boolean) method.invoke(target, ((ReflectionProxy) obj).getTarget());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Proxy for the 'hashCode' method
     *
     * @return The hashCode from the target class
     */
    public int hashCode() {
        if (target == null) {
            return 0;
        }
        try {
            Method method = target.getClass().getMethod("hashCode");
            method.setAccessible(true);
            return (int) method.invoke(target);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Proxy for the 'toString' method from the target class
     *
     * @return The result of 'toString' from the target instance
     */
    public String toString() {
        return invokeMethod("toString", new Class[]{});
    }

}
