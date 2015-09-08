import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void allergicToEggs() {
        Allergies allergies = new Allergies(1);

        assertEquals(true, allergies.isAllergicTo(Allergen.EGGS));
    }

    @Test
    public void allergicToPeanuts() {
        Allergies allergies = new Allergies(2);

        assertEquals(true, allergies.isAllergicTo(Allergen.PEANUTS));
    }

    @Test
    public void allergicToShellfish() {
        Allergies allergies = new Allergies(4);

        assertEquals(true, allergies.isAllergicTo(Allergen.SHELLFISH));
    }

    @Test
    public void allergicToStrawberries() {
        Allergies allergies = new Allergies(8);

        assertEquals(true, allergies.isAllergicTo(Allergen.STRAWBERRIES));
    }

    @Test
    public void allergicToTomatoes() {
        Allergies allergies = new Allergies(16);

        assertEquals(true, allergies.isAllergicTo(Allergen.TOMATOES));
    }

    @Test
    public void allergicToChocolate() {
        Allergies allergies = new Allergies(32);

        assertEquals(true, allergies.isAllergicTo(Allergen.CHOCOLATE));
    }

    @Test
    public void allergicToPollen() {
        Allergies allergies = new Allergies(64);

        assertEquals(true, allergies.isAllergicTo(Allergen.POLLEN));
    }

    @Test
    public void allergicToCats() {
        Allergies allergies = new Allergies(128);

        assertEquals(true, allergies.isAllergicTo(Allergen.CATS));
    }

    @Test
    public void isAllergicToEggsInAdditionToOtherStuff() {
        Allergies allergies = new Allergies(5);

        assertEquals(true, allergies.isAllergicTo(Allergen.EGGS));
    }

    @Test
    public void noAllergies() {
        Allergies allergies = new Allergies(0);

        assertEquals(0, allergies.getList().size());
    }

    @Test
    public void isAllergicToJustEggs() {
        Allergies allergies = new Allergies(1);
        List<Allergen> expectedAllergens = Arrays.asList(new Allergen[]{Allergen.EGGS});

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Test
    public void isAllergicToJustPeanuts() {
        Allergies allergies = new Allergies(2);
        List<Allergen> expectedAllergens = Arrays.asList(new Allergen[]{Allergen.PEANUTS});

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Test
    public void isAllergicToJustStrawberries() {
        Allergies allergies = new Allergies(8);
        List<Allergen> expectedAllergens = Arrays.asList(new Allergen[]{Allergen.STRAWBERRIES});

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Test
    public void isAllergicToEggsAndPeanuts() {
        Allergies allergies = new Allergies(3);
        List<Allergen> expectedAllergens = Arrays.asList(new Allergen[]{
                Allergen.EGGS,
                Allergen.PEANUTS
        });

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Test
    public void isAllergicToEggsAndShellfish() {
        Allergies allergies = new Allergies(5);
        List<Allergen> expectedAllergens = Arrays.asList(new Allergen[]{
                Allergen.EGGS,
                Allergen.SHELLFISH
        });

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Test
    public void isAllergicToLotsOfStuff() {
        Allergies allergies = new Allergies(248);
        List<Allergen> expectedAllergens = Arrays.asList(new Allergen[]{
                Allergen.STRAWBERRIES,
                Allergen.TOMATOES,
                Allergen.CHOCOLATE,
                Allergen.POLLEN,
                Allergen.CATS
        });

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Test
    public void isAllergicToEverything() {
        Allergies allergies = new Allergies(255);
        List<Allergen> expectedAllergens = Arrays.asList(new Allergen[]{
                Allergen.EGGS,
                Allergen.PEANUTS,
                Allergen.SHELLFISH,
                Allergen.STRAWBERRIES,
                Allergen.TOMATOES,
                Allergen.CHOCOLATE,
                Allergen.POLLEN,
                Allergen.CATS
        });

        assertEquals(expectedAllergens, allergies.getList());
    }

    @Test
    public void ignoreNonAllergenScoreParts() {
        Allergies allergies = new Allergies(509);
        List<Allergen> expectedAllergens = Arrays.asList(new Allergen[]{
                Allergen.EGGS,
                Allergen.SHELLFISH,
                Allergen.STRAWBERRIES,
                Allergen.TOMATOES,
                Allergen.CHOCOLATE,
                Allergen.POLLEN,
                Allergen.CATS
        });

        assertEquals(expectedAllergens, allergies.getList());
    }
}
