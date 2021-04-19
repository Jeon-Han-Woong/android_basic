package org.ict.bookingapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton dateRadio, timeRadio;
    CalendarView date;
    TimePicker time;
    Chronometer chronoTime;
    int selectYear, selectMonth, selectDay, selectHour, selectMinute;
    String daytime;
    LinearLayout frameset;

    TextView[] textList = new TextView[6];
    Integer[] yourtext = {(R.id.textYear), (R.id.textMonth), (R.id.textDay), (R.id.aandr), (R.id.textHour), (R.id.textMinute)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        dateRadio = (RadioButton) findViewById(R.id.dateRadio);
        timeRadio = (RadioButton) findViewById(R.id.timeRadio);
        date = (CalendarView) findViewById(R.id.myDate);
        time = (TimePicker) findViewById(R.id.myTime);
        chronoTime = (Chronometer) findViewById(R.id.chronoTime);
        frameset = (LinearLayout) findViewById(R.id.frameset);

        date.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);
        radioGroup.setVisibility(View.INVISIBLE);


        for (int i = 0; i < yourtext.length; i ++) {
            textList[i] = (TextView) findViewById(yourtext[i]);
        }

        chronoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronoTime.setBase(SystemClock.elapsedRealtime());
                chronoTime.start();
                chronoTime.setTextColor(Color.RED);
                radioGroup.setVisibility(View.VISIBLE);
                frameset.setVisibility(View.VISIBLE);
            }
        });


        // 크로노미터를 초기화시키고 실행, 색상도 변경
       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronoTime.setBase(SystemClock.elapsedRealtime());
                chronoTime.start();
                chronoTime.setTextColor(Color.RED);
            }
        }); */

        // 날짜 선택시
        dateRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);
            }
        });
        // 시간 선택시
        timeRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);
            }
        });

        textList[0].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                chronoTime.stop();
                chronoTime.setTextColor(Color.BLUE);
                textList[0].setText("" + selectYear + "년");
                textList[1].setText("" + selectMonth + "월");
                textList[2].setText("" + selectDay + "일");

                daytime = "오전";
                selectHour = time.getHour();
                if(selectHour > 11) {
                    daytime = "오후";
                    if (selectHour != 12){
                        selectHour = time.getHour() - 12;
                    }
                } else if (selectHour == 0) {
                    selectHour = 12;
                }

                textList[3].setText("" + daytime);
                textList[4].setText("" + selectHour + "시");
                textList[5].setText("" + time.getMinute() + "분");

                String str = textList[0].getText().toString() + " " + textList[1].getText().toString() + " " + textList[2].getText().toString() + " " +
                        textList[3].getText().toString() + " " + textList[4].getText().toString() + " " + textList[5].getText().toString();

                Toast.makeText(getApplicationContext(), "예약 시간 : " + str, Toast.LENGTH_SHORT).show();

                radioGroup.setVisibility(View.INVISIBLE);
                frameset.setVisibility(View.INVISIBLE);
            }
        });

        /*
        // 정지버튼이 눌리면 크로노미터를 멈추고 색상 변경
        btn2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                chronoTime.stop();
                chronoTime.setTextColor(Color.BLUE);
                textList[0].setText("" + selectYear + "년");
                textList[1].setText("" + selectMonth + "월");
                textList[2].setText("" + selectDay + "일");

                daytime = "AM";
                selectHour = time.getHour();
                if(selectHour > 11) {
                    daytime = "PM";
                    if (selectHour != 12){
                        selectHour = time.getHour() - 12;
                    }
                } else if (selectHour == 0) {
                    selectHour = 12;
                }

                textList[3].setText("" + daytime);
                textList[4].setText("" + selectHour + "시");
                textList[5].setText("" + time.getMinute() + "분");

                String str = textList[0].getText().toString() + " " + textList[1].getText().toString() + " " + textList[2].getText().toString() + " " +
                        textList[3].getText().toString() + " " + textList[4].getText().toString() + " " + textList[5].getText().toString();

                Toast.makeText(getApplicationContext(), "예약 시간 : " + str, Toast.LENGTH_SHORT).show();
            }
        });
         */

        date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView,
                                            // 첫 번째 파라미터는 연도,
                                            // 두 번째 파라미터는 월,
                                            // 세 번째 파라미터는 일
                                            int year, int month, int day) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = day;
            }
        });


    }
}