import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

public class CircularBufferTest {

    @Test
    public void readingFromEmptyBufferShouldThrowException() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        BufferIOException expected =
            assertThrows(BufferIOException.class, buffer::read);

        assertThat(expected)
            .hasMessage("Tried to read from empty buffer");
    }

    @Ignore("Remove to run test")
    @Test
    public void canReadItemJustWritten() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void canReadItemOnlyOnce() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);

        BufferIOException expected =
            assertThrows(BufferIOException.class, buffer::read);

        assertThat(expected)
            .hasMessage("Tried to read from empty buffer");
    }

    @Ignore("Remove to run test")
    @Test
    public void readsItemsInOrderWritten() throws BufferIOException { 
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(1);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Ignore("Remove to run test")
    @Test
    public void fullBufferCantBeWrittenTo() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);

        BufferIOException expected =
            assertThrows(BufferIOException.class, () -> buffer.write(2));

        assertThat(expected)
            .hasMessage("Tried to write to full buffer");
    }

    @Ignore("Remove to run test")
    @Test
    public void readFreesUpSpaceForWrite() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Ignore("Remove to run test")
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

    @Ignore("Remove to run test")
    @Test
    public void cantReadClearedItems() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        buffer.clear();

        BufferIOException expected =
            assertThrows(BufferIOException.class, buffer::read);

        assertThat(expected)
            .hasMessage("Tried to read from empty buffer");
    }

    @Ignore("Remove to run test")
    @Test
    public void clearFreesUpCapacity() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        buffer.clear();
        buffer.write(2);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Ignore("Remove to run test")
    @Test
    public void clearDoesNothingOnEmptyBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.clear();
        buffer.write(1);
        assertThat(buffer.read()).isEqualTo(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void overwriteActsLikeWriteOnNonFullBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.overwrite(2);
        assertThat(buffer.read()).isEqualTo(1);
        assertThat(buffer.read()).isEqualTo(2);
    }

    @Ignore("Remove to run test")
    @Test
    public void overwriteRemovesOldestElementOnFullBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        buffer.overwrite(3);
        assertThat(buffer.read()).isEqualTo(2);
        assertThat(buffer.read()).isEqualTo(3);
    }

    @Ignore("Remove to run test")
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

    @Ignore("Remove to run test")
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

        BufferIOException expected =
            assertThrows(BufferIOException.class, buffer::read);

        assertThat(expected)
            .hasMessage("Tried to read from empty buffer");
    }
}

