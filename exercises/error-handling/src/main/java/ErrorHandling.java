import java.util.Optional;

class ErrorHandling {

    public void handleErrorByThrowingException() throws Exception {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    public void handleErrorByThrowingExceptionWithDetailMessage(String message) throws Exception {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    public void handleErrorByThrowingIllegalArgumentException() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    public void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    public Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
