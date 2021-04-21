package org.ict.userinsertprj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // activity_main
    TextView aName, aAge, aEmail, aJob;
    Button regBtn;
    // dialog1
    EditText edtName, edtAge, edtEmail, edtJob;
    // toast1
    TextView toastText;
    // View
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aName = (TextView) findViewById(R.id.name);
        aAge = (TextView) findViewById(R.id.age);
        aEmail = (TextView) findViewById(R.id.email);
        aJob = (TextView) findViewById(R.id.job);
        regBtn = (Button) findViewById(R.id.registerBtn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View)View.inflate(MainActivity.this, R.layout.dialog1, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("회원 등록 창");

                dlg.setIcon(R.drawable.myprofileimg);

                dlg.setView(dialogView);

                dlg.setPositiveButton("등록" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edtName = (EditText) dialogView.findViewById(R.id.edtName);
                        edtAge = (EditText) dialogView.findViewById(R.id.edtAge);
                        edtEmail = (EditText) dialogView.findViewById(R.id.edtEmail);
                        edtJob = (EditText) dialogView.findViewById(R.id.edtJob);

                        aName.setText(edtName.getText().toString());
                        aAge.setText(edtAge.getText().toString());
                        aEmail.setText(edtEmail.getText().toString());
                        aJob.setText(edtJob.getText().toString());
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);

                        toastView = (View)View.inflate(MainActivity.this, R.layout.toast1, null);

                        toastText = (TextView) toastView.findViewById(R.id.toastText);

                        toastText.setText("취소되었습니다.");

                        toast.setView(toastView);

                        toast.show();
                    }
                });

                dlg.show();
            }
        });
    }
}