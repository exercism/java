import java.io.*;

class FileOperations implements Closeable {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    private long bytesRead;
    private long bytesWritten;
    private long readOperationCount;
    private long writeOperationCount;
    private String mode;


    public FileOperations(File file, boolean readOperation) throws FileNotFoundException {

        if (readOperation) {
            fileInputStream = new FileInputStream(file);
            this.mode = "r";
        } else {
            fileOutputStream = new FileOutputStream(file);
            this.mode = "w";
        }

    }

    public int read() throws IOException {

        if (this.mode.equals("r")) {

            int byteData = fileInputStream.read();
            if (byteData != -1) {
                bytesRead += 1;
                readOperationCount += 1;
            }
            return byteData;
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }
    }

    public int read(byte[] b) throws IOException {

        if (this.mode.equals("r")) {
            int totalBytesRead = fileInputStream.read(b);
            if (totalBytesRead != -1) {
                bytesRead += totalBytesRead;
                readOperationCount += 1;
            }
            return totalBytesRead;
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }
    }

    public int read(byte[] b, int off, int len) throws IOException {

        if (mode.equals("r")) {
            int bytesRead = fileInputStream.read(b, off, len);

            return bytesRead;
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }

    }

    public byte[] readAllBytes() throws IOException {

        if (mode.equals("r")) {
            byte[] allData = this.fileInputStream.readAllBytes();
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }

        return new byte[0];
    }

    public byte[] readNBytes(int len) throws IOException {
        return new byte[0];
    }


    //Getter Setter
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getBytesWritten() {
        return bytesWritten;
    }

    public void setBytesWritten(long bytesWritten) {
        this.bytesWritten = bytesWritten;
    }

    public long getReadOperationCount() {
        return readOperationCount;
    }

    public void setReadOperationCount(long readOperationCount) {
        this.readOperationCount = readOperationCount;
    }

    public long getWriteOperationCount() {
        return writeOperationCount;
    }

    public void setWriteOperationCount(long writeOperationCount) {
        this.writeOperationCount = writeOperationCount;
    }

    @Override
    public void close() throws IOException {

    }
}
