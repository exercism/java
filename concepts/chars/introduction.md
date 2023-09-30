# Introduction

The Java `char` type represents the smallest addressable components of text.
Multiple `char`s can comprise a string such as `"word"` or `char`s can be
processed independently. Their literals have single quotes e.g. `'A'`.

Java `char`s support Unicode encoding so in addition to the Latin character set
pretty much all the writing systems in use worldwide can be represented,
e.g. the Greek letter `'β'`.

There are many builtin library methods to inspect and manipulate `char`s. These
can be found as static methods of the `java.lang.Character` class.

`char`s are sometimes used in conjunction with a `StringBuilder` object.
This object has methods that allow a string to be constructed
character by character and manipulated. At the end of the process
`toString` can be called on it to output a complete string.
