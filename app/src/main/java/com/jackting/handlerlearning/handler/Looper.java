package com.jackting.handlerlearning.handler;

public class Looper {
    static final ThreadLocal<Looper> sThreadLocal= new ThreadLocal<>();
    final MessageQueue mQueue;

    private Looper(){
        mQueue=new MessageQueue();
    }

    public static Looper myLooper(){
        return sThreadLocal.get();
    }

    public static void prepare(){
        if(sThreadLocal.get()!=null){
            throw new RuntimeException("Looper prepare exception");
        }
        sThreadLocal.set(new Looper());
    }

    public static MessageQueue myQueue(){
        return myLooper().mQueue;
    }

    public static void loop(){
        final Looper me=myLooper();
        final MessageQueue queue=me.mQueue;
        for(;;){
            Message message=queue.next();
            if(message!=null){
                message.target.dispatchMessage(message);
            }
        }
    }
}
