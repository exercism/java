# Hints

## 1. Creating a remote controlled car

- [Define a constructor][constructor-syntax] that has two `int` parameters.
- Store the two parameters as [fields][fields] to access them from the classes' methods.

## 2. Creating a race track

- [Define a constructor][constructor-syntax] that has one `int` parameter.
- Store the parameter as a [field][fields] to access it from the class' method.

## 3. Drive the car

- Add a [field][fields] to keep track of the distance driven.
- Add the car's speed to the [field][fields] that keeps track of the distance driven.

## 4. Check for a drained battery

- Add a [field][fields] to keep track of the remaining battery charge percentage (starts at 100%).
- Remove the car's battery drain from the [field][fields] to keep track of the battery charge.
- Don't update the distance driven if the battery is drained.
- Remember that if the battery charge is less than the battery drain percentage, it is considered drained.

## 5. Create the Nitro remote control car

- [Instantiate][instance-constructors] an instance of the `RemoteControlCar` with the correct arguments.

## 6. Check if a remote control car can finish a race

- Solving this is probably best done by [repeatedly driving the car][while].
- Remember that the car has a method to retrieve the distance it has driven.
- Consider what to do when the battery has been drained before reaching the finish line.

[constructor-syntax]: https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
[instance-constructors]: https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html
[while]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html
[fields]: https://docs.oracle.com/javase/tutorial/java/javaOO/variables.html
