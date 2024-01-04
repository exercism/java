# Introduction

## Method Overloading

In Java, method overloading is a feature that allows a class to have more than one method having the same name, if their
parameter lists are different.
It is related to compile-time (or static) polymorphism.
This concept is crucial for
creating methods that perform similar tasks but with different inputs.

### Why Overload Methods?

Method overloading increases the readability of the program.
Different methods can be given the same name but with
different parameters.
Depending on the number of parameters or the type of parameters, the corresponding method is called.

### How to Overload Methods?

The key to method overloading is a method's signature.
Two methods will be considered different if they have different signatures.
There are two ways to overload a method:

1. **Different Number of Parameters**: Methods can have the same name but a different number of parameters.

   ```java
   public class Display {

       public void show(int x) {
           System.out.println("Show with int: " + x);
       }

       public void show(int x, int y) {
           System.out.println("Show with two ints: " + x + ", " + y);
       }
   }
   ```

2. **Different Types of Parameters**: Methods can have the same name and the same number of parameters but with
   different types.

   ```java
   public class Display {

       public void show(int x) {
           System.out.println("Show with int: " + x);
       }

       public void show(String s) {
           System.out.println("Show with String: " + s);
       }
   }
   ```

### Points to Remember

- Overloaded methods must change the argument list.
- Overloaded methods can also change the return type, but merely changing the return type does not constitute method
  overloading.
- Methods can be overloaded in the same class or in a subclass.

In this concept, we will explore various examples and nuances of method overloading in Java.
