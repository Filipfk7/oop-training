package inheritance;

public class FailedMessage extends Message {

    private final Exception exception;

    public FailedMessage(Exception exception) {
        super(MessageType.FAILED);
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
