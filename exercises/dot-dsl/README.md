# DOT DSL

A [Domain Specific Language
(DSL)](https://en.wikipedia.org/wiki/Domain-specific_language) is a
small language optimized for a specific domain. Since a DSL is 
targeted, it can greatly impact productivity/understanding by allowing the 
writer to declare *what* they want rather than *how*.

One problem area where they are applied are complex customizations/configurations.

For example the [DOT language](https://en.wikipedia.org/wiki/DOT_(graph_description_language)) allows
you to write a textual description of a graph which is then transformed into a picture by one of
the [Graphviz](http://graphviz.org/) tools (such as `dot`). A simple graph looks like this:

    graph {
        graph [bgcolor="yellow"]
        a [color="red"]
        b [color="blue"]
        a -- b [color="green"]
    }

Putting this in a file `example.dot` and running `dot example.dot -T png
-o example.png` creates an image `example.png` with red and blue circle
connected by a green line on a yellow background.

Write a Domain Specific Language similar to the Graphviz dot language.

Our DSL is similar to the Graphviz dot language in that our DSL will be used
to create graph data structures. However, unlike the DOT Language, our DSL will
be an internal DSL for use only in our language. 

More information about the difference between internal and external DSLs can be
found [here](https://martinfowler.com/bliki/DomainSpecificLanguage.html).

## Description of DSL

A graph, in this DSL, is an object of type `Graph`, taking a list of one 
or more

+ attributes
+ nodes
+ edges

described as tuples.

The implementations of `Node` and `Edge` provided in `DotDsl.java`.

Observe the test cases in `DotDslTest.java` to understand the DSL's design.

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

In the test suites all tests but the first have been skipped.

Once you get a test passing, you can enable the next one by removing the
`@Ignore("Remove to run test")` annotation.

## Submitting Exercises

Note that, when trying to submit an exercise, make sure the solution is in the `$EXERCISM_WORKSPACE/python/dot-dsl` directory.

You can find your Exercism workspace by running `exercism debug` and looking for the line that starts with `Workspace`.

For more detailed information about running tests, code style and linting,
please see [Running the Tests](http://exercism.io/tracks/python/tests).

## Source

Wikipedia [https://en.wikipedia.org/wiki/DOT_(graph_description_language)](https://en.wikipedia.org/wiki/DOT_(graph_description_language))

## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have completed the exercise.