import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class DnDCharacterTest {

    private DnDCharacter dndCharacter = new DnDCharacter();

    @Test
    public void testAbilityModifierForScore3IsNegative4() {
        assertEquals(-4, dndCharacter.modifier(3));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore4IsNegative3() {
        assertEquals(-3, dndCharacter.modifier(4));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore5IsNegative3() {
        assertEquals(-3, dndCharacter.modifier(5));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore6IsNegative2() {
        assertEquals(-2, dndCharacter.modifier(6));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore7IsNegative2() {
        assertEquals(-2, dndCharacter.modifier(7));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore8IsNegative1() {
        assertEquals(-1, dndCharacter.modifier(8));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore9IsNegative1() {
        assertEquals(-1, dndCharacter.modifier(9));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore10Is0() {
        assertEquals(0, dndCharacter.modifier(10));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore11Is0() {
        assertEquals(0, dndCharacter.modifier(11));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore12Is1() {
        assertEquals(1, dndCharacter.modifier(12));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore13Is1() {
        assertEquals(1, dndCharacter.modifier(13));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore14Is2() {
        assertEquals(2, dndCharacter.modifier(14));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore15Is2() {
        assertEquals(2, dndCharacter.modifier(15));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore16Is3() {
        assertEquals(3, dndCharacter.modifier(16));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore17Is3() {
        assertEquals(3, dndCharacter.modifier(17));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityModifierForScore18Is4() {
        assertEquals(4, dndCharacter.modifier(18));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRandomAbilityIsWithinRange() {
        int score = dndCharacter.ability();
        assertTrue(score > 2 && score < 19);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRandomCharacterIsValid() {
        for (int i = 0; i < 1000; i++) {
            DnDCharacter character = new DnDCharacter();
            assertTrue(character.getStrength() > 2 && character.getStrength() < 19);
            assertTrue(character.getDexterity() > 2 && character.getDexterity() < 19);
            assertTrue(character.getConstitution() > 2 && character.getConstitution() < 19);
            assertTrue(character.getIntelligence() > 2 && character.getIntelligence() < 19);
            assertTrue(character.getWisdom() > 2 && character.getWisdom() < 19);
            assertTrue(character.getCharisma() > 2 && character.getCharisma() < 19);
            assertEquals(character.getHitpoints(),
                    10 + character.modifier(character.getConstitution()));
        }
    }

    @Ignore("Remove to run test")
    @Test
    public void testEachAbilityIsOnlyCalculatedOnce() {
        assertEquals(dndCharacter.getStrength(), dndCharacter.getStrength());
    }

}
