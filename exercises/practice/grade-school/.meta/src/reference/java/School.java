import java.util.*;

class School {

    private final SortedMap<Integer, SortedSet<String>> database = new TreeMap<>();

    boolean add(String student, int grade) {
        if (database.values().stream().anyMatch(students -> students.contains(student))) {
            return false;
        }

        database.putIfAbsent(grade, new TreeSet<>());
        database.get(grade).add(student);
        return true;
    }

    List<String> roster() {
        List<String> result = new ArrayList<>();
        for (SortedSet<String> students : database.values()) {
            result.addAll(students);
        }
        return result;
    }

    List<String> grade(int grade) {
        SortedSet<String> students = database.getOrDefault(grade, new TreeSet<>());
        return new ArrayList<>(students);
    }
}
