# Introduction

## Method Overloading

_Method overloading_ allows multiple methods in the same class to have the same name. Overloaded methods must be different from each other by either:

- The number of parameters
- The type of the parameters

There is no method overloading based on the return type.

The compiler will automatically infer which overloaded method to call based on the number of parameters and their type.

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
