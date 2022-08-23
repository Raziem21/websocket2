package co.develhope.websocket2.entities;

public class MessageFromClient {

    private String from;
    private String text;

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
