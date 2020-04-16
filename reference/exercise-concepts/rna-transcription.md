# Rna-transcription

[Example implementation](https://github.com/exercism/java/blob/master/exercises/rna-transcription/.meta/src/reference/java/RnaTranscription.java)

## General

- Class: define a class to resolve the problem
- Methods: define a method to contain the logic
- Argument: the method should take the input as argument
- Strings: input and output of the class method are strings
- Assignment: assign some objects to local variables
- Variables: define references to created objects
- Loops: iterate on every character of the input string
- Objects: create a object of class `StringBuilder` to store the transcription
- Return values: method should return the final transcription
- Pattern matching: match the right operation to execute depending on the input value
- Error handling: manage the scenario when an invalid value is found

## Approach: Use conditional

- use conditional instead of pattern matching to choose the right operation to execute for the input value

## Approach: functional style

- use stream instead of loops to iterate on input values and map operation with a method reference to transform the data
