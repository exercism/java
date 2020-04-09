# How to implement a Java Concept Exercise

This document describes how to implement a Concept Exercise for the Java track. As this document is generic, the following placeholders are used:

- `<slug>`: the name of the exercise in snake_case (e.g. `anonymous-methods`).
- `<concepts>`: the Concepts the exercise is about (e.g. `loops`),
- `<concept-1>`: a single Concept slug,
- `<prerequisite-n>`: a single Concept slug,
- `<uuid>`: a _new_ v4 UUID (random!)
- `<first-and-last-name>`: your first and last name (e.g. `John Doe`)
- `<git-email>`: the email address you use for git (e.g. `johndoe@email.com`)

Before implementing the exercise, please make sure you have a good understanding of what the exercise should be teaching (and what not). This information can be found in the exercise's GitHub issue. Having done this, please read the [Java Concept exercises introduction][concept-exercises]. If you have come up with something completely new, create a new issue _first_ so we can discuss the Concept Exercise.

To implement a Concept Exercise, the following files must be created:

<pre>
languages
└── java
    └── exercises
        └── concept
            └── &lt;slug&gt;
                |── .docs
                |   |── instructions.md
                |   |── introduction.md
                |   |── hints.md
                |   └── after.md (optional)
                |── .gitignore
                |── .meta
                |   |── design.md
                |   |── config.json
                |   └── example
                |       |── build.gradle
                |       └── src
                |           └── main
                |               └── java
                |                   └── &lt;slug&gt;.java
                |── build.gradle
                └── src
                    |── main
                    |   └── java
                    |       └── &lt;slug&gt;.java
                    └── test
                        └── java
                            └── &lt;slug&gt;Test.java
</pre>

## Step 1: add .docs/introduction.md

This file contains an introduction to the concept. It should make the exercise's learning goals explicit and provide a short introduction with enough detail for the student to complete the exercise. The aim is to give the student just enough context to figure out the solution themselves, as research has shown that self-discovery is the most effective learning experience. Using the proper technical terms in the descriptions will be helpful if the student wants to search for more information. If the exercise introduces new syntax, an example of the syntax should always be included; students should not need to search the web for examples of syntax.

As an example, the introduction to a "strings" exercise might describe a string as just a "Sequence of Unicode characters" or a "series of bytes". Unless the student needs to understand more nuanced details in order to solve the exercise, this type of brief explanation (along with an example of its syntax) should be sufficient information for the student to solve the exercise.

## Step 2: add .docs/instructions.md

This file contains instructions for the exercise. It should explicitly explain what the student needs to do (define a method with the signature `public String X(String s)` that takes an A and returns a Z), and provide at least one example usage of that function. If there are multiple tasks within the exercise, it should provide an example of each.

## Step 3: add .docs/hints.md

If the student gets stuck, we will allow them to click a button requesting a hint, which shows this file. This will not be a "recommended" path and we will (softly) discourage them using it unless they can't progress without it. As such, it's worth considering that the student reading it will be a little confused/overwhelmed and maybe frustrated.

The file should contain both general and task-specific "hints". These hints should be enough to unblock almost any student. They might link to the docs of the functions that need to be used.

The hints should not spell out the solution, but instead point to a resource describing the solution (e.g. linking to documentation for the function to use).

## Step 4: add .docs/after.md

Once the student completes the exercise they will be shown this file, which should provide them with a summary of what the exercise aimed to teach. This document can also link to any additional resources that might be interesting to the student in the context of the exercise.

## Step 5: update languages/java/config.json

An entry should be added to the track's `config.json` file for the new Concept Exercise:

```json
{
  ...
  "exercises": {
    "concept": [
      ...
      {
        "slug": "<slug>",
        "uuid": "<uuid>",
        "concepts": ["<concept-1>"],
        "prerequisites": ["<prerequisite-1>", "<prerequisite-2>"]
      }
    ]
  }
}
```

## Step 6: adding track-specific files

The configuration files may be copied from another exercise. We aim to keep these in sync:

- `build.gradle`

Now create the following three files:

- `src/main/java/<slug>.java`. the stub implementation file, which is the starting point for students to work on the exercise.
- `src/test/java/<slug>Test.java`: the test suite.
- `.meta/example/src/main/java/<slug>.java`: an example implementation that passes all the tests.

## Step 7: add analyzer (optional)

Some exercises could benefit from having an exercise-specific [analyzer][analyzer]. If so, specify what analysis rules should be applied to this exercise and why.

## Step 8: custom representation (optional)

Some exercises could benefit from having an custom representation as generated by the [Java representer][representer]. If so, specify what changes to the representation should be applied and why.

## Step 9: add `.meta/design.md`

This file contains information on the exercise's design, which includes things like its goal, its teaching goals, what not to teach, and more. This information can be extracted from the exercise's corresponding GitHub issue.

## Step 10: add .meta/config.json:

This file contains meta information on the exercise, which currently only includes the exercise's contributors.

## Inspiration

When implementing an exercise, it can be very useful to look at the exercises the track has already implemented. You can also check the exercise's [general concepts documents][reference] to see if other languages that have already an exercise for that Concept.

## Inspiration

When implementing an exercise, it can be very useful to look at already implemented Java exercises like the strings or numbers exercises. You can also check the exercise's [general concepts documents][reference] to see if other languages have already implemented an exercise for that Concept.

## Help

If you have any questions regarding implementing the exercise, please post them as comments in the exercise's GitHub issue.

[analyzer]: https://github.com/exercism/java-analyzer
[representer]: https://github.com/exercism/java-representer
[concept-exercises]: ../exercises/concept/README.md
[how-to-implement-a-concept-exercise]: ../../../docs/maintainers/generic-how-to-implement-a-concept-exercise.md
[reference]: ../../../reference/README.md
