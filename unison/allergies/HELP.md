# Help

## Running the tests

## Quick overview

  1. Make your changes in the `<myFileName>.u` file
  2. Save the `<myFileName>.u` file
  3. If the file typechecks, run the `add` or `update` UCM commands
    * If the file does not typecheck, make changes to the code in your `<myFileName>.u` file until it compiles
  4. Run the `load <myFileName>.test.u` command in the UCM cli to bring the tests into scope and run them

  ## Walk through

  If you're working on an Exercism problem on the command line, most likely you'll be implementing your solution in the directory named after the given exercise. For example, if the exercise is `hello-world`, you should open the `ucm` from the command line after having `cd`'ed into `~/exercism/unison/hello-world`. Make your implementation changes in the `hello.u` file, and when you're satisfied with your implementation, enter the `add` or `update` command in the Unison codebase manager CLI (UCM) to add your work from the file into the codebase.

  The file that contains the tests for each exercise is suffixed `.test.u`. You'll want to use the `load` command in the UCM to bring the tests into scope and run them. The `load` command takes a file path as its argument. Here's what that might look like for the hello world exercise:

  ```
  .> load hello.test.u
  ```

  You should see a message from the UCM about the terms that were brought into scope and, importantly, the result of running the test:

  ```

    ⍟ These new definitions are ok to `add`:

      hello.test : Test.Test
      tests      : [Result]

  Now evaluating any watch expressions (lines starting with
  `>`)... Ctrl+C cancels.


    6 | test> tests = runAll [hello.test]

    🚫 FAILED
  ```

  Let's say your tests didn't pass the first time. Switch back to editing your `myExercise.u` file, and upon saving you can `update`

  ```
  I found and typechecked these definitions in ~/Exercism/unison/hello-world/hello.u. If you do an
  `add` or `update`, here's how your codebase would change:

    ⍟ These names already exist. You can `update` them to your new definition:

      hello : Text

  .> update

  ⍟ I've updated these names to your new definition:

    hello : Text
  ```

  Next we can re-load our tests to see if anything changed!

  ```
  .> load hello.test.u
    Now evaluating any watch expressions (lines starting with `>`)... Ctrl+C cancels.


    6 | test> tests = runAll [hello.test]

    ✅ Passed : Passed 1 tests.
  ```

## Submitting your solution

You can submit your solution using the `exercism submit allergies.u` command.
This command will upload your solution to the Exercism website and print the solution page's URL.

It's possible to submit an incomplete solution which allows you to:

- See how others have completed the exercise
- Request help from a mentor

## Need to get help?

If you'd like help solving the exercise, check the following pages:

- The [Unison track's documentation](https://exercism.org/docs/tracks/unison)
- [Exercism's support channel on gitter](https://gitter.im/exercism/support)
- The [Frequently Asked Questions](https://exercism.org/docs/using/faqs)

Should those resources not suffice, you could submit your (incomplete) solution to request mentoring.

The [official Unison language documentation](https://www.unison-lang.org/learn/fundamentals/values-and-functions/terms/) is an excellent place to start learning. It details fundamental Unison concepts, like functions, data types, and algebraic effects.

We've created [a video walk-through of the workflow for running and testing an Exercism problem](https://www.youtube.com/watch?v=4UMaaiJnWGY) if you're working on the command line with the Unison Codebase Manager.

For reference material, the [Unison language reference](https://www.unison-lang.org/learn/language-reference/top-level-declaration/) contains granular details about Unison features. They're listed in the website sidebar.

You may want to familiarize yourself with [Unison Share](https://share.unison-lang.org/), Unison's repository for public libraries and projects. The documentation for the standard library, [`base`](https://share.unison-lang.org/latest/namespaces/unison/base), contains helpful usage information.

👋 If you're ever stuck, we're happy to help. The #beginner-friendly channel in [the official Unison slack](http://unison-lang.org/slack) is filled with friendly people.