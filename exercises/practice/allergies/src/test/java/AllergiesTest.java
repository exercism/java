import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllergiesTest {


    // Testing for eggs allergy

    @Test
    @DisplayName("not allergic to anything")
    public void eggsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic only to eggs")
    public void eggsAllergicOnlyToEggs() {
        Allergies allergies = new Allergies(1);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to eggs and something else")
    public void eggsAllergicToEggsAndSomethingElse() {
        Allergies allergies = new Allergies(3);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to something, but not eggs")
    public void eggsAllergicToSomethingButNotEggs() {
        Allergies allergies = new Allergies(2);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to everything")
    public void eggsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }


    // Testing for peanuts allergy

    @Test
    @DisplayName("not allergic to anything")
    public void peanutsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic only to peanuts")
    public void peanutsAllergicOnlyToPeanuts() {
        Allergies allergies = new Allergies(2);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to peanuts and something else")
    public void peanutsAllergicToPeanutsAndSomethingElse() {
        Allergies allergies = new Allergies(7);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to something, but not peanuts")
    public void peanutsAllergicToSomethingButNotPeanuts() {
        Allergies allergies = new Allergies(5);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to everything")
    public void peanutsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }


    // Testing for shellfish allergy

    @Test
    @DisplayName("not allergic to anything")
    public void shellfishNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic only to shellfish")
    public void shellfishAllergicOnlyToShellfish() {
        Allergies allergies = new Allergies(4);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to shellfish and something else")
    public void shellfishAllergicToShellfishAndSomethingElse() {
        Allergies allergies = new Allergies(14);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to something, but not shellfish")
    public void shellfishAllergicToSomethingButNotShellfish() {
        Allergies allergies = new Allergies(10);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to everything")
    public void shellfishAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }


    // Testing for strawberries allergy

    @Test
    @DisplayName("not allergic to anything")
    public void strawberriesNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic only to strawberries")
    public void strawberriesAllergicOnlyToStrawberries() {
        Allergies allergies = new Allergies(8);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to strawberries and something else")
    public void strawberriesAllergicToStrawberriesAndSomethingElse() {
        Allergies allergies = new Allergies(28);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to something, but not strawberries")
    public void strawberriesAllergicToSomethingButNotStrawberries() {
        Allergies allergies = new Allergies(20);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to everything")
    public void strawberriesAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }


    // Testing for tomatoes allergy

    @Test
    @DisplayName("not allergic to anything")
    public void tomatoesNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic only to tomatoes")
    public void tomatoesAllergicOnlyToTomatoes() {
        Allergies allergies = new Allergies(16);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to tomatoes and something else")
    public void tomatoesAllergicToTomatoesAndSomethingElse() {
        Allergies allergies = new Allergies(56);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to something, but not tomatoes")
    public void tomatoesAllergicToSomethingButNotTomatoes() {
        Allergies allergies = new Allergies(40);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to everything")
    public void tomatoesAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }


    // Testing for chocolate allergy

    @Test
    @DisplayName("not allergic to anything")
    public void chocolateNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic only to chocolate")
    public void chocolateAllergicOnlyToChocolate() {
        Allergies allergies = new Allergies(32);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to chocolate and something else")
    public void chocolateAllergicToChocolateAndSomethingElse() {
        Allergies allergies = new Allergies(112);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to something, but not chocolate")
    public void chocolateAllergicToSomethingButNotChocolate() {
        Allergies allergies = new Allergies(80);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to everything")
    public void chocolateAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }


    // Testing for pollen allergy

    @Test
    @DisplayName("not allergic to anything")
    public void pollenNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic only to pollen")
    public void pollenAllergicOnlyToPollen() {
        Allergies allergies = new Allergies(64);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to pollen and something else")
    public void pollenAllergicToPollenAndSomethingElse() {
        Allergies allergies = new Allergies(224);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to something, but not pollen")
    public void pollenAllergicToSomethingButNotPollen() {
        Allergies allergies = new Allergies(160);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to everything")
    public void pollenAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }


    // Testing for cats allergy

    @Test
    @DisplayName("not allergic to anything")
    public void catsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic only to cats")
    public void catsAllergicOnlyToCats() {
        Allergies allergies = new Allergies(128);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to cats and something else")
    public void catsAllergicToCatsAndSomethingElse() {
        Allergies allergies = new Allergies(192);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to something, but not cats")
    public void catsAllergicToSomethingButNotCats() {
        Allergies allergies = new Allergies(64);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("allergic to everything")
    public void catsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }


    // Testing listing allergies

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no allergies")
    public void listNoAllergies() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.getList().size()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("just eggs")
    public void listJustEggs() {
        Allergies allergies = new Allergies(1);

        assertThat(allergies.getList())
                .containsExactly(Allergen.EGGS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("just peanuts")
    public void listJustPeanuts() {
        Allergies allergies = new Allergies(2);

        assertThat(allergies.getList())
                .containsExactly(Allergen.PEANUTS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("just strawberries")
    public void listJustStrawberries() {
        Allergies allergies = new Allergies(8);

        assertThat(allergies.getList())
                .containsExactly(Allergen.STRAWBERRIES);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("eggs and peanuts")
    public void listEggsAndPeanuts() {
        Allergies allergies = new Allergies(3);

        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.PEANUTS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more than eggs but not peanuts")
    public void listoMoreThanEggsButNotPeanuts() {
        Allergies allergies = new Allergies(5);

        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.SHELLFISH);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("lots of stuff")
    public void listManyAllergies() {
        Allergies allergies = new Allergies(248);

        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.STRAWBERRIES,
                        Allergen.TOMATOES,
                        Allergen.CHOCOLATE,
                        Allergen.POLLEN,
                        Allergen.CATS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("everything")
    public void listEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.PEANUTS,
                        Allergen.SHELLFISH,
                        Allergen.STRAWBERRIES,
                        Allergen.TOMATOES,
                        Allergen.CHOCOLATE,
                        Allergen.POLLEN,
                        Allergen.CATS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no allergen score parts")
    public void listNoAllergenScoreParts() {
        Allergies allergies = new Allergies(509);

        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.SHELLFISH,
                        Allergen.STRAWBERRIES,
                        Allergen.TOMATOES,
                        Allergen.CHOCOLATE,
                        Allergen.POLLEN,
                        Allergen.CATS);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no allergen score parts without highest valid score")
    public void listNoAllergenScorePartsWithoutHighestValidScore() {
        Allergies allergies = new Allergies(257);

        assertThat(allergies.getList())
                .containsExactly(Allergen.EGGS);
    }
}
