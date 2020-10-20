Like an _if/else_ statement, a `switch` statement allow you to change the flow of the program by conditionally executing code. The difference is that a `switch` statement can only compare the value of a primitive or string expression against pre-defined constant values.

Some keywords are usefull when using a switch statement.

- `switch` : this keyword allow you to declare the structure of the switch. It his follow by the expression or the variable that will make the result change.
- `case` : you will use this one to declare the differents possibilties for the result.
- `break` : the `break` keyword is very usefull in order to stop the execution of the switch at the end of the wanted flow. If you forget it, the program will continue and may lead to unexpected results.
- `default` : as it's name says use it as a default result when no other case matchs your expression's result.

At their simplest they test a primitive or string expression and make a decision based on its value. For example:

```java
String direction = getDirection();
switch (direction) {
    case "left":
        goLeft();
        break;
    case "right":
        goRight();
        break;
    default:
        //otherwise
        markTime();
        break;
}
```

Starting with Java 14 (available as a preview before in Java 12 and 13) it is possible to use the "enhanced" switch implementation.

1. You have the possiblity to assign multiple value in a sigle case.
   In the traditional switch-statement you can use fall-throught. In the following example `case 1` and `case 3` will execute the same stuff. This is done by `case 1` not using the `break` keyword.

   ```java
   switch (number) {
       case 1:
       case 3:
           //do same stuff
           break;
       case 2:
           //do different stuff
           break;
       (...)
   }
   ```

   In the enhanced `switch expression` you can directly assign multiple value to a `case`.
   Look at the following exemple :

   ```java
   switch (number) {
       case 1, 3:
           //do stuff
           break;
       case 2:
           //do other stuff
           break;
       (...)
   }
   ```

2. You can now write a `switch-statement` or a `switch expression`. What is the difference ?
   Basicly a statement is expecting some strict logic where an expression can return a value.
   Instead of :

   ```java
   String result = "";
   switch (expression) {
       case "bob":
           result = "bob;
           break;
       (...)
   }
   ```

   You can do :

   ```java
   String result = switch(expression) {
       case "bob":
           yield "bob";
       (...)
   }
   ```

   The [`yield`][yield-keyword] works like a `return` except it's for switch expression. As `yield` terminates the expression `break` is not needed here.

3. Another difference between _switch statements_ and _switch expressions_: in _switch expressions_ you _**MUST**_ cover all cases. Either by having a `case` for all possible values or using a `default` case.

4. You can use `->` instead of `:`. The `->` allow you to not include the `break` keyword. Both notation can be used but in a switch you have to stick with only one.

   ```java
       switch(expression) {
           case 1 -> yield "one"
           case 2 -> yield "two"
           default: yield "other number" // Removing this will result in a compile error
       }
   ```

5. The scope. Traditionnals `switch` can lead to some unexected behavior because of it's scope as there is only one scope for the whole `switch`.

   ```java
       switch(expression) {
           case 1:
               String message = "something";
               break;
           case 2:
               String message = "anything";
               break;
           (...)
       }
   ```

   This exemple is not working because message is declared twice in the `switch`.
   It could be solved using :

   ```java
       switch(expression) {
           case 1: {
               String message = "something";
               break;
           }
           case 2: {
               String message = "anything";
               break;
           }
           (...)
       }
   ```

   As the `{}` is delimiting the scope of the `case`. However it's not intuitive because `{}` are not mandatory.
   However if you use the new `->` notation it must be followed by either : a single statement/expression, a `throw` statement or a `{}` block. No more confussion!

You can find more information on enhanced switch [here][switch1], [here][switch2] and on the [oracle documentation][oracle-doc].

[yield-keyword]: https://www.codejava.net/java-core/the-java-language/yield-keyword-in-java
[switch1]: https://www.vojtechruzicka.com/java-enhanced-switch/
[switch2]: https://howtodoinjava.com/java14/switch-expressions/
[oracle-doc]: https://docs.oracle.com/en/java/javase/13/language/switch-expressions.html
