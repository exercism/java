enum TravelMethod {
    WALKING,
    HORSEBACK
}

public class GameMaster {

    public static String describe(Character character) {
        throw new UnsupportedOperationException("Please implement the static GameMaster.describe(Character) method");
    }

    public static String describe(Destination destination) {
        throw new UnsupportedOperationException("Please implement the static GameMaster.describe(Destination) method");
    }

    public static String describe(TravelMethod travelMethod) {
        throw new UnsupportedOperationException("Please implement the static GameMaster.describe(TravelMethod) method");
    }

    public static String describe(Character character, Destination destination, TravelMethod travelMethod) {
        throw new UnsupportedOperationException("Please implement the static GameMaster.describe(Character, " +
                                                "Destination, TravelMethod) method");
    }

    public static String describe(Character character, Destination destination) {
        throw new UnsupportedOperationException("Please implement the static GameMaster.describe(Character, " +
                                                "Destination) method");
    }
}

class Character {
    private String characterClass;
    private int level;
    private int hitPoints;

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}

class Destination {
    private String name;
    private int inhabitants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(int inhabitants) {
        this.inhabitants = inhabitants;
    }
}
