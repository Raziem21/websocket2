package co.develhope.websocket2.controllers;

import co.develhope.websocket2.entities.MessageFromClient;
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
public class Notification {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notification")
    public ResponseEntity sendNotificationToClient(@RequestBody SimpleMessageDTO simpleMessageDTO) {
        simpMessagingTemplate.convertAndSend("/topic/messages",simpleMessageDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public SimpleMessageDTO handleMessageFromWebSocket(MessageFromClient message) {
        System.out.println("Arrived something on /app/hello " + message.toString());
        return new SimpleMessageDTO("Message from server", message.getFrom() + " - " + message.getText(), "Postman");
    }
}
