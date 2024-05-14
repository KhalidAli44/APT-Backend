package com.APT.Backend.Model;

public class MessageInfo {
    private int insertedIndex;
    private String insertedChar;
    private String sessionId;

    public MessageInfo() {
    }

    public int getInsertedIndex() {
        return insertedIndex;
    }

    public void setInsertedIndex(int insertedIndex) {
        this.insertedIndex = insertedIndex;
    }

    public String getInsertedChar() {
        return insertedChar;
    }

    public void setInsertedChar(String insertedChar) {
        this.insertedChar = insertedChar;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
