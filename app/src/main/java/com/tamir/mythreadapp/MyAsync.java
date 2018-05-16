package com.tamir.mythreadapp;

import android.app.Activity;
import android.os.AsyncTask;

import static java.lang.Thread.sleep;

public class MyAsync extends AsyncTask<AsyncActivity, Integer, Integer> {
    AsyncActivity rootActivity;

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        rootActivity.updateMainText(values[0]);
    }

    @Override
    protected Integer doInBackground(AsyncActivity... asyncActivities) {
        rootActivity = asyncActivities[0];

        for (Integer i = 1; i < 11; i++)
        {
            if(isCancelled())
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
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        rootActivity.updateMainText(integer);
    }
}
