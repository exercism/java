import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

public class ErrorHandlingTest {

    private ErrorHandling errorHandling;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        errorHandling = new ErrorHandling();
    }

    @Test
    public void testThrowException() throws Exception {
        thrown.expect(Exception.class);
        errorHandling.handleErrorByThrowingException();
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowExceptionWithDetailMessage() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("This is the detail message.");
        errorHandling.handleErrorByThrowingExceptionWithDetailMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        errorHandling.handleErrorByThrowingIllegalArgumentException();
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowIllegalArgumentExceptionWithDetailMessage() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("This is the detail message.");
        errorHandling.handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomCheckedException() throws CustomCheckedException {
        thrown.expect(CustomCheckedException.class);
        errorHandling.handleErrorByThrowingCustomCheckedException();
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomCheckedExceptionWithDetailMessage() throws CustomCheckedException {
        thrown.expect(CustomCheckedException.class);
        thrown.expectMessage("This is the detail message.");
        errorHandling.handleErrorByThrowingCustomCheckedExceptionWithDetailMessage("This is the detail message.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomUncheckedException() {
        thrown.expect(CustomUncheckedException.class);
        errorHandling.handleErrorByThrowingCustomUncheckedException();
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomUncheckedExceptionWithDetailMessage() {
        thrown.expect(CustomUncheckedException.class);
        thrown.expectMessage("This is the detail message.");
        errorHandling.handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage("This is the detail message.");
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
