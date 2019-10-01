/**
 * Example Class
 */
public class ResistorColorDuo {
    public enum Color {
        black, brown, red, orange, yellow, green, blue, violet, grey, white;
    };

    int colorCode(String[] colors) {
        int resistance = 0;
        resistance += 10 * Color.valueOf(colors[0]).ordinal();
        resistance += Color.valueOf(colors[1]).ordinal();
        return resistance;
    }
}
