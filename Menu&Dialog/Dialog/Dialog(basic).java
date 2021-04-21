package org.ict.dialogprj;

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
                // 대화상자를 의미하는 객체는 아래와 같이
                // AlertDialog객체이며, Builder를 이용해 생성.
                // 이 경우, 액티비티 객체명.this를 파라미터로 설정해야
                // 해당 액티비티 내부에 다이얼로그를 띄울 수 있음.
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                // 모달창의 title을 설정.
                dlg.setTitle("제목");
                // 모달창의 content를 설정.
                dlg.setMessage("내용입니다.");
                // 모달창 좌상단에 올라갈 아이콘을 설정.
                dlg.setIcon(R.mipmap.ic_launcher);
                // 모달창 하단에 버튼을 출력.
                // text는 버튼에 붙여줄 문자열을, listener는 확인시 실행할 실행문이
                // 들어가지만 현재는 연결할 실행문이 없으므로 우선 null 처리.
//                dlg.setPositiveButton("확인",null);

                // 만약 확인버튼을 눌렀을 때 실행할 구문을 설정하고자 한다면
                // 아래 예시와 같이 new DialogInterface.OnClickListener 설정을
                // 활용해서 연결.
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 첫 번째 파라미터는 원래 일반적으로는
                        // getApplicationContext()를 사용하지만
                        // 다이얼로그를 통해 표출될때는 역시
                        // 메인클래스명.this 를 넘겨줌.
                        Toast.makeText(MainActivity.this,"확인처리 되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                // 설정이 완료된 모달창을 표출.
                dlg.show();

            }
        });
    }
}