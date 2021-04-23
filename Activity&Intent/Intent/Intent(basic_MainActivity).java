package org.ict.activity1prj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// 액티비티는 기본적으로 Activity나, Activity를 상속받은 클래스를 재상속해 만듬.
// AppCompatActivity 역시 Activity로 분류되지만, 명확한 설명을 위해
// 정확히 Activity를 상속.
public class MainActivity extends AppCompatActivity {

    Button btnActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity = (Button) findViewById(R.id.btnActivity);

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 목적지 정보 저장
                // 1번 파라미터에 현재 액티비티 정보를 입력(getApplicationContext())
                // 2번 파라미터에 목적지 액티비티 클래스명을 입력
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                // startActivity에 목적지 객체를 입력하면 이동
                // manifests에도 SecondActivity에 대한 정보를 등록해야
                // 그 때부터 액티비티가 등장
                startActivity(intent);
            }
        });
    }
}