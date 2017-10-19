# Hamming

Calculate the Hamming difference between two DNA strands.

A mutation is simply a mistake that occurs during the creation or
copying of a nucleic acid, in particular DNA. Because nucleic acids are
vital to cellular functions, mutations tend to cause a ripple effect
throughout the cell. Although mutations are technically mistakes, a very
rare mutation may equip the cell with a beneficial attribute. In fact,
the macro effects of evolution are attributable by the accumulated
result of beneficial microscopic mutations over many generations.

The simplest and most common type of nucleic acid mutation is a point
mutation, which replaces one base with another at a single nucleotide.

By counting the number of differences between two homologous DNA strands
taken from different genomes with a common ancestor, we get a measure of
the minimum number of point mutations that could have occurred on the
evolutionary path between the two strands.

This is called the 'Hamming distance'.

It is found by comparing two DNA strands and counting how many of the
nucleotides are different from their equivalent in the other string.

    GAGCCTACTAACGGGAT
    CATCGTAATGACGGCCT
    ^ ^ ^  ^ ^    ^^

The Hamming distance between these two DNA strands is 7.

# Implementation notes

The Hamming distance is only defined for sequences of equal length. This means
that based on the definition, each language could deal with getting sequences
of equal length differently.

# Java Tips

## Hints

This is the first exercise with tests that require you to throw an
[`Exception`](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html). `Exception`s are typically thrown to
indicate that a program has encountered an unexpected input or state.

We use JUnit's [`ExpectedException`](http://junit.org/junit4/javadoc/4.12/org/junit/rules/ExpectedException.html)
[rule](https://github.com/junit-team/junit4/wiki/rules) throughout the track to verify that the exceptions you throw
are:

1. instances of a specified Java type;
2. (optionally) initialized with a specified message.


# Running the tests

You can run all the tests for an exercise by entering

```sh
$ gradle test
```

in your terminal.

## Source

The Calculating Point Mutations problem at Rosalind [http://rosalind.info/problems/hamm/](http://rosalind.info/problems/hamm/)

## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have completed the exercise.
