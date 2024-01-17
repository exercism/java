import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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

        assertThat(parsedInput).isEqualTo("0");

    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSingle1() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "   ",
                "  |",
                "  |",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("1");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderReturnsQuestionMarkForUnreadableButCorrectlySizedInput() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "   ",
                "  _",
                "  |",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("?");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderThrowsExceptionWhenNumberOfInputLinesIsNotAMultipleOf4() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new OpticalCharacterReader()
                        .parse(
                                Arrays.asList(
                                        " _ ",
                                        "| |",
                                        "   ")))
                .withMessage("Number of input rows must be a positive multiple of 4");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderThrowsExceptionWhenNumberOfInputColumnsIsNotAMultipleOf3() {


        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new OpticalCharacterReader()
                        .parse(
                                Arrays.asList(
                                        "    ",
                                        "   |",
                                        "   |",
                                        "    ")))
                .withMessage("Number of input columns must be a positive multiple of 3");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesBinarySequence110101100() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "       _     _        _  _ ",
                "  |  || |  || |  |  || || |",
                "  |  ||_|  ||_|  |  ||_||_|",
                "                           "
        ));

        assertThat(parsedInput).isEqualTo("110101100");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderReplacesUnreadableDigitsWithQuestionMarksWithinSequence() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "       _     _           _ ",
                "  |  || |  || |     || || |",
                "  |  | _|  ||_|  |  ||_||_|",
                "                           "
        ));


        assertThat(parsedInput).isEqualTo("11?10?1?0");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSingle2() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                " _|",
                "|_ ",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("2");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSingle3() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                " _|",
                " _|",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("3");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSingle4() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "   ",
                "|_|",
                "  |",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("4");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSingle5() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "|_ ",
                " _|",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("5");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSingle6() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "|_ ",
                "|_|",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("6");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSingle7() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "  |",
                "  |",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("7");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSingle8() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "|_|",
                "|_|",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("8");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSingle9() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                " _ ",
                "|_|",
                " _|",
                "   "
        ));

        assertThat(parsedInput).isEqualTo("9");
    }

    @Disabled("Remove to run test")
    @Test
    public void testReaderRecognizesSequence1234567890() {
        String parsedInput = new OpticalCharacterReader().parse(Arrays.asList(
                "    _  _     _  _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|| |",
                "  ||_  _|  | _||_|  ||_| _||_|",
                "                              "
        ));

        assertThat(parsedInput).isEqualTo("1234567890");
    }

    @Disabled("Remove to run test")
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

        assertThat(parsedInput).isEqualTo("123,456,789");
    }

}
