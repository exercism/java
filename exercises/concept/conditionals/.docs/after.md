## Logical Operators

Java supports three [logical operators][logical-operators] `&&` (AND), `||` (OR), and `!` (NOT).

## If statement

The underlying type of any conditional operation is the `boolean` type, which can have the value of `true` or `false`. Conditionals are often used as flow control mechanisms to check for various conditions. For checking a particular case an [`if` statement][if-statement] can be used, which executes its code if the underlying condition is `true` like this:

```java
int val;

if(val == 9) {
    // conditional code
}
```

In scenarios involving more than one case many `if` statements can be chained together using the `else if` and `else` statements.

```java
if(val == 10) {
    // conditional code
} else if(val == 17) {
    // conditional code
} else {
    // executes when val is different from 10 and 17
}
```

## Switch statement

Java also provides a [`switch` statement][switch-statement] for scenarios with multiple options. It can be used to switch on a variable's content as a replacement for simple `if ... else if` statements. A switch statement can have a `default` case which is executed if no other case applies.

In Java you can't use any type as the value in a `switch`, only integer and enumerated data types, plus the `String` class are allowed.

If there are three or more cases in a single `if` (e.g. `if ... else if ... else`), it should be replaced by a `switch` statement. A `switch` with a single case should be replaced by an `if` statement.

```java
int val;

// switch statement on variable content
switch(val) {
    case 1:
        // conditional code
        break;
    case 2: case 3: case 4:
        // conditional code
        break;
    default:
        // if all cases fail
        break;
}
```

    Note: Make sure the expression in the switch statement is not null, otherwise a NullPointerException will be thrown

To learn more about this topic it is recommended to check these sources:

- [A refresh of Ternary operators][example-ternary]
- [If/Else datailed with flowcharts][example-ifelse-flowcharts]
- [Switch examples][example-switch]

[logical-operators]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html
[if-statement]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
[switch-statement]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
[example-ifelse-flowcharts]: https://www.javatpoint.com/java-if-else
[example-ternary]: https://www.programiz.com/java-programming/ternary-operator
[example-switch]: https://www.geeksforgeeks.org/switch-statement-in-java/
