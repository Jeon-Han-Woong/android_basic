package org.ict.rawfileioprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button getRawBtn;
    EditText edtRaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRawBtn = (Button) findViewById(R.id.getRawBtn);
        edtRaw = (EditText) findViewById(R.id.edtRaw);

        getRawBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // raw 폴더내부의 리소스를 가져오는 메서드는 고정.
                    // openRawResource() 내부에 R.raw. 파일명 형식을 넣어 가져옴.
                    InputStream inputS = getResources().openRawResource(R.raw.test);
                    // available()는 파일 크기만큼 정확하게 파일크기를 만듬.
                    byte[] txt = new byte[inputS.available()];

                    inputS.read(txt);

                    edtRaw.setText(new String(txt));

                    inputS.close();
                } catch (Exception e) {

                }
            }
        });
    }
}