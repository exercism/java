import java.io.*;

class FileOperations implements Closeable {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    private long bytesRead;
    private long bytesWritten;
    private long readOperationCount;
    private long writeOperationCount;
    private String mode;

    public FileOperations(File file, boolean readOperation){

    }

    public int read() throws IOException {

        if (this.mode.equals("r")) {

            int byteData = fileInputStream.read();
            if (byteData != -1) {
                bytesRead += byteData;
                readOperationCount += 1;
            }
            return byteData;
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }
    }

    public int read(byte[] b) throws IOException {

        return -1;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return -1;
    }

    public byte[] readAllBytes() throws IOException {
        return new byte[0];
    }

    public byte[] readNBytes(int len) throws IOException {
        return new byte[0];
    }

    @Override
    public void close() throws IOException {

    }


    //Getter Setter

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}


