package com.APT.Backend.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.PriorityQueue;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // PriorityQueue to store timestamps along with other information
    private PriorityQueue<MessageInfo> messageQueue = new PriorityQueue<>();

    // Class to represent the message info
    private static class MessageInfo implements Comparable<MessageInfo> {
        private int insertedIndex;
        private char insertedChar;
        private long timeStamp;

        public MessageInfo(int insertedIndex, char insertedChar, long timeStamp) {
            this.insertedIndex = insertedIndex;
            this.insertedChar = insertedChar;
            this.timeStamp = timeStamp;
        }

        @Override
        public int compareTo(MessageInfo other) {
            // Compare based on timestamp
            return Long.compare(this.timeStamp, other.timeStamp);
        }
    }

    @MessageMapping("/operation/{documentId}")
    @SendTo("/all/broadcast/{documentId}")
    public String passMessage(final String message) {
        // Parse the message to extract insertedIndex, insertedChar, and timeStamp
        String[] parts = message.split("[\\(\\),\\s]+");
        int insertedIndex = Integer.parseInt(parts[1]);
        char insertedChar = parts[2].charAt(0); // Assuming insertedChar is a single character
        long timeStamp = Long.parseLong(parts[3]);

        // Create a new MessageInfo object and add it to the queue
        MessageInfo messageInfo = new MessageInfo(insertedIndex, insertedChar, timeStamp);
        messageQueue.offer(messageInfo);

        // You might want to process the queue here or elsewhere

        // You might also want to return something meaningful here

            return message;
        

        }
}
