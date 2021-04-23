package org.ict.interactactivityprj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button goSecond;

    EditText edtNum1, edtNum2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goSecond = (Button) findViewById(R.id.goSecond);

        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);

        goSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                intent.putExtra("num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edtNum2.getText().toString()));

                // startActivityForResult(intent, int i);
                // 상호작용이 가능하게 발송
                // 돌려받을 값이 있는 경우에만, 2번째 파라미터에 양수 or 0을 받음.
                startActivityForResult(intent, 0);
            }
        });

    }

    // 타 액티비티에서 데이터를 전송받았을 때 실행
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            // get자료형extra로 데이터를 받아올때 파라미터를 2개 입력하면
            // 두 번째 파라미터는 디폴트값을 지정.
            int sum = data.getIntExtra("sum", 0);
            Toast.makeText(getApplicationContext(), "합계: " + sum, Toast.LENGTH_SHORT).show();
        }
    }
}