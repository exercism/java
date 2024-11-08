# About

In Java, the [`null` literal][null-keyword] is used to denote the absence of a value.

[Primitive data types][primitive-data-types] in Java all have a default value and therefore can never be `null`.
By convention, they start with a lowercase letter e.g `int`.

[Reference types][reference-data-types] contain the memory address of an object and can have a value of `null`.
They generally start with an uppercase letter, e.g. `String`.

Attempting to assign a primitive variable a value of `null` will result in a compile time error as the variable always holds a default value of the type assigned.

```java
// Throws compile time error stating the required type is int, but null was provided
int number = null;
```

Assigning a reference variable a `null` value will not result in a compile time error as reference variables are nullable.

```java
//No error will occur as the String variable str is nullable
String str = null;
```

Whilst accessing a reference variable which has a value of `null` will compile fine, it will result in a `NullPointerException` being thrown at runtime.

```java
int[] arr = null;

// Throws NullPointerException at runtime
arr.Length;
```

A [`NullPointerException` is thrown][null-pointer-exception] when trying to access a reference variable which is null but requires an object.

To safely work with nullable values, one should check if they are `null` before working with them which can be done using [equality operators][equality-operators] such as `==` or `!=`:

```java
int[] arr = null;

if(arr != null) {
    System.out.println(arr.length);
} else {
    //Perform an alternate action when arr is null
}
```

[null-keyword]: https://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.7
[primitive-data-types]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
[reference-data-types]: https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.3
[null-pointer-exception]: https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html
[equality-operators]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html
