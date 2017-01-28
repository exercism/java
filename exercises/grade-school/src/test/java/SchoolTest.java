import org.junit.Ignore;
import org.junit.Test;

import java.lang.Integer;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class SchoolTest {
  private final School school = new School();

  @Test
  public void startsWithNoStudents() {
    assertThat(school.numberOfStudents(), is(0));
  }

  @Ignore
  @Test
  public void addsStudents() {
    school.add("Aimee", 2);
    assertThat(school.grade(2), hasItem("Aimee"));
  }

  @Ignore
  @Test
  public void addsMoreStudentsInSameGrade() {
    final int grade = 2;
    school.add("James", grade);
    school.add("Blair", grade);
    school.add("Paul", grade);

    assertThat(school.grade(grade).size(), is(3));
    assertThat(school.grade(grade), allOf(hasItem("James"), hasItem("Blair"), hasItem("Paul")));
  }

  @Ignore
  @Test
  public void addsStudentsInMultipleGrades() {
    school.add("Chelsea", 3);
    school.add("Logan", 7);

    assertThat(school.numberOfStudents(), is(2));
    assertThat(school.grade(3).size(), is(1));
    assertThat(school.grade(3), hasItem("Chelsea"));
    assertThat(school.grade(7).size(), is(1));
    assertThat(school.grade(7), hasItem("Logan"));
  }

  @Ignore
  @Test
  public void getsStudentsInEmptyGrade() {
    assertTrue(school.grade(1).isEmpty());
  }

  @Ignore
  @Test
  public void gradeReturnsStudentsInTheOrderTheyWereInserted() {
    int grade = 4;
    school.add("Bartimaeus", grade);
    school.add("Nathaniel", grade);
    school.add("Faquarl", grade);
    List<String> studentsInGrade = school.grade(grade);
    assertThat(studentsInGrade.get(0), is("Bartimaeus"));
    assertThat(studentsInGrade.get(1), is("Nathaniel"));
    assertThat(studentsInGrade.get(2), is("Faquarl"));
  }

  @Ignore
  @Test
  public void sortsSchool() {
    school.add("Jennifer", 4);
    school.add("Kareem", 6);
    school.add("Christopher", 4);
    school.add("Kyle", 3);
    Map<Integer, List<String>> sortedStudents = new HashMap<Integer, List<String>>();
    sortedStudents.put(6, Arrays.asList("Kareem"));
    sortedStudents.put(4, Arrays.asList("Christopher", "Jennifer"));
    sortedStudents.put(3, Arrays.asList("Kyle"));
    assertEquals(school.studentsByGradeAlphabetical(), sortedStudents);
  }

  @Ignore
  @Test
  public void modifyingFetchedGradeShouldNotModifyInternalDatabase() {
    String shouldNotBeAdded = "Should not be added to school";
    int grade = 1;

    List<String> students = school.grade(grade);
    students.add(shouldNotBeAdded);

    assertThat(school.grade(grade), not(hasItem(shouldNotBeAdded)));
  }

  @Ignore
  @Test
  public void modifyingSortedStudentsShouldNotModifyInternalDatabase() {
    int grade = 2;
    String studentWhichShouldNotBeAdded = "Should not be added";
    List<String> listWhichShouldNotBeAdded = new ArrayList<>();
    listWhichShouldNotBeAdded.add(studentWhichShouldNotBeAdded);

    Map<Integer, List<String>> sortedStudents = school.studentsByGradeAlphabetical();
    sortedStudents.put(grade,listWhichShouldNotBeAdded);

    assertThat(school.studentsByGradeAlphabetical().get(grade), not(hasItem(studentWhichShouldNotBeAdded)));
  }
}
