import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DnDCharacterTest {

    private DnDCharacter dndCharacter = new DnDCharacter();

    @Test
    @DisplayName("ability modifier for score 3 is -4")
    public void testAbilityModifierForScore3IsNegative4() {
        assertThat(dndCharacter.modifier(3)).isEqualTo(-4);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 4 is -3")
    public void testAbilityModifierForScore4IsNegative3() {
        assertThat(dndCharacter.modifier(4)).isEqualTo(-3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 5 is -3")
    public void testAbilityModifierForScore5IsNegative3() {
        assertThat(dndCharacter.modifier(5)).isEqualTo(-3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 6 is -2")
    public void testAbilityModifierForScore6IsNegative2() {
        assertThat(dndCharacter.modifier(6)).isEqualTo(-2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 7 is -2")
    public void testAbilityModifierForScore7IsNegative2() {
        assertThat(dndCharacter.modifier(7)).isEqualTo(-2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 8 is -1")
    public void testAbilityModifierForScore8IsNegative1() {
        assertThat(dndCharacter.modifier(8)).isEqualTo(-1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 9 is -1")
    public void testAbilityModifierForScore9IsNegative1() {
        assertThat(dndCharacter.modifier(9)).isEqualTo(-1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 10 is 0")
    public void testAbilityModifierForScore10Is0() {
        assertThat(dndCharacter.modifier(10)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 11 is 0")
    public void testAbilityModifierForScore11Is0() {
        assertThat(dndCharacter.modifier(11)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 12 is +1")
    public void testAbilityModifierForScore12Is1() {
        assertThat(dndCharacter.modifier(12)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 13 is +1")
    public void testAbilityModifierForScore13Is1() {
        assertThat(dndCharacter.modifier(13)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 14 is +2")
    public void testAbilityModifierForScore14Is2() {
        assertThat(dndCharacter.modifier(14)).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 15 is +2")
    public void testAbilityModifierForScore15Is2() {
        assertThat(dndCharacter.modifier(15)).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 16 is +3")
    public void testAbilityModifierForScore16Is3() {
        assertThat(dndCharacter.modifier(16)).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 17 is +3")
    public void testAbilityModifierForScore17Is3() {
        assertThat(dndCharacter.modifier(17)).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ability modifier for score 18 is +4")
    public void testAbilityModifierForScore18Is4() {
        assertThat(dndCharacter.modifier(18)).isEqualTo(4);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Rolling uses 4 dice")
    public void test4DiceWereUsedForRollingScores() {
        assertThat(dndCharacter.rollDice().size()).isEqualTo(4);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Dice values are between 1 and 6 inclusive")
    public void testDiceValuesBetween1And6() {
        assertThat(dndCharacter.rollDice()).allMatch(d -> d >= 1 && d <= 6);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Ability uses 3 largest numbers from scores in descending order")
    public void testAbilityCalculationsUses3LargestNumbersFromScoresInDescendingOrder() {
        assertThat(dndCharacter.ability(List.of(4, 3, 2, 1))).isEqualTo(9);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Ability uses 3 largest numbers from scores in ascending order")
    public void testAbilityCalculationsUses3LargestNumbersFromFromScoresInAscendingOrder() {
        assertThat(dndCharacter.ability(List.of(1, 2, 3, 4))).isEqualTo(9);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Ability uses 3 largest numbers from scores in random order")
    public void testAbilityCalculationsUses3LargestNumbersFromScoresInRandomOrder() {
        assertThat(dndCharacter.ability(List.of(2, 4, 3, 1))).isEqualTo(9);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Ability with all lowest equal numbers yields 3")
    public void testAbilityCalculationsWithLowestEqualNumbers() {
        assertThat(dndCharacter.ability(List.of(1, 1, 1, 1))).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Ability with all highest equal numbers yields 18")
    public void testAbilityCalculationsWithHighestEqualNumbers() {
        assertThat(dndCharacter.ability(List.of(6, 6, 6, 6))).isEqualTo(18);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Ability calculation with two lowest numbers")
    public void testAbilityCalculationsWithTwoLowestNumbers() {
        assertThat(dndCharacter.ability(List.of(3, 5, 3, 4))).isEqualTo(12);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Ability calculation does not mutate input scores")
    public void testAbilityCalculationDoesNotChangeInputScores() {
        List<Integer> scores = List.of(1, 2, 3, 4);
        dndCharacter.ability(scores);

        assertThat(scores.size()).isEqualTo(4);
        assertThat(scores).containsExactly(1, 2, 3, 4);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("random character is valid")
    public void testRandomCharacterIsValid() {
        for (int i = 0; i < 1000; i++) {
            DnDCharacter character = new DnDCharacter();
            assertThat(character.getStrength()).isGreaterThan(2).isLessThan(19);
            assertThat(character.getDexterity()).isGreaterThan(2).isLessThan(19);
            assertThat(character.getConstitution()).isGreaterThan(2).isLessThan(19);
            assertThat(character.getIntelligence()).isGreaterThan(2).isLessThan(19);
            assertThat(character.getWisdom()).isGreaterThan(2).isLessThan(19);
            assertThat(character.getCharisma()).isGreaterThan(2).isLessThan(19);
            assertThat(character.getHitpoints()).isEqualTo(10 + character.modifier(character.getConstitution()));
        }
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("each ability is only calculated once")
    public void testEachAbilityIsOnlyCalculatedOnce() {
        assertThat(dndCharacter.getStrength()).isEqualTo(dndCharacter.getStrength());
        assertThat(dndCharacter.getDexterity()).isEqualTo(dndCharacter.getDexterity());
        assertThat(dndCharacter.getConstitution()).isEqualTo(dndCharacter.getConstitution());
        assertThat(dndCharacter.getIntelligence()).isEqualTo(dndCharacter.getIntelligence());
        assertThat(dndCharacter.getWisdom()).isEqualTo(dndCharacter.getWisdom());
        assertThat(dndCharacter.getCharisma()).isEqualTo(dndCharacter.getCharisma());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Each randomly created character should be unique in attributes")
    public void testUniqueCharacterIsCreated() {
        DnDCharacter uniqueDnDCharacter = new DnDCharacter();
        for (int i = 0; i < 1000; i++) {
            DnDCharacter dnDCharacter = new DnDCharacter();
            boolean dnDCharactersHaveDifferentAttributes =
                    dnDCharacter.getStrength() != uniqueDnDCharacter.getStrength()
                            || dnDCharacter.getDexterity() != uniqueDnDCharacter.getDexterity()
                            || dnDCharacter.getConstitution() != uniqueDnDCharacter.getConstitution()
                            || dnDCharacter.getIntelligence() != uniqueDnDCharacter.getIntelligence()
                            || dnDCharacter.getWisdom() != uniqueDnDCharacter.getWisdom()
                            || dnDCharacter.getCharisma() != uniqueDnDCharacter.getCharisma()
                            || dnDCharacter.getHitpoints() != uniqueDnDCharacter.getHitpoints();
            assertThat(dnDCharactersHaveDifferentAttributes).isTrue();
        }
    }
}
