#Leap

[Example implementation](https://github.com/exercism/java/blob/master/exercises/leap/.meta/src/reference/java/Leap.java)

## General

- Classes: The method being implemented is defined in a class. It can only be called by creating an instance of the class and then calling the method using the class, `class.method()`

- Visibility: By default, methods without a modifier before the `class` keyword can be accessed only by other classes within the same package. The class will not be visible (available) to any other classes. Modifier options are `protected`, `private`, or `public`

- Method: A series of statements that are executed when the method is called

- Parameter: Information passed into a method when the method is called. Methods can have zero, one, or many parameters.

- Return values: Returning values from a method, denoted by a `return` statement in the method and return type in the method signature. Once a method executes a `return` statement, no other statement in the method will be executed and control is returned the caller of the method

- `boolean`: A primitive type that can only have the values `true` or `false`

- Boolean Expression: Java code that can be evaluated to return either `true` or `false`. Simple boolean expressions can be combined to represent more complex logic

- modulo operator `%`: The modulo operator takes two numbers and returns the remainder when dividing the left-hand value by the right-hand value. This is commonly used to determine whether a number is even, where a number modulo 2 has a result of 0. Contrast with the division operator `/`

- Equality `==`: Performs a comparison of the two numbers and returns `true` when the numers are equal, `false` when the numbers are not equal

- Inequality `!=`: Performs a comparison of the two numbers and returns `true` when the numbers are not equal, `false` when the numbers are equal

- Logical-Or `||`: Performs a check of two Boolean expressions and returns `true` when either (or both) expression is true, `false` when both expressions are not true

## Approach: Modulo operator and Boolean Expressions

- Pass the year in as a parameter. Use the Modulo operator to determine whether the year is evenly divisible by a certain number, resulting in a boolean. Combine two or more boolean results in a Boolean Expression. Return a boolean value that indicates the year is a leap year, or not.
