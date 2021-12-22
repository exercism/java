# Arrays

In Java, data structures that can hold zero or more elements are known as _collections_. An **array** is a collection that has a fixed size/length and whose elements must all be of the same type. Elements can be assigned to an array or retrieved from it using an index. Java arrays are zero-based, meaning that the first element's index is always zero:

```java
// Declare array with explicit size (size is 2)
int[] twoInts = new int[2];

// Assign second element by index
twoInts[1] = 8;

// Retrieve the second element by index and assign to the int element
int element = twoInts[1];
```

Arrays can also be defined using a shortcut notation that allows you to both create the array and set its value. As the compiler can now tell how many elements the array will have, the length can be omitted:

```java
// Two equivalent ways to declare and initialize an array (size is 3)
int[] threeIntsV1 = new int[] { 4, 9, 7 };
int[] threeIntsV2 = { 4, 9, 7 };
```

Arrays can be manipulated by either calling an array instance's methods or properties, or by using the static methods defined in the `Arrays` class.

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
