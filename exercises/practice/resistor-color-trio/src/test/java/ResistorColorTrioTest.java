import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
public class ResistorColorTrioTest{

    @Test
    public void testColorsOrangeOrangeBlack{
        ResistorColorTrio.Color[] resistorOOB = {ResistorColorTrio.Color.ORANGE,
                ResistorColorTrio.Color.ORANGE,
                ResistorColorTrio.Color.BLACK};
        long valExpected = 33L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorOOB);
        assertEquals(valExpected,valActual);
    }
    @Ignore("Remove to run test")
    @Test
    public void testColorsBlueGreyBrown{
        ResistorColorTrio.Color[] resistorBGB = {ResistorColorTrio.Color.BLUE,
                ResistorColorTrio.Color.GREY,
                ResistorColorTrio.Color.BROWN};
        long valExpected = 680L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorBGB);
        assertEquals(valExpected,valActual);
    }
    @Ignore("Remove to run test")
    @Test
    public void testColorsRedBlackRed{
        ResistorColorTrio.Color[] resistorRBR = {ResistorColorTrio.Color.RED,
        ResistorColorTrio.Color.BLACK,
        ResistorColorTrio.Color.RED};
        long valExpected = 2000L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorRBR);
        assertEquals(valExpected,valActual);
    }
    @Ignore("Remove to run test")
    @Test
    public void testColorsGreenBrownOrange{
        ResistorColorTrio.Color[] resistorGBO = {ResistorColorTrio.Color.GREEN,
                ResistorColorTrio.Color.BROWN,
                ResistorColorTrio.Color.ORANGE};
        long valExpected = 51000L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorGBO);
        assertEquals(valExpected,valActual);
    }
    @Ignore("Remove to run test")
    @Test
    public void testColorsYellowVioletYellow{
        ResistorColorTrio.Color[] resistorYVY = {ResistorColorTrio.Color.YELLOW,
                ResistorColorTrio.Color.VIOLET,
                ResistorColorTrio.Color.YELLOW};
        long valExpected = 51000L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorYVY);
        assertEquals(valExpected,valActual);
    }
    @Ignore("Remove to run test")
    @Test
    public void testColorsBlueVioletBlue{
        ResistorColorTrio.Color[] resistorBVB = {ResistorColorTrio.Color.BLUE,
                ResistorColorTrio.Color.VIOLET,
                ResistorColorTrio.Color.BLUE};
        long valExpected = 67000000L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorBVB);
        assertEquals(valExpected,valActual);
    }
    @Ignore("Remove to run test")
    @Test
    public void testColorsMinimumValueBlackBlackBlack{
        ResistorColorTrio.Color[] resistorBBB = {ResistorColorTrio.Color.BLACK,
                ResistorColorTrio.Color.BLACK,
                ResistorColorTrio.Color.BLACK};
        long valExpected = 0L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorBBB);
        assertEquals(valExpected,valActual);
    }
    @Ignore("Remove to run test")
    @Test
    public void testColorsMaximumValueWithWhiteWhiteWhite{
        ResistorColorTrio.Color[] resistorWWW = {ResistorColorTrio.Color.WHITE,
                ResistorColorTrio.Color.WHITE,
                ResistorColorTrio.Color.WHITE};
        long valExpected = 99_000_000_000L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorWWW);
        assertEquals(valExpected,valActual);
    }
    @Ignore("Remove to run test")
    @Test
    public void testColorsBlackGreyBlack{
        ResistorColorTrio.Color[] resistorBGB = {ResistorColorTrio.Color.BLACK,
                ResistorColorTrio.Color.GREY,
                ResistorColorTrio.Color.BLACK};
        long valExpected = 8L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorBGB);
        assertEquals(valExpected,valActual);
    }
    @Ignore("Remove to run test")
    @Test
    public void testExtraColorsOfWhichTheLastOneShouldBeIgnored{
        ResistorColorTrio.Color[] resistorBGYO = {ResistorColorTrio.Color.BLUE,
                ResistorColorTrio.Color.GREEN,
                ResistorColorTrio.Color.YELLOW,
                ResistorColorTrio.Color.ORANGE};
        long valExpected = 650_000L;
        long valActual = ResistorColorTrio.getValueOfResistor(resistorBGYO);
        assertEquals(valExpected,valActual);
    }
}