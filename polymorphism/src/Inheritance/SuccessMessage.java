package Inheritance;

public class SuccessMessage extends Message {

    private final String text;

    public SuccessMessage(String text) {
        super(MessageType.SUCCESS);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
