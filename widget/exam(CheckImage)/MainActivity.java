package org.ict.HelloAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1;
    RadioGroup radio1;
    RadioButton man, woman, not;
    ImageView img;
    CheckBox setchk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("성별 고르기");

        btn1 = (Button) findViewById(R.id.choice);
        radio1 = (RadioGroup) findViewById(R.id.animalGroup);
        man = (RadioButton) findViewById(R.id.manbtn);
        woman = (RadioButton) findViewById(R.id.womanbtn);
        not = (RadioButton) findViewById(R.id.notbtn);
        img = (ImageView) findViewById(R.id.yourchoice);
        setchk = (CheckBox) findViewById(R.id.setchkbox);
        tv1 = (TextView) findViewById(R.id.infoRadio);

        setchk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    radio1.setVisibility(View.VISIBLE);
                    tv1.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                } else {
                    radio1.setVisibility(View.INVISIBLE);
                    tv1.setVisibility(View.INVISIBLE);
                    btn1.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radio1.getCheckedRadioButtonId() == (R.id.manbtn)){
                    img.setImageResource(R.drawable.male);
                } else if (radio1.getCheckedRadioButtonId() == (R.id.womanbtn)){
                    img.setImageResource(R.drawable.female);
                } else if (radio1.getCheckedRadioButtonId() == (R.id.notbtn)){
                    img.setImageResource(R.drawable.what);
                }
            }
        });


    }

}