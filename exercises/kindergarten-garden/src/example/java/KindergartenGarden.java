import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class KindergartenGarden {
    private String[] students;
    private String garden;
    private final int PLANTS_PER_STUDENT_PER_ROW = 2;
    private int NEW_ROW_LOCATION;

    private final static String[] DEFAULT_STUDENTS = {
            "Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry"
    };

    public KindergartenGarden(String garden, String[] students) {
        this.garden = garden;
        Arrays.sort(students);
        this.students = students;
        NEW_ROW_LOCATION = garden.indexOf('\n') + 1;
    }

    public KindergartenGarden(String garden) {
        this(garden, DEFAULT_STUDENTS);
    }

    public Plant[] getPlantsOfStudent(String student) {
        List<Plant> plants = new ArrayList<Plant>();
        int studentPlantsIndex = Arrays.binarySearch(students, student) * PLANTS_PER_STUDENT_PER_ROW;

        for (int i = studentPlantsIndex; i < studentPlantsIndex + PLANTS_PER_STUDENT_PER_ROW; i++) {
            plants.add(Plant.getPlant(garden.charAt(i)));
        }

        for (int i = NEW_ROW_LOCATION + studentPlantsIndex;
             i < NEW_ROW_LOCATION + studentPlantsIndex + PLANTS_PER_STUDENT_PER_ROW; i++) {
            plants.add(Plant.getPlant(garden.charAt(i)));
        }

        return plants.toArray(new Plant[0]);
    }
}