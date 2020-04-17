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
        for (int i = 0; i < 1000; i++) {
            int score = dndCharacter.ability();
            assertTrue(score > 2 && score < 19);
        }
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
        int initialStrength     = dndCharacter.getStrength();
        int initialDexterity    = dndCharacter.getDexterity();
        int initialConstitution = dndCharacter.getConstitution();
        int initialIntelligence = dndCharacter.getIntelligence();
        int initialWisdom       = dndCharacter.getWisdom();
        int initialCharisma     = dndCharacter.getCharisma();
        for (int j = 0; j < 100; j++) {
            assertEquals(initialStrength,     dndCharacter.getStrength());
            assertEquals(initialDexterity,    dndCharacter.getDexterity());
            assertEquals(initialConstitution, dndCharacter.getConstitution());
            assertEquals(initialIntelligence, dndCharacter.getIntelligence());
            assertEquals(initialWisdom,       dndCharacter.getWisdom());
            assertEquals(initialCharisma,     dndCharacter.getCharisma());
        }
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityIsProbablyNotConstant() {
        int ability = dndCharacter.ability();
        for (int i = 0; i < 100; i++) {
            if (ability != dndCharacter.ability()) {
                return;
            }
        }
        fail();
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbilityIsDistributedAccordingToRules() {
        /* This test is meant to check if the 'ability' method is actually
         * returning a (pseudo-)random number which respects the rules of the
         * game:
         *     Roll four dice. Take the sum of the largest three dice.
         *
         * This test was added to filter out two common, wrong implementations:
         *     Returning a random number between 3 and 18.
         *     Returning the sum of three random numbers each between 1 and 6.
         *
         * The way we check if the 'ability' method is distributed correctly is
         * by creating a histogram of the distribution by calling ability
         * repeatedly. Then we compare it to the reference distribution within
         * a certain tolerance.
         */

        // These two values were chosen empirically.
        final int cycles       = 10000;
        final double tolerance = 0.02;

        // Amount of possible combinations for throwing 4 dice
        int referenceCount = 6 * 6 * 6 * 6;
        // This distribution was generated by going through all possible
        // combinations for throwing four dice, computing the ability for that
        // combination, and incrementing the array at that index.
        int[] referenceDistribution = new int[] {
            0, 0, 0, 1, 4, 10, 21, 38, 62, 91, 122, 148, 167, 172, 160, 131, 94, 54, 21
        };
        int[] actualDistribution = new int[19];

        for (int i = 0; i < cycles; i++) {
            int ability = dndCharacter.ability();
            if (ability >= 3 && ability <= 18) {
                actualDistribution[ability]++;
            } else {
                fail("ability out of Range");
            }
        }

        for (int ability = 3; ability <= 18; ability++) {
            double referenceProbability = (double) referenceDistribution[ability] / referenceCount;
            double actualProbability    = (double) actualDistribution[ability] / cycles;
            double difference           = Math.abs(referenceProbability - actualProbability);
            if (difference > tolerance) {
                fail();
            }
        }
    }

    /*
     * Extra Notes:
     *
     * What is the difference between "throwing four dice and taking the sum of
     * the largest three" and just "throwing three dice and taking their sum"?
     *
     * Let's take a look at a few examples:
     *
     * What would the probability be to get an ability of 3?
     * For this to happen all four dice have to be a 1:
     *     1 1 1 1
     * Otherwise if one dice were larger than 1 it would be within the largest
     * three and the resulting sum would be greater than 3. So the probability
     * must be: 1/6 * 1/6 * 1/6 * 1/6 = 1/1296.
     *
     * What would the probability be to get an ability of 18?
     * One option would be that all dices are a 6. But as we are only summing
     * the three largest dice we actually don't care what the last dice was!
     * We also don't care if it is the first, second, third or fourth dice
     * which isn't a 6 as long as the others are.
     * So all combinations which result in an ability of 18 are:
     *     6 6 6 6
     *
     *     6 6 6 1
     *     6 6 6 2
     *     6 6 6 3
     *     6 6 6 4
     *     6 6 6 5
     *
     *     6 6 1 6
     *     6 6 2 6
     *     6 6 3 6
     *     6 6 4 6
     *     6 6 5 6
     *
     *     6 1 6 6
     *     6 2 6 6
     *     6 3 6 6
     *     6 4 6 6
     *     6 5 6 6
     *
     *     1 6 6 6
     *     2 6 6 6
     *     3 6 6 6
     *     4 6 6 6
     *     5 6 6 6
     * In total there are 21, so the probability is 21/1296, which is 21 times
     * higher than that of getting an ability of 3!
     *
     * If we were just throwing three dice the probability for an ability of 3
     * and 18 would be the same: For each one there is just one possible
     * combination:
     *     1 1 1    for 3
     *     6 6 6    for 18
     * Thus the probability for both is each: 1/6 * 1/6 * 1/6 = 1/216
     *
     * Intuitively you can think of the distribution of the "roll four dice.
     * sum the larges three" being more biased to larger abilities than the
     * "sum three dice".
     */

}
