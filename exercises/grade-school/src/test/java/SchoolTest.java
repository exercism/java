import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collection;
import java.util.Arrays;

import org.hamcrest.Matcher;
import org.hamcrest.collection.IsIterableContainingInOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

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
    assertEquals(school.roster(), expected);
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
    assertEquals(school.roster(), expected);
  }

  @Ignore("Remove to run test")
  @Test
  public void addingStudentsToDifferentGradesAddsThemToTheSameSortedRoster() {
    school = new School();
    school.add("Chelsea", 3);
    school.add("Logan", 7);
    List<String> expected = Arrays.asList("Chelsea", "Logan");
    assertEquals(school.roster(), expected);
  }

  @Ignore("Remove to run test")
  @Test
  public void rosterReturnsAnEmptyListIfThereAreNoStudentsEnrolled() {
    school = new School();
    List<String> expected = Arrays.asList();
    assertEquals(school.roster(), expected);
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
    assertEquals(school.roster(), expected);
  }

  @Ignore("Remove to run test")
  @Test
  public void gradeReturnsTheStudentsInThatGradeInAlphabeticalOrder() {
    school = new School();
    school.add("Franklin", 5);
    school.add("Bradley", 5);
    school.add("Jeff", 1);
    List<String> expected = Arrays.asList("Bradley", "Franklin");
    assertEquals(school.grade(5), expected);
  }

  @Ignore("Remove to run test")
  @Test
  public void gradeReturnsAnEmptyListIfThereAreNoStudentsInThatGrade() {
    school = new School();
    List<String> expected = Arrays.asList();
    assertEquals(school.grade(1), expected);
  }
}
