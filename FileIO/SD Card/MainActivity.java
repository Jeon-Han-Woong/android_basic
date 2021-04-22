package org.ict.sdfileioprj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class MainActivity extends AppCompatActivity {

    Button readBtn;
    EditText sdEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readBtn = (Button) findViewById(R.id.readBtn);
        sdEdt = (EditText) findViewById(R.id.sdEdt);

        // 권한 허용 설정
        ActivityCompat.requestPermissions(this, new String[] {
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}
                , MODE_PRIVATE);

        // 루트 폴더 절대 경로 얻어오기
        final String strSDpath =
                Environment.getExternalStorageDirectory().getAbsolutePath();

        String fileName = "test.txt";

       readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // File IO는 try~catch 내부에 작성.
                try {
                    // InputFileStream이 에러가 나는 경우
                    // 대체 코드를 작성
                    // 파일 객체 생성
                    File file = new File(strSDpath, fileName);
                    // 파일 내용 읽기
                    // BufferReader 객체를 생성해 파일 내용을 reader에 저장.
                    BufferedReader reader = new BufferedReader(new FileReader(file));

                    // BufferedReader는 한 줄 한 줄 단위로 읽어오기 때문에
                    // 반복문을 이용해 모든 줄을 저장.
                    String result = "";
                    String line;
                    while((line = reader.readLine()) != null) {
                        result += line;
                    }
                    // 읽어온 내용을 토스트로 디버깅
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getApplicationContext(), "ㅎㅎ", Toast.LENGTH_SHORT).show();
//                    FileInputStream inFs = new FileInputStream(
//                            fileName);
//
//                    byte [] txt = new byte[inFs.available()];
//
//                    inFs.read(txt);
//
//                    sdEdt.setText(new String(txt));
//
//                    inFs.close();

                } catch (Exception e) {
                }
            }
        });
    }
}