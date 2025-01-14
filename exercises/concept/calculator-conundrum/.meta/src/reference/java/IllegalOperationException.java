public class IllegalOperationException extends RuntimeException {
    public IllegalOperationException(String errorMessage) {
        super(errorMessage);
    }

    public IllegalOperationException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
