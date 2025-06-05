import java.io.*;
import java.net.Socket;
import java.util.Objects;

class FileOperations implements Closeable {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    private GenericInputOperation genericInputOperation;
    private GenericWriteOperation genericWriteOperation;
    private final String mode;


    public FileOperations(File file, boolean readOperation) throws FileNotFoundException {

        if(Objects.isNull(file)){
            throw new RuntimeException("File object cannot be null");
        }

        if (readOperation) {
            fileInputStream = new FileInputStream(file);
            genericInputOperation = new GenericInputOperation(fileInputStream);
            this.mode = "r";
        } else {
            fileOutputStream = new FileOutputStream(file);
            genericWriteOperation = new GenericWriteOperation(fileOutputStream);
            this.mode = "w";
        }

    }

    public int read() throws IOException {

        if (this.mode.equals("r")) {
            return genericInputOperation.read();
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }
    }

    public int read(byte[] b) throws IOException {

        if (this.mode.equals("r")) {
            return genericInputOperation.read(b);
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }
    }

    public int read(byte[] b, int off, int len) throws IOException {

        if (mode.equals("r")) {
            return genericInputOperation.read(b, off, len);
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }

    }

    public byte[] readAllBytes() throws IOException {

        if (mode.equals("r")) {
            return this.genericInputOperation.readAllBytes();
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }
    }

    public byte[] readNBytes(int len) throws IOException {

        if (mode.equals("r")) {
            return this.genericInputOperation.readNBytes(len);
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }

    }

    public void write(int b) throws IOException {


        if (mode.equals("w")) {
            this.genericWriteOperation.write(b);
        } else {
            throw new UnsupportedOperationException("Not in write mode.");
        }


    }

    public void write(byte[] b) throws IOException {

        if (mode.equals("w")) {
            this.genericWriteOperation.write(b);
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }

    }

    public void write(byte[] b, int off, int len) throws IOException {

        if (mode.equals("w")) {
            this.genericWriteOperation.write(b, off, len);
        } else {
            throw new UnsupportedOperationException("Not in read mode.");
        }


    }


    //Getter Setter
    public String getMode() {
        return mode;
    }

    public long getBytesRead() {
        return genericInputOperation.getBytesRead();
    }


    public long getBytesWritten() {
        return genericWriteOperation.getBytesWritten();
    }

    public long getReadOperationCount() {
        return genericInputOperation.getReadOperationCount();
    }

    public long getWriteOperationCount() {
        return genericWriteOperation.getWriteOperationCount();
    }

    @Override
    public void close() throws IOException {

        if (this.mode.equals("r")) {
            this.fileInputStream.close();
            this.genericInputOperation.close();
        } else {
            this.fileOutputStream.close();
            this.genericWriteOperation.close();
        }

    }
}

class SocketOperations extends Socket {

    Socket socket;
    private final GenericInputOperation genericInputOperation;
    private final GenericWriteOperation genericWriteOperation;

    SocketOperations(Socket socket) throws IOException {
        this.socket = socket;
        genericInputOperation = new GenericInputOperation(socket.getInputStream());
        genericWriteOperation = new GenericWriteOperation(socket.getOutputStream());
    }

    public int read() throws IOException {
        return genericInputOperation.read();
    }

    public int read(byte[] b) throws IOException {

        return genericInputOperation.read(b);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return genericInputOperation.read(b, off, len);
    }

    public byte[] readAllBytes() throws IOException {
        return this.genericInputOperation.readAllBytes();
    }

    public byte[] readNBytes(int len) throws IOException {
        return this.genericInputOperation.readNBytes(len);
    }

    public void write(int b) throws IOException {
        this.genericWriteOperation.write(b);
    }

    public void write(byte[] b) throws IOException {
        this.genericWriteOperation.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        this.genericWriteOperation.write(b, off, len);
    }

    public long getBytesRead() {
        return genericInputOperation.getBytesRead();
    }

    public long getBytesWritten() {
        return genericWriteOperation.getBytesWritten();
    }

    public long getReadOperationCount() {
        return genericInputOperation.getReadOperationCount();
    }

    public long getWriteOperationCount() {
        return genericWriteOperation.getWriteOperationCount();
    }
}


class GenericInputOperation implements Closeable {

    private long bytesRead;
    private long readOperationCount;

    private final InputStream inputStream;

    public GenericInputOperation(InputStream inputStream) throws FileNotFoundException {
        this.inputStream = inputStream;
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
//        return new byte[0];

        byte[] allData = this.inputStream.readNBytes(len);
        if (allData.length > 0) {
            readOperationCount++;
            bytesRead += allData.length;
        }
        return allData;
    }

    @Override
    public void close() throws IOException {
        if (this.inputStream != null) {
            this.inputStream.close();
        }
    }

    public long getBytesRead() {
        return bytesRead;
    }


    public long getReadOperationCount() {
        return readOperationCount;
    }


}

class GenericWriteOperation implements Closeable {


    private long bytesWritten;
    private long writeOperationCount;

    private final OutputStream outputStream;

    public GenericWriteOperation(OutputStream outputStream) {
        this.outputStream = outputStream;
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

    @Override
    public void close() throws IOException {
        if (this.outputStream != null) {
            this.outputStream.close();
        }
    }

    public long getBytesWritten() {
        return bytesWritten;
    }

    public long getWriteOperationCount() {
        return writeOperationCount;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}



