package tasks;

public class NoDbTableAnnotationException extends RuntimeException {
    public NoDbTableAnnotationException() {
    }
    public NoDbTableAnnotationException(String message) {
        super(message);
    }
}
