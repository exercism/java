# Introduction

Inheritance lets one class build on top of another, reusing its fields and methods without rewriting them.
The class being extended is called the **parent** (or superclass); the class doing the extending is the **child** (or subclass).
The relationship is described as IS-A: a `Dog` IS-A `Animal`.

```java
public class Animal {
    public void makeSound() {
        System.out.println("...");
    }
}
```

Use the `extends` keyword to inherit from a class:

```java
public class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
```

~~~~exercism/note
The `@Override` annotation tells the compiler that you intend to replace a parent method.
It's not required, but it's considered good practice — the compiler will warn you if the method name doesn't actually match anything in the parent.
~~~~

Because `Dog` extends `Animal`, a `Dog` instance can be stored in an `Animal` variable.
The actual type at runtime decides which method runs — this is called **polymorphism**:

```java
Animal animal = new Dog();
animal.makeSound(); // prints "Woof!", not "..."
```

## The `super` keyword

Inside a child class, `super` refers to the parent.
You can use it to call the parent's constructor or a method you've overridden:

```java
public class Dog extends Animal {
    private String name;

    public Dog(String name) {
        super(); // calls Animal's constructor
        this.name = name;
    }

    @Override
    public void makeSound() {
        super.makeSound(); // calls Animal's version first
        System.out.println(name + " says: Woof!");
    }
}
```

## Abstract classes

If it doesn't make sense to instantiate the parent directly, mark it `abstract`.
An abstract class can declare methods without providing a body — each subclass is then required to implement them:

```java
public abstract class Shape {
    public abstract double area(); // subclasses must implement this
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
```

To read more about inheritance in Java, see the [official documentation][java-inheritance].

[java-inheritance]: https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
