package com.jackting.handlerlearning;

import com.jackting.handlerlearning.handler.Handler;
import com.jackting.handlerlearning.handler.Looper;
import com.jackting.handlerlearning.handler.Message;

import java.util.UUID;

public class TestMain {

//    private Handler handler;

    public static void main(String[] args){
        Looper.prepare();
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                System.out.println("handleMessage:"+msg.toString()+"");
            }
        };


        new Thread(new Runnable(){
            @Override
            public void run() {
                int index=0;
                while (true){
                    Message msg=new Message(index+":"+UUID.randomUUID().toString());
                    System.out.println(index+":"+Thread.currentThread().toString());
                    handler.sendMessage(msg);

                    index++;
                    if(index>10){
                        break;
                    }
                }
            }
        }).start();

        Looper.loop();
    }


}
