import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Say {

    private static List<Magnitude> supportedMagnitudes = Arrays.asList(
        Magnitude.BILLIONS, Magnitude.MILLIONS, 
        Magnitude.THOUSANDS, Magnitude.ONES);

    private enum Magnitude {
        TRILLIONS(1_000_000_000_000L, "trillion"), 
        BILLIONS(1_000_000_000, "billion"), 
        MILLIONS(1_000_000, "million"), 
        THOUSANDS(1_000, "thousand"), 
        ONES(1, "one");

        private long number;
        private String inEnglish;

        private Magnitude(long number, String inEnglish) {
            this.number = number;
            this.inEnglish = inEnglish;
        }

        public long getNumber() {
            return number;
        }

        public String inEnglish() {
            return inEnglish;
        }
    }

    public String say(long number) {
        if (number < 0 || number >= Magnitude.TRILLIONS.getNumber()) {
            throw new IllegalArgumentException("input out of range");
        }
        List<Part> parts = new ArrayList<Say.Part>();
        for (Magnitude magnitude: supportedMagnitudes) { 
            double quoziente = Math.floor(number / magnitude.getNumber());
            Part part = new Part((int) quoziente, magnitude);
            if (part.getDigits() > 0 || (part.getMagnitude().equals(Magnitude.ONES) && parts.size() == 0)) {
                parts.add(part);
            }
            number =   number % magnitude.getNumber();
        }
      
        return String.join(" ", parts.stream().map(part -> part.say()).collect(Collectors.toList()));
    }

    private static class Part {
        private int digits;
        private Magnitude magnitude;

        public Part(int digits, Magnitude magnitude) {
            this.digits = digits;
            this.magnitude = magnitude;
        }

        private static String[] untilTwenty = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eigth",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "senventeen", "eithteen",
            "nineteen" };

        public int getDigits() {
            return digits;
        }

        public Magnitude getMagnitude() {
            return magnitude;
        }
        
        private String convertTens(long digit) {
            switch ((int) digit) {
                case 2:
                    return "twenty";
                case 3:
                    return "thirty";
                case 4:
                    return "forty";
                case 5:
                    return "fifty";
                case 6:
                    return "sixty";
                case 7:
                    return "seventy";
                case 8:
                    return "eighty";
                case 9:
                    return "ninety";
                default:
                    throw new IllegalArgumentException("not supported value");
            }
        }

        private String say() {
            StringBuffer stringBuffer = new StringBuffer();
            int hundreds = (int) digits / 100;
            int tens = (int) digits % 100;
            if (hundreds > 0) {
                stringBuffer.append(untilTwenty[hundreds]).append(" hundred");
            }

            if (stringBuffer.length() > 0) {
                stringBuffer.append(" ");
            }

            if (tens >= 20) {
                stringBuffer.append(convertTens(tens / 10));
                if (tens % 10 > 0) {
                    stringBuffer.append("-").append(untilTwenty[tens % 10]);
                }
            } else {
                stringBuffer.append(untilTwenty[tens]);
            }
            
            if (!magnitude.equals(Magnitude.ONES)) {
                stringBuffer.append(" ").append(magnitude.inEnglish());
            }
                 
            String message = stringBuffer.toString().replace(" zero", "");
            return message;
        }
    }
}

