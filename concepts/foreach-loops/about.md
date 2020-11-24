The [foreach loop][foreach-loop] provides a mechanism for executing a statement group for each element in a collection or array.

Syntax:
`````java
for(declaration: collection) {
    // body
}
`````

The declaration part declares the variable used to hold the values assigned from the collection:

The collection is an array or a collection holding the values that will be assigned to the loop variable.

The body contains the statements that will be executed once for each value in the collection.

Example:

```java
char[] vowels = {'a', 'e', 'i', 'o', 'u'};

for(char vowel:vowels) {
    // Output the vowel
    System.out.print(vowel);
}

// => aeiou
```

Generally a `foreach` loop is preferrable over a `for` loop for the following reasons:

- A `foreach` loop is guaranteed to iterate over _all_ values. With a `for` loop, it is easy to miss elements, for example due to an off-by-one error.
- A `foreach` loop is more _declarative_, your code is communicating _what_ you want it to do, instead of a `for` loop that communicates _how_ you want to do it.
- A `foreach` loop is foolproof, whereas with `for` loops it is easy to have an off-by-one error.
- A `foreach` loop works on all collection types, including those that don't support using an indexer to access elements.

To guarantee that a `foreach` loop will iterate over _all_ values, the compiler will not allow updating of a collection within a `foreach` loop:

```java
char[] vowels = ['a', 'e', 'i', 'o', 'u'];

for(char vowel:vowels) {
    vowels = ['Y'];  // This would result in a compiler error
}
```

[foreach-loop]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html

