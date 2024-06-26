package com.APT.Backend.Web;

import com.APT.Backend.Model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
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


    private final Object mutex = new Object();
    private int lock = 0;

    @MessageMapping("/operation/{documentId}")
    public void passMessage(final MessageInfo message, @DestinationVariable String documentId) {
        synchronized(mutex) {
            if (lock == 0) {
                lock = 1;
            } else {
                return;
            }
        }
        messagingTemplate.convertAndSend("/all/broadcast/" + documentId, message);
        synchronized(mutex) {
            lock = 0;
        }

    }
}
