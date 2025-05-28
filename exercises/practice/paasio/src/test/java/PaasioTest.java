import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaasioTest {

    private File tmpFile;

    @BeforeEach
    public void setUPTest() throws IOException {
        tmpFile = File.createTempFile("sample", ".txt");
        //Writing data to file to read its content
        try (FileOutputStream writeToFile = new FileOutputStream(tmpFile)) {
            writeToFile.write("This is data ".getBytes());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @AfterEach
    public void cleanFile() {
        if (tmpFile.exists()) {
            tmpFile.delete();
        }
    }

    @Test
    void checkReadOperationCount() {

        try (FileOperations customFileReader = new FileOperations(tmpFile, true)) {

            customFileReader.read();
            customFileReader.read();
            customFileReader.read();
            assertThat(3).isEqualTo(customFileReader.getReadOperationCount());
        } catch (IOException ioException) {
            System.out.println("Exception occured");
        }

    }

    @Test
    void throwUnsupportedOperationExceptionExceptionWhenTryingToReadInWriteMode() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            FileOperations customFileReader = new FileOperations(tmpFile, false);
            customFileReader.read();
        });
    }

    @Test
    void checkAmountOfDataReadInBytes() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            fileOperations.read();
            fileOperations.read();
            fileOperations.read();
            fileOperations.read();

            assertThat(4).isEqualTo(fileOperations.getBytesRead());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    void checkAmountOfDataReadInBytesForMultipleOperations() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            fileOperations.read();
            fileOperations.read();
            fileOperations.read();
            fileOperations.read();

            byte readByteData[] = new byte[5];
            fileOperations.read(readByteData);
            assertThat(9).isEqualTo(fileOperations.getBytesRead());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    void checkByteValueReadFromTheFile() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte fileData[] = new byte[100];

            int bytesRead = fileOperations.read(fileData);
            String dataInFile = new String(fileData, 0, bytesRead, StandardCharsets.UTF_8);
            assertThat("This is data ").isEqualTo(dataInFile);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    void checkIfNullPointerExceptionIsThrownWhenNullIsPassedInsteadOfByteArray() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            FileOperations customFileReader = new FileOperations(tmpFile, true);
            customFileReader.read(null);
        });

    }

    @Test
    void checkIfDataFollowsTheOffsetWhileWritingInByteArray() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte[] initialMessage = "Hello! ".getBytes();
            byte[] someMessage = new byte[50];

            for (int i = 0; i < initialMessage.length; i++) {
                someMessage[i] = initialMessage[i];
            }

            int bytesRead = fileOperations.read(someMessage, initialMessage.length, someMessage.length - initialMessage.length-2);

            String dataInFile = new String(someMessage, 0, initialMessage.length + bytesRead, StandardCharsets.UTF_8);
            assertThat("Hello! This is data ").isEqualTo(dataInFile);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    @Test
    void validateBytesOfDataReadWhileReadingItFromOffset(){

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte byteData[] = new byte[50];
            int bytesRead = fileOperations.read(byteData,0,10);

            assertThat(bytesRead).isEqualTo(10);

        }catch(IOException ioException){
            ioException.printStackTrace();
        }

    }

    @Test
    void validateAllBytesReadingData(){

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte[] bytes = fileOperations.readAllBytes();
            assertThat(fileOperations.getBytesRead()).isEqualTo(bytes.length);

        }catch(IOException ioException){
            ioException.printStackTrace();
        }

    }


    @Test
    void validateAllBytesReadOperationCount(){

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            fileOperations.read();
            fileOperations.read();
            byte[] bytes = fileOperations.readAllBytes();
            assertThat(fileOperations.getReadOperationCount()).isEqualTo(3);

        }catch(IOException ioException){
            ioException.printStackTrace();
        }

    }


    @Test
    void validateReadNBytesReadOperationCount() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            fileOperations.readNBytes(5);
            fileOperations.readNBytes(5);

            assertThat(fileOperations.getReadOperationCount()).isEqualTo(2);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    void validateReadNBytesDataReadInBytesAndVerifyReadCount() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte dataRead[] = new byte[100];
            byte[] helloArray = "Hello! ".getBytes();

            for(int i=0;i<helloArray.length;i++)
            {
                dataRead[i] = helloArray[i];
            }

            int bytesRead = fileOperations.read(dataRead, helloArray.length, 40);
            String finalVAlue = new String(dataRead,0, helloArray.length+bytesRead, StandardCharsets.UTF_8);

            assertThat("Hello! This is data ").isEqualTo(finalVAlue);
            assertThat(1).isEqualTo(fileOperations.getReadOperationCount());

        }
        catch (IOException ioException){

        }

    }

    @Test
    void verifyNumberOfWriteOperations(){

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {
            fileOperations.write(23);
            fileOperations.write(24);
            fileOperations.write(25);
            fileOperations.write(25);

            assertThat(4).isEqualTo(fileOperations.getWriteOperationCount());

        }catch (IOException ioException){
            ioException.printStackTrace();
        }

    }

    @Test
    void verifyIfExceptionIsThrownIfFileOperationIsNotInWriteMode(){
        assertThatThrownBy(()->{
            FileOperations customFileReader = new FileOperations(tmpFile, true);
            customFileReader.write(null);
        });
    }

    @Test
    void verifyFileContentAfterWritingByteArrayIntoTheFile(){


        try(FileOperations fileOperations = new FileOperations(tmpFile, false)){

            byte writeFileContent[] = "This is additional Content.".getBytes();
            fileOperations.write(writeFileContent);

            FileOperations readFile = new FileOperations(tmpFile, true);

            byte fileContent[] = readFile.readAllBytes();
            assertThat("This is data This is additional Content.".getBytes()).isEqualTo(fileContent);

        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    @Test
    void verifyWriteOperationCountAfterWritingByteArrayIntoTheFile(){

        try(FileOperations fileOperations = new FileOperations(tmpFile, false)){

            byte writeFileContent[] = "This is additional Content.".getBytes();
            fileOperations.write(writeFileContent);
            fileOperations.write(writeFileContent);
            fileOperations.write(43);

            assertThat(3).isEqualTo(fileOperations.getWriteOperationCount());

        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }


    @Test
    void verifyBytesOfDataWrittenInTheFile(){

        try(FileOperations fileOperations = new FileOperations(tmpFile, false)){

            byte writeFileContent[] = "This is additional Content.".getBytes();
            fileOperations.write(writeFileContent);
            fileOperations.write(writeFileContent);
            fileOperations.write(43);

            assertThat((writeFileContent.length*2)+1).isEqualTo(fileOperations.getBytesWritten());

        }catch(IOException ioException){
            ioException.printStackTrace();
        }

    }



}
