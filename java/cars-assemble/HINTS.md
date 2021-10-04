# Hints

## General

- [Numbers tutorial][numbers].

## 1. Calculate the production rate per second

- Determining the success rate can be done through a [conditional statement][if-statement].
- Java allows for multiplication to be applied to two different number types (such as an `int` and a `double`). It will automatically return the "broader" data type.
- Numbers can be compared using the built-in [comparison][comparison-operators] and [equality operators][comparison-operators].

## 2. Calculate the number of working items produced per second

- Whereas an `int` can be automatically converted to a `double`, the reverse does not hold. The reason for this is that an `int` has less precision than a `double` so rounding has to be applied, also the range of numbers an `int` can represent is smaller than a `double`. To force this conversion you can use a [cast to an int][cast-int].

[cast-int]: https://www.w3schools.com/java/java_type_casting.asp
[numbers]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
[if-statement]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
[comparison-operators]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html