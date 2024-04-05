# Instructions

You're a teaching assistant correcting student exams.
Keeping track of results manually is getting both tedious and mistake-prone.
You decide to make things a little more interesting by putting together some functions to count and calculate results for the class.

## 1. Non-Passing Students

As you were grading the exam, you noticed some students weren't performing as well as you had hoped.
But you were distracted, and forgot to note exactly _how many_ students.

Create the method `countFailedStudentd(List<Integer> studentScores)` that takes a `List<Integer>` of students scores.
This method should count up the number of students who don't have passing scores and return that count as an integer.
A student needs a score greater than **40** to achieve a passing grade on the exam.

```java
MakingTheGrade.countFailedStudentd(List.of(40, 70, 80, 20, 39));
// => 3
```

## 2. Get the average of the first 10 graded exams

As your second task of the day the professor asks you to get the average score of the first 10 students to handle the exam.

Create the method `getAverageScoreOfTheFirstTenExams(List<Integer> studentScores)` that takes a `List<Integer>` of students scores.
This method should get the first 10 students sum their score and return the average of the sum as an integer.

```java
MakingTheGrade.getAverageScoreOfTheFirstTenExams(List.of(40, 70, 80, 20, 39, 50, 100, 90, 66, 15, 79));
// => 57
```

## 3. Calculating letter grades

The teacher you are assisting needs to handle a letter with the amount of students needed to score a maximum score of 95 to the principal of the school.
This letter has to have at least 1 student in it (if the first students alone exceeds the score should be added as well).
And if already one student was added to the letter do not exceed the maximum score.

Create the method `MakingTheGrade.letterGrades(Map<String, Integer> studentScores, int maxScore)` that takes a `Map<String, Integer>` of students with their scores and a `int` that represents the maximum score to be achieved for the letter to be completed.
This method should return the list of students added to the letter.

```java
MakingTheGrade.letterGrades(Map.of("Joci", 100, "Sara", 20, "Bern", 53, "Fred", 91));
// => ["Joci"]

MakingTheGrade.letterGrades(Map.of("Jan", 20, "Kora", 40, "Sara", 30, "Peter", 85));
// => ["Jan", "Kora", "Sara"]
```

## 4. Matching Names to Scores

You have a list of exam scores in descending order, and another list of student names also sorted in descending order by their exam scores. You would like to match each student name with their exam score and print out an overall class ranking.

Create the method `studentRanking(List<Integer> studentScores, List<String> studentNames)` with parameters `List<integer>` of studentScores and  `List<String>` studentNames. Match each student name on the studentNames list with their score from the studentScores list. You can assume each argument list will be sorted from highest score(er) to lowest score(er). The function should return a list of strings with the format <rank>. <student name>: <student score>.

```java
List<Integer> studentScores = List.of(100, 99, 90, 84, 66, 53, 47);
List<String> studentNames = List.of("Joci", "Sara", "Kora", "Jan", "John", "Bern", "Fred");

MakingTheGrade.studentRanking(studentScores, studentNames);
// => ["1. Joci: 100", "2. Sara: 99", "3. Kora: 90", "4. Jan: 84", "5. John: 66", "6. Bern: 53", "7. Fred: 47"]
```
