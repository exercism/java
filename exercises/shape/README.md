# Shape
For this assignment, you will need to implement some classes that represent geometric figures like Rectangle, Square, Oval, and so on.  All these classes will play a role of drawable, in other words, they will all implement a method draw defined inside the interface Drawable.
In the source code, you will only have the class Paint (class with main method) and the class DrawWindows that allows to draw a Drawable in a windows/ panel. You will create the other classes respecting the given names and some other instructions.  In addition, you will use the class Graphics from API Java, you can consult the documentation here  **[http://download.oracle.com/javase/1.5.0/docs/api/java/awt/Graphics.html](http://download.oracle.com/javase/1.5.0/docs/api/java/awt/Graphics.html)**
Only the three-fallowing method are allowed:
- ```setColor(Color c)``` : a specific zone in the graphic will be set to color c. 
- ```drawLine(int x1, int y1, int x2, int y2)``` : paint a line
- ```drawOval(int x, int y, int width, int height)```: paint an oval
You will also use the class Color,  you can consult the documentation here **[http://download.oracle.com/javase/1.5.0/docs/api/java/awt/Color.html](http://download.oracle.com/javase/1.5.0/docs/api/java/awt/Color.html)**
As you can see, these classes are accessible in the java API, in other words, do not forget those statements **import** the package **java.awt.Graphics** and **java.awt.Color** when you use them. 
### Instructions
For all the following classes, you will create the globals atributes,  feel free to use them outside the class but you need to create the methods get and set, also you will need to create the construtor of the calass (more than one if you want).
### Drawable
Write the interface **Drawable.java** , declare a method whit the fallowing signature,  
```
public void draw(Graphics g)
  ```
  when you have a shape that implement this interface you can use like this:
    ```Drawable rectangle = new Rectangle(...);```
(see hint 1 if needed)  
### DrawWindows
The class **DrawWindows.java** is completed, you can see the code and modify if you want after submission of your solution. This class will allow to draw a Drawable in a small windows/panel of size 550x550. You can draw a shape like this.
```DrawWindows panel = new DrawWindows(rectangle);// rectangle is a Drawable```
In this window, the coordinate system is: (0, 0) is in the upper left corner, the abscissa is increasing from left to right and the ordinate is increasing from top to bottom. 
### Rectangle
Write a class **Rectangle.java**  that will implement the interface Drawable, you can create as many constructors as you which, but one of them will have the following signature: 
```
public Rectangle(int x0, int y0, int x1, int y1, int height)
```
where x0, y0, x1, y1 are the coordinates x0, y0, x1, y1 respectively in the described coordinate system and height is the height of the rectangle.   

#### Square
Write the class **Square.java** that will extends from Rectangle you can create as many constructors as you which, but one of them will have the following signature: 
```
public Square(int x0, int y0, int x1, int y1)
```
where x0, y0, x1, y1 are the coordinates x0, y0, x1, y1 respectively in the described  coordinate system. There is another constructor that have only three parameters, try to find it.
(see hint 2 if needed)

### Triangle
Write the class **Triangle.java**  that will implement the interface Drawable, you can create as many constructors as you which, but one of them will have the following signature: 

```
public Triangle(int x0,int y0, int x1,int y1, int x2,int y2 ){}

```
#### Triangle Equilateral
Write the class **Triangle_Equilateral.java** that will extends from Triangle, you can create as many constructors as you which, but one of them will have the following signature: 
```
public Triangle_Equilateral(int x0, int y0, int x1){ ... }
```
where x0, y0, x1 are the coordinates x0, y0, x1 respectively in the described coordinate system.  
(see hint 2 if needed)
### Oval
Write the class **Oval.java**  that will implement the interface Drawable, you can create as many constructors as you which, but one of them will have the following signature: 
```
public Oval(int originX, int originY, int diameter1, int diameter2){...}
```
see the class Graphics of API java. 

### Line
Write the class **Line.java** that will implement the interface Drawable, you can create as many constructors as you which, but one of them will have the following signature: 
```
public Line(int x0, int y0, int x1, int y1){...}
```
where x0, y0, x1, y1 are the coordinates x0, y0, x1, y1 respectively in the described  coordinate system.  

### Paint
This is a given class **Paint.java** you have an example that allows to paint a simple Triangle (you will not be able to run this class until you create the class Triangle).  Here you will also fill in the body of the following method
```
public Drawable[] painting(){...}
```
that will create an array of “Drawable”, this will allow to draw a list of different shapes when you iterate in this array.
## Extra
Write the class **Cubism_PP.java** that will implement the interface Drawable in this class you will use any type of shape that you’ve previously created, all the shapes will be in one windows/panel. 
Create your own classes that implements **Drawable** and be imaginative, create the class **Mandala.java**, or other classes with your abstract art. 
## Hint
1. When you implement the method
    ```
    public void draw(Graphics g){...}
    ```
    in each class, use only the allowed methods of the class **Graphics** , you can can also change the color of the shape using the class **Color**. Remeber **import** the package **java.awt.Graphics** and **java.awt.Color** when you use these classes.  


2. Use the keyword “super” when you use heritage.

# Tips

Since this exercise has difficulty 5 it doesn't come with any starter implementation.
This is so that you get to practice creating classes and methods which is an important part of programming in Java.
It does mean that when you first try to run the tests, they won't compile.
They will give you an error similar to:
```
 path-to-exercism-dir\exercism\java\name-of-exercise\src\test\java\ExerciseClassNameTest.java:14: error: cannot find symbol
        ExerciseClassName exerciseClassName = new ExerciseClassName();
        ^
 symbol:   class ExerciseClassName
 location: class ExerciseClassNameTest
```
This error occurs because the test refers to a class that hasn't been created yet (`ExerciseClassName`).
To resolve the error you need to add a file matching the class name in the error to the `src/main/java` directory.
For example, for the error above you would add a file called `ExerciseClassName.java`.

When you try to run the tests again you will get slightly different errors.
You might get an error similar to:
```
  constructor ExerciseClassName in class ExerciseClassName cannot be applied to given types;
        ExerciseClassName exerciseClassName = new ExerciseClassName("some argument");
                                              ^
  required: no arguments
  found: String
  reason: actual and formal argument lists differ in length
```
This error means that you need to add a [constructor](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html) to your new class.
If you don't add a constructor, Java will add a default one for you.
This default constructor takes no arguments.
So if the tests expect your class to have a constructor which takes arguments, then you need to create this constructor yourself.
In the example above you could add:
```
ExerciseClassName(String input) {...}
``` 
That should make the error go away, though you might need to add some more code to your constructor to make the test pass!

You might also get an error similar to:
```
  error: cannot find symbol
        assertEquals(expectedOutput, exerciseClassName.someMethod());
                                                       ^
  symbol:   method someMethod()
  location: variable exerciseClassName of type ExerciseClassName
```
This error means that you need to add a method called `someMethod` to your new class.
In the example above you would add:
```
String someMethod() {
  return "";
}
```
Make sure the return type matches what the test is expecting.
You can find out which return type it should have by looking at the type of object it's being compared to in the tests.
Or you could set your method to return some random type (e.g. `void`), and run the tests again.
The new error should tell you which type it's expecting.

After having resolved these errors you should be ready to start making the tests pass!


## Setup

Go through the setup instructions for Java to install the necessary
dependencies:

[https://exercism.io/tracks/java/installation](https://exercism.io/tracks/java/installation)

# Running the tests

You can run all the tests for an exercise by entering the following in your
terminal:

```sh
$ gradle test
```

> Use `gradlew.bat` if you're on Windows

In the test suites all tests but the first have been skipped.

Once you get a test passing, you can enable the next one by removing the
`@Ignore("Remove to run test")` annotation.

# Visualize your shapes
When you run the test(s),  the windows/panel with your shape will close quickly, in order to visualize it an extra time , you can use the sleep method created inside the **Shape.java** you need only to modify the global attribute.

`private boolean use = true;` // if use == true you are using the method sleep if use == false you are not using it, change as you need it.
`private int second= 2;` // how many seconds the sleep will wait. In others words you will visualize the windows with you shape "x" seconds, only if use == true, change as you need it . (In this example, you will see the windows during 2 sec). 

# Visualize your shapes
When you run the test(s),  the windows/panel with your shape will close quickly, in order to visualize it an extra time , you can use the sleep method created inside the **Shape.java** you need only to modify the global attribute.

`private boolean use = true;` // if use == true you are using the method sleep if use == false you are not using it, change as you need it.
`private int second= 2;` // how many seconds the sleep will wait. In others words you will visualize the windows with you shape "x" seconds, only if use == true, change as you need it . (In this exemple, you will see the windows during 2 sec).


## Source

Jumpstart Lab Warm-up [http://jumpstartlab.com](http://jumpstartlab.com)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.