# List Ops

Implement basic list operations.

In functional languages list operations like `length`, `map`, and
`reduce` are very common. Implement a series of basic list operations,
without using existing functions.

The precise number and names of the operations to be implemented will be 
track dependent to avoid conflicts with existing names, but the general
operations you will implement include:

* `append` (*given two lists, add all items in the second list to the end of the first list*);
* `concatenate` (*given a series of lists, combine all items in all lists into one flattened list*);
* `filter` (*given a predicate and a list, return the list of all items for which `predicate(item)` is True*);
* `length` (*given a list, return the total number of items within it*);
* `map` (*given a function and a list, return the list of the results of applying `function(item)` on all items*);
* `foldl` (*given a function, a list, and initial accumulator, fold (reduce) each item into the accumulator from the left using `function(accumulator, item)`*);
* `foldr` (*given a function, a list, and an initial accumulator, fold (reduce) each item into the accumulator from the right using `function(item, accumulator)`*);
* `reverse` (*given a list, return a list with all the original items, but in reversed order*);

# Tips

## Hints

In Java it's considered best practice to use instance methods over class methods. However, there are conditions in which it is absolutely appropriate for a function to be `static`. Since classes in Java are closed for modification (i.e. you cannot add members to a class outside its definition like you can in other languages like Ruby or JavaScript), you cannot add new behavior to the class directly. What to do if you still want to define behavior for a given type? The idiomatic solution in this case is to write a utility method. 
Collections of these kinds of methods are often referred to as "utility classes". Examples of such classes from within the JRE include [Arrays](https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html) and [Collections](https://docs.oracle.com/javase/9/docs/api/java/util/Collections.html).
In this exercise we want a List to have `map()`, `reduce()`, `filter()`, etc. methods. It doesn't, so we're using static methods.

The `foldLeft` and `foldRight` methods are "fold" functions, which is a concept well-known in the functional programming world, but less so in the object-oriented one. See the Wikipedia page on folding for [general background](https://en.wikipedia.org/wiki/Fold_(higher-order_function)) and [signature/implementation hints](https://en.wikipedia.org/wiki/Fold_(higher-order_function)#Linear_folds).


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

In the test suites all tests but the first have been skipped.

Once you get a test passing, you can enable the next one by removing the
`@Ignore("Remove to run test")` annotation.


## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
