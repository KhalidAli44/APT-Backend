package com.APT.Backend.Web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/operation")
    @SendTo("/all/broadcast")
    public String greeting(String message) {
        return "Hello, " + message;
    }
}
