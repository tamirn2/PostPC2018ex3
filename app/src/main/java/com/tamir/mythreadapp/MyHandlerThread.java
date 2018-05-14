package com.tamir.mythreadapp;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import static java.lang.Thread.sleep;

class MyHandlerThread extends Thread {

    static final int WRITE_DONE = 0;
    static final int WRITE_NUMBER = 1;
    static final int WRITE_CANCEL = 2;

    boolean stopRunning = false;

    private WeakReference<Handler> handler;

    protected MyHandlerThread(Handler handler) {
        this.handler = new WeakReference<>(handler);
    }

    public void cancel()
    {
        stopRunning = true;
    }

    @Override
    public void run() {
        stopRunning = false;
        for (Integer i = 1; i < 11; i++) {
            if(stopRunning)
            {
                break;
            }
            try
            {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Message msg = this.handler.get().obtainMessage(WRITE_NUMBER, i.toString());
            this.handler.get().sendMessage(msg);
        }
        if (stopRunning) this.handler.get().sendEmptyMessage(WRITE_CANCEL);
        else this.handler.get().sendEmptyMessage(WRITE_DONE);


    }
}
