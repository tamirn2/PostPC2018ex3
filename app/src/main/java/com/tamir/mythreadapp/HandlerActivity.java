package com.tamir.mythreadapp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        Button createButton = findViewById(R.id.activity_thread_create_button);
        Button startButton = findViewById(R.id.activity_thread_start_button);
        Button cancelButton = findViewById(R.id.activity_thread_cancel_button);
        final TextView mainTextView = findViewById(R.id.activity_thread_main_text_view);

        Looper mainLooper = Looper.getMainLooper();
        final Handler mainHandler = new Handler(mainLooper) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case (MyHandlerThread.WRITE_DONE):
                        mainTextView.setText("Done!");
                        break;
                    case (MyHandlerThread.WRITE_NUMBER):
                        mainTextView.setText(msg.obj.toString());
                        break;
                    case (MyHandlerThread.WRITE_CANCEL):
                        mainTextView.setText("Cancelled!");
                        break;
                }

            }
        };

        HandlerThread handlerThread = new HandlerThread("MyHandlerThread");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        final Handler handler = new Handler(looper);

        final MyHandlerThread[] thread = new MyHandlerThread[1];

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thread[0] == null) {
                    thread[0] = new MyHandlerThread(mainHandler);
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (thread[0] != null) {
                    handler.post(thread[0]);
                } else {
                    Snackbar.make(view, "No Thread created", 500).show();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thread[0] != null)
                {
                    thread[0].cancel();
                }
                else
                {
                    Snackbar.make(view, "No Thread created", 500).show();
                }

            }
        });


    }
}
