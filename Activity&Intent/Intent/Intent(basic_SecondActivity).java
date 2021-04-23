package org.ict.activity1prj;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// 액티비티로 활용시 Activity 클래스나 Activity의 자식 클래스를 무조건 상속받아야 함.
public class SecondActivity extends AppCompatActivity {

    Button btnReturn;

    //onCreate 치고 자동완성시키면 (protected void로) 아래와 같이 자동완성
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        btnReturn = (Button) findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
