package co.develhope.websocket2.controllers;

import co.develhope.websocket2.entities.ClientMessageDTO;
import co.develhope.websocket2.entities.SimpleMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notification")
    public ResponseEntity sendNotificationToClients(@RequestBody SimpleMessageDTO simpleMessageDTO) {
        simpMessagingTemplate.convertAndSend("/topic/messages", simpleMessageDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @MessageMapping("/client-message")
    @SendTo("/topic/messages")
    public SimpleMessageDTO handleMessageFromWebSocket(ClientMessageDTO clientMessageDTO) {
        System.out.println("something arrived");
        return new SimpleMessageDTO(clientMessageDTO.getClientMsg(), clientMessageDTO.getClientAlert(), clientMessageDTO.getClientName());
    }
}
