# About

In Java there are four looping constructs, two that are iteration centric: [`For`] and [`For-each`] and the other two are condition centric: [`While`] and [`Do-while`].

## For

A for loop is a control flow statement that allows you to efficiently execute a block of code multiple times.
It achieves this repetition through a concept called iteration, where a variable (often called a loop counter) takes on different values within a specified range. This loop continues executing the code block until the iteration reaches its end.

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

```text
square of 1 is 1
square of 2 is 4
square of 3 is 9
square of 4 is 16
```

Iterating through every element in a collection is usually performed using a `for-each`, but it can be done with a `for` loop like this:

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

## For-each

A for-each loop provides a mechanism for executing a block of code for each element in a collection.

```java
for (declaration: collection) {
    body;
}
```

The `declaration` declares the variable used to hold the values assigned from the collection.

The `collection` is an array or collection holding the values that will be assigned to the loop variable.

The `body` contains the statements that will be executed once for each value in the collection.

For example:

```java
char[] vowels = {'a', 'e', 'i', 'o', 'u'};

for(char vowel: vowels) {
    System.out.println(vowel);
}
```

which outputs:

```text
a
e
i
o
u
```

Generally a `for-each` loop is preferrable over a `for` loop for the following reasons:

- A `for-each` loop is guaranteed to iterate over _all_ values.
- A `for-each` loop is more _declarative_ meaning the code is communicating _what_ it is doing, instead of _how_ it is doing it.
- A `for-each` loop is foolproof, whereas with `for` loops it is easy to have an off-by-one error (think of using `<` versus `<=`).
- A `for-each` loop works on all collection types, including those that do not support using an index to access elements (eg. a `Set`).

## While

The `while` loop continually executes a block of statements while a particular condition is true.

```java
while (condition) {
    body;
}
```

The `condition` It's a statement that can be true or false. As long as the condition is true, the loop keeps running.
The `body` it's the code that gets executed repeatedly until the condition becomes false.

For example:

```java
int counter = 1;

while (counter <= 5) {
    System.out.println(counter);
    counter++;
}
```

which outputs:

```text
1
2
3
4
5
```

Generally good rule of thumb is to use a `while` loops when you don't know exactly how many times you need to loop beforehand.

## Do-while

As `while` loops `do-while` loops are condition centric loops, but unlike a regular `while` loop, a `do-while` loop guarantees that the code inside the loop will run at least once, no matter what.

```java
do {
    body;
} while (condition);
```

For example:

```java
int counter = 1;

do {
    System.out.println(counter);
    counter++;
} while (counter < 2);
```

which outputs:

```text
1
```

## Loop control statements

Loop control statements are special keywords used within loops to alter the normal execution flow.

### Break

The break statement acts as an "exit door" for a looping construct.
When encountered within the loop's body, `break` immediately terminates the loop's execution.

For example:

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;
    }

    System.out.println(i);
}
```

which outputs:

```text
0
1
2
3
4
```

### Continue

The continue statement on the other hand acts similar to a "skip button" in a looping construct.
When encountered within a loop's body, `continue` skips the remaining statements in the current iteration.

For exmaple:

```java
for (int i = 0; i < 5; i++) {
    if (i < 3) {
        continue;
    }

    System.out.println(i);
}
```

which outputs:

```text
3
4
```

[`For`]: #for
[`For-each`]: #for-each
[`While`]: #while
[`Do-while`]: #do-while
