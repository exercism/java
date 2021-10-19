# Nucleotide Count

Welcome to Nucleotide Count on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Each of us inherits from our biological parents a set of chemical instructions known as DNA that influence how our bodies are constructed. All known life depends on DNA!

> Note: You do not need to understand anything about nucleotides or DNA to complete this exercise.

DNA is a long chain of other chemicals and the most important are the four nucleotides, adenine, cytosine, guanine and thymine. A single DNA chain can contain billions of these four nucleotides and the order in which they occur is important!
We call the order of these nucleotides in a bit of DNA a "DNA sequence".

We represent a DNA sequence as an ordered collection of these four nucleotides and a common way to do that is with a string of characters such as "ATTACG" for a DNA sequence of 6 nucleotides.
'A' for adenine, 'C' for cytosine, 'G' for guanine, and 'T' for thymine.

Given a string representing a DNA sequence, count how many of each nucleotide is present.
If the string contains characters that aren't A, C, G, or T then it is invalid and you should signal an error.

For example:

```text
"GATTACA" -> 'A': 3, 'C': 1, 'G': 1, 'T': 2
"INVALID" -> error
```

## Implementation

You should define a custom type 'DNA' with a function 'Counts' that outputs two values: 

- a frequency count for the given DNA strand
- an error (if there are invalid nucleotides)

Which is a good type for a DNA strand ? 

Which is the best Go types to represent the output values ?

Take a look at the test cases to get a hint about what could be the possible inputs.


## note about the tests
You may be wondering about the `cases_test.go` file. We explain it in the
[leap exercise][leap-exercise-readme].

[leap-exercise-readme]: https://github.com/exercism/go/blob/master/exercises/leap/README.md

## Source

### Created by

- @kytrinyx

### Contributed to by

- @alebaffa
- @bitfield
- @ekingery
- @ferhatelmas
- @hilary
- @ilmanzo
- @leenipper
- @mikegehard
- @petertseng
- @robphoenix
- @sebito91
- @sjakobi
- @soniakeys
- @tleen
- @tompao

### Based on

The Calculating DNA Nucleotides_problem at Rosalind - http://rosalind.info/problems/dna/