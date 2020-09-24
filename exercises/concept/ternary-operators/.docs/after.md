## Ternary Operator

The _ternary operators_ can be thought of as being a compact version of _if-else_. It's usually used in (but not restricted to) return statements, it needs just one single line to make the decision, returning the left value if the expression is `true` and the right value if `false`.

A lot of simple _if/else_ expressions can be simplified using _ternary operators_.

```java
// this ternary statement
return 5 > 4 ? true : false;

// is equivalent to this if/else
if ( 5 > 4 ) {
    return true;
} else {
    return false;
}
```

So, how to decide between _if-else_ and _ternary_ ? Well, _ternary operators_ are used in simple scenarios, where you just need to return a value based on a condition and no extra computation is needed. Use an _if-else_ for everthing else, like nested conditions, big expressions and when more than one line is needed to decide the return value.

While you can nest _ternary operators_, the code often becomes hard to read. In these cases, nested if's are preferred.

```java
// hard to read
int value = expr1 ? expr2 && expr3 ? val1 : (val2 + val3) : expr4;

// easier to read
if (expr1){

    if (expr2 && expr3){

        return val1;
    }

    return val2 + val3;
}
return val4;


```

_Ternary operators_ and _if/else_ statements are a good example that you have different ways of achieving the same result when programming.

For more examples check out [this][ternary-operator-first] and [this][ternary-operator-second] sources.

[ternary-operator-first]: https://www.programiz.com/java-programming/ternary-operator
[ternary-operator-second]: https://www.baeldung.com/java-ternary-operator
