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
    public void soundFor3OrNumberWithOnlyDistinctFactorOf3() {
        assertEquals("Pling", raindropConverter.convert(3));
        assertEquals("Pling", raindropConverter.convert(6));
        assertEquals("Pling", raindropConverter.convert(9));
        assertEquals("Pling", raindropConverter.convert(27));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor5OrNumberWithOnlyDistinctFactorOf5IsPlang() {
        assertEquals("Plang", raindropConverter.convert(5));
        assertEquals("Plang", raindropConverter.convert(10));
        assertEquals("Plang", raindropConverter.convert(25));
        assertEquals("Plang", raindropConverter.convert(3125));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor7OrNumberWithOnlyDistinctFactorOf7IsPlong() {
        assertEquals("Plong", raindropConverter.convert(7));
        assertEquals("Plong", raindropConverter.convert(14));
        assertEquals("Plong", raindropConverter.convert(49));
    }

    @Ignore("Remove to run test")
    @Test
    public void noSoundFor2Cubed() {
        assertEquals("8", raindropConverter.convert(8));
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
    public void soundFor35IsPlangPong() {
        assertEquals("PlangPong", raindropConverter.convert(35));
    }

    @Ignore("Remove to run test")
    @Test
    public void noSoundFor52() {
        assertEquals("52", raindropConverter.convert(52));
    }

    @Ignore("Remove to run test")
    @Test
    public void soundFor105IsPlingPlangPlong() {
        assertEquals("PlingPlangPong", raindropConverter.convert(105));
    }

}
