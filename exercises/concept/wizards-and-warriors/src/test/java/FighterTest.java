import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import utils.Warrior;
import utils.Wizard;

public class FighterTest {

    @Test
    @Tag("task:1")
    @DisplayName("Test that the Warrior class exists in the code")
    public void testWarriorClassExists() {
        try {
            Class.forName("Warrior");
        } catch (ClassNotFoundException e) {
            fail("Should have a class called Warrior");
        }
    }

    @Test
    @Tag("task:1")
    @DisplayName("Test that the Warrior class is an instance of the Fighter class")
    public void testWarriorIsInstanceOfFighter() {
        assertThat(new Warrior().extendsClass("Fighter")).isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("Warrior has the toString method implemented")
    public void implemented_to_string_for_warrior() {
        assertThat(new Warrior().hasMethod("toString"))
                .withFailMessage("Method toString must be created")
                .isTrue();
        assertThat(new Warrior().isMethodPublic("toString"))
                .withFailMessage("Method toString must be public")
                .isTrue();
        assertThat(new Warrior().isMethodReturnType(String.class, "toString"))
                .withFailMessage("Method toString must return a String")
                .isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The toString method of the Warrior returns the correct description of the fighter")
    public void testWarriorToString() {
        assertThat(new Warrior().toString()).isEqualTo("Fighter is a Warrior");
    }

    @Test
    @Tag("task:3")
    @DisplayName("Warrior has the isVulnerable method implemented")
    public void implemented_is_vulnerable_for_warrior() {
        assertThat(new Warrior().hasMethod("isVulnerable"))
                .withFailMessage("Method isVulnerable must be created")
                .isTrue();
        assertThat(new Warrior().isMethodPublic("isVulnerable"))
                .withFailMessage("Method isVulnerable must be public")
                .isTrue();
        assertThat(new Warrior().isMethodReturnType(boolean.class, "isVulnerable"))
                .withFailMessage("Method isVulnerable must return a boolean")
                .isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The isVulnerable method of the Warrior always returns false")
    public void testWarriorAlwaysInvulnerable() {
        assertThat(new Warrior().isVulnerable()).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("Warrior has the getDamagePoints method implemented")
    public void implemented_get_damage_points_for_warrior() {
        assertThat(new Warrior().hasMethod("getDamagePoints"))
                .withFailMessage("Method getDamagePoints must be created")
                .isTrue();
        assertThat(new Warrior().isMethodPublic("getDamagePoints"))
                .withFailMessage("Method getDamagePoints must be public")
                .isTrue();
        assertThat(new Warrior().isMethodReturnType(int.class, "getDamagePoints"))
                .withFailMessage("Method getDamagePoints must return an int")
                .isTrue();
    }
    
    @Test
    @Tag("task:4")
    @DisplayName("The getDamagePoints method of the Warrior returns 10 when target is vulnerable")
    public void testWarriorsDamagePointsWhenTargetVulnerable() {
        assertThat(new Warrior().getDamagePoints(new Wizard())).isEqualTo(10);
    }

    @Test
    @Tag("task:4")
    @DisplayName("The getDamagePoints method of the Warrior returns 6 when target is not vulnerable")
    public void testWarriorsDamagePointsWhenTargetNotVulnerable() {
        Wizard wizard = new Wizard();
        wizard.prepareSpell();
        assertThat(new Warrior().getDamagePoints(wizard)).isEqualTo(6);
    }
    
    @Test
    @Tag("task:5")
    @DisplayName("Test that the Wizard class exists in the code")
    public void testWizardClassExists() {
        try {
            Class.forName("Wizard");
        } catch (ClassNotFoundException e) {
            fail("Should have a class called Wizard");
        }
    }
    
    @Test
    @Tag("task:5")
    @DisplayName("Test that the Wizard class is an instance of the Fighter class")
    public void testWizardIsInstanceOfFighter() {
        assertThat(new Wizard().extendsClass("Fighter")).isTrue();
    }

    @Test
    @Tag("task:6")
    @DisplayName("Wizard has the toString method implemented")
    public void implemented_to_string_for_wizard() {
        assertThat(new Wizard().hasMethod("toString"))
                .withFailMessage("Method toString must be created")
                .isTrue();
        assertThat(new Wizard().isMethodPublic("toString"))
                .withFailMessage("Method toString must be public")
                .isTrue();
        assertThat(new Wizard().isMethodReturnType(String.class, "toString"))
                .withFailMessage("Method toString must return a String")
                .isTrue();
    }

    @Test
    @Tag("task:6")
    @DisplayName("The toString method of the Wizard returns the correct description of the fighter")
    public void testWizardToString() {
        assertThat(new Wizard().toString()).isEqualTo("Fighter is a Wizard");
    }

    @Test
    @Tag("task:8")
    @DisplayName("Wizard has the prepareSpell method implemented")
    public void implemented_prepare_spell_for_wizard() {
        assertThat(new Wizard().hasMethod("prepareSpell"))
                .withFailMessage("Method prepareSpell must be created")
                .isTrue();
        assertThat(new Wizard().isMethodPublic("prepareSpell"))
                .withFailMessage("Method prepareSpell must be public")
                .isTrue();
    }

    @Test
    @Tag("task:7")
    @DisplayName("The prepareSpell method makes the Wizard not vulnerable")
    public void testWizardVulnerable() {
        Wizard wizard = new Wizard();
        wizard.prepareSpell();
        assertThat(wizard.isVulnerable()).isFalse();
    }

    @Test
    @Tag("task:8")
    @DisplayName("Wizard has the isVulnerable method implemented")
    public void implemented_is_vulnerable_for_wizard() {
        assertThat(new Wizard().hasMethod("isVulnerable"))
                .withFailMessage("Method isVulnerable must be created")
                .isTrue();
        assertThat(new Wizard().isMethodPublic("isVulnerable"))
                .withFailMessage("Method isVulnerable must be public")
                .isTrue();
        assertThat(new Wizard().isMethodReturnType(boolean.class, "isVulnerable"))
                .withFailMessage("Method isVulnerable must return a boolean")
                .isTrue();
    }

    @Test
    @Tag("task:8")
    @DisplayName("The isVulnerable method of the Wizard returns true by default")
    public void testWizardVulnerableByDefault() {
        assertThat(new Wizard().isVulnerable()).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("Wizard has the getDamagePoints method implemented")
    public void implemented_get_damage_points_for_wizard() {
        assertThat(new Wizard().hasMethod("getDamagePoints"))
                .withFailMessage("Method getDamagePoints must be created")
                .isTrue();
        assertThat(new Wizard().isMethodPublic("getDamagePoints"))
                .withFailMessage("Method getDamagePoints must be public")
                .isTrue();
        assertThat(new Wizard().isMethodReturnType(int.class, "getDamagePoints"))
                .withFailMessage("Method getDamagePoints must return an int")
                .isTrue();
    }

    @Test
    @Tag("task:9")
    @DisplayName("The getDamagePoints method of the Wizard returns 3 when spell has not been prepared")
    public void testWizardsDamagePoints() {
        assertThat(new Wizard().getDamagePoints(new Warrior())).isEqualTo(3);
    }

    @Test
    @Tag("task:9")
    @DisplayName("The getDamagePoints method of the Wizard returns 12 after a spell has been prepared")
    public void testWizardsDamagePointsAfterPreparingSpell() {
        Wizard wizard = new Wizard();
        wizard.prepareSpell();
        assertThat(wizard.getDamagePoints(new Warrior())).isEqualTo(12);
    }
}
