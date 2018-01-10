# Phone Number

Clean up user-entered phone numbers so that they can be sent SMS messages.

The **North American Numbering Plan (NANP)** is a telephone numbering system used by many countries in North America like the United States, Canada or Bermuda. All NANP-countries share the same international country code: `1`.

NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan Area code, commonly known as *area code*, followed by a seven-digit local number. The first three digits of the local number represent the *exchange code*, followed by the unique four-digit number which is the *subscriber number*.

The format is usually represented as

```text
(NXX)-NXX-XXXX
```

where `N` is any digit from 2 through 9 and `X` is any digit from 0 through 9.

Your task is to clean up differently formatted telephone numbers by removing punctuation and the country code (1) if present.

For example, the inputs
- `+1 (613)-995-0253`
- `613-995-0253`
- `1 613 995 0253`
- `613.995.0253`

should all produce the output

`6139950253`

**Note:** As this exercise only deals with telephone numbers used in NANP-countries, only 1 is considered a valid country code.

# Java Tips

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


# Running the tests

You can run all the tests for an exercise by entering

```sh
$ gradle test
```

in your terminal.

## Source

Event Manager by JumpstartLab [http://tutorials.jumpstartlab.com/projects/eventmanager.html](http://tutorials.jumpstartlab.com/projects/eventmanager.html)

## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have completed the exercise.
