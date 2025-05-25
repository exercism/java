import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PaasioTest {

    private File tmpFile;

    @BeforeEach
    public void setUPTest() throws IOException {
        tmpFile = File.createTempFile("sample",".txt");
    }

    @AfterEach
    public void cleanFile(){
        if(tmpFile.exists()) {
            tmpFile.delete();
        }
    }

    @Test
    void checkReadOperationCount(){

        //Writing data to file to read its content
        try(FileOutputStream writeToFile = new FileOutputStream(tmpFile)){
            writeToFile.write("This is data ".getBytes());
        }catch(IOException ioException){
            ioException.printStackTrace();
        }

        try(FileOperations customFileReader = new FileOperations(tmpFile,true)){

            customFileReader.read();
            customFileReader.read();
            customFileReader.read();
            assertThat(3).isEqualTo(customFileReader.getReadOperationCount());
        }
        catch(IOException ioException){
            System.out.println("Exception occured");
        }

    }



}
