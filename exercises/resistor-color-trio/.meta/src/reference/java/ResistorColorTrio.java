class ResistorColorTrio {
    private enum Color {
        BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, GREY, WHITE;
    };

    String value(String[] colors) {
        int intValue = (10 * Color.valueOf(colors[0]).ordinal() + Color.valueOf(colors[1]).ordinal())
                * (int) Math.pow(10, Color.valueOf(colors[2]).ordinal());
        String stringValue;
        if (intValue >= 1000) {
            stringValue = String.valueOf(intValue / 1000) + " kiloohms";
        } else {
            stringValue = String.valueOf(intValue) + " ohms";
        }
        return stringValue;
    }
}
