package com.tamir.mythreadapp;

import android.os.SystemClock;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import static java.lang.Thread.sleep;

public class MyThreadHandler implements Runnable {

    private WeakReference<TextView> mTextView;

    protected MyThreadHandler(TextView textView)
    {
        super();
        this.mTextView = new WeakReference<>(textView);
    }

    @Override
    public void run()
    {
        Long time = SystemClock.elapsedRealtime();
        for (int i = 0; i < 10; i++)
        {

        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long endTime = SystemClock.elapsedRealtime() - time;
        this.mTextView.get().setText(endTime.toString());
//        MainActivity.this.onResult();
    }

//    public MyThreadHandler(String name, TextView textView)
//    {
//        super(name);
//        this.textView = textView;
//    }
//
//    @Override
//    public void run() {
//        Long time = SystemClock.elapsedRealtime();
//        for (int i = 0; i < 10; i++)
//        {
//
//        }
//        try {
//            sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Long endTime = SystemClock.elapsedRealtime() - time;
//        this.textView.setText(endTime.toString());
//    }
}
