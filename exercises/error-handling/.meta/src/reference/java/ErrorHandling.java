import java.util.Optional;

class ErrorHandling {

    public void handleErrorByThrowingException() throws Exception {
        throw new Exception();
    }

    public void handleErrorByThrowingExceptionWithDetailMessage(String message) throws Exception {
        throw new Exception(message);
    }

    public void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    public void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    public Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        if (tryParseInt(integer)) {
            return Optional.of(Integer.parseInt(integer));
        } else {
            return Optional.empty();
        }
    }

    private boolean tryParseInt(String integer) {
        try {
            Integer.parseInt(integer);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
