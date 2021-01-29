# OCR Numbers

Given a 3 x 4 grid of pipes, underscores, and spaces, determine which number is
represented, or whether it is garbled.

# Step One

To begin with, convert a simple binary font to a string containing 0 or 1.

The binary font uses pipes and underscores, four rows high and three columns wide.

```text
     _   #
    | |  # zero.
    |_|  #
         # the fourth row is always blank
```

Is converted to "0"

```text
         #
      |  # one.
      |  #
         # (blank fourth row)
```

Is converted to "1"

If the input is the correct size, but not recognizable, your program should return '?'

If the input is the incorrect size, your program should return an error.

# Step Two

Update your program to recognize multi-character binary strings, replacing garbled numbers with ?

# Step Three

Update your program to recognize all numbers 0 through 9, both individually and as part of a larger string.

```text
 _ 
 _|
|_ 
   
```

Is converted to "2"

```text
      _  _     _  _  _  _  _  _  #
    | _| _||_||_ |_   ||_||_|| | # decimal numbers.
    ||_  _|  | _||_|  ||_| _||_| #
                                 # fourth line is always blank
```

Is converted to "1234567890"

# Step Four

Update your program to handle multiple numbers, one per line. When converting several lines, join the lines with commas.

```text
    _  _ 
  | _| _|
  ||_  _|
         
    _  _ 
|_||_ |_ 
  | _||_|
         
 _  _  _ 
  ||_||_|
  ||_| _|
         
```

Is converted to "123,456,789"

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

## Source

Inspired by the Bank OCR kata [http://codingdojo.org/cgi-bin/wiki.pl?KataBankOCR](http://codingdojo.org/cgi-bin/wiki.pl?KataBankOCR)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
