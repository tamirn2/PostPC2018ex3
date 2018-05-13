package com.tamir.mythreadapp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class HandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        final TextView textView = findViewById(R.id.activity_thread_main_text_view);
//        MyThreadHandler thread;

        final HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        final Handler handler = new Handler(looper);
//        final ArrayList<MyThreadHandler> thread = new ArrayList<>();

        Button createButton = findViewById(R.id.activity_thread_create_button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                handler.post(new MyThreadHandler(textView));
            }
        });

        Button startButton = findViewById(R.id.activity_thread_start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                handlerThread.start();

            }
        });

        Button cancelButton = findViewById(R.id.activity_thread_cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });


    }
}
