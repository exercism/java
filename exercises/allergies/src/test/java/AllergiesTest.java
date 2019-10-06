import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AllergiesTest {


    // Testing for eggs allergy

    @Test
    public void eggsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertFalse(allergies.isAllergicTo(Allergen.EGGS));
    }

    @Ignore("Remove to run test")
    @Test
    public void eggsAllergicOnlyToEggs() {
        Allergies allergies = new Allergies(1);

        assertTrue(allergies.isAllergicTo(Allergen.EGGS));
    }

    @Ignore("Remove to run test")
    @Test
    public void eggsAllergicToEggsAndSomethingElse() {
        Allergies allergies = new Allergies(3);

        assertTrue(allergies.isAllergicTo(Allergen.EGGS));
    }

    @Ignore("Remove to run test")
    @Test
    public void eggsAllergicToSomethingButNotEggs() {
        Allergies allergies = new Allergies(2);

        assertFalse(allergies.isAllergicTo(Allergen.EGGS));
    }

    @Ignore("Remove to run test")
    @Test
    public void eggsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertTrue(allergies.isAllergicTo(Allergen.EGGS));
    }


    // Testing for peanuts allergy

    @Test
    public void peanutsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertFalse(allergies.isAllergicTo(Allergen.PEANUTS));
    }

    @Ignore("Remove to run test")
    @Test
    public void peanutsAllergicOnlyToPeanuts() {
        Allergies allergies = new Allergies(2);

        assertTrue(allergies.isAllergicTo(Allergen.PEANUTS));
    }

    @Ignore("Remove to run test")
    @Test
    public void peanutsAllergicToPeanutsAndSomethingElse() {
        Allergies allergies = new Allergies(7);

        assertTrue(allergies.isAllergicTo(Allergen.PEANUTS));
    }

    @Ignore("Remove to run test")
    @Test
    public void peanutsAllergicToSomethingButNotPeanuts() {
        Allergies allergies = new Allergies(5);

        assertFalse(allergies.isAllergicTo(Allergen.PEANUTS));
    }

    @Ignore("Remove to run test")
    @Test
    public void peanutsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertTrue(allergies.isAllergicTo(Allergen.PEANUTS));
    }


    // Testing for shellfish allergy

    @Test
    public void shellfishNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertFalse(allergies.isAllergicTo(Allergen.SHELLFISH));
    }

    @Ignore("Remove to run test")
    @Test
    public void shellfishAllergicOnlyToShellfish() {
        Allergies allergies = new Allergies(4);

        assertTrue(allergies.isAllergicTo(Allergen.SHELLFISH));
    }

    @Ignore("Remove to run test")
    @Test
    public void shellfishAllergicToShellfishAndSomethingElse() {
        Allergies allergies = new Allergies(14);

        assertTrue(allergies.isAllergicTo(Allergen.SHELLFISH));
    }

    @Ignore("Remove to run test")
    @Test
    public void shellfishAllergicToSomethingButNotShellfish() {
        Allergies allergies = new Allergies(10);

        assertFalse(allergies.isAllergicTo(Allergen.SHELLFISH));
    }

    @Ignore("Remove to run test")
    @Test
    public void shellfishAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertTrue(allergies.isAllergicTo(Allergen.SHELLFISH));
    }


    // Testing for strawberries allergy

    @Test
    public void strawberriesNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertFalse(allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }

    @Ignore("Remove to run test")
    @Test
    public void strawberriesAllergicOnlyToStrawberries() {
        Allergies allergies = new Allergies(8);

        assertTrue(allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }

    @Ignore("Remove to run test")
    @Test
    public void strawberriesAllergicToStrawberriesAndSomethingElse() {
        Allergies allergies = new Allergies(28);

        assertTrue(allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }

    @Ignore("Remove to run test")
    @Test
    public void strawberriesAllergicToSomethingButNotStrawberries() {
        Allergies allergies = new Allergies(20);

        assertFalse(allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }

    @Ignore("Remove to run test")
    @Test
    public void strawberriesAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertTrue(allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }


    // Testing for tomatoes allergy

    @Test
    public void tomatoesNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertFalse(allergies.isAllergicTo(Allergen.TOMATOES));
    }

    @Ignore("Remove to run test")
    @Test
    public void tomatoesAllergicOnlyToTomatoes() {
        Allergies allergies = new Allergies(16);

        assertTrue(allergies.isAllergicTo(Allergen.TOMATOES));
    }

    @Ignore("Remove to run test")
    @Test
    public void tomatoesAllergicToTomatoesAndSomethingElse() {
        Allergies allergies = new Allergies(56);

        assertTrue(allergies.isAllergicTo(Allergen.TOMATOES));
    }

    @Ignore("Remove to run test")
    @Test
    public void tomatoesAllergicToSomethingButNotTomatoes() {
        Allergies allergies = new Allergies(40);

        assertFalse(allergies.isAllergicTo(Allergen.TOMATOES));
    }

    @Ignore("Remove to run test")
    @Test
    public void tomatoesAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertTrue(allergies.isAllergicTo(Allergen.TOMATOES));
    }


    // Testing for chocolate allergy

    @Test
    public void chocolateNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertFalse(allergies.isAllergicTo(Allergen.CHOCOLATE));
    }

    @Ignore("Remove to run test")
    @Test
    public void chocolateAllergicOnlyToChocolate() {
        Allergies allergies = new Allergies(32);

        assertTrue(allergies.isAllergicTo(Allergen.CHOCOLATE));
    }

    @Ignore("Remove to run test")
    @Test
    public void chocolateAllergicToChocolateAndSomethingElse() {
        Allergies allergies = new Allergies(112);

        assertTrue(allergies.isAllergicTo(Allergen.CHOCOLATE));
    }

    @Ignore("Remove to run test")
    @Test
    public void chocolateAllergicToSomethingButNotChocolate() {
        Allergies allergies = new Allergies(80);

        assertFalse(allergies.isAllergicTo(Allergen.CHOCOLATE));
    }

    @Ignore("Remove to run test")
    @Test
    public void chocolateAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertTrue(allergies.isAllergicTo(Allergen.CHOCOLATE));
    }


    // Testing for pollen allergy

    @Test
    public void pollenNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertFalse(allergies.isAllergicTo(Allergen.POLLEN));
    }

    @Ignore("Remove to run test")
    @Test
    public void pollenAllergicOnlyToPollen() {
        Allergies allergies = new Allergies(64);

        assertTrue(allergies.isAllergicTo(Allergen.POLLEN));
    }

    @Ignore("Remove to run test")
    @Test
    public void pollenAllergicToPollenAndSomethingElse() {
        Allergies allergies = new Allergies(224);

        assertTrue(allergies.isAllergicTo(Allergen.POLLEN));
    }

    @Ignore("Remove to run test")
    @Test
    public void pollenAllergicToSomethingButNotPollen() {
        Allergies allergies = new Allergies(160);

        assertFalse(allergies.isAllergicTo(Allergen.POLLEN));
    }

    @Ignore("Remove to run test")
    @Test
    public void pollenAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertTrue(allergies.isAllergicTo(Allergen.POLLEN));
    }


    // Testing for cats allergy

    @Test
    public void catsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertFalse(allergies.isAllergicTo(Allergen.CATS));
    }

    @Ignore("Remove to run test")
    @Test
    public void catsAllergicOnlyToCats() {
        Allergies allergies = new Allergies(128);

        assertTrue(allergies.isAllergicTo(Allergen.CATS));
    }

    @Ignore("Remove to run test")
    @Test
    public void catsAllergicToCatsAndSomethingElse() {
        Allergies allergies = new Allergies(192);

        assertTrue(allergies.isAllergicTo(Allergen.CATS));
    }

    @Ignore("Remove to run test")
    @Test
    public void catsAllergicToSomethingButNotCats() {
        Allergies allergies = new Allergies(64);

        assertFalse(allergies.isAllergicTo(Allergen.CATS));
    }

    @Ignore("Remove to run test")
    @Test
    public void catsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        assertTrue(allergies.isAllergicTo(Allergen.CATS));
    }


    // Testing listing allergies

    @Ignore("Remove to run test")
    @Test
    public void listNoAllergies() {
        Allergies allergies = new Allergies(0);

        assertEquals(0, allergies.getList().size());
    }

    @Ignore("Remove to run test")
    @Test
    public void listJustEggs() {
        Allergies allergies = new Allergies(1);
        List<Allergen> expectedAllergens = Collections.singletonList(Allergen.EGGS);

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void listJustPeanuts() {
        Allergies allergies = new Allergies(2);
        List<Allergen> expectedAllergens = Collections.singletonList(Allergen.PEANUTS);

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void listJustStrawberries() {
        Allergies allergies = new Allergies(8);
        List<Allergen> expectedAllergens = Collections.singletonList(Allergen.STRAWBERRIES);

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void listEggsAndPeanuts() {
        Allergies allergies = new Allergies(3);
        List<Allergen> expectedAllergens = Arrays.asList(
                Allergen.EGGS,
                Allergen.PEANUTS
        );

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void listoMoreThanEggsButNotPeanuts() {
        Allergies allergies = new Allergies(5);
        List<Allergen> expectedAllergens = Arrays.asList(
                Allergen.EGGS,
                Allergen.SHELLFISH
        );

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void listManyAllergies() {
        Allergies allergies = new Allergies(248);
        List<Allergen> expectedAllergens = Arrays.asList(
                Allergen.STRAWBERRIES,
                Allergen.TOMATOES,
                Allergen.CHOCOLATE,
                Allergen.POLLEN,
                Allergen.CATS
        );

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void listEverything() {
        Allergies allergies = new Allergies(255);
        List<Allergen> expectedAllergens = Arrays.asList(
                Allergen.EGGS,
                Allergen.PEANUTS,
                Allergen.SHELLFISH,
                Allergen.STRAWBERRIES,
                Allergen.TOMATOES,
                Allergen.CHOCOLATE,
                Allergen.POLLEN,
                Allergen.CATS
        );

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void listNoAllergenScoreParts() {
        Allergies allergies = new Allergies(509);
        List<Allergen> expectedAllergens = Arrays.asList(
                Allergen.EGGS,
                Allergen.SHELLFISH,
                Allergen.STRAWBERRIES,
                Allergen.TOMATOES,
                Allergen.CHOCOLATE,
                Allergen.POLLEN,
                Allergen.CATS
        );

        assertEquals(expectedAllergens, allergies.getList());
    }
}
