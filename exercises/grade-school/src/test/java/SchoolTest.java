import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collection;

import org.hamcrest.Matcher;
import org.hamcrest.collection.IsIterableContainingInOrder;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/*
 * Based on problem-specifications/exercises/grade-school/canonical-data.json 1.0.0
 */
public class SchoolTest {

  @Test
  public void startsWithNoStudents() {
    School school = new School();
    assertThat(school.numberOfStudents(), is(0));
  }

  @Ignore("Remove to run test")
  @Test
  public void addingAStudentAddsThemToTheSortedRoster() {
    School school = new School();
    school.add("Aimee", 2);
    String[] expected = {"Aimee"};
    assertArrayEquals(expected, school.roster().toArray(new String[0]));
  }

  @Ignore("Remove to run test")
  @Test
  public void addingMoreStudentsAddsThemToTheSameSortedRoster() {
    School school = new School();
    int grade = 2;
    school.add("Blair", grade);
    school.add("James", grade);
    school.add("Paul", grade);
    String[] expected = {"Blair", "James", "Paul"};
    assertArrayEquals(expected, school.roster().toArray(new String[0]));
  }

  @Ignore("Remove to run test")
  @Test
  public void addingStudentsToDifferentGradesAddsThemToTheSameSortedRoster() {
    School school = new School();
    school.add("Chelsea", 3);
    school.add("Logan", 7);
    String[] expected = {"Chelsea", "Logan"};
    assertArrayEquals(expected, school.roster().toArray(new String[0]));
  }

  @Ignore("Remove to run test")
  @Test
  public void rosterReturnsAnEmptyListIfThereAreNoStudentsEnrolled() {
    School school = new School();
    String[] expected = {};
    assertArrayEquals(expected, school.roster().toArray(new String[0]));
  }

  @Ignore("Remove to run test")
  @Test
  public void studentNamesWithGradesAreDisplayedInTheSameSortedRoster() {
    School school = new School();
    school.add("Peter", 2);
    school.add("Anna", 1);
    school.add("Barb", 1);
    school.add("Zoe", 2);
    school.add("Alex", 2);
    school.add("Jim", 3);
    school.add("Charlie", 1);
    String[] expected = {"Anna", "Barb", "Charlie", "Alex", "Peter", "Zoe", "Jim"};
    assertArrayEquals(expected, school.roster().toArray(new String[0]));
  }

  @Ignore("Remove to run test")
  @Test
  public void gradeReturnsTheStudentsInThatGradeInAlphabeticalOrder() {
    School school = new School();
    school.add("Franklin", 5);
    school.add("Bradley", 5);
    school.add("Jeff", 1);
    String[] expected = {"Bradley", "Franklin"};
    assertArrayEquals(expected, school.grade(5).toArray(new String[0]));
  }

  @Ignore("Remove to run test")
  @Test
  public void gradeReturnsAnEmptyListIfThereAreNoStudentsInThatGrade() {
    School school = new School();
    String[] expected = {};
    assertArrayEquals(expected, school.grade(1).toArray(new String[0]));
  }
}
