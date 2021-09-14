# Elon's Toys

Welcome to Elon's Toys on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

A [method][methods] is a function with a special _receiver_ argument. The receiver appears in its own argument list between `func` keyword and the name of the method.

```go
func (receiver type) MethodName(parameters) (returnTypes){

}
```

You can only define a method with a receiver whose type is defined in the same package as the method. The receiver can be either a struct type or a non-struct type as in the example below.

```go
type Name string

func (s Name) Greetings() string {
	return fmt.Sprintf("Welcome %s !", s)
}

func main() {
	s := Name("Bronson")
	fmt.Println(s.Greetings())
}
// Output: Welcome Bronson !
```

Methods with a value receiver operate on a copy of the value passed to it, meaning that any modification done to the receiver inside the method is not visible to the caller.

You can declare methods with pointer receivers in order to modify the value to which the receiver points. Such modifications are visible to the caller or the method as well.

```go
type rect struct {
	width, height int
}
func (r *rect) squareIt() {
	r.height = r.width
}

func main() {
	r := rect{width: 10, height: 20}
	fmt.Printf("Width: %d, Height: %d\n", r.width, r.height)
	// Output: Width: 10, Height: 20

	r.squareIt()
	fmt.Printf("Width: %d, Height: %d\n", r.width, r.height)
	// Output: Width: 10, Height: 10
}
```

You can find several examples [here][pointers_receivers]. Also checkout this short tutorial about [methods][methods_tutorial].

Remember: a method is just a function with a receiver argument.

[methods]: https://tour.golang.org/methods/1
[pointers_receivers]: https://tour.golang.org/methods/4
[methods_tutorial]: https://www.callicoder.com/golang-methods-tutorial/

## Instructions

Note: This exercise is a continuation of the `need-for-speed` exercise.

In this exercise you'll be organizing races between various types of remote controlled cars. Each car has its own speed and battery drain characteristics.

Cars start with full (100%) batteries. Each time you drive the car using the remote control, it covers the car's speed in meters and decreases the remaining battery percentage by its battery drain.

If a car's battery is below its battery drain percentage, you can't drive the car anymore.

The remote controlled car has a fancy LED display that shows two bits of information:

- The total distance it has driven, displayed as: `"Driven <METERS> meters"`.
- The remaining battery charge, displayed as: `"Battery at <PERCENTAGE>%"`.

Each race track has its own distance. Cars are tested by checking if they can finish the track without running out of battery.

## 1. Drive the car

Implement the `Drive` method on the `Car` that updates the number of meters driven based on the car's speed, and reduces the battery according to the battery drainage:

```go
speed := 5
batteryDrain := 2
car := NewCar(speed, batteryDrain)
car.Drive()
// Output: Car{speed: 5, batteryDrain: 2, battery: 98, distance: 5}
```

Note: If a car's battery is below its battery drain percentage, you can't drive the car anymore.

## 2. Display the distance driven

Implement a `DisplayDistance` method on `Car` to return the distance as displayed on the LED display:

```go
speed := 5
batteryDrain := 2
car := NewCar(speed, batteryDrain)

car.DisplayDistance()
// Output: "Driven 0 meters"
```

## 3. Display the battery percentage

Implement the `DisplayBattery` method on `Car` to return the distance as displayed on the LED display:

```go
speed := 5
batteryDrain := 2
car := NewCar(speed, batteryDrain)

car.DisplayBattery()
// Output: "Battery at 100%"
```

## 4. Check if a remote control car can finish a race

To finish a race, a car has to be able to drive the race's distance. This means not draining its battery before having crossed the finish line. Implement the `CanFinish` function that takes a `Car` and a `Track` instance as its parameter and returns `true` if the car can finish the race; otherwise, return `false`:

```go
speed := 5
batteryDrain := 2
car := NewCar(speed, batteryDrain)

distance := 100
raceTrack := NewTrack(distance)

car.CanFinish(raceTrack)
// Output: true
```

## Source

### Created by

- @tehsphinx

### Contributed to by

- @oanaOM