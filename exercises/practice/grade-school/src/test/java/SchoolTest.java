import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SchoolTest {
    private School school;

    @BeforeEach
    public void setUp() {
        school = new School();
    }

    @Test
    @DisplayName("Roster is empty when no student is added")
    public void rosterReturnsAnEmptyListIfThereAreNoStudentsEnrolled() {
        assertThat(school.roster()).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add a student")
    public void addAStudent() {
        assertThat(school.add("Aimee", 2)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Student is added to the roster")
    public void addingAStudentAddsThemToTheSortedRoster() {
        school.add("Aimee", 2);

        assertThat(school.roster()).containsExactly("Aimee");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Adding multiple students in the same grade in the roster")
    public void addingMultipleStudentsInTheSameGrade() {
        assertThat(school.add("Blair", 2)).isTrue();
        assertThat(school.add("James", 2)).isTrue();
        assertThat(school.add("Paul", 2)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiple students in the same grade are added to the roster")
    public void addingMoreStudentsAddsThemToTheSameSortedRoster() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("Paul", 2);

        assertThat(school.roster()).containsExactly("Blair", "James", "Paul");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Cannot add student to same grade in the roster more than once")
    public void cannotAddStudentsToSameGradeInTheRosterMoreThanOnce() {
        assertThat(school.add("Blair", 2)).isTrue();
        assertThat(school.add("James", 2)).isTrue();
        assertThat(school.add("James", 2)).isFalse();
        assertThat(school.add("Paul", 2)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Student not added to same grade in the roster more than once")
    public void studentNotAddedToSameGradeInTheRosterMoreThanOnce() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("James", 2);
        school.add("Paul", 2);

        assertThat(school.roster()).containsExactly("Blair", "James", "Paul");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Adding students in multiple grades")
    public void addingStudentsInMultipleGrades() {
        assertThat(school.add("Chelsea", 3)).isTrue();
        assertThat(school.add("Logan", 7)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Students in multiple grades are added to the roster")
    public void addingStudentsToDifferentGradesAddsThemToTheSameSortedRoster() {
        school.add("Chelsea", 3);
        school.add("Logan", 7);

        assertThat(school.roster()).containsExactly("Chelsea", "Logan");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Cannot add same student to multiple grades in the roster")
    public void cannotAddSameStudentToMultipleGradesInTheRoster() {
        assertThat(school.add("Blair", 2)).isTrue();
        assertThat(school.add("James", 2)).isTrue();
        assertThat(school.add("James", 3)).isFalse();
        assertThat(school.add("Paul", 3)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Student not added to multiple grades in the roster")
    public void studentNotAddedToMultipleGradesInTheRoster() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("James", 3);
        school.add("Paul", 3);

        assertThat(school.roster()).containsExactly("Blair", "James", "Paul");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Students are sorted by grades in the roster")
    public void studentsAreSortedByGradeInTheRoster() {
        school.add("Jim", 3);
        school.add("Peter", 2);
        school.add("Anna", 1);

        assertThat(school.roster()).containsExactly("Anna", "Peter", "Jim");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Students are sorted by name in the roster")
    public void studentsAreSortedByNameInTheRoster() {
        school.add("Peter", 2);
        school.add("Zoe", 2);
        school.add("Alex", 2);

        assertThat(school.roster()).containsExactly("Alex", "Peter", "Zoe");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Students are sorted by grades and then by name in the roster")
    public void studentsAreSortedByGradeAndThenByNameInTheRoster() {
        school.add("Peter", 2);
        school.add("Anna", 1);
        school.add("Barb", 1);
        school.add("Zoe", 2);
        school.add("Alex", 2);
        school.add("Jim", 3);
        school.add("Charlie", 1);

        assertThat(school.roster()).containsExactly("Anna", "Barb", "Charlie", "Alex", "Peter", "Zoe", "Jim");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Grade is empty if no students in the roster")
    public void gradeIsEmptyIfNoStudentsInTheRoster() {
        assertThat(school.grade(1)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Grade is empty if no students in that grade")
    public void gradeIsEmptyIfNoStudentsInThatGrade() {
        school.add("Peter", 2);
        school.add("Zoe", 2);
        school.add("Alex", 2);
        school.add("Jim", 3);

        assertThat(school.grade(1)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Student not added to same grade more than once")
    public void studentNotAddedToTheSameGradeMoreThanOnce() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("James", 2);
        school.add("Paul", 2);

        assertThat(school.grade(2)).containsExactly("Blair", "James", "Paul");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Student not added to multiple grades")
    public void studentNotAddedToMultipleGrades() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("James", 3);
        school.add("Paul", 3);

        assertThat(school.grade(2)).containsExactly("Blair", "James");
        assertThat(school.grade(3)).containsExactly("Paul");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Students are sorted by name in a grade")
    public void studentsAreSortedByNameInAGrade() {
        school.add("Franklin", 5);
        school.add("Bradley", 5);
        school.add("Jeff", 1);

        assertThat(school.grade(5)).containsExactly("Bradley", "Franklin");
    }
}
