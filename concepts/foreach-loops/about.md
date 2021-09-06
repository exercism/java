# About For-Each Loops

The [for-each loop](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html) provides a mechanism for executing a block of code for each element in a collection.
Some documentation (eg. Oracle's documentation) refers to these as enhanced for loops.

Here is the general syntax:

```java
for(declaration: collection) {
    body;
}
```

The `declaration` declares the variable used to hold the values assigned from the collection.

The `collection` is an array or a collection holding the values that will be assigned to the loop variable.

The `body` contains the statements that will be executed once for each value in the collection.

For example:

```java
char[] vowels = {'a', 'e', 'i', 'o', 'u'};

for(char vowel: vowels) {
    System.out.println(vowel);
}
```

which outputs:

```
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
