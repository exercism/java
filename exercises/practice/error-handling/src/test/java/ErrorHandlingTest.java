import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

public class ErrorHandlingTest {

    private ErrorHandling errorHandling = new ErrorHandling();

    @Test
    public void testThrowIllegalArgumentException() {
        assertThrows(
            IllegalArgumentException.class,
            errorHandling::handleErrorByThrowingIllegalArgumentException);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowIllegalArgumentExceptionWithDetailMessage() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> errorHandling
                    .handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(
                        "This is the detail message."));

        assertThat(expected).hasMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowAnyCheckedException() {
        Exception expected =
            assertThrows(
                Exception.class,
                errorHandling::handleErrorByThrowingAnyCheckedException);
        assertThat(expected).isNotInstanceOf(RuntimeException.class);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowAnyCheckedExceptionWithDetailMessage() {
        Exception expected =
            assertThrows(
                Exception.class,
                () -> errorHandling
                    .handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(
                        "This is the detail message."));
        assertThat(expected).isNotInstanceOf(RuntimeException.class);
        assertThat(expected).hasMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowAnyUncheckedException() {
        assertThrows(
            RuntimeException.class,
            errorHandling::handleErrorByThrowingAnyUncheckedException);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowAnyUncheckedExceptionWithDetailMessage() {
        RuntimeException expected =
            assertThrows(
                RuntimeException.class,
                () -> errorHandling
                    .handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(
                        "This is the detail message."));
        assertThat(expected).hasMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomCheckedException() {
        assertThrows(
            CustomCheckedException.class,
            errorHandling::handleErrorByThrowingCustomCheckedException);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomCheckedExceptionWithDetailMessage() {
        CustomCheckedException expected =
            assertThrows(
                CustomCheckedException.class,
                () -> errorHandling
                    .handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(
                        "This is the detail message."));
        assertThat(expected).hasMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomUncheckedException() {
        assertThrows(
            CustomUncheckedException.class,
            errorHandling::handleErrorByThrowingCustomUncheckedException);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomUncheckedExceptionWithDetailMessage() {
        CustomUncheckedException expected =
            assertThrows(
                CustomUncheckedException.class,
                () -> errorHandling
                    .handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(
                        "This is the detail message."));
        assertThat(expected).hasMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testReturnOptionalInstance() {
        Optional<Integer> successfulResult = errorHandling.handleErrorByReturningOptionalInstance("1");
        assertTrue(successfulResult.isPresent());
        assertEquals(1, (int) successfulResult.get());

        Optional<Integer> failureResult = errorHandling.handleErrorByReturningOptionalInstance("a");
        assertFalse(failureResult.isPresent());
    }

}
