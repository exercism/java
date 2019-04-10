# Isogram

Determine if a word or phrase is an isogram.

An isogram (also known as a "nonpattern word") is a word or phrase without a repeating letter, however spaces and hyphens are allowed to appear multiple times.

Examples of isograms:

- lumberjacks
- background
- downstream
- six-year-old

The word *isograms*, however, is not an isogram, because the s repeats.

# Tips

If you find that `testWorksWithGermanLetters` fails even though you think you've implemented it correctly,
this could be because of the [JVM encoding](https://www.ibm.com/support/knowledgecenter/en/ssw_ibm_i_61/rzaha/international.htm). 
Try setting the `JAVA_TOOL_OPTIONS` environment variable to `-Dfile.encoding=UTF8` to fix this.
- To set an environment variable on Windows:
    1. Go to Computer -> Properties -> Advanced System Settings
    2. Add a new environment variable

- [To set an environment variable on a mac](http://blog.lidalia.org.uk/2011/04/setting-default-java-file-encoding-to.html)

- [To set an environment variable on linux](https://unix.stackexchange.com/questions/151733/where-can-i-set-global-java-options)

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

Wikipedia [https://en.wikipedia.org/wiki/Isogram](https://en.wikipedia.org/wiki/Isogram)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
