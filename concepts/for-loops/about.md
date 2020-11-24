The [for loop][for-loop] provides a mechanism to execute a group of statements repeatedly.
The loop consists of four parts:

````java
for (initialization; test; update)
{
     // body
}
````


The initialization sets an initial state for the loop.
Typically it declares and sets a variable used in the test expression and update statement.
For example:

````java
int i=1
````

The test expression tests if the loop should execute the body
and execute the update statement.

If the test evaluates to true the body and the update expression will be executed.

If the expression evaluates to false neither the body nor the update statement will be executed and execution continues after the loop.
An example of a test can be:

````java
i <= 10
````

After executing the loop body, the update expression increments/decrements the loop variable by some value.
Example:
````java
i++
````

A for loop executing over each element in an array can look like this:
```java
char[] vowels = {'a', 'e', 'i', 'o', 'u'};

for (int i = 0; i<vowels.length; i++) {
    // Output the vowel
    System.out.print(vowels[i]);
}

// => aeiou
```

A `for` loop does have some advantages over a `foreach` loop:

- You can start or stop at the index you want.
- You can use any (boolean) termination condition you want.
- You can skip elements by customizing the incrementing of the loop variable.
- You can process collections from back to front by counting down.
- You can use `for` loops in scenarios that don't involve collections.

[for-loop]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html
