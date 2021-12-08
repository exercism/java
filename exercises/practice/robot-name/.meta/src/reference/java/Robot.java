import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Robot {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String name;
    private final Random random;
    private static Set<String> nameLog = new HashSet<>();

    public Robot() {
        random = new Random();
        assignNewName();
    }

    private void assignNewName() {
        String newName = String.format("%s%d", prefix(), suffix());
        while (!nameLog.add(newName)) {
            newName = String.format("%s%d", prefix(), suffix());
        }
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void reset() {
        assignNewName();
    }

    private String prefix() {
        return String.format("%c%c",
                            getRandomCharacterFromAlphabet(),
                            getRandomCharacterFromAlphabet());
    }

    private char getRandomCharacterFromAlphabet() {
        return ALPHABET.charAt(random.nextInt(ALPHABET.length()));
    }

    private int suffix() {
        final int low = 100;
        final int high = 999;
        return random.nextInt(high - low - 1) + low;
    }
}
