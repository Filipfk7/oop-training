package Inheritance;

import java.util.ArrayList;
import java.util.List;

public class MessageApplication {

    private final static List<Message> messages = new ArrayList<>();

    public static void main(String[] args) {
        Message failed = new FailedMessage(new NullPointerException());
        Message success = new SuccessMessage("HELLO");
        Message message = new Message(MessageType.TEST);

        addMessage(failed);
        addMessage(success);
        addMessage(message);

        messages.stream()
                .map(Message::getMessageType)
                .forEach(System.out::println);
    }

    private static<T extends Message> void addMessage(T message) {
        messages.add(message);
    }
}
