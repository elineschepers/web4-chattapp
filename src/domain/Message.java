package domain;

public class Message {

    private Person sender;
    private String message;

    public Message(Person sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public Person getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }


}
