import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CircularBufferTest {

    @Test
    public void readingFromEmptyBufferShouldThrowException() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        assertThatExceptionOfType(BufferIOException.class)
                .isThrownBy(buffer::read)
                .withMessage("Tried to read from empty buffer");
    }

    @Disabled("Remove to run test")
    @Test
    public void canReadItemJustWritten() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    public void canReadItemOnlyOnce() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);

        assertThatExceptionOfType(BufferIOException.class)
                .isThrownBy(buffer::read)
                .withMessage("Tried to read from empty buffer");
    }

    @Disabled("Remove to run test")
    @Test
    public void readsItemsInOrderWritten() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(1);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    public void fullBufferCantBeWrittenTo() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);

        assertThatExceptionOfType(BufferIOException.class)
                .isThrownBy(() -> buffer.write(2))
                .withMessage("Tried to write to full buffer");
    }

    @Disabled("Remove to run test")
    @Test
    public void readFreesUpSpaceForWrite() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    public void maintainsReadPositionAcrossWrites() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        buffer.write(1);
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(1);
        buffer.write(3);
        assertThat(buffer.read()).isEqualTo(2);
        assertThat(buffer.read()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    public void cantReadClearedItems() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        buffer.clear();

        assertThatExceptionOfType(BufferIOException.class)
                .isThrownBy(buffer::read)
                .withMessage("Tried to read from empty buffer");
    }

    @Disabled("Remove to run test")
    @Test
    public void clearFreesUpCapacity() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        buffer.clear();
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    public void clearDoesNothingOnEmptyBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.clear();
        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    public void overwriteActsLikeWriteOnNonFullBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.overwrite(2);
        assertThat(buffer.read()).isEqualTo(1);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    public void overwriteRemovesOldestElementOnFullBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        buffer.overwrite(3);
        assertThat(buffer.read()).isEqualTo(2);
        assertThat(buffer.read()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    public void overwriteDoesntRemoveAnAlreadyReadElement() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        assertThat(buffer.read()).isEqualTo(1);
        buffer.write(4);
        buffer.overwrite(5);
        assertThat(buffer.read()).isEqualTo(3);
        assertThat(buffer.read()).isEqualTo(4);
        assertThat(buffer.read()).isEqualTo(5);
    }

    @Disabled("Remove to run test")
    @Test
    public void initialClearDoesNotAffectWrappingAround() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.clear();
        buffer.write(1);
        buffer.write(2);
        buffer.overwrite(3);
        buffer.overwrite(4);
        assertThat(buffer.read()).isEqualTo(3);
        assertThat(buffer.read()).isEqualTo(4);

        assertThatExceptionOfType(BufferIOException.class)
                .isThrownBy(buffer::read)
                .withMessage("Tried to read from empty buffer");
    }
}
