class BottleSong {
    private String word(int number) {
        return switch (number) {
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            case 10 -> "ten";
            default -> throw new IllegalArgumentException("Unrecognised number: " + Integer.toString(number));
        };
    }

    private String verse(int number) {
        return switch (number) {
            case 1 -> 
                "One green bottle hanging on the wall,\n" +
                "One green bottle hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be no green bottles hanging on the wall.\n";
            case 2 -> 
                "Two green bottles hanging on the wall,\n" +
                "Two green bottles hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be one green bottle hanging on the wall.\n";
            default -> { 
                var codePoints = word(number).codePoints().toArray();
                codePoints[0] = Character.toUpperCase(codePoints[0]);
                var numberText = new String(codePoints, 0, codePoints.length);

                var nextNumberText = word(number - 1);

                yield String.format(
                    "%s green bottles hanging on the wall,\n" +
                    "%s green bottles hanging on the wall,\n" +
                    "And if one green bottle should accidentally fall,\n" +
                    "There'll be %s green bottles hanging on the wall.\n",
                    numberText, numberText, nextNumberText);
            }
        };
    }

    String recite(int startBottles, int takeDown) {
        var stop = startBottles - takeDown + 1;
        var output = new StringBuilder();

        for (var i = startBottles; i >= stop; i--) {
            if (i != startBottles) {
                output.append("\n");
            }
            output.append(verse(i));
        }

        return output.toString();
    }
}
