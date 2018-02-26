import java.util.Optional;

class ErrorHandling {

    void handleErrorByThrowingException() throws Exception {
        throw new Exception();
    }

    void handleErrorByThrowingExceptionWithDetailMessage(String message) throws Exception {
        throw new Exception(message);
    }

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
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
