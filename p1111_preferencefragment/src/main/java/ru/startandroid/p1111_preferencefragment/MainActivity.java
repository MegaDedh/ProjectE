package ru.startandroid.p1111_preferencefragment;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends PreferenceActivity {

    //Чтобы заработало, добавьте в MainActivity метод:
    protected boolean isValidFragment (String fragmentName){
        return true;
    }
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_head, target);
        //Чтобы программно определить, будет экран делиться на две части или нет, можно использовать метод isMultiPane.
        // ЧЕГО-ТО НЕ РАБОТАЕТ(
        Log.d("myLogs", Boolean.toString(this.isMultiPane()));
    }
}