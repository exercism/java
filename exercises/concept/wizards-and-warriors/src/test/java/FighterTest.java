import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FighterTest {

    @Test
    public void testWarriorToString() {
        Fighter warrior = new Warrior();
        assertThat(warrior.toString()).isEqualTo("Fighter is a Warrior");
    }

    @Test
    public void testWizardToString() {
        Wizard wizard = new Wizard();
        assertThat(wizard.toString()).isEqualTo("Fighter is a Wizard");
    }

    @Test
    public void testFighterVulnerableByDefault() {
        Fighter warrior = new Warrior();
        assertThat(warrior.isVulnerable()).isFalse();
    }

    @Test
    public void testWizardVulnerable() {
        Wizard wizard = new Wizard();
        assertThat(wizard.isVulnerable()).isTrue();
        wizard.prepareSpell();
        assertThat(wizard.isVulnerable()).isFalse();
    }

    @Test
    public void testWizardsDamagePoints() {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior();
        assertThat(wizard.damagePoints(warrior)).isEqualTo(3);
        wizard.prepareSpell();
        assertThat(wizard.damagePoints(warrior)).isEqualTo(12);
    }

    @Test
    public void testWarriorsDamagePoints() {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();
        assertThat(warrior.damagePoints(wizard)).isEqualTo(10);
        wizard.prepareSpell();
        assertThat(warrior.damagePoints(wizard)).isEqualTo(6);
    }
}
