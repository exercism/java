import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SchoolTest {
    private School school;

    @Before
    public void setUp() {
        school = new School();
    }

    @Test
    public void addingAStudentAddsThemToTheSortedRoster() {
        school = new School();
        school.add("Aimee", 2);
        List<String> expected = Arrays.asList("Aimee");
        assertThat(school.roster()).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void addingMoreStudentsAddsThemToTheSameSortedRoster() {
        school = new School();
        int grade = 2;
        school.add("Blair", grade);
        school.add("James", grade);
        school.add("Paul", grade);
        List<String> expected = Arrays.asList("Blair", "James", "Paul");
        assertThat(school.roster()).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void addingStudentsToDifferentGradesAddsThemToTheSameSortedRoster() {
        school = new School();
        school.add("Chelsea", 3);
        school.add("Logan", 7);
        List<String> expected = Arrays.asList("Chelsea", "Logan");
        assertThat(school.roster()).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void rosterReturnsAnEmptyListIfThereAreNoStudentsEnrolled() {
        school = new School();
        List<String> expected = Arrays.asList();
        assertThat(school.roster()).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void studentNamesWithGradesAreDisplayedInTheSameSortedRoster() {
        school = new School();
        school.add("Peter", 2);
        school.add("Anna", 1);
        school.add("Barb", 1);
        school.add("Zoe", 2);
        school.add("Alex", 2);
        school.add("Jim", 3);
        school.add("Charlie", 1);
        List<String> expected = Arrays.asList("Anna", "Barb", "Charlie", "Alex", "Peter", "Zoe", "Jim");
        assertThat(school.roster()).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void gradeReturnsTheStudentsInThatGradeInAlphabeticalOrder() {
        school = new School();
        school.add("Franklin", 5);
        school.add("Bradley", 5);
        school.add("Jeff", 1);
        List<String> expected = Arrays.asList("Bradley", "Franklin");
        assertThat(school.grade(5)).isEqualTo(expected);
    }

    @Ignore("Remove to run test")
    @Test
    public void gradeReturnsAnEmptyListIfThereAreNoStudentsInThatGrade() {
        school = new School();
        List<String> expected = Arrays.asList();
        assertThat(school.grade(1)).isEqualTo(expected);
    }
}
