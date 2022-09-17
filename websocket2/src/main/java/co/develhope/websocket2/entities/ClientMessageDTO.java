package co.develhope.websocket2.entities;

import lombok.Data;

@Data
public class ClientMessageDTO {

    private String clientName;
    private String clientAlert;
    private String clientMsg;
}
