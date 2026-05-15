import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AnnalynsInfiltrationTest {

    @Test
    @Tag("task:1")
    @DisplayName("The canFastAttack method returns false when knight is awake")
    public void cannotExecuteFastAttackIfKnightIsAwake() {
        boolean knightIsAwake = true;
        assertThat(AnnalynsInfiltration.canFastAttack(knightIsAwake)).isFalse();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The canFastAttack method returns true when knight is sleeping")
    public void canExecuteFastAttackIfKnightIsSleeping() {
        boolean knightIsAwake = false;
        assertThat(AnnalynsInfiltration.canFastAttack(knightIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns false when everyone is sleeping")
    public void cannotSpyIfEveryoneIsSleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when everyone but knight is sleeping")
    public void canSpyIfEveryoneButKnightIsSleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when everyone but archer is sleeping")
    public void canSpyIfEveryoneButArcherIsSleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when everyone but prisoner is sleeping")
    public void canSpyIfEveryoneButPrisonerIsSleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when only knight is sleeping")
    public void canSpyIfOnlyKnightIsSleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when only archer is sleeping")
    public void canSpyIfOnlyArcherIsSleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when only prisoner is sleeping")
    public void canSpyIfOnlyPrisonerIsSleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The canSpy method returns true when everyone is awake")
    public void canSpyIfEveryoneIsAwake() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The canSignalPrisoner method returns true when prisoner is awake and archer is sleeping")
    public void canSignalPrisonerIfArcherIsSleepingAndPrisonerIsAwake() {
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The canSignalPrisoner method returns false when prisoner is sleeping and archer is awake")
    public void cannotSignalPrisonerIfArcherIsAwakeAndPrisonerIsSleeping() {
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The canSignalPrisoner method returns false when both prisoner and archer are sleeping")
    public void cannotSignalPrisonerIfArcherAndPrisonerAreBothSleeping() {
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The canSignalPrisoner method returns false when both prisoner and archer are awake")
    public void cannotSignalPrisonerIfArcherAndPrisonerAreBothAwake() {
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The canFreePrisoner method returns false when everyone is awake and pet dog is present")
    public void cannotReleasePrisonerIfEveryoneIsAwakeAndPetDogIsPresent() {
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
    public void cannotReleasePrisonerIfEveryoneIsAwakeAndPetDogIsAbsent() {
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
    public void canReleasePrisonerIfEveryoneIsAsleepAndPetDogIsPresent() {
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
    public void cannotReleasePrisonerIfEveryoneIsAsleepAndPetDogIsAbsent() {
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
    public void canReleasePrisonerIfOnlyPrisonerIsAwakeAndPetDogIsPresent() {
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
    public void canReleasePrisonerIfOnlyPrisonerIsAwakeAndPetDogIsAbsent() {
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
    public void cannotReleasePrisonerIfOnlyArcherIsAwakeAndPetDogIsPresent() {
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
    public void cannotReleasePrisonerIfOnlyArcherIsAwakeAndPetDogIsAbsent() {
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
    public void canReleasePrisonerIfOnlyKnightIsAwakeAndPetDogIsPresent() {
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
    public void cannotReleasePrisonerIfOnlyKnightIsAwakeAndPetDogIsAbsent() {
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
    public void cannotReleasePrisonerIfOnlyKnightIsAsleepAndPetDogIsPresent() {
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
    public void cannotReleasePrisonerIfOnlyKnightIsAsleepAndPetDogIsAbsent() {
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
    public void canReleasePrisonerIfOnlyArcherIsAsleepAndPetDogIsPresent() {
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
    public void cannotReleasePrisonerIfOnlyArcherIsAsleepAndPetDogIsAbsent() {
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
    public void cannotReleasePrisonerIfOnlyPrisonerIsAsleepAndPetDogIsPresent() {
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
    public void cannotReleasePrisonerIfOnlyPrisonerIsAsleepAndPetDogIsAbsent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }
}
