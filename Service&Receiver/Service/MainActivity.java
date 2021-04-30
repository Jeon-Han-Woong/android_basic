package org.ict.musicplayprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 음악 파일을 받아올 인텐트 생성
    Intent intent;
    // 버튼 변수 생성
    Button btnStart, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.musicStartBtn);
        btnEnd = (Button) findViewById(R.id.musicEndBtn);

        // 인텐트의 목적지는 MusicService
        intent = new Intent(this, MusicService.class);

        // startService() 함수에 인텐트를 파라미터로 넘겨주면 실행.
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.util.Log.i("노래 시작", "onStart()");
                startService(intent);
            }
        });

        // stopService() 함수 호출시 재생 멈춤.
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });

    }
}