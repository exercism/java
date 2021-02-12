# Instructions append

This exercise introduces [generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html).
To make the tests pass you need to construct your class such that it accepts any type of input, e.g. `Integer` or `String`.

Generics are useful because they allow you to write more general and reusable code.
The Java [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html) and [Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html) implementations are both examples of classes that use generics.
By using them you can construct a `List` containing `Integers` or a list containing `Strings` or any other type.

There are a few constraints on the types used in generics.
One of them is that once you've constructed a `List` containing `Integers`, you can't put `Strings` into it.
You have to specify which type you want to put into the class when you construct it, and that instance can then only be used with that type.

For example you could construct a list of `Integers`:

`List<Integer> someList = new LinkedList<>();`

Now `someList` can only contain `Integers`. You could also do:

`List<String> someOtherList = new LinkedList<>()`

Now `someOtherList` can only contain `Strings`.

Another constraint is that any type used with generics cannot be a [primitive type](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html), such as `int` or `long`.
However, every primitive type has a corresponding reference type, so instead of `int` you can use [`Integer`](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html) and instead of `long` you can use [`Long`](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html).

It can help to look at an [example use case of generics](https://docs.oracle.com/javase/tutorial/java/generics/types.html) to get you started.
