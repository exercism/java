# Need For Speed

Welcome to Need For Speed on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In Go, a `struct` is a sequence of named elements called _fields_, each field has a name and type.
The name of a field must be unique within the struct.
Structs can be compared with _classes_ in the Object-Oriented Programming paradigm.

## Defining a struct

You create a new struct by using the `type` and `struct` keywords, and explicitly define the name and type of the fields.
For example, here we define `Shape` struct, that holds the name of a shape and its size:

```go
type Shape struct {
    name string
    size int
}
```

Field names in structs follow the Go convention - fields whose name starts with a lower case letter are only visible to code in the same package, whereas those whose name starts with an upper case letter are visible in other packages.

## Creating instances of a struct

Once you have defined the `struct`, you need to create a new instance defining the fields using their field name
in any order:

```go
s := Shape {
    name: "Square",
    size: 25,
}
```

To read or modify instance fields, use the `.` notation:

```go
// Update the name and the size
s.name = "Circle"
s.size = 35
fmt.Printf("name: %s size: %d\n", s.name, s.size)
// Output: name: Circle size: 35
```

Fields that don't have an initial value assigned, will have their zero value. For example:

```go
s := Shape{name: "Circle"}
fmt.Printf("name: %s size: %d\n", s.name, s.size)
// Output: name: Circle size: 0
```

You can create an instance of a `struct` without using the field names, as long as you define the fields _in order_:

```go
s := Shape {
	"Oval",
	20,
}
```

However, this syntax is considered _brittle code_ since it can break when a field is added, especially when the new field is of a different type.
In the following example we add an extra field to `Shape`:

```go
type Shape struct {
	name        string
	description string // new field 'description' added
	size        int
}

s := Shape{
    "Circle",
    20,
}
// Since the second field of the struct is now a string and not an int,
// the compiler will throw an error when compiling the program:
// Output: cannot use 20 (type untyped int) as type string in field value
// Output: too few values in Shape{...}
```

## "New" functions

Sometimes it can be nice to have functions that help us create struct instances.
By convention, these functions are usually called `New` or have their names starting with `New`, but since they are just regular functions, you can give them any name you want.
They might remind you of constructors in other languages, but in Go they are just regular functions.

In the following example, one of these `New` functions is used to create a new instance of `Shape` and automatically set a default value for the `size` of the shape:

```go
func NewShape(name string) Shape {
	return Shape{
		name: name,
		size: 100, //default-value for size is 100
	}
}

NewShape("Triangle")
// => Shape { name: "Triangle", size: 100 }

```

Using `New` functions can have the following advantages:
* validation of the given values
* handling of default-values
* since `New` functions are often declared in the same package of the structs they initialize, they can initialize even private fields of the struct

## Instructions

In this exercise you'll be organizing races between various types of remote controlled cars.
Each car has its own speed and battery drain characteristics.

Cars start with full (100%) batteries. Each time you drive the car using the remote control,
it covers the car's speed in meters and decreases the remaining battery percentage by its battery drain.

If a car's battery is below its battery drain percentage, you can't drive the car anymore.

Each race track has its own distance. Cars are tested by checking if they can finish the track without running out of battery.

## 1. Create a remote controlled car

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
// => Car{speed: 5, batteryDrain: 2, battery:100, distance: 0}
```

## 2. Create a race track

Define another struct type called `Track` with the field `distance` of type integer.
Allow creating a race track by defining a function `NewTrack` that takes the track's distance in meters as its sole parameter (which is of type `int`):

```go
distance := 800
track := NewTrack(distance)
// => Track{distance: 800}
```

## 3. Drive the car

Implement the `Drive` function that updates the number of meters driven based on the car's speed, and reduces the battery according to the battery drainage.
If there is not enough battery to drive one more time the car will not move:

```go
speed := 5
batteryDrain := 2
car := NewCar(speed, batteryDrain)
car = Drive(car)
// => Car{speed: 5, batteryDrain: 2, battery: 98, distance: 5}
```

## 4. Check if a remote controlled car can finish a race

To finish a race, a car has to be able to drive the race's distance. This means not draining its battery before having crossed the finish line. Implement the `CanFinish` function that takes a `Car` and a `Track` instance as its parameter and returns `true` if the car can finish the race; otherwise, return `false`.

Assume that you are currently at the starting line of the race and start the engine of the car for the race. Take into account that the car's battery might not necessarily be fully charged when starting the race:
```go
speed := 5
batteryDrain := 2
car := NewCar(speed, batteryDrain)

distance := 100
track := NewTrack(distance)

CanFinish(car, track)
// => true
```

## Source

### Created by

- @tehsphinx

### Contributed to by

- @oanaOM
- @eklatzer
- @andrerfcsantos