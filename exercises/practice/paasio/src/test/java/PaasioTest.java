import org.junit.jupiter.api.*;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

public class PaasioTest {

    private ByteArrayInputStream dataInputStream;
    private ByteArrayOutputStream dataOutputStream;

    @BeforeEach
    public void setUPTest(TestInfo testInfo) throws IOException {

        this.dataInputStream = new ByteArrayInputStream("This is data ".getBytes());
        this.dataOutputStream = new ByteArrayOutputStream();
    }

//    @AfterEach
//    public void cleanFile(TestInfo testInfo) {
//
//        if (testInfo.getTags().contains("fileOperation") && tmpFile.exists()) {
//            tmpFile.delete();
//        }
//    }

    @Test
    void checkReadOperationCount() {

        try (Paasio customFileReader = new Paasio(this.dataInputStream, this.dataOutputStream)) {
            customFileReader.read();
            customFileReader.read();
            customFileReader.read();
            assertThat(customFileReader.getReadOperationCount()).isEqualTo(3);
        } catch (IOException ioException) {
            System.out.println("Exception occured");
        }

    }

    @Test
    void checkAmountOfDataReadInBytes() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

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

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

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

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

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

        assertThatThrownBy(() -> {
            Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream);
            fileOperations.read(null);
        }).isInstanceOf(NullPointerException.class);

        //        Assertions.assertThrows(NullPointerException.class, () -> {
        //            FileOperations customFileReader = new FileOperations(tmpFile, true);
        //            customFileReader.read(null);
        //        });

    }

    @Test
    void checkIfDataFollowsTheOffsetWhileWritingInByteArray() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

            byte[] initialMessage = "Hello! ".getBytes();
            byte[] messageArray = new byte[50];

            for (int i = 0; i < initialMessage.length; i++) {
                messageArray[i] = initialMessage[i];
            }

            int length = messageArray.length - initialMessage.length - 2;
            //It will read data into the messageArray and will begin writing it from its  initialMessage.length index
            int bytesRead = fileOperations.read(messageArray, initialMessage.length, length);

            String dataInFile = new String(messageArray, 0, initialMessage.length + bytesRead, StandardCharsets.UTF_8);
            assertThat("Hello! This is data ").isEqualTo(dataInFile);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    @Test
    void validateBytesOfDataReadWhileReadingItFromOffset() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

            byte byteData[] = new byte[50];
            int bytesRead = fileOperations.read(byteData, 0, 10);

            assertThat(bytesRead).isEqualTo(10);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    @Test
    void validateAllBytesReadingData() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

            byte[] bytes = fileOperations.readAllBytes();
            assertThat(fileOperations.getBytesRead()).isEqualTo(bytes.length);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    void validateAllBytesReadOperationCount() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

            fileOperations.read();
            fileOperations.read();
            byte[] bytes = fileOperations.readAllBytes();
            assertThat(fileOperations.getReadOperationCount()).isEqualTo(3);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    void validateReadNBytesReadOperationCount() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

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
    void validateReadNBytesDataReadInBytesAndVerifyReadCount() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

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
    void verifyNumberOfWriteOperations() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {
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
    void verifyContentAfterWritingByteArrayIntoTheOutputStream() {
        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

            byte writeFileContent[] = "This is additional Content.".getBytes();
            fileOperations.write(writeFileContent);
            String dataWritten = this.dataOutputStream.toString(StandardCharsets.UTF_8);

            assertThat(dataWritten).isEqualTo("This is additional Content.");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    void verifyWriteOperationCountAfterWritingByteArrayIntoTheOutputStream() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

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
    void verifyBytesOfDataWrittenInTheOutputStream() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

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
    void verifyBytesWrittenFromOffsetIntoTheOutputStreamAlongWithTheCount() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

            String fileContentToBeWritten = "   This is additional Content.";
            byte[] writeFileContent = fileContentToBeWritten.getBytes();

            fileOperations.write(writeFileContent, 3, writeFileContent.length - 3);

            String fileConvertedToString = this.dataOutputStream.toString(StandardCharsets.UTF_8);

            assertThat(fileContentToBeWritten.trim()).isEqualTo(fileConvertedToString);
            assertThat(fileOperations.getWriteOperationCount()).isEqualTo(1);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }


    @Test
    void verifyReadOperationStats() {

        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

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


    @Test
    public void checkBytesOfDataWrittenAlongWithWriteOperationCount() {

        byte[] someData = "Writing Data".getBytes();
        try (Paasio fileOperations = new Paasio(this.dataInputStream, this.dataOutputStream)) {

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


//    @Test
//    @Tag("socketOperation")
//    void verifyIfMethodThrowsExceptionIfSocketObjectIsNull(){
//
//        assertThatThrownBy(()->{
//            SocketOperations fileOperations = new SocketOperations(null);
//        }).isInstanceOf(RuntimeException.class);
//    }
}
