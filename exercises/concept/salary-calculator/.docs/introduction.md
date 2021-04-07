# Introduction

The _ternary operator_ is a lightweight, compact alternative for simple _if/else_ statements. Usually used in (but not restricted to) return statements, it needs just one single line to make the decision, returning the left value if the expression is `true` and the right value if `false`, as follows:

```java
boolean expr = 0 != 200;

// Ternary statement
int value = expr ? 22 : 33;
// => 22
```

A lot of simple _if/else_ expressions can be simplified using _ternary operators_.
