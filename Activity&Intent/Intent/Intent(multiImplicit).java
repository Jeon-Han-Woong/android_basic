package org.ict.multiintentprj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtPhone, edtSearch, edtSmsNum, edtSmsCnt;
    Button btnPhone, btnSearch, btnSms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtSearch = (EditText) findViewById(R.id.edtSearch);
        edtSmsNum = (EditText) findViewById(R.id.edtSmsNum);
        edtSmsCnt = (EditText) findViewById(R.id.edtSmsCnt);
        btnPhone = (Button) findViewById(R.id.btnPhone);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSms = (Button) findViewById(R.id.btnSms);

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:" + edtPhone.getText().toString());

                Intent intent = new Intent(Intent.ACTION_DIAL, uri);

                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);

                intent.putExtra(SearchManager.QUERY, edtSearch.getText().toString());

                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", edtSmsCnt.getText().toString());
                intent.setData(Uri.parse("smsto:" + Uri.encode(edtSmsNum.getText().toString())));

                startActivity(intent);
            }
        });

    }
}