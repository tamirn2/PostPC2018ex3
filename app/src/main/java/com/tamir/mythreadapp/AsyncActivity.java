package com.tamir.mythreadapp;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class AsyncActivity extends AppCompatActivity {

    private TextView mainTextView;
    private LinkedList<MyAsync> myAsyncTasks;


    protected void updateMainText(Integer progress)
    {
        if (progress == -1)
        {
            mainTextView.setText("Done!");
            myAsyncTasks.removeFirst();
        }
        else if (progress == 0)
        {
            mainTextView.setText("Cancelled!");
            myAsyncTasks.removeFirst();
        }
        else
        {
            mainTextView.setText(progress.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        Button createButton = findViewById(R.id.activity_thread_create_button);
        Button startButton = findViewById(R.id.activity_thread_start_button);
        Button cancelButton = findViewById(R.id.activity_thread_cancel_button);
        mainTextView = findViewById(R.id.activity_thread_main_text_view);
        final Activity activityContext = this;
        myAsyncTasks = new LinkedList<>();


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                myAsyncTasks.add(new MyAsync((AsyncActivity) activityContext));
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (!myAsyncTasks.isEmpty())
                {
                    MyAsync curTask = myAsyncTasks.getFirst();
                    curTask.execute();
                }
                else
                {
                    Snackbar.make(view, "No Thread created", 500).show();
                }

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                myAsyncTasks.getFirst().cancel(true);
            }
        });

    }
}
