package ru.startandroid.p1101_dialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DialogFragment;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DialogFragment dlg1;
    DialogFragment dlg2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        dlg1 = new Dialog1();
        dlg2 = new Dialog2();
        dlg1.setCancelable(false); // Если вы не хотите, чтобы ваш диалог можно было закрыть кнопкой back
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDlg1:
                dlg1.show(getFragmentManager(), "dlg1");
                break;
            case R.id.btnDlg2:
                dlg2.show(getFragmentManager(), "dlg2");
                break;
            default:
                break;
        }

    }
}