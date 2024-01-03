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
        if (travelMethod == TravelMethod.WALKING) {
            return "You're traveling to your destination by walking.";
        }
        return "You're traveling to your destination on horseback.";

    }

    public static String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
    }

    public static String describe(Character character, Destination destination) {
        return describe(character) + " " + describe(TravelMethod.WALKING) + " " + describe(destination);
    }
}
