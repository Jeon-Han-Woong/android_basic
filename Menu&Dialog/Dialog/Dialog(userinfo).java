package org.ict.userinfoprj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button callBtn;
    TextView nameView, emailView;
    EditText det1, det2;
    TextView ttv;
    // dialog1.xml, toast1.xml
    View dialogView, toastView;
    ImageView tiv1, tiv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callBtn = (Button) findViewById(R.id.callDialogBtn);
        nameView = (TextView) findViewById(R.id.nameView);
        emailView = (TextView) findViewById(R.id.emailView);
//        ttv = (TextView) findViewById(R.id.toastText);
//        tiv1 = (ImageView) findViewById(R.id.img1);
//        tiv2 = (ImageView) findViewById(R.id.img2);
//        det1 = (EditText) findViewById(R.id.dlgEdtName);
//        det2 = (EditText) findViewById(R.id.dlgEdtEmail);

        // 버튼 클릭시 대화상자가 뜨도록 onClick을 설정.
        // 단, 생성되는 대화상자는 dialog1.xml을 기반으로 떠야함.
        // 따라서, dialog1과 연동되도록 처리해야함.
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 상단 dialogView 변수에 dialog.xml을 연결하기
                dialogView = (View)View.inflate(MainActivity.this, R.layout.dialog1, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("사용자 정보 입력");

                dlg.setIcon(R.mipmap.ic_launcher);

                dlg.setView(dialogView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        det1 = (EditText) dialogView.findViewById(R.id.dlgEdtName);
                        det2 = (EditText) dialogView.findViewById(R.id.dlgEdtEmail);
                        nameView.setText(det1.getText().toString());
                        emailView.setText(det2.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 토스트 객체 생성
                        Toast toast = new Toast(MainActivity.this);

                        toastView = (View)View.inflate(MainActivity.this, R.layout.toast1, null);

                        ttv = (TextView) toastView.findViewById(R.id.toastText);

                        ttv.setText("취소되었습니다.");

                        toast.setView(toastView);

                        toast.show();

                    }
                });

                dlg.show();

            }
        });
    }
}