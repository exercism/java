# Introduction

Creating an instance of a _class_ is done by calling its _constructor_ through the `new` operator. A constructor is a special type of method whose goal is to initialize a newly created instance. Constructors look like regular methods, but without a return type and with a name that matches the classes' name.

```java
class Library {
    private int books;

    public Library() {
        // Initialize the books field
        this.books = 10;
    }
}

// This will call the constructor
var library = new Library();
```

Like regular methods, constructors can have parameters. Constructor parameters are usually stored as (private) fields to be accessed later, or else used in some one-off calculation. Arguments can be passed to constructors just like passing arguments to regular methods.

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
var largeBuilding = new Building(55, 6.2);
```
