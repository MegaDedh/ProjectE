package ru.startandroid.p1111_preferencefragment;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends PreferenceActivity {

    //Чтобы заработало, добавьте в MainActivity метод:
    protected boolean isValidFragment (String fragmentName){
        return true;
    }
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_head, target);
    }
}