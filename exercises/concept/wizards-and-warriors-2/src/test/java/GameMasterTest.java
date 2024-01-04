import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameMasterTest {

    @Test
    @Tag("task:1")
    @DisplayName("Implemented the describeCharacter method")
    public void implementedDescribeCharacter() {
        assertThat(new GameMasterProxy().hasMethod("describe", Character.class))
                .withFailMessage("Please implement the 'describe(Character character) method")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodPublic("describe", Character.class))
                .withFailMessage("Method 'describe(Character character)' must be public")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodReturnType(String.class, "describe", Character.class))
                .withFailMessage("Method 'describe(Character character)' must return a String")
                .isTrue();

    }

    @Test
    @Tag("task:1")
    @DisplayName("Describe a character by class: Warrior")
    public void describeWarriorCharacter() {
        Character character = new Character();
        character.setCharacterClass("Warrior");
        character.setLevel(16);
        character.setHitPoints(89);

        assertThat(new GameMasterProxy().describe(character)).isEqualTo("You're a level 16 Warrior with 89 hit points" +
                                                                        ".");
    }

    @Test
    @Tag("task:1")
    @DisplayName("Describe a character by class: Wizard")
    public void describeWizardCharacter() {
        Character character = new Character();
        character.setCharacterClass("Wizard");
        character.setLevel(7);
        character.setHitPoints(33);

        assertThat(new GameMasterProxy().describe(character)).isEqualTo("You're a level 7 Wizard with 33 hit points.");
    }

    @Test
    @Tag("task:2")
    @DisplayName("Implemented the describeDestination method")
    public void implementedDescribeDestination() {
        assertThat(new GameMasterProxy().hasMethod("describe", Destination.class))
                .withFailMessage("Please implement the 'describe(Destination destination)' method")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodPublic("describe", Destination.class))
                .withFailMessage("Method 'describe(Destination destination)' must be public")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodReturnType(String.class, "describe", Destination.class))
                .withFailMessage("Method 'describe(Destination destination)' must return a String")
                .isTrue();

    }

    @Test
    @Tag("task:2")
    @DisplayName("Describe a destination: Tol Honeth")
    public void describeSmallTownDestination() {
        Destination destination = new Destination();
        destination.setName("Tol Honeth");
        destination.setInhabitants(41);

        assertThat(new GameMasterProxy().describe(destination)).isEqualTo("You've arrived at Tol Honeth, which has 41" +
                                                                          " inhabitants.");
    }

    @Test
    @Tag("task:2")
    @DisplayName("Describe a destination: Ashaba")
    public void describeLargeTownDestination() {
        Destination destination = new Destination();
        destination.setName("Ashaba");
        destination.setInhabitants(1500);

        assertThat(new GameMasterProxy().describe(destination)).isEqualTo("You've arrived at Ashaba, which has 1500 " +
                                                                          "inhabitants.");
    }

    @Test
    @Tag("task:3")
    @DisplayName("Implemented the describeTravelMethod method")
    public void implementedDescribeTravelMethod() {
        assertThat(new GameMasterProxy().hasMethod("describe", TravelMethod.class))
                .withFailMessage("Please implement the 'describe(TravelMethod travelMethod)' " +
                                 "method")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodPublic("describe", TravelMethod.class))
                .withFailMessage("Method 'describe(TravelMethod travelMethod)' must be public")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodReturnType(String.class, "describe", TravelMethod.class))
                .withFailMessage("Method 'describe(TravelMethod travelMethod)' must return a String")
                .isTrue();

    }

    @Test
    @Tag("task:3")
    @DisplayName("Describe the travel method: walking")
    public void describeWalkingTravelMethod() {
        assertThat(new GameMasterProxy().describe(TravelMethod.WALKING)).isEqualTo("You're traveling to your " +
                                                                                   "destination by walking.");
    }

    @Test
    @Tag("task:3")
    @DisplayName("Describe the travel method: horseback")
    public void describeHorseTravelMethod() {
        assertThat(new GameMasterProxy().describe(TravelMethod.HORSEBACK)).isEqualTo("You're traveling to your " +
                                                                                     "destination on horseback.");
    }

    @Test
    @Tag("task:4")
    @DisplayName("Implemented the describeCharacterToDestinationByTravelMethod method")
    public void implementedDescribeCharacterTravelingToDestinationWithExplicitTravelMethod() {
        assertThat(new GameMasterProxy().hasMethod("describe", Character.class, Destination.class, TravelMethod.class))
                .withFailMessage("Please implement the 'describe(Character character, Destination destination, " +
                                 "TravelMethod travelMethod)' method")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodPublic("describe", Character.class, Destination.class,
                TravelMethod.class))
                .withFailMessage("Method 'describe(Character character, Destination destination, TravelMethod " +
                                 "travelMethod)' must be public")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodReturnType(String.class, "describe", Character.class,
                Destination.class, TravelMethod.class))
                .withFailMessage("Method 'describe(Character character, Destination destination, TravelMethod " +
                                 "travelMethod)' must return a String")
                .isTrue();

    }

    @Test
    @Tag("task:4")
    @DisplayName("Describe a character traveling to a destination")
    public void describeCharacterTravelingToDestinationWithExplicitTravelMethod() {
        Character character = new Character();
        character.setCharacterClass("Wizard");
        character.setLevel(20);
        character.setHitPoints(120);

        Destination destination = new Destination();
        destination.setName("Camaar");
        destination.setInhabitants(999);

        assertThat(new GameMasterProxy().describe(character, destination, TravelMethod.HORSEBACK)).isEqualTo(
                "You're a level 20 Wizard with 120 hit points. You're traveling to your destination on horseback. " +
                "You've arrived at Camaar, which has 999 inhabitants.");
    }

    @Test
    @Tag("task:5")
    @DisplayName("Implemented the describeCharacterToDestination method")
    public void implementedDescribeCharacterTravelingToDestinationWithoutExplicitTravelMethod() {
        assertThat(new GameMasterProxy().hasMethod("describe", Character.class, Destination.class))
                .withFailMessage("Please implement the 'describe(Character character, Destination destination)' method")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodPublic("describe", Character.class, Destination.class,
                TravelMethod.class))
                .withFailMessage("Method 'describe(Character character, Destination destination)' must be public")
                .isTrue();
        assertThat(new GameMasterProxy().isMethodReturnType(String.class, "describe", Character.class,
                Destination.class, TravelMethod.class))
                .withFailMessage("Method 'describe(Character character, Destination destination)' must return a String")
                .isTrue();

    }

    @Test
    @Tag("task:5")
    @DisplayName("Combined description should handle character and destination with default travel method")
    public void describeCharacterTravelingToDestinationWithoutExplicitTravelMethod() {
        Character character = new Character();
        character.setCharacterClass("Warrior");
        character.setLevel(1);
        character.setHitPoints(30);

        Destination destination = new Destination();
        destination.setName("Vo Mimbre");
        destination.setInhabitants(332);

        assertThat(new GameMasterProxy().describe(character, destination)).isEqualTo(
                "You're a level 1 Warrior with 30 hit points. You're traveling to your destination by walking. You've" +
                " arrived at Vo Mimbre, which has 332 inhabitants.");
    }
}
