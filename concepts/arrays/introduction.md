# Introduction to Arrays

In Java, data structures that can hold zero or more elements are known as _collections_.
An **array** is a collection that has a fixed size and whose elements must all be of the same type.
Elements can be assigned to an array or retrieved from it using an index.
Java arrays use zero-based indexing: the first element's index is 0, the second element's index is 1, etc.

Here is the standard syntax for initializing an array:

```java
type[] variableName = new type[size];
```

The `type` is the type of elements in the array which may be a primitive type (e.g. `int`) or a class (e.g. `String`).

The `size` is the number of elements this array will hold (which cannot be changed later).
After array creation, the elements are initialized to their default values (typically `0`, `false` or `null`).

```java
// Declare array with explicit size (size is 2)
int[] twoInts = new int[2];
```

Arrays can also be defined using a shortcut notation that allows you to both create the array and set its value:

```java
// Two equivalent ways to declare and initialize an array (size is 3)
int[] threeIntsV1 = new int[] { 4, 9, 7 };
int[] threeIntsV2 = { 4, 9, 7 };
```

As the compiler can now tell how many elements the array will have, the length can be omitted.

Array elements may be assigned and accessed using a bracketed index notation:

```java
// Assign second element by index
twoInts[1] = 8;

// Retrieve the second element by index and assign to the int element
int secondElement = twoInts[1];
```

Accessing an index that is outside of the valid indexes for the array results in an `IndexOutOfBoundsException`.

Arrays can be manipulated by either calling an array instance's methods or properties, or by using the static methods defined in the `Arrays` class (typically only used in generic code).
The `length` property holds the length of an array.
It can be accessed like this:

```java
int arrayLength = someArray.length;
```

Java also provides a helpful utility class [`java.util.Arrays`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html) that has lots of useful array-related methods (eg. `Arrays.equals`).

Java also supports [multi-dimensional arrays](https://www.programiz.com/java-programming/multidimensional-array) like `int[][] arr = new int[3][4];` which can be very useful.

The fact that an array is also a _collection_ means that, besides accessing values by index, you can iterate over _all_ its values using a `for-each` loop:

```java
char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

for(char vowel: vowels) {
    // Output the vowel
    System.out.print(vowel);
}

// => aeiou
```

If you want more control over which values to iterate over, a `for` loop can be used:

```java
char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

for (int i = 0; i < 3; i++) {
    // Output the vowel
    System.out.print(vowels[i]);
}

// => aei
```
