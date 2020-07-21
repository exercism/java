import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class QuestLogicTest {
    @Test
    public void cannot_execute_fast_attack_if_knight_is_awake() {
        boolean knightIsAwake = true;
        assertFalse(QuestLogic.canFastAttack(knightIsAwake));
    }

    @Test
    @Ignore
    public void can_execute_fast_attack_if_knight_is_sleeping() {
        boolean knightIsAwake = false;
        assertTrue(QuestLogic.canFastAttack(knightIsAwake));
    }

    @Test
    @Ignore
    public void cannot_spy_if_everyone_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        assertFalse(QuestLogic.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void can_spy_if_everyone_but_knight_is_sleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        assertTrue(QuestLogic.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void can_spy_if_everyone_but_archer_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        assertTrue(QuestLogic.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void can_spy_if_everyone_but_prisoner_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;


        boolean prisonerIsAwake = true;
        assertTrue(QuestLogic.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void can_spy_if_only_knight_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        assertTrue(QuestLogic.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void can_spy_if_only_archer_is_sleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        assertTrue(QuestLogic.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void can_spy_if_only_prisoner_is_sleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        assertTrue(QuestLogic.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void can_spy_if_everyone_is_awake() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        assertTrue(QuestLogic.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void can_signal_prisoner_ifarcher_is_sleeping_and_prisoner_is_awake() {
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        assertTrue(QuestLogic.canSignalPrisoner(archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void cannot_signal_prisoner_ifarcher_is_awake_and_prisoner_is_sleeping() {
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        assertFalse(QuestLogic.canSignalPrisoner(archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void cannot_signal_prisoner_ifarcher_and_prisoner_are_both_sleeping() {
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        assertFalse(QuestLogic.canSignalPrisoner(archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void cannot_signal_prisoner_ifarcher_and_prisoner_are_both_awake() {
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        assertFalse(QuestLogic.canSignalPrisoner(archerIsAwake, prisonerIsAwake));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_everyone_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_everyone_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void can_release_prisoner_if_everyone_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        assertTrue(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_everyone_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void can_release_prisoner_if_only_prisoner_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        assertTrue(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void can_release_prisoner_if_only_prisoner_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        assertTrue(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_only_archer_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_only_archer_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void can_release_prisoner_if_only_knight_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        assertTrue(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_only_knight_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_only_knight_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_only_knight_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void can_release_prisoner_if_only_archer_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        assertTrue(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_only_archer_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_only_prisoner_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }

    @Test
    @Ignore
    public void cannot_release_prisoner_if_only_prisoner_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        assertFalse(QuestLogic.canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent));
    }
}
