package co.develhope.websocket2.entities;

public class SimpleMessageDTO {

    private String sender;
    private String content;

    private String type;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public SimpleMessageDTO() {

    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public SimpleMessageDTO(String content, String type, String sender) {
        this.content = content;
        this.type = type;
        this.sender = sender;
    }
}
