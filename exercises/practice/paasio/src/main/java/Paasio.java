import java.io.*;

public class Paasio implements Closeable {

    private long bytesRead;
    private long readOperationCount;
    private long bytesWritten;
    private long writeOperationCount;

    private final InputStream inputStream;
    private final OutputStream outputStream;

    public Paasio(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public int read() throws IOException {
        int byteData = inputStream.read();
        if (byteData != -1) {
            bytesRead += 1;
            readOperationCount++;
        }
        return byteData;
    }

    public int read(byte[] b) throws IOException {

        int totalBytesRead = inputStream.read(b);
        if (totalBytesRead != -1) {
            bytesRead += totalBytesRead;
            readOperationCount++;
        }
        return totalBytesRead;

    }

    public int read(byte[] b, int off, int len) throws IOException {

        int bytesReadIntoBuffer = inputStream.read(b, off, len);

        if (bytesReadIntoBuffer != -1) {
            bytesRead += bytesReadIntoBuffer;
            readOperationCount++;
        }
        return bytesReadIntoBuffer;


    }

    public byte[] readAllBytes() throws IOException {

        byte[] allData = this.inputStream.readAllBytes();

        if (allData.length > 0) {
            readOperationCount++;
            bytesRead += allData.length;
        }
        return allData;

    }

    public byte[] readNBytes(int len) throws IOException {

        byte[] allData = this.inputStream.readNBytes(len);
        if (allData.length > 0) {
            readOperationCount++;
            bytesRead += allData.length;
        }
        return allData;
    }

    public void write(int b) throws IOException {

        try {
            this.outputStream.write(b);
            writeOperationCount++;
            bytesWritten++;

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public void write(byte[] b) throws IOException {
        try {

            this.outputStream.write(b);
            writeOperationCount++;
            bytesWritten += b.length;


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void write(byte[] b, int off, int len) throws IOException {
        try {
            this.outputStream.write(b, off, len);
            writeOperationCount++;
            bytesWritten += len;

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
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




