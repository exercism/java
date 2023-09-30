import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AnnalynsInfiltrationTest {

    @Test
    @Tag("task:1")
    @DisplayName("The canFastAttack method returns false when knight is awake")
    public void cannot_execute_fast_attack_if_knight_is_awake() {
        boolean knightIsAwake = true;
        assertThat(AnnalynsInfiltration.canFastAttack(knightIsAwake)).isFalse();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The canFastAttack method returns true when knight is sleeping")
    public void can_execute_fast_attack_if_knight_is_sleeping() {
        boolean knightIsAwake = false;
        assertThat(AnnalynsInfiltration.canFastAttack(knightIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns false when everyone is sleeping")
    public void cannot_spy_if_everyone_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when everyone but knight is sleeping")
    public void can_spy_if_everyone_but_knight_is_sleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when everyone but archer is sleeping")
    public void can_spy_if_everyone_but_archer_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when everyone but prisoner is sleeping")
    public void can_spy_if_everyone_but_prisoner_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when only knight is sleeping")
    public void can_spy_if_only_knight_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when only archer is sleeping")
    public void can_spy_if_only_archer_is_sleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when only prisoner is sleeping")
    public void can_spy_if_only_prisoner_is_sleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when everyone is awake")
    public void can_spy_if_everyone_is_awake() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The canSignalPrisoner method returns true when prisoner is awake and archer is sleeping")
    public void can_signal_prisoner_if_archer_is_sleeping_and_prisoner_is_awake() {
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The canSignalPrisoner method returns false when prisoner is sleeping and archer is awake")
    public void cannot_signal_prisoner_if_archer_is_awake_and_prisoner_is_sleeping() {
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The canSignalPrisoner method returns false when both prisoner and archer are sleeping")
    public void cannot_signal_prisoner_if_archer_and_prisoner_are_both_sleeping() {
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The canSignalPrisoner method returns false when both prisoner and archer are awake")
    public void cannot_signal_prisoner_if_archer_and_prisoner_are_both_awake() {
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when everyone is awake and pet dog is present")
    public void cannot_release_prisoner_if_everyone_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when everyone is awake and pet dog is absent")
    public void cannot_release_prisoner_if_everyone_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns true when everyone is sleeping and pet dog is present")
    public void can_release_prisoner_if_everyone_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when everyone is sleeping and pet dog is absent")
    public void cannot_release_prisoner_if_everyone_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns true when only prisoner is awake and pet dog is present")
    public void can_release_prisoner_if_only_prisoner_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns true when only prisoner is awake and pet dog is absent")
    public void can_release_prisoner_if_only_prisoner_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when only archer is awake and pet dog is present")
    public void cannot_release_prisoner_if_only_archer_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when only archer is awake and pet dog is absent")
    public void cannot_release_prisoner_if_only_archer_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns true when only knight is awake and pet dog is present")
    public void can_release_prisoner_if_only_knight_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when only knight is awake and pet dog is absent")
    public void cannot_release_prisoner_if_only_knight_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when only knight is sleeping and pet dog is present")
    public void cannot_release_prisoner_if_only_knight_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when only knight is sleeping and pet dog is absent")
    public void cannot_release_prisoner_if_only_knight_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns true when only archer is sleeping and pet dog is present")
    public void can_release_prisoner_if_only_archer_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when only archer is sleeping and pet dog is absent")
    public void cannot_release_prisoner_if_only_archer_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when only prisoner is sleeping and pet dog is present")
    public void cannot_release_prisoner_if_only_prisoner_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when only prisoner is sleeping and pet dog is absent")
    public void cannot_release_prisoner_if_only_prisoner_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }
}
