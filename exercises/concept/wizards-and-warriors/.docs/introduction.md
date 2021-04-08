# Introduction

Inheritance is a core concept in OOP (Object Oriented Programming). It donates IS-A relationship.
It literally means in programming as it means in english, inheriting features from parent(in programming features is normally functions
and variables).

Consider a class, `Animal` as shown,

```java
//Creating an Animal class with bark() as a member function.
public class Animal {

    public void bark() {
        System.out.println("This is a animal");
    }

}
```

`Animal` is a parent class, because the properties this class has can be extended to all the animals in general.

Consider an animal named `Lion`, having a class like,

```java
//Lion class is a child class of Animal.
public class Lion extends Animal {

    public void bark() {
        System.out.println("Lion here!!");
    }

}
```

Now whenever we do,

```java
Animal animal = new Lion(); //creating instance of Animal, of type Lion
animal.bark();
```

Note: Initialising the `Animal` class with `Lion`.
The output will look like

```java
Lion here!!
```

According to OOP, there are many types of inheritance, but Java supports only some of them(Multi-level and Hierarchical).
To read more about it, please read [this][java-inheritance].

[java-inheritance]: https://www.javatpoint.com/inheritance-in-java#:~:text=On%20the%20basis%20of%20class,will%20learn%20about%20interfaces%20later.
