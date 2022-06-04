# Need For Speed

Welcome to Need For Speed on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In Go, a `struct` is a sequence of named elements called _fields_, each field has a name and type. The name of a field must be unique within the struct.
Structs can be compared with _classes_ in the Object-Oriented Programming paradigm.

You create a new struct by using the `type` keyword and the **_built-in type_** `struct`, and explicitly define the name and type of the fields.
For example, to define a `Person` struct:

```go
type Person struct{
    name string
    age int
}
```

Once you have defined the `struct`, you need to create a new instance defining the fields using their field name
in any order:

```go
person := Person{
	name: "John",
	age: 22,
}
```

To read or modify instance fields, use the `.` notation:

```go
// Update the age
person.age = 23
fmt.Printf("name: %s age: %d\n", person.name, person.age)
// Output: name: John age: 23
```

## Instructions

In this exercise you'll be organizing races between various types of remote controlled cars.
Each car has its own speed and battery drain characteristics.

Cars start with full (100%) batteries. Each time you drive the car using the remote control,
it covers the car's speed in meters and decreases the remaining battery percentage by its battery drain.

If a car's battery is below its battery drain percentage, you can't drive the car anymore.

Each race track has its own distance. Cars are tested by checking if they can finish the track without running out of battery.

## 1. Creating a remote controlled car

Define a `Car` struct with the following `int` type fields:

- battery
- batteryDrain
- speed
- distance

Allow creating a remote controlled car by defining a function `NewCar` that takes the speed of the car in meters,
and the battery drain percentage as its two parameters (both of type `int`) and returns a `Car` instance:

```go
speed := 5
batteryDrain := 2
car := NewCar(speed, batteryDrain)
// Output: Car{speed: 5, batteryDrain: 2, battery:100, distance: 0}
```

## 2. Creating a race track

Define another struct type called `Track` with the field `distance` of type integer.
Allow creating a race track by defining a function `NewTrack` that takes the track's distance in meters as its sole parameter (which is of type `int`):

```go
distance := 800
raceTrack := NewTrack(distance)
// Output: Track{distance: 800}
```

## 3. Drive the car

Implement the `Drive` function that updates the number of meters driven based on the car's speed, and reduces the battery according to the battery drainage:

```go
speed := 5
batteryDrain := 2
car := NewCar(speed, batteryDrain)
car = Drive(car)
// Output: Car{speed: 5, batteryDrain: 2, battery: 98, distance: 5}
```

## 4. Check if a remote controlled car can finish a race

To finish a race, a car has to be able to drive the race's distance. This means not draining its battery before having crossed the finish line. Implement the `CanFinish` function that takes a `Car` and a `Track` instance as its parameter and returns `true` if the car can finish the race; otherwise, return `false`.

Assume that you start the engine of the car for the race but take into account that the car might have some mileage already (`distance >= 0`) and its battery might not necessarily be fully charged (`battery <= 100`):

```go
speed := 5
batteryDrain := 2
car := NewCar(speed, batteryDrain)

distance := 100
raceTrack := NewTrack(distance)

CanFinish(car, raceTrack)
// Output: true
```

## Source

### Created by

- @tehsphinx

### Contributed to by

- @oanaOM