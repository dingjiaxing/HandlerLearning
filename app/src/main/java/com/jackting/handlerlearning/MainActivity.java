package com.jackting.handlerlearning;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tv);

        createHandler();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendMessage(Message.obtain());
            }
        },5000);

    }

    private void createHandler(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                handler=new Handler(Looper.myLooper(), new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message message) {
//                        Toast.makeText(MainActivity.this,"handleMessage",Toast.LENGTH_SHORT).show();
//                        textView.setText("Message");
                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText("handleMessage");
                            }
                        });

                        return false;
                    }
                });
                Looper.loop();


            }
        }.start();
    }
}
