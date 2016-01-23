# Getting Started

These exercises lean on Test-Driven Development (TDD), but they're not an exact match.

The following steps assume that you are in the base directory of the exercise.

You must have `gradle` installed.

## Step 1

Run the test suite. It's written using the JUnit framework, and can be run with gradle:

```sh
$ gradle test
```

This will fail, complaining that there is no method called `hello` for the `HelloWorld` class.

To fix the error, open `src/main/java/HelloWorld.java` and add a `hello` method that returns a `String`.
The method can return an empty string `""` for now:

```java
public class HelloWorld {
    public static String hello() {
        return "";
    }
}
```

## Step 2

Run the tests again. It will give you a new error, since now the method exists, but the tests are expects the
method to accept one argument as input, a name.

The errors will look something like:

```
$ gradle test
:compileJava
:processResources UP-TO-DATE
:classes
:compileTestJava
/exercism/exercises/java/hello-world/src/test/java/HelloWorldTest.java:9: error: method hello in class HelloWorld cannot be applied to given types;
        assertEquals("Hello, World!", HelloWorld.hello(""));
                                                ^
  required: no arguments
  found: String
  reason: actual and formal argument lists differ in length

  ...

4 errors
:compileTestJava FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileTestJava'.
> Compilation failed; see the compiler error output for details.
```

### Fixing the Error

To fix it, open `src/main/java/HelloWorld.java` and add a `name` to the method the signature:

```java
public class HelloWorld {
    public static String hello(String name) {
        return "";
    }
}
```

Now the `hello` method accepts a `name` as an input.

### Understanding Test Failures

Test failures will either be compilation errors or test failures. So far, we've been dealing with compilation
errors. Once our test and main code successful compile, `gradle` will run the actual test suite.

## Step 3

Run the tests again. You'll notice that the gradle output passes the `:compileTestJava` phase and fails
at the `:test` phase.

The errors will look something like:

```
$ gradle test
:compileJava
:processResources UP-TO-DATE
:classes
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
:test

HelloWorldTest > helloNoName FAILED
    org.junit.ComparisonFailure at HelloWorldTest.java:9

...

3 tests completed, 3 failed
:test FAILED
```

These are actual test failures. It means that both our main and test java code is running but the test is
expecting one outcome, but getting another.

Open `src/test/java/HelloWorldTest.java` and go to line 9.

```java
assertEquals("Hello, World!", HelloWorld.hello(""));
```

The test is expecting that `hello` returns "Hello, World!", when given an empty string (`""`) as input.
The easiest way to make the test pass is to return `"Hello, World!"` instead of `"".

```java
public class HelloWorld {
    public static String hello(String name) {
        return "Hello, World!";
    }
}
```

## Wash, Rinse, Repeat

Run the tests again.

If it fails you're going to need to read the error message carefully to figure out what went wrong, fix the problem
in the main code, and then try again until all the tests pass.

```
$ gradle test
:compileJava
:processResources UP-TO-DATE
:classes
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
:test

BUILD SUCCESSFUL
```

## Submit

When everything is passing, you can submit your code with the following command:

```
$ exercism submit src/main/java/HelloWorld.java
```



