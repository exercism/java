import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class DnDCharacter {

    private static final int NUMBER_OF_DICE = 4;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
        this.hitpoints = 10 + modifier(this.constitution);
    }

    int ability(List<Integer> scores) {
        return scores.stream().sorted(Collections.reverseOrder())
                .limit(3)
                .mapToInt(nr -> nr).sum();
    }

    List<Integer> rollDice() {
        return new Random()
                .ints(NUMBER_OF_DICE, 1, 7)
                .boxed()
                .collect(Collectors.toList());
    }

    int modifier(int constitution) {
        return Math.floorDiv(constitution - 10, 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }
}
