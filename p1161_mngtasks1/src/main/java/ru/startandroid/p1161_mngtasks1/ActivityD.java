package ru.startandroid.p1161_mngtasks1;

import android.content.Intent;
import android.view.View;

public class ActivityD extends MainActivity {
    public void onClick(View v) {
        startActivity(new Intent(this, ActivityD.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}