import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameMasterTest {

    @Test
    @Tag("task:1")
    @DisplayName("Describe a character by class: Warrior")
    public void describeWarriorCharacter() {
        Character character = new Character();
        character.setCharacterClass("Warrior");
        character.setLevel(16);
        character.setHitPoints(89);

        assertThat(GameMaster.describe(character)).isEqualTo("You're a level 16 Warrior with 89 hit points.");
    }

    @Test
    @Tag("task:1")
    @DisplayName("Describe a character by class: Wizard")
    public void describeWizardCharacter() {
        Character character = new Character();
        character.setCharacterClass("Wizard");
        character.setLevel(7);
        character.setHitPoints(33);

        assertThat(GameMaster.describe(character)).isEqualTo("You're a level 7 Wizard with 33 hit points.");
    }

    @Test
    @Tag("task:2")
    @DisplayName("Describe a destination: Tol Honeth")
    public void describeSmallTownDestination() {
        Destination destination = new Destination();
        destination.setName("Tol Honeth");
        destination.setInhabitants(41);

        assertThat(GameMaster.describe(destination)).isEqualTo("You've arrived at Tol Honeth, which has 41 " +
                                                               "inhabitants.");
    }

    @Test
    @Tag("task:2")
    @DisplayName("Describe a destination: Ashaba")
    public void describeLargeTownDestination() {
        Destination destination = new Destination();
        destination.setName("Ashaba");
        destination.setInhabitants(1500);

        assertThat(GameMaster.describe(destination)).isEqualTo("You've arrived at Ashaba, which has 1500 inhabitants.");
    }

    @Test
    @Tag("task:3")
    @DisplayName("Describe the travel method: walking")
    public void describeWalkingTravelMethod() {
        assertThat(GameMaster.describe(TravelMethod.WALKING)).isEqualTo("You're traveling to your destination by " +
                                                                        "walking.");
    }

    @Test
    @Tag("task:3")
    @DisplayName("Describe the travel method: horseback")
    public void describeHorseTravelMethod() {
        assertThat(GameMaster.describe(TravelMethod.HORSEBACK)).isEqualTo("You're traveling to your destination on " +
                                                                          "horseback.");
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

        assertThat(GameMaster.describe(character, destination, TravelMethod.HORSEBACK)).isEqualTo(
                "You're a level 20 Wizard with 120 hit points. You're traveling to your destination on horseback. " +
                "You've arrived at Camaar, which has 999 inhabitants.");
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

        assertThat(GameMaster.describe(character, destination)).isEqualTo(
                "You're a level 1 Warrior with 30 hit points. You're traveling to your destination by walking. You've" +
                " arrived at Vo Mimbre, which has 332 inhabitants.");
    }
}
