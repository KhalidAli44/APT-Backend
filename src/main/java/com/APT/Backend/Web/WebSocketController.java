package com.APT.Backend.Web;

import com.APT.Backend.Model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/operation/{documentId}")
    @SendTo("/all/broadcast/{documentId}")
    public MessageInfo passMessage(final MessageInfo message) {
            return message;
    }
}
