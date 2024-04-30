public class GameMaster {

    public String describe(Character character) {
        return "You're a level %d %s with %d hit points.".formatted(character.getLevel(),
                character.getCharacterClass(), character.getHitPoints());
    }

    public String describe(Destination destination) {
        return "You've arrived at %s, which has %d inhabitants.".formatted(destination.getName(),
                destination.getInhabitants());
    }

    public String describe(TravelMethod travelMethod) {
        if (travelMethod == TravelMethod.WALKING) {
            return "You're traveling to your destination by walking.";
        }
        return "You're traveling to your destination on horseback.";

    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return "%s %s %s".formatted(describe(character), describe(travelMethod), describe(destination));
    }

    public String describe(Character character, Destination destination) {
        return describe(character, destination, TravelMethod.WALKING);
    }
}
