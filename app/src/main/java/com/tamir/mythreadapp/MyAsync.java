package com.tamir.mythreadapp;

import android.app.Activity;
import android.os.AsyncTask;

import static java.lang.Thread.sleep;

public class MyAsync extends AsyncTask<Void, Integer, Integer> {
    AsyncActivity rootActivity;

    protected MyAsync(AsyncActivity rootActivity)
    {
        this.rootActivity = rootActivity;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        rootActivity.updateMainText(values[0]);
    }

    @Override
    protected Integer doInBackground(Void... voids) {

        for (Integer i = 1; i < 11; i++)
        {
            if (isCancelled())
            {
                return 0;
            }
            publishProgress(i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return -1;
    }

    @Override
    protected void onCancelled(Integer integer) {
        super.onCancelled(integer);
        rootActivity.updateMainText(integer);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        rootActivity.updateMainText(integer);
    }
}
