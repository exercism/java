# Clock

Implement a clock that handles times without dates.

You should be able to add and subtract minutes to it.

Two clocks that represent the same time should be equal to each other.

# Tips

In order to satisfy the requirement that two clocks are considered equal just when they are set to the same time, you will need to override the [`equals`](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals(java.lang.Object)) and [`hashcode`](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#hashCode) methods in your `Clock` class.
 
For more information on how to override these methods, see [this JavaWorld article](https://web.archive.org/web/20170528222153/http://www.javaworld.com/article/2072762/java-app-dev/object-equality.html).


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

## Source

Pairing session with Erin Drummond [https://twitter.com/ebdrummond](https://twitter.com/ebdrummond)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
