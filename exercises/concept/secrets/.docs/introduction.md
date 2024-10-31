# Introduction

## Bit Manipulation

Java has operators for manipulating the bits of a `byte`, `short`, `int`, `long` or `char`.

### Shift operators

Use `<<` to shift bits to the left and `>>` to shift to the right.

```java
// Shift two places to the left
0b0000_1011 << 2;
// # => 0b0010_1100

// Shift two places to the right
0b0000_1011 >> 2;
// # => 0b0000_0010
```

The `<<` operator always inserts 0s on the right hand side.
However, `>>` inserts the same bit as the left most bit (1 if the number is negative or 0 if positive).

```java
// Shift 2 places to the right preserves the sign
// This is a negative value, whose binary representation is
// 1000_0000_0000_0000_0000_0000_0010_0110
int value = -0x7FFFFFDA;

// Shift two places to the right, preserving the sign bit
value >> 2;
// # => 1110_0000_0000_0000_0000_0000_0000_1001
```

Use `>>>` instead when 0s are to be inserted when shifting to the right.

```java
// Shift two places to the right, inserting 0s on the left
value >>> 2;
// # => 0010_0000_0000_0000_0000_0000_0000_1001
```

### Bitwise Operations

#### Bitwise AND

The bitwise AND (`&`) operator takes two values and performs an AND on each bit.
It compares each bit from the first value with the bit in the same position from the second value.
If they are both 1, then the result's bit is 1.
Otherwise, the result's bit is 0.

```java
0b0110_0101 & 0b0011_1100;
// # => 0b0010_0100
```

#### Bitwise OR

The bitwise OR (`|`) operator takes two values and performs an OR on each bit.
It compares each bit from the first value with the bit in the same position from the second value.
If either bit is 1, the result's bit is 1.
Otherwise, it is 0.

```java
0b0110_0101 | 0b0011_1100;
// # => 0b0111_1101
```

#### Bitwise XOR

The bitwise XOR operator (`^`) performs a bitwise XOR on two values.
Like the bitwise AND and bitwise OR operators, it compares each bit from the first value against the bit in the same position from the second value.
If only one of them is 1, the resulting bit is 1.
Otherwise, it is 0.

```java
0b0110_0101 ^ 0b0011_1100;
// # => 0b0101_1001
```

#### Bitwise NOT(`~`)

Lastly, the bitwise NOT operator (`~`) flips each bit.
Unlike the earlier operators, this is a unary operator, acting only on one value.

```java
~0b0110_0101;
// # => 0b1001_1010
```
