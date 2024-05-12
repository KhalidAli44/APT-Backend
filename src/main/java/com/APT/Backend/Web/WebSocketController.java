package com.APT.Backend.Web;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/operation/{documentId}")
    @SendTo("/all/broadcast/{documentId}")
    public String passMessage(@DestinationVariable String documentId, String message) {
        return "Hello, " + message;
    }
}
