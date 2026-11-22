# Instructions append

## Exception messages

Sometimes it is necessary to [throw an exception](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html).
When you do this, you should always include a **meaningful error message** to indicate what the source of the error is.
This makes your code more readable and helps significantly with debugging.

This particular exercise requires that you use the [throw keyword](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)
to "throw" an `IllegalArgumentException` if the question passed to `solve()` contains an unsupported operation, is not a math question, or has invalid syntax.
The tests will only pass if you both `throw` the `exception` and include this exact message with it, which is the same for every case:

```java
throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
```
