import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MakingTheGradeTest {
    
    @Test
    @Tag("task:1")
    @DisplayName("All students scored above 40")
    void testAllStudentsScoredAbove40() {
        assertThat(MakingTheGrade.countFailedStudents(List.of(50, 60, 70, 80, 90, 100))).isEqualTo(0);
    }

    @Test
    @Tag("task:1")
    @DisplayName("One student failed the exam")
    void testOneStudentFailedTheExam() {
        assertThat(MakingTheGrade.countFailedStudents(List.of(39, 100, 90, 96, 73))).isEqualTo(1);
    }

    @Test
    @Tag("task:1")
    @DisplayName("Multiple students failed the exam")
    void testMultipleStudentsFailedTheExam() {
        assertThat(MakingTheGrade.countFailedStudents(List.of(20, 10, 15, 35, 50, 60, 85))).isEqualTo(4);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Getting the average of 10 students")
    void testGettingTheAverageOf10Students() {
        assertThat(
            MakingTheGrade.getAverageScoreOfStudents(List.of(40, 70, 80, 20, 39, 50, 100, 90, 66, 15, 79), 10)
            ).isEqualTo(57);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Getting the average of 5 students, with multiple failed scores")
    void testGettingTheAverageOf5StudentsWithMultipleFailedScores() {
        assertThat(
            MakingTheGrade.getAverageScoreOfStudents(List.of(33, 22, 11, 20, 39, 90, 100, 90, 95, 87, 75, 74, 13), 5)
            ).isEqualTo(25);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Getting the average of 7 students, without failed scores")
    void testGettingTheAverageOf7StudentsWithoutFailedScores() {
        assertThat(
            MakingTheGrade.getAverageScoreOfStudents(List.of(70, 60, 65, 55, 95, 100, 80, 70, 20, 30, 15, 100, 50), 7)
            ).isEqualTo(75);
    }

    @Test
    @Tag("task:3")
    @DisplayName("First student exceeds the score limit for the letter")
    void testFirstStudentExceedTheScoreForTheLetter() {
        assertThat(
            MakingTheGrade.letterGrades(
                List.of(100, 20, 53, 91),
                List.of("Joci", "Sara", "Bern", "Fred"))
            ).isEqualTo(List.of("Joci"));
    }

    @Test
    @Tag("task:3")
    @DisplayName("The sum of the scores of the first three students are lower than 95")
    void testSumOfFirstThreeStudentsLowerThan95() {
        assertThat(
            MakingTheGrade.letterGrades(
                List.of(20, 40, 30, 85), 
                List.of("Jan", "Kora", "Sara", "Peter"))
            ).isEqualTo(List.of("Jan", "Kora", "Sara"));
    }

    @Test
    @Tag("task:3")
    @DisplayName("The sum of the scores of the first two students exceed 95")
    void testSumOfFirstTwoStudentsExceed95() {
        assertThat(
            MakingTheGrade.letterGrades(
                List.of(50, 46, 100, 15), 
                List.of("Cole", "Mason", "Enzo", "Connor"))
            ).isEqualTo(List.of("Cole"));
    }

    @Test
    @Tag("task:4")
    @DisplayName("Creating an all exceeded students ranking")
    void testAllStudentsExceededRanking() {
        List<String> answer = List.of(
            "1. Joci: 100", "2. Sara: 99", "3. Kora: 90", 
            "4. Jan: 84", "5. John: 66", "6. Bern: 53", "7. Fred: 47");

        assertThat(
            MakingTheGrade.studentRanking(
                List.of(100, 99, 90, 84, 66, 53, 47),
                List.of("Joci", "Sara", "Kora", "Jan", "John", "Bern", "Fred"))
            ).isEqualTo(answer);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Creating an all failed students ranking")
    void testAllStudentsFailedRanking() {
        List<String> answer = List.of(
            "1. Kai: 35", "2. Kevin: 30", "3. Erling: 29", "4. Jude: 26", 
            "5. Benjamin: 19", "6. Malo: 13", "7. Moises: 5");

        assertThat(
            MakingTheGrade.studentRanking(
                List.of(35, 30, 29, 26, 19, 13, 5),
                List.of("Kai", "Kevin", "Erling", "Jude", "Benjamin", "Malo", "Moises"))
            ).isEqualTo(answer);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Giving empty students and score lists")
    void testEmptyLists() {
        assertThat(
            MakingTheGrade.studentRanking(List.of(), List.of())
            ).isEqualTo(List.of());
    }

    @Test
    @Tag("task:5")
    @DisplayName("Three student scores were odd after the correction of the math tests")
    void testThreeOddScores() {
        assertThat(
            MakingTheGrade.countOddScores(List.of(20, 35, 40, 10, 39, 77))
            ).isEqualTo(3);
    }

    @Test
    @Tag("task:5")
    @DisplayName("None of the scores are odd")
    void testNoneOfTheScoresAreOdd() {
        assertThat(
            MakingTheGrade.countOddScores(List.of(20, 40, 60, 80, 10))
            ).isEqualTo(0);
    }

    @Test
    @Tag("task:5")
    @DisplayName("All the scores are odd")
    void testAllTheScoresAreOdd() {
        assertThat(
            MakingTheGrade.countOddScores(List.of(11, 33, 55, 77, 99))
            ).isEqualTo(5);
    }

    @Test
    @Tag("task:6")
    @DisplayName("Two students passed the exam before the first non-passing score")
    void testTwoStudentsPassedTheExamBeforeTheNonPassingScore() {
        assertThat(
            MakingTheGrade.evaluateChallengingExam(List.of(45, 90, 15, 100, 70))
            ).isEqualTo(2);
    }

    @Test
    @Tag("task:6")
    @DisplayName("None of the students passed the exam")
    void testNoneOfTheStudentsPassedTheExam() {
        assertThat(
            MakingTheGrade.evaluateChallengingExam(List.of(5, 10, 25, 2, 37))
            ).isEqualTo(0);
    }

    @Test
    @Tag("task:6")
    @DisplayName("All the students passed the exam")
    void testAllTheStudentsPassedTheExam() {
        assertThat(
            MakingTheGrade.evaluateChallengingExam(List.of(90, 98, 75, 80, 100))
            ).isEqualTo(5);
    }
}
