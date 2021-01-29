import java.util.Arrays;
import java.util.Random;

class DnDCharacter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;

    DnDCharacter() {
        this.strength = ability();
        this.dexterity = ability();
        this.constitution = ability();
        this.intelligence = ability();
        this.wisdom = ability();
        this.charisma = ability();
        this.hitpoints = 10 + modifier(this.constitution);
    }

    int ability() {
        int[] scores = rollDices();
        int scoreSum = 0;
        for (int i = 1; i < 4; i++) {
            scoreSum += scores[i];
        }
        return scoreSum;
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

    private int[] rollDices() {
        int[] scoreSum = new int[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int score = random.nextInt(6) + 1;
            scoreSum[i] = score;
        }
        Arrays.sort(scoreSum);
        return scoreSum;
    }

}
