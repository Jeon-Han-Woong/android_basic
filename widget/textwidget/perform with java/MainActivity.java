package org.ict.widgetprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        textView1.setText("안녕? 난 1번 TextView!");
        textView1.setTextColor(Color.RED);

        textView2.setTextSize(30);
        textView2.setTypeface(Typeface.SERIF, Typeface.ITALIC);

        textView3.setText("공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. 공격은 최선의 방어, 방어는 최선의 공격. ");
        textView3.setSingleLine();

    }
}