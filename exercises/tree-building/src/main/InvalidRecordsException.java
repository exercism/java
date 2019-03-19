public class InvalidRecordsException extends Exception {
    private String message;

    public InvalidRecordsException(String msg) {
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
