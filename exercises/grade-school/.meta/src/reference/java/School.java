import java.util.*;

class School {

  private final Map<Integer, List<String>> database = new HashMap<>();

  int numberOfStudents() {
    int result = 0;
    for (List<String> studentsInGrade : database.values()) {
      result += studentsInGrade.size();
    }
    return result;
  }

  void add(String student, int grade) {
    List<String> students = fetchGradeFromDatabase(grade);
    students.add(student);
  }

  List<String> grade(int grade) {
    return new ArrayList<>(fetchGradeFromDatabase(grade));
  }

  List<String> fetchGradeFromDatabase(int grade) {
    if (!database.containsKey(grade)) {
      database.put(grade, new LinkedList<>());
    }
    return database.get(grade);
  }

  Map<Integer, List<String>> studentsByGradeAlphabetical() {
    Map<Integer, List<String>> sortedStudents = new HashMap<>();
    for (Integer grade : database.keySet()) {
      List<String> studentsInGrade = database.get(grade);
      Collections.sort(studentsInGrade);
      sortedStudents.put(grade, studentsInGrade);
    }
    return sortedStudents;
  }
}
