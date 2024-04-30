import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllergiesTest {


    // Testing for eggs allergy

    @Test
    public void eggsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void eggsAllergicOnlyToEggs() {
        Allergies allergies = new Allergies(1);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void eggsAllergicToEggsAndSomethingElse() {
        Allergies allergies = new Allergies(3);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void eggsAllergicToSomethingButNotEggs() {
        Allergies allergies = new Allergies(2);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void eggsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }


    // Testing for peanuts allergy

    @Test
    public void peanutsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void peanutsAllergicOnlyToPeanuts() {
        Allergies allergies = new Allergies(2);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void peanutsAllergicToPeanutsAndSomethingElse() {
        Allergies allergies = new Allergies(7);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void peanutsAllergicToSomethingButNotPeanuts() {
        Allergies allergies = new Allergies(5);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void peanutsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }


    // Testing for shellfish allergy

    @Test
    public void shellfishNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void shellfishAllergicOnlyToShellfish() {
        Allergies allergies = new Allergies(4);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void shellfishAllergicToShellfishAndSomethingElse() {
        Allergies allergies = new Allergies(14);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void shellfishAllergicToSomethingButNotShellfish() {
        Allergies allergies = new Allergies(10);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void shellfishAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }


    // Testing for strawberries allergy

    @Test
    public void strawberriesNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void strawberriesAllergicOnlyToStrawberries() {
        Allergies allergies = new Allergies(8);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void strawberriesAllergicToStrawberriesAndSomethingElse() {
        Allergies allergies = new Allergies(28);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void strawberriesAllergicToSomethingButNotStrawberries() {
        Allergies allergies = new Allergies(20);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void strawberriesAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }


    // Testing for tomatoes allergy

    @Test
    public void tomatoesNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void tomatoesAllergicOnlyToTomatoes() {
        Allergies allergies = new Allergies(16);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void tomatoesAllergicToTomatoesAndSomethingElse() {
        Allergies allergies = new Allergies(56);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void tomatoesAllergicToSomethingButNotTomatoes() {
        Allergies allergies = new Allergies(40);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void tomatoesAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }


    // Testing for chocolate allergy

    @Test
    public void chocolateNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void chocolateAllergicOnlyToChocolate() {
        Allergies allergies = new Allergies(32);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void chocolateAllergicToChocolateAndSomethingElse() {
        Allergies allergies = new Allergies(112);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void chocolateAllergicToSomethingButNotChocolate() {
        Allergies allergies = new Allergies(80);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void chocolateAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }


    // Testing for pollen allergy

    @Test
    public void pollenNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void pollenAllergicOnlyToPollen() {
        Allergies allergies = new Allergies(64);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void pollenAllergicToPollenAndSomethingElse() {
        Allergies allergies = new Allergies(224);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void pollenAllergicToSomethingButNotPollen() {
        Allergies allergies = new Allergies(160);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void pollenAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }


    // Testing for cats allergy

    @Test
    public void catsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void catsAllergicOnlyToCats() {
        Allergies allergies = new Allergies(128);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void catsAllergicToCatsAndSomethingElse() {
        Allergies allergies = new Allergies(192);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void catsAllergicToSomethingButNotCats() {
        Allergies allergies = new Allergies(64);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void catsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }


    // Testing listing allergies

    @Disabled("Remove to run test")
    @Test
    public void listNoAllergies() {
        Allergies allergies = new Allergies(0);

        assertThat(allergies.getList().size()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    public void listJustEggs() {
        Allergies allergies = new Allergies(1);

        assertThat(allergies.getList())
                .containsExactly(Allergen.EGGS);
    }

    @Disabled("Remove to run test")
    @Test
    public void listJustPeanuts() {
        Allergies allergies = new Allergies(2);

        assertThat(allergies.getList())
                .containsExactly(Allergen.PEANUTS);
    }

    @Disabled("Remove to run test")
    @Test
    public void listJustStrawberries() {
        Allergies allergies = new Allergies(8);

        assertThat(allergies.getList())
                .containsExactly(Allergen.STRAWBERRIES);
    }

    @Disabled("Remove to run test")
    @Test
    public void listEggsAndPeanuts() {
        Allergies allergies = new Allergies(3);

        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.PEANUTS);
    }

    @Disabled("Remove to run test")
    @Test
    public void listoMoreThanEggsButNotPeanuts() {
        Allergies allergies = new Allergies(5);

        assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.SHELLFISH);
    }

    @Disabled("Remove to run test")
    @Test
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
    public void listNoAllergenScorePartsWithoutHighestValidScore() {
        Allergies allergies = new Allergies(257);

        assertThat(allergies.getList())
                .containsExactly(Allergen.EGGS);
    }
}
