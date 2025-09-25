import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class OpticalCharacterReaderTest {

    @Test
    @DisplayName("Recognizes 0")
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
    @DisplayName("Recognizes 1")
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
    @DisplayName("Unreadable but correctly sized inputs return ?")
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
    @DisplayName("Input with a number of lines that is not a multiple of four raises an error")
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
    @DisplayName("Input with a number of columns that is not a multiple of three raises an error")
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
    @DisplayName("Recognizes 110101100")
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
    @DisplayName("Garbled numbers in a string are replaced with ?")
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
    @DisplayName("Recognizes 2")
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
    @DisplayName("Recognizes 3")
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
    @DisplayName("Recognizes 4")
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
    @DisplayName("Recognizes 5")
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
    @DisplayName("Recognizes 6")
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
    @DisplayName("Recognizes 7")
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
    @DisplayName("Recognizes 8")
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
    @DisplayName("Recognizes 9")
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
    @DisplayName("Recognizes string of decimal numbers")
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
    @DisplayName("Numbers separated by empty lines are recognized. Lines are joined by commas.")
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
