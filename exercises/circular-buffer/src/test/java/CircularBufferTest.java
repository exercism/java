import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CircularBufferTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void readingFromEmptyBufferShouldThrowException() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to read from empty buffer");
        buffer.read();
    }

    @Ignore("Remove to run test")
    @Test
    public void canReadItemJustWritten() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertEquals((int) buffer.read(), 1);
    }

    @Ignore("Remove to run test")
    @Test
    public void canReadItemOnlyOnce() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertEquals((int) buffer.read(), 1);

        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to read from empty buffer");
        buffer.read();
    }

    @Ignore("Remove to run test")
    @Test
    public void readsItemsInOrderWritten() throws BufferIOException { 
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        assertEquals((int) buffer.read(), 1);
        assertEquals((int) buffer.read(), 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void fullBufferCantBeWrittenTo() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to write to full buffer");
        buffer.write(2);
    }

    @Ignore("Remove to run test")
    @Test
    public void readFreesUpSpaceForWrite() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        assertEquals((int) buffer.read(), 1);
        buffer.write(2);
        assertEquals((int) buffer.read(), 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void maintainsReadPositionAcrossWrites() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        buffer.write(1);
        buffer.write(2);
        assertEquals((int) buffer.read(), 1);
        buffer.write(3);
        assertEquals((int) buffer.read(), 2);
        assertEquals((int) buffer.read(), 3);
    }

    @Ignore("Remove to run test")
    @Test
    public void cantReadClearedItems() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        buffer.clear();
        expectedException.expect(BufferIOException.class);
        expectedException.expectMessage("Tried to read from empty buffer");
        buffer.read();
    }

    @Ignore("Remove to run test")
    @Test
    public void clearFreesUpCapacity() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.write(1);
        buffer.clear();
        buffer.write(2);
        assertEquals((int) buffer.read(), 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void clearDoesNothingOnEmptyBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(1);

        buffer.clear();
        buffer.write(1);
        assertEquals((int) buffer.read(), 1);
    }

    @Ignore("Remove to run test")
    @Test
    public void overwriteActsLikeWriteOnNonFullBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.overwrite(2);
        assertEquals((int) buffer.read(), 1);
        assertEquals((int) buffer.read(), 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void overwriteRemovesOldestElementOnFullBuffer() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(2);

        buffer.write(1);
        buffer.write(2);
        buffer.overwrite(3);
        assertEquals((int) buffer.read(), 2);
        assertEquals((int) buffer.read(), 3);
    }

    @Ignore("Remove to run test")
    @Test
    public void overwriteDoesntRemoveAnAlreadyReadElement() throws BufferIOException {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        assertEquals((int) buffer.read(), 1);
        buffer.write(4);
        buffer.overwrite(5);
        assertEquals((int) buffer.read(), 3);
        assertEquals((int) buffer.read(), 4);
        assertEquals((int) buffer.read(), 5);
    }
}

