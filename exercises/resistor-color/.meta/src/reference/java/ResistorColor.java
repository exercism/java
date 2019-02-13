import java.util.Arrays;

class ResistorColor {

    final String[] COLORS = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int colorCode(String color) {
        return Arrays.asList(COLORS).indexOf(color);
    }

    String[] colors() {
        return COLORS;
    }
}
