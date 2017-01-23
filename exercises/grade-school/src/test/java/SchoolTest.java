import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import static org.hamcrest.collection.IsIterableContainingInOrder.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SchoolTest {
  private final School school = new School();


  @Test
  public void startsWithNoStudents() {
    assertTrue(school.db().isEmpty());
  }

  @Ignore
  @Test
  public void addsStudents() {
    school.add("Aimee", 2);
    assertThat(school.db().get(2), hasItem("Aimee"));
  }

  @Ignore
  @Test
  public void addsMoreStudentsInSameGrade() {
    final int grade = 2;
    school.add("James", grade);
    school.add("Blair", grade);
    school.add("Paul", grade);

    assertThat(school.db().get(grade).size(), is(3));
    assertThat(school.db().get(grade), allOf(hasItem("James"), hasItem("Blair"), hasItem("Paul")));
  }

  @Ignore
  @Test
  public void addsStudentsInMultipleGrades() {
    school.add("Chelsea", 3);
    school.add("Logan", 7);

    assertThat(school.db().size(), is(2));
    assertThat(school.db().get(3).size(), is(1));
    assertThat(school.db().get(3), hasItem("Chelsea"));
    assertThat(school.db().get(7).size(), is(1));
    assertThat(school.db().get(7), hasItem("Logan"));
  }

  @Ignore
  @Test
  public void getsStudentsInAGrade() {
    school.add("Franklin", 5);
    school.add("Bradley", 5);
    school.add("Jeff", 1);
    assertThat(school.grade(5).size(), is(2));
    assertThat(school.grade(5), allOf(hasItem("Franklin"), hasItem("Bradley")));
  }

  @Ignore
  @Test
  public void getsStudentsInEmptyGrade() {
    assertTrue(school.grade(1).isEmpty());
  }

  @Ignore
  @Test
  public void sortsSchool() {
    school.add("Kyle", 4);
    school.add("Zed", 4);
    school.add("Adam", 4);
    school.add("Jennifer", 4);
    school.add("Kareem", 6);
    school.add("Christopher", 4);
    school.add("Kylie", 3);
    Map<Integer, Matcher> sortedStudents = new HashMap<Integer, Matcher>();
    sortedStudents.put(6, contains("Kareem"));
    sortedStudents.put(4, contains("Adam", "Christopher", "Jennifer", "Kyle", "Zed"));
    sortedStudents.put(3, contains("Kylie"));

    Map schoolStudents = school.sort();
    for (Map.Entry<?, Matcher> entry : sortedStudents.entrySet()) {

      assertThat((Collection) schoolStudents.get(entry.getKey()), entry.getValue());
    }
  }
}
