import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class OpticalCharacterReaderTest {

    @Test
    public void testReaderRecognizesSingle0() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "| |",
                "|_|",
                "   "
        ));

        assertEquals("0", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSingle1() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "   ",
                "  |",
                "  |",
                "   "
        ));

        assertEquals("1", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderReturnsQuestionMarkForUnreadableButCorrectlySizedInput() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "   ",
                "  _",
                "  |",
                "   "
        ));

        assertEquals("?", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderThrowsExceptionWhenNumberOfInputLinesIsNotAMultipleOf4() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new OpticalCharacterReader()
                    .parse(
                        Arrays.asList(
                            " _ ",
                            "| |",
                            "   ")));

        assertThat(expected)
            .hasMessage(
                "Number of input rows must be a positive multiple of 4");
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderThrowsExceptionWhenNumberOfInputColumnsIsNotAMultipleOf3() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> new OpticalCharacterReader()
                    .parse(
                        Arrays.asList(
                            "    ",
                            "   |",
                            "   |",
                            "    ")));

        assertThat(expected)
            .hasMessage(
                "Number of input columns must be a positive multiple of 3");
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesBinarySequence110101100() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "       _     _        _  _ ",
                "  |  || |  || |  |  || || |",
                "  |  ||_|  ||_|  |  ||_||_|",
                "                           "
        ));

        assertEquals("110101100", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderReplacesUnreadableDigitsWithQuestionMarksWithinSequence() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "       _     _           _ ",
                "  |  || |  || |     || || |",
                "  |  | _|  ||_|  |  ||_||_|",
                "                           "
        ));

        assertEquals("11?10?1?0", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSingle2() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                " _|",
                "|_ ",
                "   "
        ));

        assertEquals("2", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSingle3() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                " _|",
                " _|",
                "   "
        ));

        assertEquals("3", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSingle4() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "   ",
                "|_|",
                "  |",
                "   "
        ));

        assertEquals("4", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSingle5() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "|_ ",
                " _|",
                "   "
        ));

        assertEquals("5", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSingle6() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "|_ ",
                "|_|",
                "   "
        ));

        assertEquals("6", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSingle7() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "  |",
                "  |",
                "   "
        ));

        assertEquals("7", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSingle8() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "|_|",
                "|_|",
                "   "
        ));

        assertEquals("8", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSingle9() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "|_|",
                " _|",
                "   "
        ));

        assertEquals("9", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesSequence1234567890() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "    _  _     _  _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|| |",
                "  ||_  _|  | _||_|  ||_| _||_|",
                "                              "
        ));

        assertEquals("1234567890", parsedInput);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReaderRecognizesAndCorrectlyFormatsMultiRowInput() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "    _  _ ",
                "  | _| _|",
                "  ||_  _|",
                "         ",
                "    _  _ ",
                "|_||_ |_ ",
                "  | _||_|",
                "         ",
                " _  _  _ ",
                "  ||_||_|",
                "  ||_| _|",
                "         "
        ));

        assertEquals("123,456,789", parsedInput);
    }

}
