public class UnreachableGoalException extends RuntimeException {
    
    public UnreachableGoalException() {
        super();
    }

    public UnreachableGoalException(String message) {
        super(message);
    }

    public UnreachableGoalException(String message, Throwable cause) {
        super(message, cause);
    }
}
