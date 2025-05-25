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
