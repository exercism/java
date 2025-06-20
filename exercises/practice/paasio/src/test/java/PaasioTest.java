import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

public class PaasioTest {

    private File tmpFile;

    class DummySocket extends Socket {

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
        if (testInfo.getTags().contains("fileOperation")) {
            tmpFile = File.createTempFile("sample", ".txt");
            //Writing data to file to read its content

            InputStream is = new FileInputStream(tmpFile);
            try (FileOutputStream writeToFile = new FileOutputStream(tmpFile)) {
                writeToFile.write("This is data ".getBytes());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            is.read();
            is.read();
        }

        if (testInfo.getTags().contains("socketOperation")) {
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

        try (Paasio customFileReader = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {
            customFileReader.read();
            customFileReader.read();
            customFileReader.read();
            assertThat(customFileReader.getReadOperationCount()).isEqualTo(3);
        } catch (IOException ioException) {
            System.out.println("Exception occured");
        }

    }

    @Test
    @Tag("fileOperation")
    void checkAmountOfDataReadInBytes() {

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

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

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

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

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

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

        assertThatThrownBy(() -> {
            Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true));
            fileOperations.read(null);
        }).isInstanceOf(NullPointerException.class);

        //        Assertions.assertThrows(NullPointerException.class, () -> {
        //            FileOperations customFileReader = new FileOperations(tmpFile, true);
        //            customFileReader.read(null);
        //        });

    }

    @Test
    @Tag("fileOperation")
    void checkIfDataFollowsTheOffsetWhileWritingInByteArray() {

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

            byte[] im = "Hello! ".getBytes();
            byte[] sm = new byte[50];

            for (int i = 0; i < im.length; i++) {
                sm[i] = im[i];
            }

            int bytesRead = fileOperations.read(sm, im.length, sm.length - im.length - 2);

            String dataInFile = new String(sm, 0, im.length + bytesRead, StandardCharsets.UTF_8);
            assertThat("Hello! This is data ").isEqualTo(dataInFile);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    @Test
    @Tag("fileOperation")
    void validateBytesOfDataReadWhileReadingItFromOffset() {

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

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

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

            byte[] bytes = fileOperations.readAllBytes();
            assertThat(fileOperations.getBytesRead()).isEqualTo(bytes.length);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    @Tag("fileOperation")
    void validateAllBytesReadOperationCount() {

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

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

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

            fileOperations.readNBytes(5);
            fileOperations.readNBytes(5);

            assertThat(fileOperations.getReadOperationCount()).isEqualTo(2);
            System.out.println("haha ");
            System.out.println(fileOperations.getReadOperationCount());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    @Tag("fileOperation")
    void validateReadNBytesDataReadInBytesAndVerifyReadCount() {

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

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

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {
            fileOperations.write(23);
            fileOperations.write(24);
            fileOperations.write(25);
            fileOperations.write(25);

            assertThat(4).isEqualTo(fileOperations.getWriteOperationCount());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

//    @Test
//    @Tag("fileOperation")
//    void verifyIfExceptionIsThrownIfFileOperationIsNotInWriteMode() {
//        assertThatThrownBy(() -> {
//            Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile,true));
//            fileOperations.write(null);
//        }).isInstanceOf(UnsupportedOperationException.class);
//    }

    @Test
    @Tag("fileOperation")
    void verifyFileContentAfterWritingByteArrayIntoTheFile() {
        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile))) {

            byte writeFileContent[] = "This is additional Content.".getBytes();
            fileOperations.write(writeFileContent);
            byte fileContent[] = fileOperations.readAllBytes();
            String dataWritten = new String(fileContent, StandardCharsets.UTF_8);

            assertThat(dataWritten).isEqualTo("This is additional Content.");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    @Tag("fileOperation")
    void verifyWriteOperationCountAfterWritingByteArrayIntoTheFile() {

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

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

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

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

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile))) {

            String fileContentToBeWritten = "   This is additional Content.";
            byte[] writeFileContent = fileContentToBeWritten.getBytes();

            fileOperations.write(writeFileContent, 3, writeFileContent.length - 3);

            byte[] fileContentRead = fileOperations.readAllBytes();
            String fileConvertedToString = new String(fileContentRead, StandardCharsets.UTF_8);

            assertThat(fileContentToBeWritten.trim()).isEqualTo(fileConvertedToString);
            assertThat(fileOperations.getWriteOperationCount()).isEqualTo(1);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    @Tag("fileOperation")
    void verifyReadOperationStats() {

        try (Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile, true))) {

            byte[] dataRead = new byte[50];

            fileOperations.read();
            fileOperations.read();
            fileOperations.read();
            fileOperations.read(dataRead, 0, 5);

            assertThat(4).isEqualTo(fileOperations.getReadOperationCount());
            assertThat(8).isEqualTo(fileOperations.getBytesRead());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


//    @Test
//    @Tag("fileOperation")
//    void verifyIfMethodThrowsExceptionIfObjectIsNull(){
//
//        assertThatThrownBy(()->{
//            Paasio fileOperations = new Paasio(new FileInputStream(tmpFile), new FileOutputStream(tmpFile,true));
//        }).isInstanceOf(RuntimeException.class);
//    }

    //Socket Testing

    @Test
    @Tag("socketOperation")
    public void checkReadOperationCountInSocket() {

//        try(SocketOperations socketOperations = new SocketOperations(dummySocket)){
        try (Paasio fileOperations = new Paasio(dummySocket.getInputStream(), dummySocket.getOutputStream())) {

            fileOperations.read();
            fileOperations.read();
            fileOperations.read();
            assertThat(fileOperations.getReadOperationCount()).isEqualTo(3);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    @Tag("socketOperation")
    public void checkDataReadInAByte() {

        byte[] data = new byte[100];
        try (Paasio fileOperations = new Paasio(dummySocket.getInputStream(), dummySocket.getOutputStream())) {

            fileOperations.read(data);
            String dataReadToString = new String(data, StandardCharsets.UTF_8).trim();
            assertThat(dataReadToString).isEqualTo("This is data");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    @Tag("socketOperation")
    public void checkOverAllReadOperationsAndBytesReadAfterReadingUsingDifferentMethods() {

        byte[] someData = new byte[100];
        try (Paasio fileOperations = new Paasio(dummySocket.getInputStream(), dummySocket.getOutputStream())) {

            fileOperations.read();
            fileOperations.read();
            fileOperations.read(someData, 0, 3);

            assertThat(fileOperations.getReadOperationCount()).isEqualTo(3);
            assertThat(fileOperations.getBytesRead()).isEqualTo(5);


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }


    @Test
    @Tag("socketOperation")
    public void checkBytesOfDataWrittenAlongWithWriteOperationCount() {

        byte[] someData = "Writing Data".getBytes();
        try (Paasio fileOperations = new Paasio(dummySocket.getInputStream(), dummySocket.getOutputStream())) {

            fileOperations.write('3');
            fileOperations.write('4');
            fileOperations.write('6');
            fileOperations.write(someData);

            assertThat(fileOperations.getWriteOperationCount()).isEqualTo(4);
            assertThat(fileOperations.getBytesWritten()).isEqualTo(15);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    @Tag("socketOperation")
    void verifyIfDataWrittenInOutputStream() {

        try (Paasio fileOperations = new Paasio(dummySocket.getInputStream(), dummySocket.getOutputStream())) {

            byte[] byteData = "Data to write".getBytes();
            fileOperations.write(byteData);

            assertThat(dummySocket.sampleOutputStream.toString()).isEqualTo("Data to write");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

//    @Test
//    @Tag("socketOperation")
//    void verifyIfMethodThrowsExceptionIfSocketObjectIsNull(){
//
//        assertThatThrownBy(()->{
//            SocketOperations fileOperations = new SocketOperations(null);
//        }).isInstanceOf(RuntimeException.class);
//    }
}
