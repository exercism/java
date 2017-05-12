import java.util.Arrays;

public class KindergartenGarden {
    private String[] students;
    private String garden;
    final int PARTITION_SIZE_WIDTH = 2;
    final static String[] DEFAULT_STUDENTS = {
            "Alice", "Bob", "Charlie", "David",
            "Eve", "Fred", "Ginny", "Harriet",
            "Ileana", "Joseph", "Kincaid", "Larry"
    };

    public KindergartenGarden(String garden, String[] students) {
        this.garden = garden;
        Arrays.sort(students);
        this.students = students;
    }

    public KindergartenGarden(String garden) {
        this(garden, DEFAULT_STUDENTS);
    }

    public String[] getPlantsOfStudent(String student) {
        String[] plants = new String[PARTITION_SIZE_WIDTH * 2];
        int studentPlantsIndex = Arrays.binarySearch(students, student) * PARTITION_SIZE_WIDTH;

        for (int i = 0; i < PARTITION_SIZE_WIDTH; i++) {
            plants[i] = getPlantName(garden.charAt(studentPlantsIndex + i));
        }

        int newRowLocation = garden.indexOf('\n');

        for (int i = PARTITION_SIZE_WIDTH; i < PARTITION_SIZE_WIDTH * 2; i++) {
            plants[i] = getPlantName(garden.charAt(newRowLocation - 1 + studentPlantsIndex + i));
        }

        return plants;
    }

    public String getPlantName(char plantCode) {
        switch (plantCode) {
            case 'G':
                return "grass";
            case 'C':
                return "clover";
            case 'R':
                return "radishes";
            case 'V':
                return "violets";
        }

        return null;
    }
}