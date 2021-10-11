# Introduction

## Logical Operators

Java supports the three logical operators `&&` (AND), `||` (OR), and `!` (NOT).

## If statement

The underlying type of any conditional operation is the `boolean` type, which can have the value of `true` or `false`. Conditionals are often used as flow control mechanisms to check for various conditions. For checking a particular case an `if` statement can be used, which executes its code if the underlying condition is `true` like this:

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

Java also provides a `switch` statement for scenarios with multiple options.

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
