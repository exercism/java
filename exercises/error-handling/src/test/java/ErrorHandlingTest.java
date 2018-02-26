import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

class ErrorHandlingTest {

    private ErrorHandling errorHandling;

    @Before
    public void setUp() {
        errorHandling = new ErrorHandling();
    }

    @Test(expected = Exception.class)
    public void testThrowException() throws Exception {
        errorHandling.handleErrorByThrowingException();
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowExceptionWithDetailMessage() {
        try {
            errorHandling.handleErrorByThrowingExceptionWithDetailMessage("This is the detail message.");
            throw new AssertionFailedError();
        } catch (Exception e) {
            assertEquals("This is the detail message.", e.getMessage());
        }
    }

    @Ignore("Remove to run test")
    @Test(expected = IllegalArgumentException.class)
    public void testThrowIllegalArgumentException() throws Exception {
        errorHandling.handleErrorByThrowingIllegalArgumentException();
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowIllegalArgumentExceptionWithDetailMessage() {
        try {
            errorHandling.handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage("This is the detail message.");
            throw new AssertionFailedError();
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("This is the detail message.", e.getMessage());
        }
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
