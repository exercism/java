# Table of Contents

* [Introduction](#introduction)
* [Exercise Structure](#exercise-structure)
* [Solving "Hello, World!"](#solving-hello-world)
* [Submitting your first iteration](#submitting-your-first-iteration)
* [Next Steps](#next-steps)

# Introduction

Welcome to the first exercise on the Java track!

This document is a step-by-step guide to solving this exercise. The
instructions should work equally well on Windows, Mac OS X and Linux.

Even if you are already familiar with Java basics, stepping through this guide
may be helpful as it will help you understand the output from the tool, Gradle,
that we use to compile and test our code, as well as introduce some of the
patterns common to all exercises in this track.

# Exercise Structure

When you fetch a new Java exercise, you will receive:

* __one or more test files__ (always). These live in the `src/test/java`
directory and define a set of tests that our solution must satisfy before we
can safely declare that it is working.
* __one or more starter files__ (initially). If provided, these live in the
`src/main/java` directory and define shells of the classes you will need
in order to solve the current problem.

# Solving "Hello, World!"

Before proceeding any further, make sure you have completed the required setup
steps described by the links below:
* [Installing Java and Gradle](http://exercism.io/languages/java/installation);
* [Running the Tests (in Java)](http://exercism.io/languages/java/tests).

## Step 1: Run the tests against the starter solution

Use Gradle to run the tests:

```
$ gradle test
```

This command does a lot and displays a bunch of stuff.  Let's break it down...

```
:compileJava
:processResources UP-TO-DATE
:classes
```

Each line that begins with a colon (like `:compileJava`) is Gradle telling
us that it's starting that task.  The first three tasks are about compiling
the source code of our _solution_. This exercise contains starter files with
just enough code for the solution to compile without requiring modification.

When a task is successful, it generally does not output anything.  This is
why `:compileJava` and `:classes` do not produce any additional output.
`:processResources` reports that it had nothing to do.

So far, so good...

The next three tasks are about compiling source code of the _tests_.

```
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
```

... with both sets of source code successfully compiled, Gradle turns to
running the task you asked it to: executing the tests against the solution.

```
:test

GreeterTest > testThatGreeterReturnsTheCorrectGreeting FAILED
    java.lang.UnsupportedOperationException: Delete this statement and write your own implementation.
        at getGreeting(Greeter.java:4)
        at GreeterTest.testThatGreeterReturnsTheCorrectGreeting(GreeterTest.java:9)

1 tests completed, 1 failed
:test FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':test'.
> There were failing tests. See the report at: file:///home/<username>/hello-world/build/reports/tests/index.html

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

BUILD FAILED

Total time: 12.361 secs
```

Seeing the word "FAILED" might give you the impression you've done
something wrong.  You haven't.  This output is just a very verbose way of
telling us that the included test did not pass. This is expected - we haven't
written any code to help it pass yet!

Let's focus in on the important bits:

```
GreeterTest > testThatGreeterReturnsTheCorrectGreeting FAILED
    java.lang.UnsupportedOperationException: Delete this statement and write your own implementation.
```

...is read: "Within the test class named `GreeterTest`, the test method
`testThatGreeterReturnsTheCorrectGreeting` did not pass because an
`UnsupportedOperationException` was thrown with the message `Delete this
statement and write your own implementation.`."

The next line of the [stack trace](https://stackoverflow.com/questions/3988788/what-is-a-stack-trace-and-how-can-i-use-it-to-debug-my-application-errors)
tells us where this `UnsupportedOperationException` was thrown:

```
        at getGreeting(Greeter.java:4)
```

Looks like it was on line 4 in the `Greeter.java` file. Let's update that line
as instructed, and try running the tests again.

## Step 2: Replace the `UnsupportedOperationException` 

In your favorite text editor, open `src/main/java/Greeter.java`. You should
find the source of the exception encountered above on line 4:

```java
throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
```

[`Exception`s](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
are often used in Java to draw the attention of a developer when something goes
wrong. In our case, nothing is wrong per se; we just haven't written our
solution yet! The use of an
[`UnsupportedOperationException`](http://docs.oracle.com/javase/8/docs/api/?java/lang/UnsupportedOperationException.html)
in this situation is designed to remind us of exactly this fact. It effectively
says: "Your Code Goes Here!".

Delete the contents of line 4 and replace it with the following:

```java
return null;
```

Now run `gradle test` again.

You should see a new error this time. Don't worry though, that still
represents forward progress!

```
GreeterTest > testThatGreeterReturnsTheCorrectGreeting FAILED
    java.lang.AssertionError: expected:<Hello, World!> but was:<null>
```

...is read: "Within the test class named `GreeterTest`, 
the test method `testThatGreeterReturnsTheCorrectGreeting` did not pass because
the solution did not satisfy an assertion." 

Apparently, our test was expecting to see the string "Hello, World!", but it
received the value `null` instead.

The last line of the stack trace tells us exactly where this "unsatisfied
assertion" lives:

```
        at testThatGreeterReturnsTheCorrectGreeting(GreeterTest.java:9)
```
Looks like the mismatch was discovered on line 9 in the test file.

Knowing these two facts:

1. that the return value was not what was expected, and
2. that the failure was on line 9 of the test file,

we can turn this failure into success.

## Step 3: Fix the test!

Open `src/test/java/GreeterTest.java` and go to line 9. It reads:

```java
assertEquals("Hello, World!", new Greeter().getGreeting());
```

The test is expecting that the method `getGreeting()` returns "Hello, World!".
Instead, `getGreeting()` is returning `null`. Let's fix that.

Open `src/main/java/Greeter.java`. It should look like this:

```java
class Greeter {

    String getGreeting() {
        return null;
    }

}
```

Remove the `return null` that we previously added, and instead return the
string our test was expecting:

```java
    String getGreeting() {
        return "Hello, World!";
    }
```

Save the file and run the tests again:

```
$ gradle test
:compileJava
:processResources UP-TO-DATE
:classes
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
:test

GreeterTest > testThatGreeterReturnsTheCorrectGreeting PASSED

BUILD SUCCESSFUL

Total time: 11.717 secs
```

Success! Our solution passes the only test case supplied. We're good to go!

# Submitting your first iteration

With a working solution that we've reviewed, we're ready to submit it to
exercism.io.

```
$ exercism submit src/main/java/Greeter.java
```

# Next Steps

From here, there are a number of paths you can take.

Regardless of what you decide to do next, we sincerely hope you learn
and enjoy being part of this community.  If at any time you need assistance
do not hesitate to ask for help:

http://exercism.io/languages/java/help

Cheers!

## Move on to the next exercise

There are many more exercises you can practice with.  Grab the next one!

```
$ exercism fetch java
```

## Review (and comment on) others' submissions to this exercise

The heart of Exercism are the conversations about coding
practices.  It's definitely fun to practice, but engaging with others
both in their attempts and your own is how you get feedback.  That feedback
can help point out what you're doing well and where you might need to
improve.

Some submissions will be nearly identical to yours; others will be
completely different.  Seeing both kinds can be instructive and interesting.

Note that you can only view submissions of others for exercises you have
completed yourself.  This enriches the experience of reading others' code
because you'll have your own experience of trying to solve the problem.

Here's an up-to-date list of submissions on the Java track:

http://exercism.io/tracks/java/exercises

## Contribute to Exercism

The entire of Exercism is Open Source and is a labor of love for over
100 maintainers and many more contributors.

A starting point to jumping in can be found here:

https://github.com/exercism/docs/tree/master/contributing-to-language-tracks
