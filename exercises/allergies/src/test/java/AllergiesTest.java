import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AllergiesTest {


    @Test
    public void noAllergiesMeansNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertFalse(allergies.isAllergicTo(Allergen.PEANUTS));
        assertFalse(allergies.isAllergicTo(Allergen.CATS));
        assertFalse(allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToEggs() {
        Allergies allergies = new Allergies(1);

        assertTrue(allergies.isAllergicTo(Allergen.EGGS));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToEggsInAdditionToOtherStuff() {
        Allergies allergies = new Allergies(5);

        assertTrue(allergies.isAllergicTo(Allergen.EGGS));
        assertTrue(allergies.isAllergicTo(Allergen.SHELLFISH));
        assertFalse(allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToStrawberriesButNotPeanuts() {
        Allergies allergies = new Allergies(9);

        assertTrue(allergies.isAllergicTo(Allergen.EGGS));
        assertFalse(allergies.isAllergicTo(Allergen.PEANUTS));
        assertFalse(allergies.isAllergicTo(Allergen.SHELLFISH));
        assertTrue(allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }

    @Ignore("Remove to run test")
    @Test
    public void noAllergies() {
        Allergies allergies = new Allergies(0);

        assertEquals(0, allergies.getList().size());
    }

    @Ignore("Remove to run test")
    @Test
    public void isAllergicToJustEggs() {
        Allergies allergies = new Allergies(1);
        List<Allergen> expectedAllergens = Collections.singletonList(Allergen.EGGS);

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void isAllergicToJustPeanuts() {
        Allergies allergies = new Allergies(2);
        List<Allergen> expectedAllergens = Collections.singletonList(Allergen.PEANUTS);

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void isAllergicToJustStrawberries() {
        Allergies allergies = new Allergies(8);
        List<Allergen> expectedAllergens = Collections.singletonList(Allergen.STRAWBERRIES);

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void isAllergicToEggsAndPeanuts() {
        Allergies allergies = new Allergies(3);
        List<Allergen> expectedAllergens = Arrays.asList(
                Allergen.EGGS,
                Allergen.PEANUTS
        );

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void isAllergicToEggsAndShellfish() {
        Allergies allergies = new Allergies(5);
        List<Allergen> expectedAllergens = Arrays.asList(
                Allergen.EGGS,
                Allergen.SHELLFISH
        );

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Ignore("Remove to run test")
    @Test
    public void isAllergicToLotsOfStuff() {
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
    public void isAllergicToEverything() {
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
    public void ignoreNonAllergenScoreParts() {
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
