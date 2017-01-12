package com.example.daniel.eventbus_example.POJOevent;

public class MessageEvent {

    public String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
