import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ErrorHandlingTest {

    private ErrorHandling errorHandling;
    private Set<Class> checkedExceptions;
    private Set<Class> uncheckedExceptions;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        errorHandling = new ErrorHandling();
        setUpCheckedExceptions();
        setUpUncheckedExceptions();
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
    public void testThrowIllegalArgumentException() throws Exception {
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
    public void testThrowCustomCheckedException() {
        try {
            errorHandling.handleErrorByThrowingCustomCheckedException();
            throw new AssertionFailedError();
        } catch (Exception e) {
            assertFalse(e instanceof RuntimeException);
            assertFalse(checkedExceptions.contains(e.getClass()));
        }
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomCheckedExceptionWithDetailMessage() {
        try {
            errorHandling.handleErrorByThrowingCustomCheckedExceptionWithDetailMessage("This is the detail message.");
            throw new AssertionFailedError();
        } catch (Exception e) {
            assertFalse(e instanceof RuntimeException);
            assertFalse(checkedExceptions.contains(e.getClass()));
        }
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomUncheckedException() {
        try {
            errorHandling.handleErrorByThrowingCustomUncheckedException();
            throw new AssertionFailedError();
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
            assertFalse(uncheckedExceptions.contains(e.getClass()));
        }
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrowCustomUncheckedExceptionWithDetailMessage() {
        try {
            errorHandling.handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage("This is the detail message.");
            throw new AssertionFailedError();
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
            assertFalse(uncheckedExceptions.contains(e.getClass()));
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

    private void setUpCheckedExceptions() {
        checkedExceptions = new HashSet<>();
        checkedExceptions.add(ClassNotFoundException.class);
        checkedExceptions.add(CloneNotSupportedException.class);
        checkedExceptions.add(IllegalAccessException.class);
        checkedExceptions.add(InstantiationError.class);
        checkedExceptions.add(InterruptedException.class);
        checkedExceptions.add(NoSuchFieldException.class);
        checkedExceptions.add(NoSuchMethodException.class);
    }

    private void setUpUncheckedExceptions() {
        uncheckedExceptions = new HashSet<>();
        uncheckedExceptions.add(ArithmeticException.class);
        uncheckedExceptions.add(ArrayIndexOutOfBoundsException.class);
        uncheckedExceptions.add(ArrayStoreException.class);
        uncheckedExceptions.add(ClassCastException.class);
        uncheckedExceptions.add(IllegalArgumentException.class);
        uncheckedExceptions.add(IllegalMonitorStateException.class);
        uncheckedExceptions.add(IllegalStateException.class);
        uncheckedExceptions.add(IllegalThreadStateException.class);
        uncheckedExceptions.add(IndexOutOfBoundsException.class);
        uncheckedExceptions.add(NegativeArraySizeException.class);
        uncheckedExceptions.add(NullPointerException.class);
        uncheckedExceptions.add(NumberFormatException.class);
        uncheckedExceptions.add(SecurityException.class);
        uncheckedExceptions.add(StringIndexOutOfBoundsException.class);
        uncheckedExceptions.add(UnsupportedOperationException.class);
    }

}
