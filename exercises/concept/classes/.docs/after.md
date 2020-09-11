The primary object-oriented construct in Java is the _class_, which is a combination of data ([_fields_][fields]), also known as instance variables, and behavior ([_methods_][methods]). The fields and methods of a class are known as its _members_.

Access to members can be controlled through access modifiers, the two most common ones being:

- [`public`][public]: the member can be accessed by any code (no restrictions).
- [`private`][private]: the member can only be accessed by code in the same class.

In Java if no access modifier is specified, the default is _package visibility_. In this case, the member is visible to all classes defined into the same package.

The above-mentioned grouping of related data and behavior plus restricting access to members is known as [_encapsulation_][encapsulation], which is one of the core object-oriented concepts.

You can think of a class as a template for creating instances of that class. To [create an instance of a class][creating-objects] (also known as an _object_), the [`new` keyword][new] is used:

```java
class Car {
}

// Create two car instances
Car myCar = new Car();
Car yourCar = new Car();
```

[Fields][fields] have a type and a name (cased in [camelCase][camel-case]) and can be defined anywhere in a class (cased in [PascalCase][pascal-case]).

```java
class Car {
    // Accessible by anyone
    public int weight;

    // Only accessible by code in this class
    private String color;
}
```

One can optionally assign an initial value to a field. If a field does _not_ specify an initial value, it will be set to its type's [default value][default-values]. An instance's field values can be accessed and updated using dot-notation.

```java
class Car {
    // Will be set to specified value
    public int weight = 2500;

    // Will be set to default value (0)
    public int year;
}

Car newCar = new Car();
newCar.weight; // => 2500
newCar.year;   // => 0

// Update value of the field
newCar.year = 2018;
```

Private fields are usually updated as a side effect of calling a method. Such methods usually don't return any value, in which case the return type should be [`void`][void]:

```java
class CarImporter {
    private int carsImported;

    public void ImportCars(int numberOfCars)
    {
        // Update private field
        carsImported = carsImported + numberOfCars;
    }
}
```

Note that is not customary to use public fields in Java classes. Private fields are typically used which are accessed through [_getters_ and _setters_][so-getters-setters].

Within a class, the [`this` keyword][this] will refer to the current class. This is especially useful if a parameter has the same name as a field:

```java
class CarImporter {
    private int carsImported;

    public void SetImportedCars(int carsImported)
    {
        // Update private field from public method
        this.carsImported = carsImported;
    }
}
```

[fields]: https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html
[methods]: https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
[this]: https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
[new]: https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html
[void]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/void
[creating-objects]: https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html
[public]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/public
[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[default-values]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
[camel-case]: https://techterms.com/definition/camelcase
[pascal-case]: https://techterms.com/definition/pascalcase
[encapsulation]: https://en.wikipedia.org/wiki/Encapsulation_(computer_programming)
[so-getters-setters]: https://stackoverflow.com/questions/2036970/how-do-getters-and-setters-work
