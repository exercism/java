# About

Creating an instance of a _class_ is done by calling its [_constructor_][constructors] through the [`new` operator][new].
A constructor is a special type of method whose goal is to initialize a newly created instance.
Constructors look like regular methods, but without a return type and with a name that matches the class's name.

```java
class Library {
    private int books;

    public Library() {
        this.books = 10;
    }
}

// This will call the constructor
var library = new Library();
```

Like regular methods, constructors can have parameters.
Constructor parameters are usually stored as (private) [fields][fields] to be accessed later, or else used in some one-off calculation.
Arguments can be passed to constructors just like passing arguments to regular methods.

```java
class Building {
    private int numberOfStories;
    private int totalHeight;

    public Building(int numberOfStories, double storyHeight) {
        this.numberOfStories = numberOfStories;
        this.totalHeight = numberOfStories * storyHeight;
    }
}

// Call a constructor with two arguments
var largeBuilding = new Building(55, 6.2)
```

Specifying a constructor is optional.
If no constructor is specified, a parameterless constructor is generated by the compiler:

```java
class Elevator {
}

// This will call the (empty) generated constructor
var elevator = new Elevator();
```

If fields have an initial value assigned to them, the compiler will output code in which the assignment is actually done inside the constructor.
The following class declarations are thus equivalent (functionality-wise):

```java
class UsingFieldInitialization {
    private int players = 5;
}

class UsingConstructorInitialization {
    private int players;

    public UsingConstructorInitialization() {
        players = 5;
    }
}
```

[constructors]: https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
[new]: https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html
[fields]: https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
