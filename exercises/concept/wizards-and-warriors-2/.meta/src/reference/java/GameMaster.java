enum TravelMethod {
    WALKING,
    HORSEBACK
}

public class GameMaster {

    public static String describe(Character character) {
        return "You're a level " + character.getLevel() + " " + character.getCharacterClass() + " with " +
               character.getHitPoints() + " hit points.";
    }

    public static String describe(Destination destination) {
        return "You've arrived at " + destination.getName() + ", which has " + destination.getInhabitants() + " " +
               "inhabitants.";
    }

    public static String describe(TravelMethod travelMethod) {
        if (java.util.Objects.requireNonNull(travelMethod) == TravelMethod.WALKING) {
            return "You're traveling to your destination by walking.";
        }
        return "You're traveling to your destination on horseback.";

    }

    public static String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
    }

    public static String describe(Character character, Destination destination) {
        return describe(character) + " You're traveling to your destination by walking. " + describe(destination);
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
