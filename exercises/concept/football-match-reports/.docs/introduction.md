# Introduction

## Switch Statements

Like an _if/else_ statement, a `switch` statement allows you to change the flow of the program by conditionally executing code.
The difference is that a `switch` statement can only compare the value of a primitive or string expression against pre-defined constant values.

Some keywords are useful when using a switch statement.

- `switch`: this keyword allows you to declare the structure of the switch.
  It is followed by the expression or the variable that will change the result.
- `case`: you will use this keyword to declare the different possibilities for the result.
- `break`: the `break` keyword is very useful in order to stop the execution of the switch at the end of the wanted flow.
  If you forget it, the program will continue and may lead to unexpected results.
- `default`: as its name says, use it as a default result when no other case matches your expression's result.

At their simplest they test a primitive or string expression and make a decision based on its value.
For example:

```java
String direction = getDirection();
switch (direction) {
    case "left":
        goLeft();
        break;
    case "right":
        goRight();
        break;
    default:
        // otherwise
        markTime();
        break;
}
```

## Modern Switch Statements

The switch statement was improved in the latest Java versions.

- The `break` keyword is not needed and the arrow operator is used instead of the semicolon.
- Multiple case values can be provided in a single case statement.

```java
String direction = getDirection();
switch (direction) {
    case "left" -> goLeft();
    case "right" -> goRight();
    case "top", "bottom" -> goStraight();
    default -> markTime();
}
```

The first LTS (Long Term Support) version that had these improvements was Java 17, released on September, 2021.

Other improvement is that the case values can be any object.

## Switch Expressions

Going even further, the switch block is now an expression, meaning it returns a value.

```java
return switch (day) {   // switch expression
    case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Week day";
    case "Saturday", "Sunday" -> "Weekend";
    default -> "Unknown";
};
```

instead of using a switch statement:

```java
String day = "";
switch (day) {          // switch statement
    case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> day = "Week day";
    case "Saturday", "Sunday" -> day = "Weekend";
    default-> day = "Unknown";
};
```

In addition, a feature called `Guarded Patterns` was added, which allows you to do checks in the case label itself.

```java
String dayOfMonth = getDayOfMonth();
String day = "";
return switch (day) {
    case "Tuesday" && dayOfMonth == 13 -> "Forbidden day!!";
    case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Week day";
    case "Saturday", "Sunday" -> "Weekend";
    default -> "Unknown";
};
```

The first LTS (Long Term Support) version that had these improvements was Java 21, released on September, 2023.
