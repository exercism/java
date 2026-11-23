import java.io.*;

public class Paasio implements Closeable {

    private long bytesRead;
    private long readOperationCount;
    private long bytesWritten;
    private long writeOperationCount;

    private final InputStream inputStream;
    private final OutputStream outputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public Paasio(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public int read() throws IOException {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    public int read(byte[] b) throws IOException {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");

    }

    public int read(byte[] b, int off, int len) throws IOException {

        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");

    }

    public byte[] readAllBytes() throws IOException {

        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");

    }

    public byte[] readNBytes(int len) throws IOException {

        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    public void write(int b) throws IOException {

        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");

    }

    public void write(byte[] b) throws IOException {

        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");

    }

    public void write(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    public long getBytesRead() {
        return bytesRead;
    }

    public long getReadOperationCount() {
        return readOperationCount;
    }

    public long getBytesWritten() {
        return bytesWritten;
    }

    public long getWriteOperationCount() {
        return writeOperationCount;
    }

    @Override
    public void close() throws IOException {
        if (this.inputStream != null) {
            this.inputStream.close();
        }
        if (this.outputStream != null) {
            this.outputStream.close();
        }
    }

}




