# Series

Given a string of digits, output all the contiguous substrings of length `n` in
that string in the order that they appear.

For example, the string "49142" has the following 3-digit series:

- "491"
- "914"
- "142"

And the following 4-digit series:

- "4914"
- "9142"

And if you ask for a 6-digit series from a 5-digit string, you deserve
whatever you get.

Note that these series are only required to occupy *adjacent positions*
in the input; the digits need not be *numerically consecutive*.

# Tips

Since this exercise has difficulty 5 it doesn't come with any starter implementation.
This is so that you get to practice creating classes and methods which is an important part of programming in Java.
It does mean that when you first try to run the tests, they won't compile.
They will give you an error similar to:
```
 path-to-exercism-dir\exercism\java\name-of-exercise\src\test\java\ExerciseClassNameTest.java:14: error: cannot find symbol
        ExerciseClassName exerciseClassName = new ExerciseClassName();
        ^
 symbol:   class ExerciseClassName
 location: class ExerciseClassNameTest
```
This error occurs because the test refers to a class that hasn't been created yet (`ExerciseClassName`).
To resolve the error you need to add a file matching the class name in the error to the `src/main/java` directory.
For example, for the error above you would add a file called `ExerciseClassName.java`.

When you try to run the tests again you will get slightly different errors.
You might get an error similar to:
```
  constructor ExerciseClassName in class ExerciseClassName cannot be applied to given types;
        ExerciseClassName exerciseClassName = new ExerciseClassName("some argument");
                                              ^
  required: no arguments
  found: String
  reason: actual and formal argument lists differ in length
```
This error means that you need to add a [constructor](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html) to your new class.
If you don't add a constructor, Java will add a default one for you.
This default constructor takes no arguments.
So if the tests expect your class to have a constructor which takes arguments, then you need to create this constructor yourself.
In the example above you could add:
```
ExerciseClassName(String input) {

}
``` 
That should make the error go away, though you might need to add some more code to your constructor to make the test pass!

You might also get an error similar to:
```
  error: cannot find symbol
        assertEquals(expectedOutput, exerciseClassName.someMethod());
                                                       ^
  symbol:   method someMethod()
  location: variable exerciseClassName of type ExerciseClassName
```
This error means that you need to add a method called `someMethod` to your new class.
In the example above you would add:
```
String someMethod() {
  return "";
}
```
Make sure the return type matches what the test is expecting.
You can find out which return type it should have by looking at the type of object it's being compared to in the tests.
Or you could set your method to return some random type (e.g. `void`), and run the tests again.
The new error should tell you which type it's expecting.

After having resolved these errors you should be ready to start making the tests pass!


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

A subset of the Problem 8 at Project Euler [http://projecteuler.net/problem=8](http://projecteuler.net/problem=8)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
