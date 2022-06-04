import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class RaindropConverterTest {

    private RaindropConverter raindropConverter = new RaindropConverter();

    @Test
    public void soundFor1Is1() {
        assertEquals("1", raindropConverter.convert(1));
    }


    @Test
    public void soundFor3IsPling() {
        assertEquals("Pling", raindropConverter.convert(3));
    }


    @Test
    public void soundFor5IsPlang() {
        assertEquals("Plang", raindropConverter.convert(5));
    }


    @Test
    public void soundFor7IsPlong() {
        assertEquals("Plong", raindropConverter.convert(7));
    }


    @Test
    public void soundFor6IsPlingAsItHasFactor3() {
        assertEquals("Pling", raindropConverter.convert(6));
    }


    @Test
    public void noSoundFor2Cubed() {
        assertEquals("8", raindropConverter.convert(8));
    }


    @Test
    public void soundFor9IsPlingAsItHasFactor3() {
        assertEquals("Pling", raindropConverter.convert(9));
    }


    @Test
    public void soundFor10IsPlangAsItHasFactor5() {
        assertEquals("Plang", raindropConverter.convert(10));
    }


    @Test
    public void soundFor14IsPlongAsItHasFactor7() {
        assertEquals("Plong", raindropConverter.convert(14));
    }


    @Test
    public void soundFor15IsPlingPlangAsItHasFactors3And5() {
        assertEquals("PlingPlang", raindropConverter.convert(15));
    }


    @Test
    public void soundFor21IsPlingPlongAsItHasFactors3And7() {
        assertEquals("PlingPlong", raindropConverter.convert(21));
    }


    @Test
    public void soundFor25IsPlangAsItHasFactor5() {
        assertEquals("Plang", raindropConverter.convert(25));
    }


    @Test
    public void soundFor27IsPlingAsItHasFactor3() {
        assertEquals("Pling", raindropConverter.convert(27));
    }


    @Test
    public void soundFor35IsPlangPlongAsItHasFactors5And7() {
        assertEquals("PlangPlong", raindropConverter.convert(35));
    }


    @Test
    public void soundFor49IsPlongAsItHasFactor7() {
        assertEquals("Plong", raindropConverter.convert(49));
    }


    @Test
    public void noSoundFor52() {
        assertEquals("52", raindropConverter.convert(52));
    }


    @Test
    public void soundFor105IsPlingPlangPlongAsItHasFactors3And5And7() {
        assertEquals("PlingPlangPlong", raindropConverter.convert(105));
    }


    @Test
    public void soundFor3125IsPlangAsItHasFactor5() {
        assertEquals("Plang", raindropConverter.convert(3125));
    }

}
