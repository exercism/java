# Diamond

The diamond kata takes as its input a letter, and outputs it in a diamond 
shape. Given a letter, it prints a diamond starting with 'A', with the 
supplied letter at the widest point.

## Requirements

* The first row contains one 'A'.
* The last row contains one 'A'.
* All rows, except the first and last, have exactly two identical letters.
* All rows have as many trailing spaces as leading spaces. (This might be 0).
* The diamond is horizontally symmetric.
* The diamond is vertically symmetric.
* The diamond has a square shape (width equals height).
* The letters form a diamond shape.
* The top half has the letters in ascending order.
* The bottom half has the letters in descending order. 
* The four corners (containing the spaces) are triangles.

## Examples

In the following examples, spaces are indicated by `·` characters.

Diamond for letter 'A':

```plain
A
```

Diamond for letter 'C':

```plain
··A··
·B·B·
C···C
·B·B·
··A··
```

Diamond for letter 'E':

```plain
····A····
···B·B···
··C···C··
·D·····D·
E·······E
·D·····D·
··C···C··
···B·B···
····A····
```


To run the tests:

```sh
$ gradle test
```

For more detailed info about the Java track see the [help page](http://exercism.io/languages/java).


## Source

Seb Rose [http://claysnow.co.uk/recycling-tests-in-tdd/](http://claysnow.co.uk/recycling-tests-in-tdd/)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have completed the exercise.
