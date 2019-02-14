package ru.startandroid.p1161_mngtasks1;

import android.support.v7.app.AppCompatActivity;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public abstract class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    List<ActivityManager.AppTask> list;
    ActivityManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());
        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
    }

    public void onInfoClick(View v) {
        list = am. getAppTasks();
        for (ActivityManager.AppTask task : list) {
            if (task.getTaskInfo().baseActivity.flattenToShortString().startsWith("ru.startandroid.p116")){
                Log.d(LOG_TAG, "------------------");
                Log.d(LOG_TAG, "Count: " + task.getTaskInfo().numActivities);
                Log.d(LOG_TAG, "Root: " + task.getTaskInfo().baseActivity.flattenToShortString());
                Log.d(LOG_TAG, "Top: " + task.getTaskInfo().topActivity.flattenToShortString());
            }
        }
    }

    abstract public void onClick(View v);
}