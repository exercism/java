NOTE: You can also view the HTML version of this file here:
https://github.com/exercism/kotlin/blob/master/exercises/hello-world/TUTORIAL.md

* [Introduction](#introduction)
* [Exercise Structure](#exercise-structure)
* [Solving "Hello, World!"](#solving-hello-world)
* [Submitting your first iteration](#submitting-your-first-iteration)
* [Next Steps](#next-steps)

----

# Introduction

Welcome to the first exercise on the Kotlin track!

This is a step-by-step guide to solving this exercise.

Each exercise comes with a set of tests.  The first pass through the
exercise is about getting all of the tests to pass, one at a time.

If you have not installed the Java Development Kit and Gradle, you must do
so now.  For help with this, see: http://exercism.io/languages/kotlin/installation

----

This guide picks-up where [Running the Tests (in Kotlin)](http://exercism.io/languages/kotlin/tests)
left off.  If you haven't reviewed those instructions, do so now.

The following instructions work equally well on Windows, macOS and Linux.

# Exercise Structure

When you fetch a new Kotlin exercise, you will receive:

* __one or more test files__ (always). These live in the `src/test/kotlin`
directory and define a set of tests that our solution must satisfy before we
can safely declare that it is working.
* __one or more starter files__ (initially). If provided, these live in the
`src/main/kotlin` directory and define shells of the classes you will need
in order to solve the current problem.



# Solving "Hello World!"

## Step 1: Run the tests against the starter solution

Use Gradle to run the tests:

```
$ gradle test
```

This command does a lot and displays a bunch of stuff.  Let's break it down...

```
:compileKotlin
w: /Users/jtigger/exercism/exercises/kotlin/hello-world/src/main/kotlin/HelloWorld.kt: (1, 11): Parameter 'name' is never used
:compileJava UP-TO-DATE
:copyMainKotlinClasses
:processResources UP-TO-DATE
:classes UP-TO-DATE
```

Each line that begins with a colon (like `:compileKotlin`) is Gradle telling
us that it's starting that task.  The first five tasks are about compiling
the source code of our *solution*.  We've done you a favor and included just
enough code for the solution that it compiles.

When a task is successful, it generally does not output anything.  This is
why `:copyMainKotlinClasses` does not produce any additional output.

A task may succeed but warn of a potential problem.  This is what we see from
`:compileKotlin`.  The Kotlin compiler tells us that on line 1, 11 characters in
of the `HelloWorld.kt` file, there is a parameter called `name` that was
declared but never used.  Usually, warnings _are_ helpful and should be heeded.
We'll address this warning soon enough, but we're okay for now.

The next five tasks are about compiling source code of the *tests*.

```
:compileTestKotlin
:compileTestJava UP-TO-DATE
:copyTestKotlinClasses
:processTestResources UP-TO-DATE
:testClasses UP-TO-DATE
```

... with both sets of source code successfully compiled, Gradle turns to
running the task you asked it to: executing the tests against the solution.

```
:test


HelloWorldTest > helloWorldTest FAILED
    org.junit.ComparisonFailure: expected:<[Hello, World!]> but was:<[]>
        at org.junit.Assert.assertEquals(Assert.java:115)
        at org.junit.Assert.assertEquals(Assert.java:144)
        at HelloWorldTest.helloNoName(HelloWorldTest.kt:10)

1 test completed, 1 failed
:test FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':test'.
> There were failing tests. See the report at: file:///Users/jtigger/exercism/exercises/kotlin/hello-world/build/reports/tests/index.html

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

BUILD FAILED

Total time: 7.473 secs
```

Seeing the word "fail" might give you the impression you've done
something horribly wrong!  You haven't.  It's a whole lot of noise over
a single test not passing.

Let's focus in on the important bits:

```
HelloWorldTest > helloWorldTest FAILED
    org.junit.ComparisonFailure: expected:<[Hello, World!]> but was:<[]>
```

...is read: "Within the test class named `HelloWorldTest`, the test method
`helloWorldTest` did not pass because the solution did not satisfy an
assertion.  Apparently, we expected to see the string 'Hello, World!' but
a blank string was returned instead.

The last line of the stack trace tells us exactly where this unsatisfied
assertion lives:

```
        at HelloWorldTest.helloWorldTest(HelloWorldTest.kt:10)
```

Looks like the scene of the crime is on line 10 in the test file.

Knowing these two facts,

1. the return value was not what was expected, and
2. the failure was on line 10 of the test,

we can turn this failure into success.

## Step 2: Fix the Test!

In your favorite text editor, open `src/test/kotlin/HelloWorldTest.kt`
and go to line 10.

```kotlin
assertEquals("Hello, World!", hello())
```

The test is expecting that `hello()`, returns "Hello, World!".  Instead, `hello()` is returning `""`.
Let's fix that.

Open `src/main/kotlin/HelloWorld.kt`.

```kotlin
fun hello(): String {
   return ""
}
```

Let's change that to return the expected string:

```kotlin
fun hello(): String {
   return "Hello, World!"
}
```

Save the file and run the tests again:

```
$ gradle test
:compileKotlin
:compileJava UP-TO-DATE
:copyMainKotlinClasses
:processResources UP-TO-DATE
:classes UP-TO-DATE
:compileTestKotlin
:compileTestJava UP-TO-DATE
:copyTestKotlinClasses UP-TO-DATE
:processTestResources UP-TO-DATE
:testClasses UP-TO-DATE
:test

HelloWorldTest > helloWorldTest PASSED

BUILD SUCCESSFUL

Total time: 7.318 secs
```

"BUILD SUCCESSFUL"!  Woohoo! :)  You can see that `helloWorldTest()` test is
now passing.

Congratulations!

# Submitting your first iteration

With a working solution that we've reviewed, we're ready to submit it to
exercism.io.

```
$ exercism submit src/main/kotlin/HelloWorld.kt
```



# Next Steps

From here, there are a number of paths you can take.


## Move on to another exercise

There are many more exercises you can practice with.  Grab another one
from the [Kotlin track](https://exercism.io/my/tracks/kotlin).


## Review (and comment on) others' submissions to this exercise

The heart of Exercism is the conversations about coding
practices.  It's definitely fun to practice, but engaging with others
both in their attempts and your own is how you get feedback.  That feedback
can help point out what you're doing well and where you might need to
improve.

Some submissions will be nearly identical to yours; others will be
completely different.  Seeing both kinds can be instructive and interesting.

Note that you can only view submissions of others for exercises you have
completed yourself.  This enriches the experience of reading others' code
because you'll have your own experience of trying to solve the problem.

Here's an up-to-date list of submissions on the Kotlin track:

http://exercism.io/tracks/kotlin/exercises



## Submit another iteration

You are also encouraged to consider additional "requirements" on a given
exercise.

For example, you could add a test or two that requires that the greeting
use the capitalized form on the person's name, regardless of the case they
used.

In that situation, you'd:

1. add a new test setting up that new expectation,
2. implement that in the code (the same process we just went through
   together, above).
3. review your code for readability and refactor as you see fit.

Exercism practitioners who "play" with each exercise — over trying to go as
fast as they can through the stream of exercises — report deep rewards.


## Contribute to Exercism

The entire of Exercism is Open Source and is the labor of love for more
than 100 maintainers and many more contributors.

A starting point to jumping in can be found here:

https://github.com/exercism/docs/blob/master/contributing-to-language-tracks/README.md

----

Regardless of what you decide to do next, we sincerely hope you learn
and enjoy being part of this community.  If at any time you need assistance
do not hesitate to ask for help:

http://exercism.io/languages/kotlin/help

Cheers!
