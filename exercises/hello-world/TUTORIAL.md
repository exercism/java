NOTE: You can also view the HTML version of this file here:
https://github.com/exercism/xjava/blob/master/exercises/hello-world/TUTORIAL.md

* [Solving "Hello, World!"](#solving-hello-world)
 * [Reading Gradle output](#reading-gradle-output)
 * [Fixing the first failing test](#fixing-the-first-failing-test)
 * [Enabling and fixing the second test](#enabling-and-fixing-the-second-test)
 * [Enabling the last test](#enabling-the-last-test)
 * [Refactoring](#refactoring)
* [Submitting your first iteration](#submitting-your-first-iteration)
* [Next Steps](#next-steps)
 * [Review (and comment on) others' submissions to this exercise](#review-and-comment-on-others-submissions-to-this-exercise)
 * [Extend an exercise](#extend-an-exercise)

----

# Solving "Hello, World!"

Welcome to the first exercise on the Java track!

This is a step-by-step guide to solving this exercise.

Each exercise comes with a set of tests.  The first pass through the
exercise is about getting all of the tests to pass, one at a time.

If you have not installed the Java Development Kit and Gradle, you must do
so now.  For help with this, see: http://exercism.io/languages/java/installing

----

This guide picks-up where [Running the Tests (in Java)](http://exercism.io/languages/java/tests)
left off.  If you haven't reviewed those instructions, do so now.

The following instructions work equally well on Windows, Mac OS X and Linux.

## Reading Gradle output

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
the source code of our *solution*. We've done you a favor and included just
enough code for the solution that it compiles.

When a task is successful, it generally does not output anything.  This is
why `:compileJava` and `:classes` do not produce any additional output.
`:processResources` reports that it had nothing to do.

So far, so good...

The next three tasks are about compiling source code of the *tests*.

```
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
```

... with both sets of source code successfully compiled, Gradle turns to
running the task you asked it to: executing the tests against the solution.

```
:test

HelloWorldTest > helloNoName FAILED
    java.lang.AssertionError: expected:<Hello, World!> but was:<null>
        at org.junit.Assert.fail(Assert.java:93)
        at org.junit.Assert.failNotEquals(Assert.java:647)
        at org.junit.Assert.assertEquals(Assert.java:128)
        at org.junit.Assert.assertEquals(Assert.java:147)
        at HelloWorldTest.helloNoName(HelloWorldTest.java:10)

HelloWorldTest > helloSampleName SKIPPED

HelloWorldTest > helloAnotherSampleName SKIPPED

3 tests completed, 1 failed, 2 skipped
:test FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':test'.
> There were failing tests. See the report at: file:///Users/jtigger/projects/exercism/xjava/build/exercism/java/hello-world/build/reports/tests/index.html

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

BUILD FAILED

Total time: 6.716 secs
```

Seeing the word "fail" TEN TIMES might give you the impression you've done
something horribly wrong.  You haven't.  It's a whole lot of noise over
a single test not passing.

Let's focus in on the important bits:

```
HelloWorldTest > helloNoName FAILED
    java.lang.AssertionError: expected:<Hello, World!> but was:<null>
```

...is read: "Within the test class named `HelloWorldTest`, the test method
`helloNoName` did not pass because the solution did not satisfy an
assertion.  Apparently, we expected to see the string 'Hello, World!' but
the value `null` was returned instead.

The last line of the stack trace tells us exactly where this unsatisfied
assertion lives:

```
        at HelloWorldTest.helloNoName(HelloWorldTest.java:10)
```

Looks like the crime was discovered on line 10 in the test file.

Knowing these two facts,

1. the return value was not what was expected, and
2. the failure was on line 10 of the test,
 
we can turn this failure into success.



## Fixing the first failing test

In your favorite text editor, open `src/test/java/HelloWorldTest.java`
and go to line 10.

```java
assertEquals("Hello, World!", HelloWorld.hello(""));
```

The test is expecting that `hello()`, when given an empty string (`""`),
returns "Hello, World!".  Instead, `hello()` is returning `null`.
Let's fix that.

Open `src/main/java/HelloWorld.java`.

```java
public class HelloWorld {
  public static String hello(String name) {
    return null;
  }
}
```

Let's change that to return the expected string:

```java
public class HelloWorld {
  public static String hello(String name) {
    return "Hello, World!";
  }
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

HelloWorldTest > helloAnotherSampleName SKIPPED

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloSampleName SKIPPED

BUILD SUCCESSFUL

Total time: 4.523 secs
```

"BUILD SUCCESSFUL"!  Woohoo! :)  You can see that `helloNoName()` test is
now passing.

With one win under our belt, we can turn our focus to some other messages
that we've been ignoring: the lines ending in "`SKIPPED`".

Each test suite contains a series of tests, all of which have been marked
to be skipped/ignored except the first one.  We did this to help you focus
on getting one test running at a time.

Let's tackle the next test...



## Enabling and fixing the second test

Right now, that second test is being skipped/ignored.  Let's enable it.

(Re)open `src/test/java/HelloWorldTest.java` and find the second test:

```java
...
@Test
@Ignore
public void helloSampleName() {
  assertEquals("Hello, Alice!", HelloWorld.hello("Alice"));
}
...
```

When the JUnit test runner sees that `@Ignore` annotation on the test
method, it knows to skip over that test.  Remove that line:

```java
...
@Test
public void helloSampleName() {
  assertEquals("Hello, Alice!", HelloWorld.hello("Alice"));
}
...
```

Now, when you run the tests, both tests run:

```sh
$ gradle test
...
:test

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloSampleName FAILED
    org.junit.ComparisonFailure: expected:<Hello, [Alice]!> but was:<Hello, [World]!>
        at org.junit.Assert.assertEquals(Assert.java:125)
        at org.junit.Assert.assertEquals(Assert.java:147)
        at HelloWorldTest.helloSampleName(HelloWorldTest.java:16)

HelloWorldTest > helloAnotherSampleName SKIPPED

3 tests completed, 1 failed, 1 skipped
...
```

The first test, `helloNoName()` continues to pass.  We see that
`helloSampleName` -- the test we just un-`@Ignore`'d -- is now running and
failing.  Yay, failing test!  In fact, the "failure" message is just
describing the difference between what the program does now and what it
should do for us to call it "done."

Right now, we've hardcoded the greeting.  Enabling this second test has
unleashed a new expectation: that our program incorporate a name given
into that greeting.  When given the name "`Alice`", that's who should be
greeted instead of "`World`".

(Re)open `src/main/java/HelloWorld.java`.

```java
public class HelloWorld {
  public static String hello(String name) {
    return "Hello, World!";
  }
}
```

While `hello()` does accept a reference to a string named `name`, it is not
using it in the output.  Let's change that:


```java
public class HelloWorld {
  public static String hello(String name) {
    return "Hello, " + name + "!";
  }
}
```

... and rerun the tests ...

```
$ gradle test
:test

HelloWorldTest > helloAnotherSampleName SKIPPED

HelloWorldTest > helloNoName FAILED
    org.junit.ComparisonFailure: expected:<Hello, [World]!> but was:<Hello, []!>
        at org.junit.Assert.assertEquals(Assert.java:125)
        at org.junit.Assert.assertEquals(Assert.java:147)
        at HelloWorldTest.helloNoName(HelloWorldTest.java:10)

HelloWorldTest > helloSampleName PASSED

3 tests completed, 1 failed, 1 skipped
```

Wait... didn't we just fix the test?  Why is it failing?  Take a closer look...

In fact, `helloSampleName()` *is* passing.  It's just that at the same time,
we just inadvertently broke that first test: `helloNoName()`.

This is one tiny example of the benefit of maintaining a test suite: if we
use them to drive out our code, the second we break the program the tests
say so.  Since we saw them passing just *before* our latest change,
whatever we *just* did most likely cause that regression.

Our latest change was making the greeting dependent on the name given. Our
first test expects that if either a blank string or null are given as the
name, then "`World`" should be substituted in.  Let's implement that.

`src/main/java/HelloWorld.java`:
```java
public class HelloWorld {
  public static String hello(String name) {
    if(name == null || "".equals(name)) {
      name = "World";
    }
    return "Hello, " + name + "!";
  }
}
```

... and re-run the tests ...

```
$ gradle test
...
:test

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloSampleName PASSED

HelloWorldTest > helloAnotherSampleName SKIPPED

BUILD SUCCESSFUL

Total time: 4.804 secs
```

Excellent!  We're now (at least) two-thirds the way done.  Just one more
test to go...



## Enabling the last test

(Re)open `src/test/java/HelloWorldTest.java` and find the last test:

```java
...
@Test
@Ignore
public void helloAnotherSampleName() {
    assertEquals("Hello, Bob!", HelloWorld.hello("Bob"));
}
...
```

... and remove it's `@Ignore` to enable it ...

```java
...
@Test
public void helloAnotherSampleName() {
    assertEquals("Hello, Bob!", HelloWorld.hello("Bob"));
}
...
```

... and re-run the tests ...

```
$ gradle test
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
:test

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloSampleName PASSED

HelloWorldTest > helloAnotherSampleName PASSED

BUILD SUCCESSFUL

Total time: 6.953 secs
```

Oh, hello!  Turns out, the solution we put into place didn't just apply for
"`Alice`" but "`Bob`" equally well.  In this case, the test succeeded with
no additional code on our part.



## Refactoring

Now that you've got all the tests passing, you might consider whether
the code is in the most readable/maintainable/efficient shape.  What makes
for "good" design of software is a big topic.  The pursuit of it underlies
much of what makes up the more valuable conversations on Exercism.

For now, let's just take a quick review of our solution and see if there's
any part of it we'd like to refactor.  Refactoring is changing the way
a bit of code reads without changing what it does.

Right now, the details of detecting whether the caller of `hello()` has
given a name or not (i.e. `name` is either `null` or an empty string) is
sitting right next to the core responsibility of the method: to produce a
personalized greeting.

```java
public class HelloWorld {
  public static String hello(String name) {
    if(name == null || "".equals(name)) {
      name = "World";
    }
    return "Hello, " + name + "!";
  }
}
```

How would things read if we extracted those details into a separate method
and at the same time, replaced the `if` with a ternary expression?

```java
public class HelloWorld {

  public static String hello(String name) {
    String whom = isBlank(name) ? "World" : name;
    return "Hello, " + whom + "!";
  }

  private static boolean isBlank(String string) {
    return string == null || "".equals(string);
  }
}
```

By extracting that logic into the `isBlank()` method, we've added a little
abstraction to our program -- it's not as literal as it was before.  Yet,
it allows us to defer *needing* to understand *how* "blankness" is
detected.  If we can assume that `isBlank()` just works, we don't have to
downshift in our head to those details.  Instead, we can remain at the same
level of thinking: to whom are we greeting?

The ternary operator allowed us to express that choice in a more compact
form.  Less to read without losing the intent.

Finally, we introduced another variable: `whom`.  Doing so gives a name to
the output of the ternary expression.  We certainly could have continued
to reuse `name`, but by introducing a second `String` to hold the
calculated value this keeps crisp the two ideas: `name` is what's given
and `whom` is what's been determined.

We made a bunch of changes, let's make sure we didn't break the program!

```
$ gradle test
...
HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloSampleName PASSED

HelloWorldTest > helloAnotherSampleName PASSED
...
```

This illustrates another benefit of writing tests: you can make significant
changes to the structure of the program and very quickly restore your
confidence that the program still works.  These tests are a far cry from a
"proof" of correctness, but well-written tests do a much better job of
(very quickly) giving us evidence that it is.  Without them, we manually
run the program with different inputs and/or inspecting the code
line-by-line -- time-consuming and error prone.



# Submitting your first iteration

With a working solution that we've reviewed, we're ready to submit it to
exercism.io.

```
$ exercism submit src/main/java/HelloWorld.java
```



# Next Steps

From here, there are a number of paths you can take.


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



## Submit another iteration

You are also encouraged to consider additional "requirements" on a given
exercise.

For example, you could add a test or two that requires that the greeting
use the capitalized form on the person's name, regardless of the case they
used.

In that situation, you'd write a test to set-up that new expectation and
then implement that in the code (the same process we just went through
together, above).



## Contribute to Exercism

The entire of Exercism is Open Source and is the labor of love for over
100 maintainers and many more contributors.

A starting point to jumping in can be found here:

https://github.com/exercism/x-common/blob/master/CONTRIBUTING.md


----

Regardless of what you decide to do next, we sincerely hope you learn
and enjoy being part of this community.  If at any time you need assistance
do not hesitate to ask for help:

http://exercism.io/languages/java/help

Cheers!
