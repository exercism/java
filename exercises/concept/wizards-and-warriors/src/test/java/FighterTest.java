import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FighterTest {

    @Test
    @Tag("task:1")
    @DisplayName("The toString method of the Warrior returns the correct description of the fighter")
    public void testWarriorToString() {
        Fighter warrior = new Warrior();
        assertThat(warrior.toString()).isEqualTo("Fighter is a Warrior");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The toString method of the Wizard returns the correct description of the fighter")
    public void testWizardToString() {
        Wizard wizard = new Wizard();
        assertThat(wizard.toString()).isEqualTo("Fighter is a Wizard");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The isVulnerable method of the Warrior returns false by default")
    public void testFighterNotVulnerableByDefault() {
        Fighter warrior = new Warrior();
        assertThat(warrior.isVulnerable()).isFalse();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The prepareSpell method makes the Wizard not vulnerable")
    public void testWizardVulnerable() {
        Wizard wizard = new Wizard();
        wizard.prepareSpell();
        assertThat(wizard.isVulnerable()).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The isVulnerable method of the Wizard returns true by default")
    public void testWizardVulnerableByDefault() {
        Wizard wizard = new Wizard();
        assertThat(wizard.isVulnerable()).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The damagePoints method of the Wizard returns 3 when spell has not been prepared")
    public void testWizardsDamagePoints() {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior();
        assertThat(wizard.damagePoints(warrior)).isEqualTo(3);
    }

    @Test
    @Tag("task:4")
    @DisplayName("The damagePoints method of the Wizard returns 12 after a spell has been prepared")
    public void testWizardsDamagePointsAfterPreparingSpell() {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior();
        wizard.prepareSpell();
        assertThat(wizard.damagePoints(warrior)).isEqualTo(12);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The damagePoints method of the Warrior returns 10 when target is vulnerable")
    public void testWarriorsDamagePointsWhenTargetVulnerable() {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();
        assertThat(warrior.damagePoints(wizard)).isEqualTo(10);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The damagePoints method of the Warrior returns 6 when target is not vulnerable")
    public void testWarriorsDamagePointsWhenTargetNotVulnerable() {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();
        wizard.prepareSpell();
        assertThat(warrior.damagePoints(wizard)).isEqualTo(6);
    }
}
