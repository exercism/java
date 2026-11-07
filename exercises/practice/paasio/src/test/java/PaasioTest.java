import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

public class PaasioTest {

    private Paasio paasioReaderWriter;

    private ByteArrayInputStream dataInputStream;
    private ByteArrayOutputStream dataOutputStream;
    private static final String MESSAGECONSTANT = "This is additional Content.";

    @BeforeEach
    public void setUpTest() {

        this.dataInputStream = new ByteArrayInputStream("This is data ".getBytes());
        this.dataOutputStream = new ByteArrayOutputStream();
        paasioReaderWriter = new Paasio(this.dataInputStream, this.dataOutputStream);
    }

    @AfterEach
    public void closeOpenStream() throws IOException {
        if (!Objects.isNull(this.paasioReaderWriter.getInputStream())) {
            this.paasioReaderWriter.getInputStream().close();
        }
        if (!Objects.isNull(this.paasioReaderWriter.getOutputStream())) {
            this.paasioReaderWriter.getOutputStream().close();
        }
    }

    @Test
    void checkReadOperationCount() throws IOException {
        paasioReaderWriter.read();
        paasioReaderWriter.read();
        paasioReaderWriter.read();
        assertThat(paasioReaderWriter.getReadOperationCount()).isEqualTo(3);
    }

    @Test
    @Disabled("Remove to run test")
    void checkAmountOfDataReadInBytes() throws IOException {

        paasioReaderWriter.read();
        paasioReaderWriter.read();
        paasioReaderWriter.read();
        paasioReaderWriter.read();

        assertThat(paasioReaderWriter.getBytesRead()).isEqualTo(4);
    }

    @Test
    void checkAmountOfDataReadInBytesForMultipleOperations() throws IOException {

        paasioReaderWriter.read();
        paasioReaderWriter.read();
        paasioReaderWriter.read();
        paasioReaderWriter.read();

        byte[] readByteData = new byte[4];
        paasioReaderWriter.read(readByteData);

        //Asserting content of the data read
        assertThat(readByteData).isEqualTo(" is ".getBytes());
        assertThat(paasioReaderWriter.getBytesRead()).isEqualTo(8);


    }

    @Test
    @Disabled("Remove to run test")
    void checkByteValueReadFromTheFile() throws IOException {

        byte[] fileData = new byte[100];
        int bytesRead = paasioReaderWriter.read(fileData);
        String dataInFile = new String(fileData, 0, bytesRead, StandardCharsets.UTF_8);
        assertThat(dataInFile).isEqualTo("This is data ");


    }

    @Test
    @Disabled("Remove to run test")
    void checkIfDataFollowsTheOffsetWhileWritingInByteArray() throws IOException {

        byte[] initialMessage = "Hello! ".getBytes();
        byte[] messageArray = Arrays.copyOf(initialMessage, 50);

        int length = messageArray.length - initialMessage.length - 2;
        //It will read data into the messageArray and will begin writing it from its  initialMessage.length index
        int bytesRead = paasioReaderWriter.read(messageArray, initialMessage.length, length);

        String dataInFile = new String(messageArray, 0, initialMessage.length + bytesRead, StandardCharsets.UTF_8);
        assertThat(dataInFile).isEqualTo("Hello! This is data ");
    }


    @Test
    @Disabled("Remove to run test")
    void validateBytesOfDataReadWhileReadingItFromOffset() throws IOException {
        byte[] byteData = new byte[50];
        int bytesRead = paasioReaderWriter.read(byteData, 0, 10);

        assertThat(bytesRead).isEqualTo(10);
    }

    @Test
    @Disabled("Remove to run test")
    void validateAllBytesReadingData() throws IOException {

        byte[] bytes = paasioReaderWriter.readAllBytes();
        assertThat(paasioReaderWriter.getBytesRead()).isEqualTo(bytes.length);

    }


    @Test
    @Disabled("Remove to run test")
    void validateAllBytesReadOperationCount() throws IOException {

        paasioReaderWriter.read();
        paasioReaderWriter.read();
        paasioReaderWriter.readAllBytes();
        assertThat(paasioReaderWriter.getReadOperationCount()).isEqualTo(3);

    }


    @Test
    @Disabled("Remove to run test")
    void validateReadNBytesReadOperationCount() throws IOException {

        paasioReaderWriter.readNBytes(5);
        paasioReaderWriter.readNBytes(5);

        assertThat(paasioReaderWriter.getReadOperationCount()).isEqualTo(2);
    }

    @Test
    @Disabled("Remove to run test")
    void validateReadNBytesDataReadInBytesAndVerifyReadCount() throws IOException {

        byte[] helloArray = "Hello! ".getBytes();
        byte[] dataRead = Arrays.copyOf(helloArray, 100);

        int bytesRead = paasioReaderWriter.read(dataRead, helloArray.length, 40);
        String finalVAlue = new String(dataRead, 0, helloArray.length + bytesRead, StandardCharsets.UTF_8);

        assertThat("Hello! This is data ").isEqualTo(finalVAlue);
        assertThat(1).isEqualTo(paasioReaderWriter.getReadOperationCount());
    }

    @Test
    @Disabled("Remove to run test")
    void verifyNumberOfWriteOperations() throws IOException {

        paasioReaderWriter.write(23);
        paasioReaderWriter.write(24);
        paasioReaderWriter.write(25);
        paasioReaderWriter.write(25);

        assertThat(paasioReaderWriter.getWriteOperationCount()).isEqualTo(4);

    }

    @Test
    @Disabled("Remove to run test")
    void verifyContentAfterWritingByteArrayIntoTheOutputStream() throws IOException {

        byte[] writeFileContent = MESSAGECONSTANT.getBytes();
        paasioReaderWriter.write(writeFileContent);
        String dataWritten = this.dataOutputStream.toString(StandardCharsets.UTF_8);

        assertThat(dataWritten).isEqualTo(MESSAGECONSTANT);
    }

    @Test
    @Disabled("Remove to run test")
    void verifyWriteOperationCountAfterWritingByteArrayIntoTheOutputStream() throws IOException {

        byte[] writeFileContent = MESSAGECONSTANT.getBytes();
        paasioReaderWriter.write(writeFileContent);
        paasioReaderWriter.write(writeFileContent);
        paasioReaderWriter.write(43);

        assertThat(3).isEqualTo(paasioReaderWriter.getWriteOperationCount());
    }


    @Test
    @Disabled("Remove to run test")
    void verifyBytesOfDataWrittenInTheOutputStream() throws IOException {

        byte[] writeFileContent = MESSAGECONSTANT.getBytes();
        paasioReaderWriter.write(writeFileContent);
        paasioReaderWriter.write(writeFileContent);
        paasioReaderWriter.write('s');

        assertThat(paasioReaderWriter.getBytesWritten()).isEqualTo((writeFileContent.length * 2L) + 1);

    }

    @Test
    @Disabled("Remove to run test")
    void verifyBytesWrittenFromOffsetIntoTheOutputStreamAlongWithTheCount() throws IOException {

        String fileContentToBeWritten = "   This is additional Content.";
        byte[] writeFileContent = fileContentToBeWritten.getBytes();

        paasioReaderWriter.write(writeFileContent, 3, writeFileContent.length - 3);

        String fileConvertedToString = this.dataOutputStream.toString(StandardCharsets.UTF_8);

        assertThat(fileConvertedToString).isEqualTo(fileContentToBeWritten.trim());
        assertThat(paasioReaderWriter.getWriteOperationCount()).isEqualTo(1);

    }


    @Test
    @Disabled("Remove to run test")
    void verifyReadOperationStats() throws IOException {

        byte[] dataRead = new byte[50];

        paasioReaderWriter.read();
        paasioReaderWriter.read();
        paasioReaderWriter.read();
        paasioReaderWriter.read(dataRead, 0, 5);

        assertThat(paasioReaderWriter.getReadOperationCount()).isEqualTo(4);
        assertThat(paasioReaderWriter.getBytesRead()).isEqualTo(8);
    }

    @Test
    @Disabled("Remove to run test")
    public void checkBytesOfDataWrittenAlongWithWriteOperationCount() throws IOException {

        byte[] someData = "Writing Data".getBytes();

        paasioReaderWriter.write('3');
        paasioReaderWriter.write('4');
        paasioReaderWriter.write('6');
        paasioReaderWriter.write(someData);

        assertThat(paasioReaderWriter.getWriteOperationCount()).isEqualTo(4);
        assertThat(paasioReaderWriter.getBytesWritten()).isEqualTo(15);

    }


}
