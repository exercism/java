import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntergalacticTransmissionTest {

    @Test
    public void calculateTransmitSequencesEmptyMessage() {
        List<Integer> input = List.of();
        List<Integer> expected = List.of();
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequences0x00IsTransmittedAs0x0000() {
        List<Integer> input = List.of(0x00);
        List<Integer> expected = List.of(0x00, 0x00);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequences0x02IsTransmittedAs0x0300() {
        List<Integer> input = List.of(0x02);
        List<Integer> expected = List.of(0x03, 0x00);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequences0x06IsTransmittedAs0x0600() {
        List<Integer> input = List.of(0x06);
        List<Integer> expected = List.of(0x06, 0x00);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequences0x05IsTransmittedAs0x0581() {
        List<Integer> input = List.of(0x05);
        List<Integer> expected = List.of(0x05, 0x81);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequences0x29IsTransmittedAs0x2881() {
        List<Integer> input = List.of(0x29);
        List<Integer> expected = List.of(0x28, 0x81);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequences0xc001c0deIsTransmittedAs0xc000711be1() {
        List<Integer> input = List.of(0xc0, 0x01, 0xc0, 0xde);
        List<Integer> expected = List.of(0xc0, 0x00, 0x71, 0x1b, 0xe1);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequencesSixByteMessage() {
        List<Integer> input = List.of(0x47, 0x72, 0x65, 0x61, 0x74, 0x21);
        List<Integer> expected = List.of(0x47, 0xb8, 0x99, 0xac, 0x17, 0xa0, 0x84);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequencesSevenByteMessage() {
        List<Integer> input = List.of(0x47, 0x72, 0x65, 0x61, 0x74, 0x31, 0x21);
        List<Integer> expected = List.of(0x47, 0xb8, 0x99, 0xac, 0x17, 0xa0, 0xc5, 0x42);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequencesEightByteMessage() {
        List<Integer> input = List.of(0xc0, 0x01, 0x13, 0x37, 0xc0, 0xde, 0x21, 0x21);
        List<Integer> expected = List.of(0xc0, 0x00, 0x44, 0x66, 0x7d, 0x06, 0x78, 0x42, 0x21, 0x81);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void calculateTransmitSequencesTwentyByteMessage() {
        List<Integer> input = List.of(
                0x45, 0x78, 0x65, 0x72, 0x63, 0x69, 0x73, 0x6d, 0x20, 0x69,
                0x73, 0x20, 0x61, 0x77, 0x65, 0x73, 0x6f, 0x6d, 0x65, 0x21);
        List<Integer> expected = List.of(
                0x44, 0xbd, 0x18, 0xaf, 0x27, 0x1b, 0xa5, 0xe7, 0x6c, 0x90,
                0x1b, 0x2e, 0x33, 0x03, 0x84, 0xee, 0x65, 0xb8, 0xdb, 0xed,
                0xd7, 0x28, 0x84);
        assertThat(IntergalacticTransmission.getTransmitSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeReceivedMessagesEmptyMessage() {
        List<Integer> input = List.of();
        List<Integer> expected = List.of();
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeReceivedMessagesZeroMessage() {
        List<Integer> input = List.of(0x00, 0x00);
        List<Integer> expected = List.of(0x00);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeReceivedMessages0x0300IsDecodedTo0x02() {
        List<Integer> input = List.of(0x03, 0x00);
        List<Integer> expected = List.of(0x02);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeReceivedMessages0x0581IsDecodedTo0x05() {
        List<Integer> input = List.of(0x05, 0x81);
        List<Integer> expected = List.of(0x05);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeReceivedMessages0x2881IsDecodedTo0x29() {
        List<Integer> input = List.of(0x28, 0x81);
        List<Integer> expected = List.of(0x29);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeFirstByteWrongParity() {
        List<Integer> input = List.of(0x07, 0x00);
        assertThrows(IllegalArgumentException.class, ()
                -> IntergalacticTransmission.decodeSequence(input));
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeSecondByteWrongParity() {
        List<Integer> input = List.of(0x03, 0x68);
        assertThrows(IllegalArgumentException.class, ()
                -> IntergalacticTransmission.decodeSequence(input));
    }

    @Disabled("Remove to run test")
    @Test
    public void decode0xcf4b00To0xce94() {
        List<Integer> input = List.of(0xcf, 0x4b, 0x00);
        List<Integer> expected = List.of(0xce, 0x94);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decode0xe2566500To0xe2ad90() {
        List<Integer> input = List.of(0xe2, 0x56, 0x65, 0x00);
        List<Integer> expected = List.of(0xe2, 0xad, 0x90);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeSixByteMessage() {
        List<Integer> input = List.of(0x47, 0xb8, 0x99, 0xac, 0x17, 0xa0, 0x84);
        List<Integer> expected = List.of(0x47, 0x72, 0x65, 0x61, 0x74, 0x21);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeSevenByteMessage() {
        List<Integer> input = List.of(0x47, 0xb8, 0x99, 0xac, 0x17, 0xa0, 0xc5, 0x42);
        List<Integer> expected = List.of(0x47, 0x72, 0x65, 0x61, 0x74, 0x31, 0x21);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeLastByteWrongParity() {
        List<Integer> input = List.of(0x47, 0xb8, 0x99, 0xac, 0x17, 0xa0, 0xc5, 0x43);
        assertThrows(IllegalArgumentException.class, ()
                -> IntergalacticTransmission.decodeSequence(input));
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeEightByteMessage() {
        List<Integer> input = List.of(0xc0, 0x00, 0x44, 0x66, 0x7d, 0x06, 0x78, 0x42, 0x21, 0x81);
        List<Integer> expected = List.of(0xc0, 0x01, 0x13, 0x37, 0xc0, 0xde, 0x21, 0x21);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeTwentyByteMessage() {
        List<Integer> input = List.of(
                0x44, 0xbd, 0x18, 0xaf, 0x27, 0x1b, 0xa5, 0xe7, 0x6c, 0x90, 0x1b,
                0x2e, 0x33, 0x03, 0x84, 0xee, 0x65, 0xb8, 0xdb, 0xed, 0xd7, 0x28, 0x84);
        List<Integer> expected = List.of(
                0x45, 0x78, 0x65, 0x72, 0x63, 0x69, 0x73, 0x6d, 0x20, 0x69,
                0x73, 0x20, 0x61, 0x77, 0x65, 0x73, 0x6f, 0x6d, 0x65, 0x21);
        assertThat(IntergalacticTransmission.decodeSequence(input))
                .isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void decodeWrongParityOn16thByte() {
        List<Integer> input = List.of(
                0x44, 0xbd, 0x18, 0xaf, 0x27, 0x1b, 0xa5, 0xe7, 0x6c, 0x90,
                0x1b, 0x2e, 0x33, 0x03, 0x84, 0xef, 0x65, 0xb8, 0xdb, 0xed, 0xd7, 0x28, 0x84);
        assertThrows(IllegalArgumentException.class, ()
                -> IntergalacticTransmission.decodeSequence(input));
    }
}
