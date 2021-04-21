package org.ict.fileioprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button outBtn, inBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outBtn = (Button) findViewById(R.id.outBtn);
        inBtn = (Button) findViewById(R.id.inBtn);

        outBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 파일 입출력은 예외가 발생할 가능성이 높기 때문에
                // 반드시 try~catch문을 적용.
                try {
                    // 내장 메모리에 파일을 쓰기 위해 file.txt라는 파일을
                    // 메모리상에 생성.
                    // 아래 코드가 실행된 시점부터는 outFs 변수에 명령을 내리면
                    // 실제로는 file.txt에 입력을 함.
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = "안드로이드 파일 입출력";
                    // str 변수에 저장된 문자열을 메모장 안에 기입하기.
                    outFs.write(str.getBytes());
                    // 파일 저장하고 닫기.
                    outFs.close();
                    // 토스트로 안내 문구 띄우기
                    Toast.makeText(getApplicationContext(), "file.txt가 생성됨", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        inBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // 파일 쓰기가 FileOutputStream이라면
                    // 파일 읽기는 FileInputStream
                    FileInputStream inFs = openFileInput("file.txt");
                    // 읽어온 파일 내용을 자바 쪽에서 처리하도록 byte배열 생성
                    byte[] txt = new byte[50];
                    // inFs(file.txt)의 내용을 읽어와 txt변수에 byte형으로 저장
                    inFs.read(txt);
                    // byte형으로 저장된 내용을 String으로 재변환
                    String str = new String(txt);
                    // 토스트에 읽어온 내용을 출력
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    // text파일 닫기
                    inFs.close();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "파일이 없습니다." , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}