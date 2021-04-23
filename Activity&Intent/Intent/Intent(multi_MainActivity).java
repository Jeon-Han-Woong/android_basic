package org.ict.activity2prj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    RadioGroup radioGroup;
    RadioButton second, third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = (Button) findViewById(R.id.btnGo);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        second = (RadioButton) findViewById(R.id.second);
        third = (RadioButton) findViewById(R.id.third);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if(second.isChecked()) {
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                } else if (third.isChecked()) {
                    intent = new Intent(getApplicationContext(), ThirdActivity.class);
                } else {
                    Toast.makeText(getApplicationContext(), "어디로 갈거야?", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
            }
        });



    }
}