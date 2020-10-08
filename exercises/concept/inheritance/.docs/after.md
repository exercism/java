## Inheritance

Java supports inheritance as it's core functionality and then to achieve a lot of OOPs principles like abstraction using
inheritance.

A class can extend another class using `extends` keyword and can inherit from an interface using `implements` keywords.

## Access Modifiers

The access modifiers define rules for the member variables of a class about their access from another classes(or anywhere in
the code).

There are mainly three access modifiers:

- private
- public
- protected
- Default (No keyword required)

You can read more about them [here][access-modifiers]

## Inheritance vs Composition

These concepts are very similar and are often confused.

- Inheritance means that the child has IS-A relationship with the parent class.

```java
interface Animal() {
    public void bark();
}

class Dog implements Animal {
    public void bark() {
        System.out.println("Bark");
    }
}
```

Here, `Dog` IS-A `Animal`

- Composition represents a HAS-A relationship.

```java
interface Engine {

}

class Car {
    private Engine engine;
}
```

Here, `Car` HAS-A `Engine`

[access-modifiers]: https://www.geeksforgeeks.org/access-modifiers-java/
