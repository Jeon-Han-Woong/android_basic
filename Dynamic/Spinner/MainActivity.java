package org.ict.spinnerprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;

    String[] items = {"아이템1", "아이템2", "아이템3", "아이템4", "아이템5", "아이템6", "아이템7", "아이템8"
            , "아이템9", "아이템10", "아이템11", "아이템12", "아이템13", "아이템14", "아이템15"};

    ImageView img;
    TextView text;

    Integer[] imgId = {R.drawable.america2, R.drawable.america3, R.drawable.japan1, R.drawable.japan2, R.drawable.korea3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        img = (ImageView) findViewById(R.id.img);
        text = (TextView) findViewById(R.id.textview1);

        String [] cont = new String[items.length];

        for (int i = 0; i < items.length; i++) {
            cont[i] = "설명입니다 " + (i + 1);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                img.setImageResource(imgId[i%5]);
                text.setText(cont[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}