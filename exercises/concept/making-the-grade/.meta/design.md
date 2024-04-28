# Design

## Learning objectives

- Know how to repeteadly execute code using a `for` loop.´
- Know how to repeteadly execute code using a `for-each` loop.
- Know how to repeteadly execute code using a `while` loop.
- Know how to repeteadly execute code using a `do-while` loop.

## Out of scope

- Specific iteration over a `Map`

## Concepts

- `loops`

## Prerequisites

This exercise's prerequisites Concepts are:

- `lists`
- `if-else-statements`

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: If the student did not use a `for-each` loop in the `countFailedStudents` method, instruct them to do so.
- `essential`: If the student did not use a `while` loop in the `getAverageScoreOfStudents` method, instruct them to do so.
- `essential`: If the student did not use a `do-while` loop in the `letterGrades` method, instruct them to do so.
- `essential`: If the student did not use a `for` loop in the `studentRanking` method, instruct them to do so.
- `essential`: If the student did not use the `continue` statement in the `countOddScores` method, instruct them to do so.
- `essential`: If the student did not use the `break` statement in the `evaluateChallengingExam` method, instruct them to do so.
- `actionable`: If the student solved the exercise using a different loop that `for-each` in the `countOddScores` method, encourage them to use `for-each` instead.
- `actionable`: If the student solved the exercise using a different loop that `for-each` in the `evaluateChallengingExam` method, encourage them to use `for-each` instead.
- `informative`: If the solution uses `String.format` in the `studentRanking` method, inform the student that this cause a small performance penalty compared to string concatenation.

If the solution does not receive any of the listed feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
