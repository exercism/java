import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CircularBufferTest {

    @Test
    @DisplayName("reading empty buffer should fail")
    public void readingFromEmptyBufferShouldThrowException() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        assertThatExceptionOfType(BufferIOException.class)
                .isThrownBy(buffer::read)
                .withMessage("Tried to read from empty buffer");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can read an item just written")
    public void canReadItemJustWritten() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("each item may only be read once")
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
    @DisplayName("items are read in the order they are written")
    public void readsItemsInOrderWritten() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(1);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("full buffer can't be written to")
    public void fullBufferCantBeWrittenTo() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);

        assertThatExceptionOfType(BufferIOException.class)
                .isThrownBy(() -> buffer.write(2))
                .withMessage("Tried to write to full buffer");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a read frees up capacity for another write")
    public void readFreesUpSpaceForWrite() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("read position is maintained even across multiple writes")
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
    @DisplayName("items cleared out of buffer can't be read")
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
    @DisplayName("clear frees up capacity for another write")
    public void clearFreesUpCapacity() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        buffer.clear();
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("clear does nothing on empty buffer")
    public void clearDoesNothingOnEmptyBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.clear();
        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("overwrite acts like write on non-full buffer")
    public void overwriteActsLikeWriteOnNonFullBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.overwrite(2);
        assertThat(buffer.read()).isEqualTo(1);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("overwrite replaces the oldest item on full buffer")
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
    @DisplayName("overwrite replaces the oldest item remaining in buffer following a read")
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
    @DisplayName("initial clear does not affect wrapping around")
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
