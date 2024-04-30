import java.lang.reflect.*;

import static java.lang.Class.forName;

/**
 * This is a helper class to be able to run the tests for this exercise.
 * The tests are located in the {@link GameMasterTest} class.
 * @see GameMasterTest
 */
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
     * The default constructor, for when you have already an instance of the target class
     *
     * @param target An instance of the target class
     */
    protected ReflectionProxy(Object target) {
        this.target = target;
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
            throw new UnsupportedOperationException();
        }
        try {
            try {
                // getDeclaredMethod is used to get protected/private methods
                Method method = target.getClass().getDeclaredMethod(methodName, parameterTypes);
                method.setAccessible(true);
                return (T) method.invoke(target, parameterValues);
            } catch (NoSuchMethodException e) {
                // try getting it from parent class, but only public methods will work
                Method method = target.getClass().getMethod(methodName, parameterTypes);
                method.setAccessible(true);
                return (T) method.invoke(target, parameterValues);
            }
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
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


    //region Unused

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
     * Checks if the target class exists
     *
     * @return True if the class exists, false otherwise
     */
    public boolean existsClass() {
        return getTargetClass() != null;
    }

    /**
     * Checks if the class implements a specific interface
     *
     * @param anInterface The interface to check
     * @return True if the class implements the referred interface, false otherwise
     */
    public boolean implementsInterface(Class<?> anInterface) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null || anInterface == null) {
            return false;
        }
        return anInterface.isAssignableFrom(targetClass);
    }

    /**
     * Checks if the target class has a specific property
     *
     * @param name The name of the property to find
     * @return True if the property is found, false otherwise
     */
    public boolean hasProperty(String name) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null || name == null) {
            return false;
        }
        try {
            Field f = targetClass.getDeclaredField(name);
            return f != null;
        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    /**
     * Checks if an existing property has the type we expect
     *
     * @param name The name of the property to check
     * @param type The type you are expecting the property to be
     * @return True if the property is found and has the specified type, false otherwise
     */
    public boolean isPropertyOfType(String name, Class<?> type) {
        return isPropertyOfType(name, type, null);
    }

    /**
     * Checks if an existing Collection type has the parameterized type (Generics) as expected (eg. List<String>)
     *
     * @param name              The name of the property
     * @param type              The type of the property (eg. List)
     * @param parameterizedType The parameterized property (eg. String)
     * @return True if the parameterized type matches the desired type, false otherwise
     */
    public boolean isPropertyOfType(String name, Class<?> type, Class<?> parameterizedType) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null || name == null || type == null) {
            return false;
        }
        try {
            Field f = targetClass.getDeclaredField(name);
            if (!f.getType().equals(type)) {
                return false;
            }
            if (parameterizedType == null) {
                return true;
            }
            if (!(f.getGenericType() instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType pType = (ParameterizedType) f.getGenericType();
            return pType.getActualTypeArguments()[0].equals(parameterizedType);

        } catch (NoSuchFieldException e) {
            return false;
        }
    }

    /**
     * Checks if a property is private
     *
     * @param name The name of the property
     * @return True if the property exists and is private, false otherwise
     */
    public boolean isPropertyPrivate(String name) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null || name == null) {
            return false;
        }
        try {
            Field f = targetClass.getDeclaredField(name);
            return Modifier.isPrivate(f.getModifiers());
        } catch (NoSuchFieldException e) {
            return false;
        }
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
     * Checks if a target class has a specific constructor
     *
     * @param parameterTypes The list of desired parameter types
     * @return True if the constructor exists, false otherwise
     */
    public boolean hasConstructor(Class<?>... parameterTypes) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null) {
            return false;
        }
        try {
            Constructor<?> c = targetClass.getDeclaredConstructor(parameterTypes);
            return c != null;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    /**
     * Checks if a specific constructor from the target class is public
     *
     * @param parameterTypes A list of parameter types
     * @return True if the constructor is found and is public, false otherwise
     */
    public boolean isConstructorPublic(Class<?>... parameterTypes) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null) {
            return false;
        }
        try {
            Constructor<?> c = targetClass.getDeclaredConstructor(parameterTypes);
            return Modifier.isPublic(c.getModifiers());
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

    /**
     * Gets a property value from the target instance (if it exists)
     *
     * @param propertyName The name of the property
     * @param <T>          The type we are expecting it to be
     * @return The value of the property (if it exists)
     */
    protected <T> T getPropertyValue(String propertyName) {
        if (target == null || !hasProperty(propertyName)) {
            return null;
        }
        try {
            Field field = target.getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            return (T) field.get(target);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Checks if the target class is abstract
     *
     * @return True if the target class exists and is abstract, false otherwise
     */
    public boolean isAbstract() {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null) {
            return false;
        }
        return Modifier.isAbstract(targetClass.getModifiers());
    }

    /**
     * Checks if the target class extends another
     *
     * @param className The fully qualified name of the class it should extend
     * @return True if the target class extends the specified one, false otherwise
     */
    public boolean extendsClass(String className) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null) {
            return false;
        }
        try {
            Class<?> parentClass = Class.forName(className);
            return parentClass.isAssignableFrom(targetClass);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /**
     * Checks if the target class is an interface
     *
     * @return True if the target class exists and is an interface, false otherwise
     */
    public boolean isInterface() {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null) {
            return false;
        }
        return targetClass.isInterface();
    }

    /**
     * Checks if a method is abstract
     *
     * @param name           The name of the method
     * @param parameterTypes The list of method parameter types
     * @return True if the method exists and is abstract, false otherwise
     */
    public boolean isMethodAbstract(String name, Class<?>... parameterTypes) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null || name == null) {
            return false;
        }
        try {
            Method m = targetClass.getDeclaredMethod(name, parameterTypes);
            return Modifier.isAbstract(m.getModifiers());
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    /**
     * Checks if a method is protected
     *
     * @param name           The name of the method
     * @param parameterTypes The list of method parameter types
     * @return True if the method exists and is protected, false otherwise
     */
    public boolean isMethodProtected(String name, Class<?>... parameterTypes) {
        Class<?> targetClass = getTargetClass();
        if (targetClass == null || name == null) {
            return false;
        }
        try {
            Method m = targetClass.getDeclaredMethod(name, parameterTypes);
            return Modifier.isProtected(m.getModifiers());
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    //endregion
}
