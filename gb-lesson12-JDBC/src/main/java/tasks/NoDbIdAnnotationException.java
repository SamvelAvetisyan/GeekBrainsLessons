package tasks;

public class NoDbIdAnnotationException extends RuntimeException {
    public NoDbIdAnnotationException(){

    }
    public NoDbIdAnnotationException(String message) {
        super(message);
    }
}
