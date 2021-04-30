package org.ict.memberinfoprj;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    EditText detailName, detailJob, detailPhone, detailContent;
    Button btnUpdate, btnReturn;

    myDBHelper myHelper;

    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailName = (EditText) findViewById(R.id.detailName);
        detailJob = (EditText) findViewById(R.id.detailJob);
        detailPhone = (EditText) findViewById(R.id.detailPhone);
        detailContent = (EditText) findViewById(R.id.detailContent);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        myHelper = new myDBHelper(this);

        Intent detailIntent = getIntent();
        String baseName = detailIntent.getStringExtra("name");
        detailName.setText(detailIntent.getStringExtra("name"));
        detailJob.setText(detailIntent.getStringExtra("job"));
        detailPhone.setText(detailIntent.getStringExtra("phone"));
        detailContent.setText(detailIntent.getStringExtra("content"));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateIntent = new Intent(getApplicationContext(), MainActivity.class);
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("UPDATE member SET mname = '" + detailName.getText().toString() + "', mjob = '" + detailJob.getText().toString() + "', mphone = '" + detailPhone.getText().toString() +"', mcontent = '" + detailContent.getText().toString() + "' WHERE mname = '" + baseName + "';");
                sqlDB.close();

                setResult(RESULT_OK, updateIntent);

                finish();
                startActivity(updateIntent);
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public class myDBHelper extends SQLiteOpenHelper {

        public myDBHelper (Context context) {
            super(context, "memberDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE member(mname CHAR(20) PRIMARY KEY, mjob CHAR(20), mphone CHAR(20), mcontent char(200));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS member;");
            onCreate(db);
        }
    }
}
