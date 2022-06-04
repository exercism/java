# Elon's Toy Car

Welcome to Elon's Toy Car on Exercism's Java Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

The primary object-oriented construct in Java is the _class_, which is a combination of data (_fields_) and behavior (_methods_). The fields and methods of a class are known as its _members_.

Access to members can be controlled through access modifiers, the two most common ones being:

- `public`: the member can be accessed by any code (no restrictions).
- `private`: the member can only be accessed by code in the same class.

You can think of a class as a template for creating instances of that class. To create an instance of a class (also known as an _object_), the `new` keyword is used:

```java
class Car {
}

// Create two car instances
Car myCar = new Car();
Car yourCar = new Car();
```

Fields have a type and a name (defined in camelCase) and can be defined anywhere in a class (by convention cased in PascalCase):

```java
class Car {
    // Accessible by anyone
    public int weight;

    // Only accessible by code in this class
    private String color;
}
```

One can optionally assign an initial value to a field. If a field does _not_ specify an initial value, it wll be set to its type's default value. An instance's field values can be accessed and updated using dot-notation.

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

Private fields are usually updated as a side effect of calling a method. Such methods usually don't return any value, in which case the return type should be `void`:

```java
class CarImporter {
    private int carsImported;

    public void ImportCars(int numberOfCars)
    {
        // Update private field from public method
        carsImported = carsImported + numberOfCars;
    }
}
```

## Instructions

In this exercise you'll be playing around with a remote controlled car, which you've finally saved enough money for to buy.

Cars start with full (100%) batteries. Each time you drive the car using the remote control, it covers 20 meters and drains one percent of the battery.

The remote controlled car has a fancy LED display that shows two bits of information:

- The total distance it has driven, displayed as: `"Driven <METERS> meters"`.
- The remaining battery charge, displayed as: `"Battery at <PERCENTAGE>%"`.

If the battery is at 0%, you can't drive the car anymore and the battery display will show `"Battery empty"`.

You have six tasks, each of which will work with remote controlled car instances.

## 1. Buy a brand-new remote controlled car

Implement the (_static_) `ElonsToyCar.buy()` method to return a brand-new remote controlled car instance:

```java
ElonsToyCar car = ElonsToyCar.buy();
```

## 2. Display the distance driven

Implement the `ElonsToyCar.distanceDisplay()` method to return the distance as displayed on the LED display:

```java
ElonsToyCar car = ElonsToyCar.buy();
car.distanceDisplay();
// => "Driven 0 meters"
```

## 3. Display the battery percentage

Implement the `ElonsToyCar.batteryDisplay()` method to return the battery percentage as displayed on the LED display:

```java
ElonsToyCar car = ElonsToyCar.buy();
car.batteryDisplay();
// => "Battery at 100%"
```

## 4. Update the number of meters driven when driving

Implement the `ElonsToyCar.drive()` method that updates the number of meters driven:

```java
ElonsToyCar car = ElonsToyCar.buy();
car.drive();
car.drive();
car.distanceDisplay();
// => "Driven 40 meters"
```

## 5. Update the battery percentage when driving

Update the `ElonsToyCar.drive()` method to update the battery percentage:

```java
ElonsToyCar car = ElonsToyCar.buy();
car.drive();
car.drive();
car.batteryDisplay();
// => "Battery at 98%"
```

## 6. Prevent driving when the battery is drained

Update the `ElonsToyCar.drive()` method to not increase the distance driven nor decrease the battery percentage when the battery is drained (at 0%):

```java
ElonsToyCar car = ElonsToyCar.buy();

// Drain the battery
// ...

car.distanceDisplay();
// => "Driven 2000 meters"

car.batteryDisplay();
// => "Battery empty"
```

## Source

### Created by

- @mikedamay

### Contributed to by

- @mirkoperillo