import static org.assertj.core.api.Assertions.assertThat;

import io.exercism.xjava.NotReady;
import org.junit.experimental.categories.Category;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolTest {
  private final School school = new School();

  @Test
  public void startsWithNoStudents() {
    assertThat(school.db()).isEmpty();
  }

  @Test
  @Category(NotReady.class)
  public void addsStudents() {
    school.add("Aimee", 2);
    assertThat(school.db().get(2)).contains("Aimee");
  }

  @Test
  @Category(NotReady.class)
  public void addsMoreStudentsInSameGrade() {
    final int grade = 2;
    school.add("James", grade);
    school.add("Blair", grade);
    school.add("Paul", grade);

    assertThat(school.db().get(grade)).hasSize(3).contains("James", "Blair", "Paul");
  }

  @Test
  @Category(NotReady.class)
  public void addsStudentsInMultipleGrades() {
    school.add("Chelsea", 3);
    school.add("Logan", 7);

    assertThat(school.db()).hasSize(2);
    assertThat(school.db().get(3)).hasSize(1).contains("Chelsea");
    assertThat(school.db().get(7)).hasSize(1).contains("Logan");
  }

  @Test
  @Category(NotReady.class)
  public void getsStudentsInAGrade() {
    school.add("Franklin", 5);
    school.add("Bradley", 5);
    school.add("Jeff", 1);
    assertThat(school.grade(5)).hasSize(2).contains("Franklin", "Bradley");
  }

  @Test
  @Category(NotReady.class)
  public void getsStudentsInEmptyGrade() {
    assertThat(school.grade(1)).isEmpty();
  }

  @Test
  @Category(NotReady.class)
  public void sortsSchool() {
    school.add("Jennifer", 4);
    school.add("Kareem", 6);
    school.add("Christopher", 4);
    school.add("Kyle", 3);
    Map<Integer, List<String>> sortedStudents = new HashMap<Integer, List<String>>();
    sortedStudents.put(6, Arrays.asList("Kareem"));
    sortedStudents.put(4, Arrays.asList("Christopher", "Jennifer"));
    sortedStudents.put(3, Arrays.asList("Kyle"));

    assertThat(school.sort()).isEqualTo(sortedStudents);
  }
}
