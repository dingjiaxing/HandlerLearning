package com.jackting.handlerlearning.handler;

public class Handler {

    final Looper mLooper;
    final MessageQueue mQueue;

    public Handler(){
        mLooper=Looper.myLooper();

        mQueue=mLooper.mQueue;
    }
    //发送消息
    public void sendMessage(Message msg){
        enqueueMessage(msg);
    }

    private void enqueueMessage(Message msg) {
        msg.target=this;
        mQueue.enqueueMessage(msg);
    }
    //最少知识原则
    public void dispatchMessage(Message msg){
        handleMessage(msg);
    }

    public void handleMessage(Message msg) {
    }
}
