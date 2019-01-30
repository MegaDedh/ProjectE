package ru.startandroid.p1061_fragmentactivity;

import android.support.v7.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Fragment frag2 = new Fragment2();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment2, frag2);
        ft.commit();
    }
}