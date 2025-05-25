import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class FileOperations {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    private long bytesRead;
    private long bytesWritten;
    private long readOperationCount;
    private long writeOperationCount;
    private String mode;

    public FileOperations(File file, boolean readOperation){

    }
}


