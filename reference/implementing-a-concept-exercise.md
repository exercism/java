# How to implement a Java Concept Exercise

This document describes how to implement a Concept Exercise for the Java track.
It assumes you have read the main [Contributing guide][contributing-guide], so make sure to read this first!

**Please please please read the docs before starting.**
Posting PRs without reading these docs will be a lot more frustrating for you during the review cycle, and exhaust Exercism's maintainers' time.
So, before diving into the implementation, please read the following documents:

- [The features of v3][docs-features-of-v3].
- [Rationale for v3][docs-rationale-for-v3].
- [What are concept exercise and how they are structured?][docs-concept-exercises]

Please also watch the following video:

- [The Anatomy of a Concept Exercise][anatomy-of-a-concept-exercise].

As this document is generic, the following placeholders are used:

- `<exercise-slug>`: the slug of the exercise (e.g. `calculator-conundrum`),
- `<ExerciseName>`: the name of the exercise (e.g. `CalculatorConundrum`),
- `<concept-slug>`: the slug of the concept (e.g. `loops`).

Before implementing the exercise, please make sure you have a good understanding of what the exercise should be teaching (and what not).
This information can be found in the exercise's GitHub issue.
If you have come up with something completely new, create a new issue _first_ so we can discuss the Concept Exercise.

To implement a Concept Exercise, the following files must be added:

<pre>
.
├── concepts
│   └── &lt;concept-slug&gt;
│       ├── .meta
│       │   └── config.json
│       ├── about.md
│       ├── introduction.md
│       └── links.json
└── exercises
    └── concept
        └── &lt;exercise-slug&gt;
            ├── .docs
            │   ├── hints.md
            │   ├── instructions.md
            │   ├── introduction.md
            │   └── introduction.md.tpl
            ├── .meta
            │   ├── config.json
            │   ├── design.md
            │   └── src
            │       └── reference
            │           └── java
            │               └── &lt;ExerciseName&gt;.java
            ├── build.gradle
            └── src
                ├── main
                │   └── java
                │       └── &lt;ExerciseName&gt;.java
                └── test
                    └── java
                        └── &lt;ExerciseName&gt;Test.java
</pre>

## Step 1: Add code files

Start by copying the `resources/exercise-template` directory to `exercises/concept/exercise-slug`, this will be the root of the new exercise.

Among others, this directory contains the following files:

- `src/main/java/ExerciseName.java`: the stub implementation file, which is the starting point for students to work on the exercise.
- `src/test/java/ExerciseNameTest.java`: the test suite, please use `assertj` to describe assertions instead of those offered by JUnit.
- `.meta/src/reference/java/ExerciseName.java`: an exemplar implementation that passes all the tests.

Make sure to rename each file to match the name of your new exercise.

Append to `exercises/settings.gradle` the following line:

```groovy
include 'concept:<exercise-slug>'
```

## Step 2: Validate the solution

Before submitting your solution, be sure it works following these two steps from the `exercises` folder:

1. Test the solution running `./gradlew concept:<exercise-slug>:test`
2. Validate the coding style running `./gradlew concept:<exercise-slug>:check`

## Step 3: Add documentation files

For more information on the documentation files used in a concept exercise, refer to the [Concept Exercise docs][docs-concept-exercises].

The introduction of each concept exercise typically contains the introduction for the corresponding concept(s).
We aim to keep these in sync by using a special template for each concept exercise.

This template should be named `.docs/introduction.md.tpl` and should look like the example below, where `concept-slug` contains the slug for the concept related to the exercise.

```md
# Introduction

%{concept:concept-slug}
```

With the introduction template file in place, the introduction can be generated using the Configlet:

```sh
bin/configlet generate
```

Running this will create (or update) the exercise's `.docs/introduction.md`.
Make sure to commit both the template and the generated introduction.

## Step 4: Add analyzer (optional)

Some exercises could benefit from having an exercise-specific [analyzer][analyzer].
If so, specify what analysis rules should be applied to this exercise and why.

_Skip this step if you're not sure what to do._

## Step 5: Add representation (optional)

Some exercises could benefit from having an custom representation as generated by the [Java representer][representer].
If so, specify what changes to the representation should be applied and why.

_Skip this step if you're not sure what to do._

## Inspiration

When implementing an exercise, it can be very useful to look at other concept exercises in the Java track, such as `annalyns-infiltration` or `cars-assemble`.
You can also check the [Concept exercise stories][docs-concept-exercise-stories] to see if other languages have already implemented an exercise for that Concept.

## Help

If you have any questions regarding implementing the exercise, please post them as comments in the exercise's GitHub issue.

[analyzer]: https://github.com/exercism/java-analyzer
[anatomy-of-a-concept-exercise]: https://www.youtube.com/watch?v=gkbBqd7hPrA
[contributing-guide]: ../CONTRIBUTING.md
[docs-concept-exercises]: https://exercism.org/docs/building/tracks/concept-exercises
[docs-concept-exercise-stories]: https://exercism.org/docs/building/tracks/stories
[docs-features-of-v3]: https://github.com/exercism/v3/blob/main/docs/features-of-v3.md
[docs-rationale-for-v3]: https://github.com/exercism/v3/blob/main/docs/rationale-for-v3.md
[representer]: https://github.com/exercism/java-representer
