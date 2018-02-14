import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class RaindropConverterTest {

    private RaindropConverter raindropConverter = new RaindropConverter();

    @Test
    public void soundFor1Is1() {
        assertEquals("1", raindropConverter.convert(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor3IsPling() {
        assertEquals("Pling", raindropConverter.convert(3));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor5IsPlang() {
        assertEquals("Plang", raindropConverter.convert(5));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor7IsPlong() {
        assertEquals("Plong", raindropConverter.convert(7));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundForNumber6WithOnlyDistinctFactorOf3IsPling() {
        assertEquals("Pling", raindropConverter.convert(6));
    }

    @Ignore("Remove to run test")
    @Test
    public void noSoundFor2Cubed() {
        assertEquals("8", raindropConverter.convert(8));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundForNumber9WithOnlyDistinctFactorOf3IsPling() {
        assertEquals("Pling", raindropConverter.convert(9));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundForNumber10WithOnlyDistinctFactorOf5IsPlang() {
        assertEquals("Plang", raindropConverter.convert(10));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundForNumber14WithOnlyDistinctFactorOf7IsPling() {
        assertEquals("Plong", raindropConverter.convert(14));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor15IsPlingPlang() {
        assertEquals("PlingPlang", raindropConverter.convert(15));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor21IsPlingPlong() {
        assertEquals("PlingPlong", raindropConverter.convert(21));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor25IsPlang() {
        assertEquals("Plang", raindropConverter.convert(25));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor27IsPling() {
        assertEquals("Pling", raindropConverter.convert(27));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor35IsPlangPlong() {
        assertEquals("PlangPlong", raindropConverter.convert(35));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundForNumber49WithOnlyDistinctFactorOf7IsPling() {
        assertEquals("Plong", raindropConverter.convert(49));
    }

    @Ignore("Remove to run test")
    @Test
    public void noSoundFor52() {
        assertEquals("52", raindropConverter.convert(52));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor105IsPlingPlangPlong() {
        assertEquals("PlingPlangPlong", raindropConverter.convert(105));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor3125IsPlang() {
        assertEquals("Plang", raindropConverter.convert(3125));
    }

}
