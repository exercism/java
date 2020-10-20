One of the key aspects of working with numbers in Java is the distinction between integers (numbers with no digits after the decimal separator) and floating-point numbers (numbers with zero or more digits after the decimal separator).

Java has other [datatypes][numeric-datatypes] apart from `int` and `double`

```java
//8-Bit Integer
byte   a = 127;

//16-Bit Integer
short  b = 262143;

//64-Bit Integer
long   d = 18446744073709551999L;

//32-bit Single-Precision Floating-Point
float  e = 5409.29f;
```

Both integers and floating-point numbers can use the `_` character as a _digit separator_, which can help when defining large numbers:

```java
int largeInt = 1_000_000;
// => 1000000

double largeDouble = 9_876_543.21;
// => 9876543.21
```

Arithmetic is done using the standard [arithmetic operators][arithmetic-operators] (`+`, `-`, `*`, etc.). Numbers can be compared using the standard [comparison operators][comparison-operators] (`<`, `>=`, etc.) along with the equality operator (`==`) and inequality operator (`!=`).

```java
5 * 6
// => 30

1.2 > 0.8
// => true

120 == 100
// => false

2 != 4
// => true
```

When converting between numeric types, there are two types of numeric conversions:

1. Implicit conversions: no data will be lost and no additional syntax is required.
2. Explicit conversions: data could be lost and additional syntax in the form of a _cast_ is required.

As an `int` has less precision than a `double`, converting from an `int` to a `double` is safe and is thus an [implicit conversion][type-casting]. However, converting from a `double` to an `int` could mean losing data, so that requires an [explicit conversion][type-casting].

```java
int i = 9;
double d = 2.72;

// Safe conversion, thus implicit conversion
double fromInt = i;

// Potentially unsafe conversion, thus explicit conversion
int fromDouble = (int)d;
```

An `if` statement can be used to conditionally execute code. The condition of an `if` statement must be of type `boolean`. Java has no concept of _truthy_ values.

```java
int x = 6;

if (x == 5){
    // Execute logic if x equals 5
} else if (x > 7){
    // Execute logic if x greater than 7
} else{
    // Execute logic in all other cases
}
```

[arithmetic-operators]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html
[comparison-operators]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html
[type-casting]: https://www.programiz.com/java-programming/typecasting
[numeric-datatypes]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
