Booleans in Java are represented by the `boolean` type, which values can be either `true` or `false`.

Java supports three [boolean operators][operators]: `!` (NOT), `&&` (AND), and `||` (OR). The `&&` and `||` operators use _short-circuit evaluation_, which means that the right-hand side of the operator is only evaluated when needed.

These are also known as conditional or logical operators. `!` is sometimes classified as a bitwise operation in the documentation but it has the conventional _NOT_ semantics.

```java
true || false // => true
true && false // => false
```

The three boolean operators each have a different [_operator precedence_][precedence]. As a consequence, they are evaluated in this order: `not` first, `&&` second, and finally `||`. If you want to 'escape' these rules, you can enclose a boolean expression in parentheses (`()`), as the parentheses have an even higher operator precedence.

```java
!true && false   // => false
!(true && false) // => true
```

[operators]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html
[precedence]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
