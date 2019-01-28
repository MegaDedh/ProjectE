package ru.startandroid.youtime;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    TextView top_title;          //Заголовок Сегодня уже...
    TextView pastDaysOfYear;     //дни года
    TextView pastHoursOfYear;    //часы года
    TextView pastMinutesOfYear;  //минуты года
    TextView pastSecondsOfYear;  //секунды года
    TextView pastDaysOfMonth;    //ДЕНЬ МЕСЯЦА
    TextView pastDaysOfWeek;     //ДЕНЬ НЕДЕЛИ
    TextView pastHoursOfDay;     //ЧАС
    TextView pastMinutesOfHour;  //МИНУТА
    TextView pastSecondsOfMinute;//СЕКУНДА


    ProgressBar pBarPastDaysOfYear; // ПБ ушедших дней года
    ProgressBar pBarPastDaysOfMonth; // ПБ ушедших дней месяца
    ProgressBar pBarPastDaysOfWeek; // ПБ ушедших дней недели
    ProgressBar pBarPastHoursOfDay; // ПБ ушедших часов суток
    ProgressBar pBarPastMinutesOfHour; // ПБ ушедших минут часа
    ProgressBar pBarPastSecondsOfMinute; // ПБ ушедших секунд минуты

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top_title = (TextView) findViewById(R.id.txtTop_title);
        //ГОД
        pastDaysOfYear = (TextView) findViewById(R.id.txtPastDaysOfYear);
        pastHoursOfYear = (TextView) findViewById(R.id.txtPastHoursOfYear);
        pastMinutesOfYear = (TextView) findViewById(R.id.txtPastMinutesOfYear);
        pastSecondsOfYear = (TextView) findViewById(R.id.txtPastSecondsOfYear);
        //МЕСЯЦ
        pastDaysOfMonth = (TextView) findViewById(R.id.txtPastDaysOfMonth);
        //НЕДЕЛЯ
        pastDaysOfWeek = (TextView) findViewById(R.id.txtPastDaysOfWeek);
        //СУТКИ
        pastHoursOfDay = (TextView) findViewById(R.id.txtPastHoursOfDay);
        //ЧАС
        pastMinutesOfHour = (TextView) findViewById(R.id.txtPastMinutesOfHour);
        //МИНУТА
        pastSecondsOfMinute = (TextView) findViewById(R.id.txtPastSeсondsOfMinute);

        //ПРОГРЕССБАРЫ
        pBarPastDaysOfYear = (ProgressBar) findViewById(R.id.pbPastDaysOfYear); // ПБ ушедших дней года
        pBarPastDaysOfMonth = (ProgressBar) findViewById(R.id.pbPastDaysOfMonth); // ПБ ушедших дней месяца
        pBarPastDaysOfWeek = (ProgressBar) findViewById(R.id.pbPastDaysOfWeek); // ПБ ушедших дней недели
        pBarPastHoursOfDay = (ProgressBar) findViewById(R.id.pbPastHoursOfDay); // ПБ ушедших часов суток
        pBarPastMinutesOfHour = (ProgressBar) findViewById(R.id.pbPastMinutesOfHour); // ПБ ушедших минут часа
        pBarPastSecondsOfMinute = (ProgressBar) findViewById(R.id.pbPastSeсondsOfMinute); // ПБ ушедших секунд минуты


    }


    @Override
    protected void onResume() {
        super.onResume();
        startTimer();
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {

      Calendar cal = Calendar.getInstance();
            int nowDayOfYear = cal.get(Calendar.DAY_OF_YEAR); // год
            int nowYear = cal.get(Calendar.YEAR); // год
            int nowMonth = cal.get(Calendar.MONTH); // месяц
            int nowDayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // день недели
            int nowDayOfMonth = cal.get(Calendar.DAY_OF_MONTH); // день месяца
            int nowHourOfDay = cal.get(Calendar.HOUR_OF_DAY); // час суток
            int nowMinute = cal.get(Calendar.MINUTE); // минуты
            int nowSeconds = cal.get(Calendar.SECOND); // секунды
            int nowMaxDaysOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // последний (максимальный) день в текущем месяце
            String[] rusMonthNames = {"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};


            String date1 = "31.12." + (nowYear-1);
            //    String date2 = "01.02.2019";

            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

            Date dateOne = null;
            //   Date dateTwo = null;


            try {
                dateOne = format.parse(date1);
                //    dateTwo = format.parse(date2);
            } catch (Exception e) {
                e.printStackTrace();
            }


            long dateTwo = System.currentTimeMillis();
            // Количество дней между датами в миллисекундах
            long difference = dateTwo - dateOne.getTime();


            //long days = TimeUnit.MILLISECONDS.toDays(difference);
            long pHoursOfYear = TimeUnit.MILLISECONDS.toHours(difference);
            long pMinutesOfYear = TimeUnit.MILLISECONDS.toMinutes(difference);
            long pSecondsOfYear = TimeUnit.MILLISECONDS.toSeconds(difference);
//      Toast.makeText(this,Long.toString(seconds), Toast.LENGTH_SHORT).show();
//      Toast.makeText(this,Integer.toString(nowMaxDaysOfMonth), Toast.LENGTH_SHORT).show();



           top_title.setText(getString(R.string.top_title, nowDayOfMonth, rusMonthNames[nowMonth]));

             //ГОД
            pBarPastDaysOfYear.setProgress(nowDayOfYear); // значение ПБ = текущей день в году
            pastDaysOfYear.setText(getString(R.string.days_past, nowDayOfYear));
            pastHoursOfYear.setText(getString(R.string.hours_past, pHoursOfYear));
            pastMinutesOfYear.setText(getString(R.string.minutes_past, pMinutesOfYear));
            pastSecondsOfYear.setText(getString(R.string.seconds_past, pSecondsOfYear));
            //МЕСЯЦ
            pBarPastDaysOfMonth.setMax(nowMaxDaysOfMonth); // максимум прогрессбара = последнему дню в текущем месяце
            pBarPastDaysOfMonth.setProgress(nowDayOfMonth); // значение ПБ = текущей день месяца
            pastDaysOfMonth.setText(getString(R.string.days_past, nowDayOfMonth));
            //НЕДЕЛЯ
            pBarPastDaysOfWeek.setProgress(nowDayOfWeek);
            pastDaysOfWeek.setText(getString(R.string.days_past, nowDayOfWeek));
            //СУТКИ
            pBarPastHoursOfDay.setProgress(nowHourOfDay);
            pastHoursOfDay.setText(getString(R.string.hours_past, nowHourOfDay));
            //ЧАС
            pBarPastMinutesOfHour.setProgress(nowMinute);
            pastMinutesOfHour.setText(getString(R.string.minutes_past, nowMinute));
            //МИНУТА
            pBarPastSecondsOfMinute.setProgress(nowSeconds);
            pastSecondsOfMinute.setText(getString(R.string.seconds_past, nowSeconds));




            startTimer();
        }
    };


    public void startTimer() {
        handler.postDelayed(runnable, 1000);
    }

    public void cancelTimer() {
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }


}