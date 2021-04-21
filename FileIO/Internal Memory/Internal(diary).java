package org.ict.diaryprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatePicker dPicker;
    EditText edtDiary;
    Button btnWrite;
    String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dPicker = (DatePicker) findViewById(R.id.dataPick1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dPicker.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {

                // 입력받은 년도, 월, 날짜를 문자열로 바꿔서 날짜에 따른 텍스트 파일로
                // 변경해 처리.
                fileName = Integer.toString(year) + "_" + Integer.toString(month + 1) + "_" + Integer.toString(day) + ".txt";

                // 특정 날짜의 일기를 읽어오기
                String str = readDiary(fileName);
                // 저장된 내용을 다이어리에 입력.
                edtDiary.setText(str);
                // 버튼 활성화
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    // 파일 읽어오기
                    FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);

                    // 다이어리 내부의 파일을 String으로 바꿔서 저장
                    String str = edtDiary.getText().toString();
                    // fos에 diary에 있던 내용을 덮어씌우기
                    fos.write(str.getBytes());
                    // 저장을 위해 fos.close() 실행
                    fos.close();
                    // 저장 완료 알림 Toast.
                    Toast.makeText(getApplicationContext(),"일기가 저장되었습니다.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    String readDiary(String fName) {

        String diaryStr = null;
        FileInputStream inFs;
        try {
            // fName(파일이름)을 이용해 일기장 내용을 읽어옴.
            inFs = openFileInput(fName);
            // txt파일 내부의 문자열을 바이트형식으로 담아옴.
            byte[] txt = new byte[1000];
            inFs.read(txt);
            // 파일 닫기
            inFs.close();
            // byte[] 자료형 문자열을 STring으로 변환 및 불필요한 공백 제거.
            String str = new String(txt);
            diaryStr = str.trim();
            // 일기가 존재하기 때문에 버튼을 저장하기 대신 수정하기로 변경.
            btnWrite.setText("수정하기");
        } catch (Exception e) {
            // 해당 날짜에 일기장이 없다면 일기장이 없음을 알리고,
            edtDiary.setHint("일기장 없음");
            // 버튼은 저장버튼으로 변경.
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }
}