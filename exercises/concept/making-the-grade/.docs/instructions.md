# Instructions

You're a teaching assistant correcting student exams.
Keeping track of results manually is getting both tedious and mistake-prone.
You decide to make things a little more interesting by putting together some functions to count and calculate results for the class.

## 1. Non-Passing Students

As you were grading the exam, you noticed some students weren't performing as well as you had hoped.
But you were distracted, and forgot to note exactly _how many_ students.

Create the method `countFailedStudents(List<Integer> studentScores)` that takes a `List<Integer>` of students scores.
This method should count up the number of students who don't have passing scores and return that count as an integer.
A student needs a score greater than **40** to achieve a passing grade on the exam.

```java
MakingTheGrade.countFailedStudents(List.of(40, 70, 80, 20, 39));
// => 3
```

## 2. Get the average grade of students

As your second task of the day the professor asks you to get the average score of a certain number of students.

Create the method `getAverageScoreOfStudents(List<Integer> studentScores, int numberOfStudents)` that takes a `List<Integer>` of studentScores and a `int` of numberOfStudents.
This method should get the average score of the number of students passed.
The number of students is guaranteed to be lower than the size of the list of scores.

```java
MakingTheGrade.getAverageScoreOfStudents(List.of(40, 70, 80, 20, 39, 50, 100, 90, 66, 15, 79), 10);
// => 57
```

## 3. Calculating letter grades

The teacher you are assisting needs to handle a letter with the amount of students needed to sum a score of 95 to the principal of the school.
This letter has to have at least 1 student in it (if the first students alone exceeds the score should be added as well).
And if already one student was added to the letter do not exceed the maximum score.

Create the method `MakingTheGrade.letterGrades(List<Integer> studentScores, List<String> studentNames)` that takes a `List<Integer> studentScores` of students scores and `List<String> studentNames` corresponding with the names of the students. This method should return the list of students added to the letter.

```java
MakingTheGrade.letterGrades(List.of(100, 20, 53, 91), List.of("Joci", "Sara", "Bern", "Fred"));
// => ["Joci"]

MakingTheGrade.letterGrades(List.of(20, 40, 30, 85), List.of("Jan", "Kora", "Sara", "Peter"));
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

## 5. Count Odd Scores

As an investigation, the principal asked the teacher to count how many scores of the math exam result being odd scores, and since you want to help him handle it efficiently.

We are going to create the method `countOddScores(List<Integer> studentScores)` with the parameter `List<integer>` of studentScores.
This method should count up the number of odd students scores and return that count as an integer.

```java
MakingTheGrade.countOddScores(List.of(20, 35, 40, 10, 39, 77));
// => 3
```

## 6. Challenging Exam

The teacher has prepared a challenging exam and wants to analyze the results.
As his assistant you'll evaluate the exams in the same order students handed them in.
The teacher is particularly interested in knowing how many students passed the exam before the first non-passing student.
As you know a student needs a score greater than **40** to achieve a passing grade on the exam.

Create the method `evaluateChallengingExam(List<Integer> studentScores)` that takes a `List<Integer>` of students scores in the handed order.
This method should count up the number of passing student scores until the first non-passing score and return that count as an integer.

```java
MakingTheGrade.evaluateChallengingExam(List.of(45, 90, 15, 100, 70));
// => 2
```
