import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class AllergiesTest {


    @Test
    public void noAllergiesMeansNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        assertEquals(false, allergies.isAllergicTo(Allergen.EGGS));
        assertEquals(false, allergies.isAllergicTo(Allergen.PEANUTS));
        assertEquals(false, allergies.isAllergicTo(Allergen.STRAWBERRIES));
        assertEquals(false, allergies.isAllergicTo(Allergen.CATS));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToEggs() {
        Allergies allergies = new Allergies(1);

        assertEquals(true, allergies.isAllergicTo(Allergen.EGGS));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToPeanuts() {
        Allergies allergies = new Allergies(2);

        assertEquals(true, allergies.isAllergicTo(Allergen.PEANUTS));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToShellfish() {
        Allergies allergies = new Allergies(4);

        assertEquals(true, allergies.isAllergicTo(Allergen.SHELLFISH));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToStrawberries() {
        Allergies allergies = new Allergies(8);

        assertEquals(true, allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToTomatoes() {
        Allergies allergies = new Allergies(16);

        assertEquals(true, allergies.isAllergicTo(Allergen.TOMATOES));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToChocolate() {
        Allergies allergies = new Allergies(32);

        assertEquals(true, allergies.isAllergicTo(Allergen.CHOCOLATE));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToPollen() {
        Allergies allergies = new Allergies(64);

        assertEquals(true, allergies.isAllergicTo(Allergen.POLLEN));
    }

    @Ignore("Remove to run test")
    @Test
    public void allergicToCats() {
        Allergies allergies = new Allergies(128);

        assertEquals(true, allergies.isAllergicTo(Allergen.CATS));
    }

    @Ignore("Remove to run test")
    @Test
    public void isAllergicToEggsInAdditionToOtherStuff() {
        Allergies allergies = new Allergies(5);

        assertEquals(true, allergies.isAllergicTo(Allergen.EGGS));
        assertEquals(true, allergies.isAllergicTo(Allergen.SHELLFISH));
        assertEquals(false, allergies.isAllergicTo(Allergen.STRAWBERRIES));
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
