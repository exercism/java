# Hamming

Welcome to Hamming on Exercism's Java Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Calculate the Hamming Distance between two DNA strands.

Your body is made up of cells that contain DNA. Those cells regularly wear out and need replacing, which they achieve by dividing into daughter cells. In fact, the average human body experiences about 10 quadrillion cell divisions in a lifetime!

When cells divide, their DNA replicates too. Sometimes during this process mistakes happen and single pieces of DNA get encoded with the incorrect information. If we compare two strands of DNA and count the differences between them we can see how many mistakes occurred. This is known as the "Hamming Distance".

We read DNA using the letters C,A,G and T. Two strands might look like this:

    GAGCCTACTAACGGGAT
    CATCGTAATGACGGCCT
    ^ ^ ^  ^ ^    ^^

They have 7 differences, and therefore the Hamming Distance is 7.

The Hamming Distance is useful for lots of things in science, not just biology, so it's a nice phrase to be familiar with :)

The Hamming distance is only defined for sequences of equal length, so
an attempt to calculate it between sequences of different lengths should
not work. The general handling of this situation (e.g., raising an
exception vs returning a special value) may differ between languages.

This is the first exercise with tests that require you to throw an
[`Exception`](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html). `Exception`s are typically thrown to
indicate that a program has encountered an unexpected input or state.

We use JUnit's [`ExpectedException`](http://junit.org/junit4/javadoc/4.12/org/junit/rules/ExpectedException.html)
[rule](https://github.com/junit-team/junit4/wiki/rules) throughout the track to verify that the exceptions you throw
are:

1. instances of a specified Java type;
2. (optionally) initialized with a specified message.

## Source

### Created by

- @wdjunaidi

### Contributed to by

- @c-thornton
- @ChristianWilkie
- @FridaTveit
- @javaeeeee
- @jmrunkle
- @jonnynabors
- @jtigger
- @kytrinyx
- @lemoncurry
- @matthewmorgan
- @michael-berger-FR
- @michaelspets
- @mirkoperillo
- @msomji
- @muzimuzhi
- @odzeno
- @sjwarner-bp
- @SleeplessByte
- @Smarticles101
- @sshine
- @stkent
- @t0dd
- @Valkryst
- @vasouv
- @Zaldrick

### Based on

The Calculating Point Mutations problem at Rosalind - http://rosalind.info/problems/hamm/