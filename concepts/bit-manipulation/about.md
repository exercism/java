# About Bit Manipulation

Java has operators for manipulating the bits of an [integral type][integral-type] (a `byte`, `short`, `int`, `long` or `char`).

## Shift operators

Use `<<` to shift bits to the left and `>>` to shift to the right.

```java
// Shift two places to the left
0b0000_1011 << 2;
// # => 0b0010_1100

// Shift two places to the right
0b0000_1011 >> 2;
// # => 0b0000_0010
```

`>>` is also called a [signed shift or arithmetic shift][arithmetic-shift] operator because the bit it is inserts is same as its sign bit.
This is the left most bit and is 0 if the value is positive or 1 when negative.
Shifting to the left with `<<` always inserts 0s on the right hand side.

```java
// Shift 2 places to the right preserves the sign
// The binary value is two's complement of 0b0000_0110 (or 0x00000026), so the binary representation will be
// 1000_0000_0000_0000_0000_0000_0010_0110
int value = -0x7FFFFFDA;

// Shift two places to the right, preserving the sign bit
value >> 2;
// # => 1110_0000_0000_0000_0000_0000_0000_1001
```

Use `>>>` instead when 0s are to be inserted when shifting to the right.
Inserting 0s when shifting is also known as a [logical shift][logical-shift].

```java
// Shift two places to the right, inserting 0s on the left
value >>> 2;
// # => 0010_0000_0000_0000_0000_0000_0000_1001
```

## Bitwise Operations

### Bitwise AND

The bitwise AND (`&`) operator takes two values and performs an AND on each bit.
It compares each bit from the first value with the bit in the same position from the second value.
If they are both 1, then the result's bit is 1.
Otherwise, the result's bit is 0.

```java
0b0110_0101 & 0b0011_1100;
// # => 0b0010_0100
```

### Bitwise OR

The bitwise OR (`|`) operator takes two values and performs an OR on each bit.
It compares each bit from the first value with the bit in the same position from the second value.
If either bit is 1, the result's bit is 1.
Otherwise, it is 0.

```java
0b0110_0101 | 0b0011_1100;
// # => 0b0111_1101
```

### Bitwise XOR

The bitwise XOR operator (`^`) performs a bitwise XOR on two values.
Like the bitwise AND and bitwise OR operators, it compares each bit from the first value against the bit in the same position from the second value.
If only one of them is 1, the resulting bit is 1.
Otherwise, it is 0.

```java
0b0110_0101 ^ 0b0011_1100;
// # => 0b0101_1001
```

### Bitwise NOT(`~`)

Lastly, the bitwise NOT operator (`~`) flips each bit.
Unlike the earlier operators, this is a unary operator, acting only on one value.

```java
~0b0110_0101;
// # => 0b1001_1010
```

[integral-type]: https://docs.oracle.com/javase/specs/jls/se21/html/jls-4.html#jls-4.2
[arithmetic-shift]: https://en.wikipedia.org/wiki/Arithmetic_shift
[logical-shift]: https://en.wikipedia.org/wiki/Logical_shift
