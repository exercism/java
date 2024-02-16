import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FighterTest {
    private WarriorProxy warrior;
    private WizardProxy wizard;

    @BeforeEach
    void setup() {
        warrior = new WarriorProxy();
        wizard = new WizardProxy();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The Warrior class is defined")
    void testWarriorClassExists() {
        try {
            Class.forName("Warrior");
        } catch (ClassNotFoundException e) {
            fail("Should have a class called Warrior");
        }
    }

    @Test
    @Tag("task:1")
    @DisplayName("The Warrior class inherits from the Fighter class")
    void testWarriorIsInstanceOfFighter() throws ClassNotFoundException {
        assertThat(Class.forName("Warrior")).isAssignableTo(Fighter.class);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The Warrior class overrides the toString method")
    void testWarriorOverridesToStringMethod() {
        assertThat(warrior.hasMethod("toString"))
                .withFailMessage("Method toString must be created")
                .isTrue();
        assertThat(warrior.isMethodPublic("toString"))
                .withFailMessage("Method toString must be public")
                .isTrue();
        assertThat(warrior.isMethodReturnType(String.class, "toString"))
                .withFailMessage("Method toString must return a String")
                .isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The toString method of the Warrior returns the correct description of the fighter")
    void testWarriorToString() {
        assertThat(warrior.toString()).isEqualTo("Fighter is a Warrior");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The Warrior class overrides the isVulnerable method")
    void testWarriorOverridesIsVulnerableMethod() {
        assertThat(warrior.hasMethod("isVulnerable"))
                .withFailMessage("Method isVulnerable must be created")
                .isTrue();
        assertThat(warrior.isMethodReturnType(boolean.class, "isVulnerable"))
                .withFailMessage("Method isVulnerable must return a boolean")
                .isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("A Warrior is never vulnerable")
    void testWarriorAlwaysInvulnerable() {
        assertThat(warrior.isVulnerable()).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The Warrior class overrides the getDamagePoints(Fighter) method")
    void testWarriorOverridesGetDamagePointsMethod() {
        assertThat(warrior.hasMethod("getDamagePoints", Fighter.class))
                .withFailMessage("Method getDamagePoints(Fighter) must be created")
                .isTrue();
        assertThat(warrior.isMethodReturnType(int.class, "getDamagePoints", Fighter.class))
                .withFailMessage("Method getDamagePoints(Fighter) must return an int")
                .isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("A Warrior deals 10 damage to a vulnerable target")
    void testWarriorsDamagePointsWhenTargetVulnerable() {
        assertThat(warrior.getDamagePoints(new VulnerableFighter())).isEqualTo(10);
    }

    @Test
    @Tag("task:4")
    @DisplayName("A Warrior deals 6 damage to an invulnerable target")
    void testWarriorsDamagePointsWhenTargetNotVulnerable() {
        assertThat(warrior.getDamagePoints(new InvulnerableFighter())).isEqualTo(6);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The Wizard class is defined")
    void testWizardClassExists() {
        try {
            Class.forName("Wizard");
        } catch (ClassNotFoundException e) {
            fail("Should have a class called Wizard");
        }
    }

    @Test
    @Tag("task:5")
    @DisplayName("The Wizard class inherits from the Fighter class")
    void testWizardIsInstanceOfFighter() throws ClassNotFoundException {
        assertThat(Class.forName("Wizard")).isAssignableTo(Fighter.class);
    }

    @Test
    @Tag("task:6")
    @DisplayName("The Wizard class overrides the toString method")
    void testWizardOverridesToStringMethod() {
        assertThat(wizard.hasMethod("toString"))
                .withFailMessage("Method toString must be created")
                .isTrue();
        assertThat(warrior.isMethodPublic("toString"))
                .withFailMessage("Method toString must be public")
                .isTrue();
        assertThat(wizard.isMethodReturnType(String.class, "toString"))
                .withFailMessage("Method toString must return a String")
                .isTrue();
    }

    @Test
    @Tag("task:6")
    @DisplayName("The toString method of the Wizard returns the correct description of the fighter")
    void testWizardToString() {
        assertThat(wizard.toString()).isEqualTo("Fighter is a Wizard");
    }

    @Test
    @Tag("task:7")
    @DisplayName("The Wizard class contains the prepareSpell method")
    void testWizardHasPrepareSpellMethod() {
        assertThat(wizard.hasMethod("prepareSpell"))
                .withFailMessage("Method prepareSpell must be created")
                .isTrue();
    }

    @Test
    @Tag("task:7")
    @DisplayName("The Fighter class does not contain the prepareSpell method")
    void testFighterDoesNotHavePrepareSpellMethod() {
        assertThatExceptionOfType(NoSuchMethodException.class)
                .isThrownBy(() -> Fighter.class.getDeclaredMethod("prepareSpell"));
    }

    @Test
    @Tag("task:7")
    @DisplayName("The Wizard class overrides the isVulnerable method")
    void testWizardOverridesIsVulnerableMethod() {
        assertThat(wizard.hasMethod("isVulnerable"))
                .withFailMessage("Method isVulnerable must be created")
                .isTrue();
        assertThat(wizard.isMethodReturnType(boolean.class, "isVulnerable"))
                .withFailMessage("Method isVulnerable must return a boolean")
                .isTrue();
    }

    @Test
    @Tag("task:7")
    @DisplayName("A Wizard is vulnerable when not prepared with a spell")
    void testWizardVulnerableByDefault() {
        assertThat(wizard.isVulnerable()).isTrue();
    }

    @Test
    @Tag("task:7")
    @DisplayName("A Wizard is not vulnerable when prepared with a spell")
    void testWizardVulnerable() {
        wizard.prepareSpell();
        assertThat(wizard.isVulnerable()).isFalse();
    }

    @Test
    @Tag("task:8")
    @DisplayName("The Wizard class overrides the getDamagePoints(Fighter) method")
    void testWizardOverridesGetDamagePointsMethod() {
        assertThat(wizard.hasMethod("getDamagePoints", Fighter.class))
                .withFailMessage("Method getDamagePoints(Fighter) must be created")
                .isTrue();
        assertThat(wizard.isMethodReturnType(int.class, "getDamagePoints", Fighter.class))
                .withFailMessage("Method getDamagePoints(Fighter) must return an int")
                .isTrue();
    }

    @Test
    @Tag("task:8")
    @DisplayName("A Wizard deals 3 damage when no spell has been prepared")
    void testWizardsDamagePoints() {
        assertThat(wizard.getDamagePoints(new Fighter())).isEqualTo(3);
    }

    @Test
    @Tag("task:8")
    @DisplayName("A Wizard deals 12 damage after a spell has been prepared")
    void testWizardsDamagePointsAfterPreparingSpell() {
        wizard.prepareSpell();
        assertThat(wizard.getDamagePoints(new Fighter())).isEqualTo(12);
    }

    private static class VulnerableFighter extends Fighter {
        @Override
        boolean isVulnerable() {
            return true;
        }
    }

    private static class InvulnerableFighter extends Fighter {
        @Override
        boolean isVulnerable() {
            return false;
        }
    }
}
