package com.tamir.mythreadapp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import static java.lang.Thread.sleep;

public class MyThreadHandler extends HandlerThread
{

    private WeakReference<Handler> handler;

    public MyThreadHandler(String name, Handler handler) {
        super(name);
        this.handler = new WeakReference<>(handler);
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

        this.handler.get().sendEmptyMessage(0);
    }

}
