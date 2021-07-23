import java.util.Map;
import java.util.LinkedHashMap;

public class RomanNumerals {

    private int arabicNumeral;

    private static final Map<Integer, String> arabicToRomanConversions = new LinkedHashMap<>();

    static {
        arabicToRomanConversions.put(1000, "M");
        arabicToRomanConversions.put(900, "CM");
        arabicToRomanConversions.put(500, "D");
        arabicToRomanConversions.put(400, "CD");
        arabicToRomanConversions.put(100, "C");
        arabicToRomanConversions.put(90, "XC");
        arabicToRomanConversions.put(50, "L");
        arabicToRomanConversions.put(40, "XL");
        arabicToRomanConversions.put(10, "X");
        arabicToRomanConversions.put(9, "IX");
        arabicToRomanConversions.put(5, "V");
        arabicToRomanConversions.put(4, "IV");
        arabicToRomanConversions.put(1, "I");
    }

    public RomanNumerals(int arabicNumeral) {
        this.arabicNumeral = arabicNumeral;
    }


    public String getRomanNumeral() {
        StringBuilder romanNumeral = new StringBuilder();

        for (Map.Entry<Integer, String> conversion : arabicToRomanConversions.entrySet()) {
            while (arabicNumeral / conversion.getKey() > 0) {
                arabicNumeral -= conversion.getKey();

                romanNumeral.append(conversion.getValue());
            }
        }

        return romanNumeral.toString();
    }
}
