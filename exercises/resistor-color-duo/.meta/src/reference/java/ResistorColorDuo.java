class ResistorColorDuo {
    private enum Color {
        black, brown, red, orange, yellow, green, blue, violet, grey, white;
    };

    int value(String[] colors) {
        return 10 * Color.valueOf(colors[0]).ordinal() + Color.valueOf(colors[1]).ordinal();
    }
}
