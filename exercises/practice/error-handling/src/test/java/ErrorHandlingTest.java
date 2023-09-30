import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

public class ErrorHandlingTest {

    private ErrorHandling errorHandling = new ErrorHandling();

    @Test
    public void testThrowIllegalArgumentException() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingIllegalArgumentException());
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowIllegalArgumentExceptionWithDetailMessage() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(
                        "This is the detail message."))
                .withMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowAnyCheckedException() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyCheckedException())
                .isNotInstanceOf(RuntimeException.class);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowAnyCheckedExceptionWithDetailMessage() {
        assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(
                        "This is the detail message."))
                .isNotInstanceOf(RuntimeException.class)
                .withMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowAnyUncheckedException() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyUncheckedException());
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowAnyUncheckedExceptionWithDetailMessage() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(
                        "This is the detail message."))
                .withMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomCheckedException() {
        assertThatExceptionOfType(CustomCheckedException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomCheckedException());
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomCheckedExceptionWithDetailMessage() {
        assertThatExceptionOfType(CustomCheckedException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(
                        "This is the detail message."))
                .withMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomUncheckedException() {
        assertThatExceptionOfType(CustomUncheckedException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomUncheckedException());
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomUncheckedExceptionWithDetailMessage() {
        assertThatExceptionOfType(CustomUncheckedException.class)
                .isThrownBy(() -> errorHandling.handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(
                        "This is the detail message."))
                .withMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testReturnOptionalInstance() {
        Optional<Integer> successfulResult = errorHandling.handleErrorByReturningOptionalInstance("1");
        assertThat(successfulResult).isPresent().hasValue(1);

        Optional<Integer> failureResult = errorHandling.handleErrorByReturningOptionalInstance("a");
        assertThat(failureResult).isNotPresent();

    }

}
