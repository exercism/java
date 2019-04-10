# Linked List

Implement a doubly linked list.

Like an array, a linked list is a simple linear data structure. Several
common data types can be implemented using linked lists, like queues,
stacks, and associative arrays.

A linked list is a collection of data elements called *nodes*. In a
*singly linked list* each node holds a value and a link to the next node.
In a *doubly linked list* each node also holds a link to the previous
node.

You will write an implementation of a doubly linked list. Implement a
Node to hold a value and pointers to the next and previous nodes. Then
implement a List which holds references to the first and last node and
offers an array-like interface for adding and removing items:

* `push` (*insert value at back*);
* `pop` (*remove value at back*);
* `shift` (*remove value at front*).
* `unshift` (*insert value at front*);

To keep your implementation simple, the tests will not cover error
conditions. Specifically: `pop` or `shift` will never be called on an
empty list.

If you want to know more about linked lists, check [Wikipedia](https://en.wikipedia.org/wiki/Linked_list).

# Tips

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


## Setup

Go through the setup instructions for Java to install the necessary
dependencies:

[https://exercism.io/tracks/java/installation](https://exercism.io/tracks/java/installation)

# Running the tests

You can run all the tests for an exercise by entering the following in your
terminal:

```sh
$ gradle test
```

> Use `gradlew.bat` if you're on Windows

In the test suites all tests but the first have been skipped.

Once you get a test passing, you can enable the next one by removing the
`@Ignore("Remove to run test")` annotation.

## Source

Classic computer science topic

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
