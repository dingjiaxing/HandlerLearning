package com.jackting.handlerlearning.handler;

public class Message {
    String obj;
    public Handler target;

    public Message(String object){
        obj=object;
    }

    @Override
    public String toString() {
        return obj.toString();
//        return super.toString();
    }
}
