package com.jackting.handlerlearning.handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//时间片
public class MessageQueue {

    //阻塞队列，模拟MessageQueue
    BlockingQueue<Message> queue=new ArrayBlockingQueue<>(10);

    public void enqueueMessage(Message msg) {
        try {
            queue.put(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Message next() {
        Message message=null;
        try {
            message=queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;
    }
}
