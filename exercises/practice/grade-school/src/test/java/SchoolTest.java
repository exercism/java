import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SchoolTest {
    private School school;

    @Before
    public void setUp() {
        school = new School();
    }

    @Test
    public void rosterReturnsAnEmptyListIfThereAreNoStudentsEnrolled() {
        assertThat(school.roster()).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void addAStudent() {
        assertThat(school.add("Aimee", 2)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void addingAStudentAddsThemToTheSortedRoster() {
        school.add("Aimee", 2);

        assertThat(school.roster()).containsExactly("Aimee");
    }

    @Ignore("Remove to run test")
    @Test
    public void addingMultipleStudentsInTheSameGrade() {
        assertThat(school.add("Blair", 2)).isTrue();
        assertThat(school.add("James", 2)).isTrue();
        assertThat(school.add("Paul", 2)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void addingMoreStudentsAddsThemToTheSameSortedRoster() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("Paul", 2);

        assertThat(school.roster()).containsExactly("Blair", "James", "Paul");
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotAddStudentsToSameGradeInTheRosterMoreThanOnce() {
        assertThat(school.add("Blair", 2)).isTrue();
        assertThat(school.add("James", 2)).isTrue();
        assertThat(school.add("James", 2)).isFalse();
        assertThat(school.add("Paul", 2)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void studentNotAddedToSameGradeInTheRosterMoreThanOnce() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("James", 2);
        school.add("Paul", 2);

        assertThat(school.roster()).containsExactly("Blair", "James", "Paul");
    }

    @Ignore("Remove to run test")
    @Test
    public void addingStudentsInMultipleGrades() {
        assertThat(school.add("Chelsea", 3)).isTrue();
        assertThat(school.add("Logan", 7)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void addingStudentsToDifferentGradesAddsThemToTheSameSortedRoster() {
        school.add("Chelsea", 3);
        school.add("Logan", 7);

        assertThat(school.roster()).containsExactly("Chelsea", "Logan");
    }

    @Ignore("Remove to run test")
    @Test
    public void cannotAddSameStudentToMultipleGradesInTheRoster() {
        assertThat(school.add("Blair", 2)).isTrue();
        assertThat(school.add("James", 2)).isTrue();
        assertThat(school.add("James", 3)).isFalse();
        assertThat(school.add("Paul", 3)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void studentNotAddedToMultipleGradesInTheRoster() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("James", 3);
        school.add("Paul", 3);

        assertThat(school.roster()).containsExactly("Blair", "James", "Paul");
    }

    @Ignore("Remove to run test")
    @Test
    public void studentsAreSortedByGradeInTheRoster() {
        school.add("Jim", 3);
        school.add("Peter", 2);
        school.add("Anna", 1);

        assertThat(school.roster()).containsExactly("Anna", "Peter", "Jim");
    }

    @Ignore("Remove to run test")
    @Test
    public void studentsAreSortedByNameInTheRoster() {
        school.add("Peter", 2);
        school.add("Zoe", 2);
        school.add("Alex", 2);

        assertThat(school.roster()).containsExactly("Alex", "Peter", "Zoe");
    }

    @Ignore("Remove to run test")
    @Test
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

    @Ignore("Remove to run test")
    @Test
    public void gradeIsEmptyIfNoStudentsInTheRoster() {
        assertThat(school.grade(1)).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void gradeIsEmptyIfNoStudentsInThatGrade() {
        school.add("Peter", 2);
        school.add("Zoe", 2);
        school.add("Alex", 2);
        school.add("Jim", 3);

        assertThat(school.grade(1)).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void studentNotAddedToTheSameGradeMoreThanOnce() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("James", 2);
        school.add("Paul", 2);

        assertThat(school.grade(2)).containsExactly("Blair", "James", "Paul");
    }

    @Ignore("Remove to run test")
    @Test
    public void studentNotAddedToMultipleGrades() {
        school.add("Blair", 2);
        school.add("James", 2);
        school.add("James", 3);
        school.add("Paul", 3);

        assertThat(school.grade(2)).containsExactly("Blair", "James");
        assertThat(school.grade(3)).containsExactly("Paul");
    }

    @Ignore("Remove to run test")
    @Test
    public void studentsAreSortedByNameInAGrade() {
        school.add("Franklin", 5);
        school.add("Bradley", 5);
        school.add("Jeff", 1);

        assertThat(school.grade(5)).containsExactly("Bradley", "Franklin");
    }
}
