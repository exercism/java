# Gigasecond

[Example implementation](https://github.com/exercism/java/blob/master/exercises/gigasecond/.meta/src/reference/java/Gigasecond.java)

## General

- Imports: placed at the top of the file allowing access to methods/classes implemented in other files.

- Integers: Integer is a wrapper class around the primitive type `int` which contains a single field of type `int`. The difference between an `int` and an `Integer` is that `int` can only be a binary value of an integer whereas an `Integer`, being a class, has access to a number of other inbuilt functions making it more flexible to manipulation.

- Classes: The tested method is defined in a class

- Visibility: By default methods in a class can be accessed by other classes within the same package. Other options are `protected`, `private`, or `public`

- Assignment: assigning values, in this case, the private property that contains the date

- Properties: In object oriented programming classes tend to have state, such state is maintained within properties to be set/read at a later time during runtime

- Overloading constructors: Sometimes there can be multiple ways to initialize a class, this is known as overloading since the name of the methods match the name of the class but only vary by their arguments.

- Scoping: `{` and `}` used to identify scope of method

- Objects: creating an instance of the LocalDateTime

- Dates: object containing information about date

- Times: object containing information about the time on a specific date

- Methods: used as a way to interact with the class

- Return values: returning values from a method, deonted by `return` in the method and typed in the method signature

## Approach: Overloading Constructors

- Two constructors where one that takes a LocalDate object as an argument and when initialized, converts it to a LocalDateTime and another that just takes the LocalDateTime object and sets that as a property in the instance of the class.
- method that returns the time (`getDateTime`) adds a gigasecond to the time initialized before returning the new LocalDateTime object
