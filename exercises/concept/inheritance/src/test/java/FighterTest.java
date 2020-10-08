import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class FighterTest {

    @Test
    public void testToString() {
        Fighter warrior = new Warrior();
        assertEquals("Fighter is a Warrior", warrior.toString());
    }

    @Ignore("Remove to run the test")
    @Test
    public void testFighterVulnerableByDefault() {
        Fighter warrior = new Warrior();
        assertFalse("The fighter shouldn't be vulnerable by default", warrior.isVulnerable());
    }

    @Ignore("Remove to run the test")
    @Test
    public void testWizardVulnerable() {
        Wizard wizard = new Wizard();
        assertTrue("", wizard.isVulnerable());

        wizard.prepareSpell();
        assertFalse("The wizard shouldn't be vulnerable after preparing the spell", wizard.isVulnerable());
    }

    @Ignore("Remove to run the test")
    @Test
    public void testWizardsDamagePoints() {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior();

        assertEquals(3, wizard.damagePoints(warrior));

        wizard.prepareSpell();
        assertEquals(12, wizard.damagePoints(warrior));
    }

    @Ignore("Remove to run the test")
    @Test
    public void testWarriorsDamagePoints() {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();

        assertEquals(10, warrior.damagePoints(wizard));

        wizard.prepareSpell();
        assertEquals(6, warrior.damagePoints(wizard));
    }
}
