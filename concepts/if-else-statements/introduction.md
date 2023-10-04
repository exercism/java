# Introduction

## The _if-then_ statement

The most basic control flow statement in Java is the _if-then_ statement.
This statement is used to only execute a section of code if a particular condition is `true`.
An _if-then_ statement is defined using the `if` clause:

```java
class Car {
    void drive() {
        // the "if" clause: the car needs to have fuel left to drive
        if (fuel > 0) {
            // the "then" clause: the car drives, consuming fuel
            fuel--;
        }
    }
}
```

In the above example, if the car is out of fuel, calling the `Car.drive` method will do nothing.

## The _if-then-else_ statement

The _if-then-else_ statement provides an alternative path of execution for when the condition in the `if` clause evaluates to `false`.
This alternative path of execution follows an `if` clause and is defined using the `else` clause:

```java
class Car {
    void drive() {
        if (fuel > 0) {
            fuel--;
        } else {
            stop();
        }
    }
}
```

In the above example, if the car is out of fuel, calling the `Car.drive` method will call another method to stop the car.

The _if-then-else_ statement also supports multiple conditions by using the `else if` clause:

```java
class Car {
    void drive() {
        if (fuel > 5) {
            fuel--;
        } else if (fuel > 0) {
            turnOnFuelLight();
            fuel--;
        } else {
            stop();
        }
    }
}
```

In the above example, driving the car when the fuel is less then or equal to `5` will drive the car, but it will turn on the fuel light.
When the fuel reaches `0`, the car will stop driving.
