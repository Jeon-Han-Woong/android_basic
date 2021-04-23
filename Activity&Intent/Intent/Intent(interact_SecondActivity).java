package org.ict.interactactivityprj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button goBack;
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        goBack = (Button) findViewById(R.id.goBack);
        tv = (TextView) findViewById(R.id.myText);

        Intent intent = getIntent();

        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);

        int result = num1 + num2;

        tv.setText(String.valueOf(result));

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);

                intent1.putExtra("sum", result);

                setResult(RESULT_OK, intent1);

                finish();
            }
        });
    }
}
