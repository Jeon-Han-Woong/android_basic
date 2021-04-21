package org.ict.dialog2prj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 메뉴에 출력할 목록을 문자열로 먼저 저장
                final String[] versionArray = new String[] {"파이", "젤리빈", "오레오", "아이스크림 샌드위치"};
                final boolean[] versionbool = new boolean[versionArray.length];
                // 다이얼로그 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                // 타이틀 설정
                dlg.setTitle("버전을 선택해봐");
                // 아이콘 설정
                dlg.setIcon(R.mipmap.ic_launcher);
                /*
                // 다이얼로그에 versionArray로 저장한 문자열을 항목으로 출력
                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    // int i는 내가 선택한 항목을 감지해서 인덱스 번호로 받아옴.
                    // 해당 인덱스번호는 위에 생성한 String[] 내부 요소 기준 순서.
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btn1.setText(versionArray[i]);
                        Toast.makeText(MainActivity.this, "버튼을 " + btn1.getText().toString() + "(으)로 변경하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                */
                /*
                // 만약 선택지를 선택한 시점에서 창이 안 닫히게 하고 싶다면,
                // 라디오 버튼 처리를 해야함.
                // 이 경우 setItem 대신 setSingleChoiceItems를 활용.
                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btn1.setText(versionArray[i]);
                        Toast.makeText(MainActivity.this, "버튼을 " + versionArray[i] + "(으)로 변경하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                */
                // 체크 박스 형태로 만들때는 setMultiChoiceItems를 사용.
                // setMultiChoiceItems는 체크박스가 선택되었는지 아닌지를
                // bool 자료형으로 표현하기 때문에 추가적으로
                // bool배열을 미리 저장해서 파라미터로 넘겨야 함.
                // 상단 versionArray 하단에 bool 배열을 만듬.
                dlg.setMultiChoiceItems(versionArray, versionbool, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        // 두 번째 파라미터는 선택한 항목의 인덱스번호
                        // 세 번째 항목은 해당 항목이 check 상태인지
                        // 확인하도록 만듦.
                        btn1.setText(versionArray[i]);
                    }
                });


                // 확인 버튼
                dlg.setPositiveButton("확인", null);
                // 다이얼로그 표출
                dlg.show();
            }
        });
   }
}