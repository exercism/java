import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

public class PaasioTest {

    private File tmpFile;
    class DummySocket extends Socket{

        private final ByteArrayInputStream sampleInputStream = new ByteArrayInputStream("This is data".getBytes());
        private final ByteArrayOutputStream sampleOutputStream = new ByteArrayOutputStream();

        public DummySocket() {
            super();
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return sampleInputStream;
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            return sampleOutputStream;
        }
    }

    private DummySocket dummySocket;

    @BeforeEach
    public void setUPTest(TestInfo testInfo) throws IOException {
        if(testInfo.getTags().contains("fileOperation")) {

            System.out.println("File Operation testing");

            tmpFile = File.createTempFile("sample", ".txt");
            //Writing data to file to read its content
            try (FileOutputStream writeToFile = new FileOutputStream(tmpFile)) {
                writeToFile.write("This is data ".getBytes());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        if(testInfo.getTags().contains("socketOperation")) {
            dummySocket = new DummySocket();
        }
    }

    @AfterEach
    public void cleanFile(TestInfo testInfo) {

        if (testInfo.getTags().contains("fileOperation") && tmpFile.exists()) {
            tmpFile.delete();
        }
    }

    @Test
    @Tag("fileOperation")
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
    @Tag("fileOperation")
    void throwUnsupportedOperationExceptionExceptionWhenTryingToReadInWriteMode() {

        assertThatThrownBy(()->{
            FileOperations customFileReader = new FileOperations(tmpFile, false);
            customFileReader.read();
        }).isInstanceOf(UnsupportedOperationException.class);

//        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
//            FileOperations customFileReader = new FileOperations(tmpFile, false);
//            customFileReader.read();
//        });
    }

    @Test
    @Tag("fileOperation")
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
    @Tag("fileOperation")
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
    @Tag("fileOperation")
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
    @Tag("fileOperation")
    void checkIfNullPointerExceptionIsThrownWhenNullIsPassedInsteadOfByteArray() {

        assertThatThrownBy(()->{
            FileOperations customFileReader = new FileOperations(tmpFile, true);
            customFileReader.read(null);
        }).isInstanceOf(NullPointerException.class);

    //        Assertions.assertThrows(NullPointerException.class, () -> {
    //            FileOperations customFileReader = new FileOperations(tmpFile, true);
    //            customFileReader.read(null);
    //        });

    }

    @Test
    @Tag("fileOperation")
    void checkIfDataFollowsTheOffsetWhileWritingInByteArray() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte[] initialMessage = "Hello! ".getBytes();
            byte[] someMessage = new byte[50];

            for (int i = 0; i < initialMessage.length; i++) {
                someMessage[i] = initialMessage[i];
            }

            int bytesRead = fileOperations.read(someMessage, initialMessage.length, someMessage.length - initialMessage.length - 2);

            String dataInFile = new String(someMessage, 0, initialMessage.length + bytesRead, StandardCharsets.UTF_8);
            assertThat("Hello! This is data ").isEqualTo(dataInFile);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    @Test
    @Tag("fileOperation")
    void validateBytesOfDataReadWhileReadingItFromOffset() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte byteData[] = new byte[50];
            int bytesRead = fileOperations.read(byteData, 0, 10);

            assertThat(bytesRead).isEqualTo(10);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    @Tag("fileOperation")
    void validateAllBytesReadingData() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte[] bytes = fileOperations.readAllBytes();
            assertThat(fileOperations.getBytesRead()).isEqualTo(bytes.length);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    @Tag("fileOperation")
    void validateAllBytesReadOperationCount() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            fileOperations.read();
            fileOperations.read();
            byte[] bytes = fileOperations.readAllBytes();
            assertThat(fileOperations.getReadOperationCount()).isEqualTo(3);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    @Tag("fileOperation")
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
    @Tag("fileOperation")
    void validateReadNBytesDataReadInBytesAndVerifyReadCount() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte dataRead[] = new byte[100];
            byte[] helloArray = "Hello! ".getBytes();

            for (int i = 0; i < helloArray.length; i++) {
                dataRead[i] = helloArray[i];
            }

            int bytesRead = fileOperations.read(dataRead, helloArray.length, 40);
            String finalVAlue = new String(dataRead, 0, helloArray.length + bytesRead, StandardCharsets.UTF_8);

            assertThat("Hello! This is data ").isEqualTo(finalVAlue);
            assertThat(1).isEqualTo(fileOperations.getReadOperationCount());

        } catch (IOException ioException) {

        }

    }

    @Test
    @Tag("fileOperation")
    void verifyNumberOfWriteOperations() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, false)) {
            fileOperations.write(23);
            fileOperations.write(24);
            fileOperations.write(25);
            fileOperations.write(25);

            assertThat(4).isEqualTo(fileOperations.getWriteOperationCount());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    @Tag("fileOperation")
    void verifyIfExceptionIsThrownIfFileOperationIsNotInWriteMode() {
        assertThatThrownBy(() -> {
            FileOperations customFileReader = new FileOperations(tmpFile, true);
            customFileReader.write(null);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @Tag("fileOperation")
    void verifyFileContentAfterWritingByteArrayIntoTheFile() {
        try (FileOperations fileOperations = new FileOperations(tmpFile, false)) {

            byte writeFileContent[] = "This is additional Content.".getBytes();
            fileOperations.write(writeFileContent);

            FileOperations readFile = new FileOperations(tmpFile, true);

            byte fileContent[] = readFile.readAllBytes();
            String dataWritten = new String(fileContent, StandardCharsets.UTF_8);

            assertThat(dataWritten).isEqualTo("This is additional Content.");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    @Tag("fileOperation")
    void verifyWriteOperationCountAfterWritingByteArrayIntoTheFile() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, false)) {

            byte writeFileContent[] = "This is additional Content.".getBytes();
            fileOperations.write(writeFileContent);
            fileOperations.write(writeFileContent);
            fileOperations.write(43);

            assertThat(3).isEqualTo(fileOperations.getWriteOperationCount());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    @Test
    @Tag("fileOperation")
    void verifyBytesOfDataWrittenInTheFile() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, false)) {

            byte writeFileContent[] = "This is additional Content.".getBytes();
            fileOperations.write(writeFileContent);
            fileOperations.write(writeFileContent);
            fileOperations.write('s');

            assertThat(fileOperations.getBytesWritten()).isEqualTo((writeFileContent.length * 2L) + 1);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    @Tag("fileOperation")
    void verifyBytesWrittenFromOffsetIntoTheFileAlongWithTheCount() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, false)) {

            String fileContentToBeWritten = "   This is additional Content.";
            byte[] writeFileContent = fileContentToBeWritten.getBytes();

            fileOperations.write(writeFileContent, 3, writeFileContent.length - 3);

            FileOperations readFileContent = new FileOperations(tmpFile, true);
            byte[] fileContentRead = readFileContent.readAllBytes();
            String fileConvertedToString = new String(fileContentRead, StandardCharsets.UTF_8);

            assertThat(fileContentToBeWritten.trim()).isEqualTo(fileConvertedToString);
            assertThat(1).isEqualTo(fileOperations.getWriteOperationCount());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    @Tag("fileOperation")
    void verifyReadOperationStats() {

        try (FileOperations fileOperations = new FileOperations(tmpFile, true)) {

            byte[] dataRead = new byte[50];

            fileOperations.read();
            fileOperations.read();
            fileOperations.read();
            fileOperations.read(dataRead,0,5);

            assertThat(4).isEqualTo(fileOperations.getReadOperationCount());
            assertThat(8).isEqualTo(fileOperations.getBytesRead());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    @Tag("fileOperation")
    void verifyIfMethodThrowsExceptionIfObjectIsNull(){

        assertThatThrownBy(()->{
            FileOperations fileOperations = new FileOperations(null,true);
        }).isInstanceOf(RuntimeException.class);
    }

    //Socket Testing

    @Test
    @Tag("socketOperation")
    public void checkReadOperationCountInSocket(){

        try(SocketOperations socketOperations = new SocketOperations(dummySocket)){

            socketOperations.read();
            socketOperations.read();
            socketOperations.read();
            assertThat(socketOperations.getReadOperationCount()).isEqualTo(3);

        }catch(IOException ioException){
            ioException.printStackTrace();
        }

    }


    @Test
    @Tag("socketOperation")
    public void checkDataReadInAByte(){

        byte[] data = new byte[100];
        try(SocketOperations socketOperations = new SocketOperations(dummySocket)){

            socketOperations.read(data);
            String dataReadToString = new String(data, StandardCharsets.UTF_8).trim();
            assertThat(dataReadToString).isEqualTo("This is data");

        }catch(IOException ioException){
            ioException.printStackTrace();
        }

    }

    @Test
    @Tag("socketOperation")
    public void checkOverAllReadOperationsAndBytesReadAfterReadingUsingDifferentMethods(){

        byte[] someData = new byte[100];
        try(SocketOperations socketOperations = new SocketOperations(dummySocket)){

            socketOperations.read();
            socketOperations.read();
            socketOperations.read(someData,0,3);

            assertThat(socketOperations.getReadOperationCount()).isEqualTo(3);
            assertThat(socketOperations.getBytesRead()).isEqualTo(5);


        }catch(IOException ioException){
            ioException.printStackTrace();
        }


    }


    @Test
    @Tag("socketOperation")
    public void checkBytesOfDataWrittenAlongWithWriteOperationCount(){

        byte[] someData = "Writing Data".getBytes();
        try(SocketOperations socketOperations = new SocketOperations(dummySocket)){

            socketOperations.write('3');
            socketOperations.write('4');
            socketOperations.write('6');
            socketOperations.write(someData);

            assertThat(socketOperations.getWriteOperationCount()).isEqualTo(4);
            assertThat(socketOperations.getBytesWritten()).isEqualTo(15);

        }catch(IOException ioException){
            ioException.printStackTrace();
        }

    }

    @Test
    @Tag("socketOperation")
    void verifyIfDataWrittenInOutputStream(){

        try(SocketOperations socketOperations = new SocketOperations(dummySocket)){

            byte[] byteData = "Data to write".getBytes();
            socketOperations.write(byteData);

            assertThat(dummySocket.sampleOutputStream.toString()).isEqualTo("Data to write");

        }catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    @Test
    @Tag("socketOperation")
    void verifyIfMethodThrowsExceptionIfSocketObjectIsNull(){

        assertThatThrownBy(()->{
            SocketOperations fileOperations = new SocketOperations(null);
        }).isInstanceOf(RuntimeException.class);
    }
}
