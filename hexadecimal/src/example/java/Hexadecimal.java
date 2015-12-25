import java.util.Arrays;

public class Hexadecimal {
    private static final String HEXES = "0123456789abcdef";
    public static int toDecimal(String input){
        boolean  isHex = input.matches("^[0-9a-f]+");
        if (!isHex) return 0;
        return Arrays.stream(input.split(""))
                .map(HEXES::indexOf)
                .reduce(0, (decimal, hex) -> decimal * 16 + hex);

    }
}


