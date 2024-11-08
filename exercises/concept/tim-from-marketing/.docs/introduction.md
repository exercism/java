# Introduction

## Nullability

In Java, the `null` literal is used to denote the absence of a value.

Primitive data types in Java all have a default value and therefore can never be `null`.
By convention, they start with a lowercase letter e.g `int`.

Reference types contain the memory address of an object and can have a value of `null`.
They generally start with an uppercase letter, e.g. `String`.

Attempting to assign a primitive variable a value of `null` will result in a compile time error as the variable always holds a primitive value of the type assigned.

```java
//Throws compile time error stating the required type is int, but null was provided
int number = null;
```

Assigning a reference variable a `null` value will not result in a compile time error as reference variables are nullable.

```java
//No error will occur as the String variable str is nullable
String str = null;
```
