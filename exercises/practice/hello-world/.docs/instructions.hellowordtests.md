## Running Tests Locally

Even if you are already familiar with Java basics, stepping through this guide

may be helpful as it will help you understand the output from the tool, Gradle,

that we use to compile and test our code, as well as introduce some of the

patterns common to all exercises in this track..

# Solving "Hello, World!"

Before proceeding any further, make sure you have completed the required setup
steps described by the link below:
* [Installing Java and Gradle](https://exercism.org/docs/tracks/java/installation);

You can run test online by utilizing our online text editor, but if you want test locally see link ->
[Testing locally on the java track](https://exercism.org/docs/tracks/java/tests) 


## Step 1: Replace the `UnsupportedOperationException`

In the online editor, you should find an exception on line 4:

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

Delete the contents of line 4 and replace it with:

```java
    String getGreeting() {
        return "Hello, World!";
    }
```

## Step 2: Run the tests within the online editor

After making corrections and implementing your solution, ensure to run the program by selecting the "Run Tests"

button on the online editor. If the tests fails, that's ok! Simply refactor your code and test again. 


Success! Our solution passes the test cases . We're good to go!

# Submitting your first iteration

With a working solution that we've reviewed, we're ready to submit it to
exercism.io.

```
$ exercism submit src/main/java/Greeter.java
```

