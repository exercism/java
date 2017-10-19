# Binary Search

Implement a binary search algorithm.

Searching a sorted collection is a common task. A dictionary is a sorted
list of word definitions. Given a word, one can find its definition. A
telephone book is a sorted list of people's names, addresses, and
telephone numbers. Knowing someone's name allows one to quickly find
their telephone number and address.

If the list to be searched contains more than a few items (a dozen, say)
a binary search will require far fewer comparisons than a linear search,
but it imposes the requirement that the list be sorted.

In computer science, a binary search or half-interval search algorithm
finds the position of a specified input value (the search "key") within
an array sorted by key value.

In each step, the algorithm compares the search key value with the key
value of the middle element of the array.

If the keys match, then a matching element has been found and its index,
or position, is returned.

Otherwise, if the search key is less than the middle element's key, then
the algorithm repeats its action on the sub-array to the left of the
middle element or, if the search key is greater, on the sub-array to the
right.

If the remaining array to be searched is empty, then the key cannot be
found in the array and a special "not found" indication is returned.

A binary search halves the number of items to check with each iteration,
so locating an item (or determining its absence) takes logarithmic time.
A binary search is a dichotomic divide and conquer search algorithm.

# Java Tips

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


# Running the tests

You can run all the tests for an exercise by entering

```sh
$ gradle test
```

in your terminal.

## Source

Wikipedia [http://en.wikipedia.org/wiki/Binary_search_algorithm](http://en.wikipedia.org/wiki/Binary_search_algorithm)

## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have completed the exercise.
