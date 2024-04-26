# Instructions append

Since this is your first Java exercise, we've included a detailed [Tutorial] that guides you through your solution. Check it out for tips and assistance!

## Tutorial

### Table of Contents

- [Introduction]
- [Exercise Structure]
- [Solving "Hello, World!"]
- [Step 1: Fix the solution]
- [Step 2: Run the tests]
- [Step 3: Submitting your first iteration]
- [Next steps]

### Introduction

Welcome to the first exercise on the Java track!

This document is a step-by-step guide to solving this exercise.
The instructions should work equally well on Windows, macOS and Linux.

Even if you are already familiar with Java basics, stepping through this guide may be helpful as it will help you understand the output from the tool, Gradle, that we use to compile and test our code, as well as introduce some of the patterns common to all exercises in this track.

### Exercise Structure

When you fetch a new Java exercise, you will receive:

- __one or more test files__ (always).
These live in the `src/test/java` directory and define a set of tests that our solution must satisfy before we can safely declare that it is working.
- __one or more starter files__ (initially).
If provided, these live in the `src/main/java` directory and define shells of the classes you will need in order to solve the current problem.

### Solving "Hello, World!"

You can use our online editor to solve your solution and run the tests, but if you want to solve the problem and run tests locally check these links below:

- [Installing Java]
- [Working Locally]
- [Testing locally on the java track]

### Step 1: Fix the solution

Either working locally or using the online editor, you should find the following code:

```java
String getGreeting() {
    return "Goodbye, Mars!";
}
```

The objective is to modify the provided code so it produces the text `"Hello, World!"` instead of `"Goodbye, Mars!"`.

### Step 2: Run the Tests

After making corrections and implementing your solution, run the tests again.
You can run the tests using the online editor or locally on your machine:

- To run the tests in the online editor, click the "Run Tests" button.
- To run the tests locally, check [Testing on the Java track][Testing locally on the java track] If the tests fails, that's ok! See what the error message is telling you, change your code and test again, when your tests pass, move on to the next step.

### Step 3: Submitting your first iteration

With a working solution that we've reviewed, we're ready to submit it to exercism.org.
You can submit the solution using the online editor or locally using the [Exercism CLI][Working Locally]:

- To submit the exercise locally, first [install the exercism CLI][Working Locally] if you haven't already and then submit the files of your solution, e.g:

  ```sh
  exercism submit <file location>
  ```

- Replace `<file location>` with the relative location of your `Greeter.java` file, so if you are working in `C:\exercism\java\hello-world` then the command would be

  ```sh
  exercism submit .\src\main\java\Greeter.java
  ```

- If you want to use the online editor to submit your solution, just click the "Submit" button!

For a closer look at submitting a solution locally:

- [Submitting locally][Working Locally]

### Next steps

From here, there are a number of paths you can take.

Regardless of what you decide to do next, we sincerely hope you learn and enjoy being part of this community.
If at any time you need assistance do not hesitate to ask for help.

Cheers!

### Move on to the next exercise

There are many more exercises you can practice with.
Grab the next one! (example for `two-fer`)

```sh
exercism download --exercise=two-fer --track=java
```

### Become a mentor

The heart of Exercism are the conversations about coding practices.
It's definitely fun to practice, but engaging with others both in their attempts and your own is how you get feedback.
That feedback can help point out what you're doing well and where you might need to improve.

Some submissions will be nearly identical to yours, others will be completely different.
Seeing both kinds can be instructive and interesting.

Mentors review submitted solutions for the track they've chosen to mentor to help users learn as much as possible.

To read more about mentoring, go to the following [link][Mentoring].

### Contribute to Exercism

The entire of Exercism is Open Source and is a labor of love for over 100 maintainers and many more contributors.

A starting point to jumping in and becoming a contributor can be found [here][Contributing].

[Tutorial]: #tutorial
[Introduction]: #introduction
[Exercise Structure]: #exercise-structure
[Solving "Hello, World!"]: #solving-hello-world
[Step 1: Fix the solution]: #step-1-fix-the-solution
[Step 2: Run the tests]: #step-2-run-the-tests
[Step 3: Submitting your first iteration]: #step-3-submitting-your-first-iteration
[Next steps]: #next-steps
[Mentoring]: https://exercism.org/docs/mentoring
[Contributing]: https://github.com/exercism/docs/tree/main/building
[Installing Java]: https://exercism.org/docs/tracks/java/installation
[Working Locally]: https://exercism.org/docs/using/solving-exercises/working-locally
[Testing locally on the java track]: https://exercism.org/docs/tracks/java/tests
