import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

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
    @DisplayName("Test that the Warrior class exists in the code")
    void testWarriorClassExists() {
        try {
            Class.forName("Warrior");
        } catch (ClassNotFoundException e) {
            fail("Should have a class called Warrior");
        }
    }

    @Test
    @Tag("task:1")
    @DisplayName("Test that the Warrior class is an instance of the Fighter class")
    void testWarriorIsInstanceOfFighter() throws ClassNotFoundException {
        assertThat(Class.forName("Warrior")).isAssignableTo(Fighter.class);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Warrior has the toString method implemented")
    void implemented_to_string_for_warrior() {
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
    @DisplayName("Warrior has the isVulnerable method implemented")
    void implemented_is_vulnerable_for_warrior() {
        assertThat(warrior.hasMethod("isVulnerable"))
                .withFailMessage("Method isVulnerable must be created")
                .isTrue();
        assertThat(warrior.isMethodReturnType(boolean.class, "isVulnerable"))
                .withFailMessage("Method isVulnerable must return a boolean")
                .isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The isVulnerable method of the Warrior always returns false")
    void testWarriorAlwaysInvulnerable() {
        assertThat(warrior.isVulnerable()).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("Warrior has the getDamagePoints method implemented")
    void implemented_get_damage_points_for_warrior() {
        assertThat(warrior.hasMethod("getDamagePoints", Fighter.class))
                .withFailMessage("Method getDamagePoints(Fighter) must be created")
                .isTrue();
        assertThat(warrior.isMethodReturnType(int.class, "getDamagePoints", Fighter.class))
                .withFailMessage("Method getDamagePoints(Fighter) must return an int")
                .isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The getDamagePoints method of the Warrior returns 10 when target is vulnerable")
    void testWarriorsDamagePointsWhenTargetVulnerable() {
        assertThat(warrior.getDamagePoints(new VulnerableFighter())).isEqualTo(10);
    }

    @Test
    @Tag("task:4")
    @DisplayName("The getDamagePoints method of the Warrior returns 6 when target is not vulnerable")
    void testWarriorsDamagePointsWhenTargetNotVulnerable() {
        assertThat(warrior.getDamagePoints(new InvulnerableFighter())).isEqualTo(6);
    }

    @Test
    @Tag("task:5")
    @DisplayName("Test that the Wizard class exists in the code")
    void testWizardClassExists() {
        try {
            Class.forName("Wizard");
        } catch (ClassNotFoundException e) {
            fail("Should have a class called Wizard");
        }
    }

    @Test
    @Tag("task:5")
    @DisplayName("Test that the Wizard class is an instance of the Fighter class")
    void testWizardIsInstanceOfFighter() throws ClassNotFoundException {
        assertThat(Class.forName("Wizard")).isAssignableTo(Fighter.class);
    }

    @Test
    @Tag("task:6")
    @DisplayName("Wizard has the toString method implemented")
    void implemented_to_string_for_wizard() {
        assertThat(wizard.hasMethod("toString"))
                .withFailMessage("Method toString must be created")
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
    @DisplayName("Wizard has the prepareSpell method implemented")
    void implemented_prepare_spell_for_wizard() {
        assertThat(wizard.hasMethod("prepareSpell"))
                .withFailMessage("Method prepareSpell must be created")
                .isTrue();
    }

    @Test
    @Tag("task:7")
    @DisplayName("The prepareSpell method makes the Wizard not vulnerable")
    void testWizardVulnerable() {
        wizard.prepareSpell();
        assertThat(wizard.isVulnerable()).isFalse();
    }

    @Test
    @Tag("task:7")
    @DisplayName("Wizard has the isVulnerable method implemented")
    void implemented_is_vulnerable_for_wizard() {
        assertThat(wizard.hasMethod("isVulnerable"))
                .withFailMessage("Method isVulnerable must be created")
                .isTrue();
        assertThat(wizard.isMethodReturnType(boolean.class, "isVulnerable"))
                .withFailMessage("Method isVulnerable must return a boolean")
                .isTrue();
    }

    @Test
    @Tag("task:7")
    @DisplayName("The isVulnerable method of the Wizard returns true by default")
    void testWizardVulnerableByDefault() {
        assertThat(wizard.isVulnerable()).isTrue();
    }

    @Test
    @Tag("task:8")
    @DisplayName("Wizard has the getDamagePoints method implemented")
    void implemented_get_damage_points_for_wizard() {
        assertThat(wizard.hasMethod("getDamagePoints", Fighter.class))
                .withFailMessage("Method getDamagePoints(Fighter) must be created")
                .isTrue();
        assertThat(wizard.isMethodReturnType(int.class, "getDamagePoints", Fighter.class))
                .withFailMessage("Method getDamagePoints(Fighter) must return an int")
                .isTrue();
    }

    @Test
    @Tag("task:8")
    @DisplayName("The getDamagePoints method of the Wizard returns 3 when spell has not been prepared")
    void testWizardsDamagePoints() {
        assertThat(wizard.getDamagePoints(new Fighter())).isEqualTo(3);
    }

    @Test
    @Tag("task:8")
    @DisplayName("The getDamagePoints method of the Wizard returns 12 after a spell has been prepared")
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
