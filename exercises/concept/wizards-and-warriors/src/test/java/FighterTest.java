import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FighterTest {

    @Test
    public void testToString() {
        Fighter warrior = new Warrior();
        assertThat(warrior.toString()).isEqualTo("Fighter is a Warrior");
    }

    @Ignore("Remove to run the test")
    @Test
    public void testFighterVulnerableByDefault() {
        Fighter warrior = new Warrior();
        assertThat(warrior.isVulnerable()).isFalse();
    }

    @Ignore("Remove to run the test")
    @Test
    public void testWizardVulnerable() {
        Wizard wizard = new Wizard();
        assertThat(wizard.isVulnerable()).isTrue();
        wizard.prepareSpell();
        assertThat(wizard.isVulnerable()).isFalse();
    }

    @Ignore("Remove to run the test")
    @Test
    public void testWizardsDamagePoints() {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior();
        assertThat(wizard.damagePoints(warrior)).isEqualTo(3);
        wizard.prepareSpell();
        assertThat(wizard.damagePoints(warrior)).isEqualTo(12);
    }

    @Ignore("Remove to run the test")
    @Test
    public void testWarriorsDamagePoints() {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();
        assertThat(warrior.damagePoints(wizard)).isEqualTo(10);
        wizard.prepareSpell();
        assertThat(warrior.damagePoints(wizard)).isEqualTo(6);
    }
}
