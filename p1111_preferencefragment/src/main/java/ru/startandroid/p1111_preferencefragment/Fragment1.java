package ru.startandroid.p1111_preferencefragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;

public class Fragment1 extends PreferenceFragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref1);

    }
}