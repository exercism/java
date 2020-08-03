Data structures that can hold zero or more elements are known as _collections_. An **array** is a collection that has a fixed size/length and whose elements must all be of the same type. Elements can be assigned to an array or retrieved from it using an index. Java arrays are zero-based, meaning that the first element's index is always zero:

```java
// Declare array with explicit size (size is 2)
int[] twoInts = new int[2];

// Assign second element by index
twoInts[1] = 8;

// Retrieve the second element by index
int element = twoInts[1];

// Check the length of the array
boolean checkSize = twoInts.length == 2; // => checkSize is true
```

Arrays can also be defined using a shortcut notation that allows you to both create the array and set its value. As the compiler can now tell how many elements the array will have, the length can be omitted:

```java
// Two equivalent ways to declare and initialize an array (size is 3)
int[] threeIntsV1 = new int[] { 4, 9, 7 };
int[] threeIntsV2 = { 4, 9, 7 };
```

Arrays can be manipulated by either calling an array instance's methods or properties, or by using the static methods defined in the `Array` class.

The fact that an array is also a _collection_ means that, besides accessing values by index, you can iterate over _all_ its values using a `foreach` loop:

```java
char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

for(char vowel:vowels) {
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

However, generally a `foreach` loop is preferrable over a `for` loop for the following reasons:

- A `foreach` loop is guaranteed to iterate over _all_ values. With a `for` loop, it is easy to miss elements, for example due to an off-by-one error.
- A `foreach` loop is more _declarative_, your code is communicating _what_ you want it to do, instead of a `for` loop that communicates _how_ you want to do it.
- A `foreach` loop is foolproof, whereas with `for` loops it is easy to have an off-by-one error.
- A `foreach` loop works on all collection types, including those that don't support using an indexer to access elements.

To guarantee that a `foreach` loop will iterate over _all_ values, the compiler will not allow updating of a collection within a `foreach` loop:

```java
char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

for(char vowel:vowels) {
    vowels = 'Y';  // This would result in a compiler error
}
```

A `for` loop does have some advantages over a `foreach` loop:

- You can start or stop at the index you want.
- You can use any (boolean) termination condition you want.
- You can skip elements by customizing the incrementing of the loop variable.
- You can process collections from back to front by counting down.
- You can use `for` loops in scenarios that don't involve collections.

Related Topics:

- You should be aware that Java supports [multi-dimensional arrays][multi-dimensional-arrays] like `int[][] arr = new int[3][4];` which can be very useful.

[multi-dimensional-arrays] https://www.programiz.com/java-programming/multidimensional-array
