# Introduction to For Loops

The [for loop](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html) provides a mechanism to execute a group of statements repeatedly until some condition is met.
The loop consists of four parts:

```java
for (initialization; test; update) {
    body;
}
```

The `initialization` sets an initial state for the loop and is executed exactly once at the start of the loop.
Typically it declares and assigns a variable used in the test expression and update statement.
For example:

```java
int i = 1
```

The `test` expression tests if the loop should end.
If it evaluates to `true`, the body and then the update expression will be executed.
If it evaluates to `false`, neither the body nor the update statement will be executed and execution resumes after the loop's closing bracket.
Typically it checks the variable assigned in the initialization block.
For example:

```java
i <= 10
```

After executing the loop body, the `update` expression is executed.
Typically it increments or decrements the loop variable by some value.
For example:

```java
i++
```

A `for` loop printing out the first four squares would look like this:

```java
for (int i = 1; i <= 4; i++) {
    System.out.println("square of " + i + " is " + i * i);
}
```

The output would be:

```
square of 1 is 1
square of 2 is 4
square of 3 is 9
square of 4 is 16
```

If iterating through every element in a collection, a `for-each` loop is preferred, but it can be done with a `for` loop like this:

```java
for (int i = 0; i < array.length; i++) {
    System.out.print(array[i]);
}
```

A `for` loop does have some advantages over a `for-each` loop:

- You can start or stop at the index you want.
- You can use any (boolean) termination condition you want.
- You can skip elements by customizing the incrementing of the loop variable.
- You can process collections from back to front by counting down.
- You can use `for` loops in scenarios that do not involve collections.
