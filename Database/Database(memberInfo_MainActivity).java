package org.ict.memberinfoprj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnDelete, btnDetail;
    EditText edtName, edtJob, edtPhone;
    ListView listview;

    myDBHelper myHelper;

    SQLiteDatabase sqlDB;

    ArrayList<String> memList;

    Cursor cursor1;

    String selector;
    int selectNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myHelper = new myDBHelper(this);

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDetail = (Button) findViewById(R.id.btnDetail);

        edtName = (EditText) findViewById(R.id.edtName);
        edtJob = (EditText) findViewById(R.id.edtJob);
        edtPhone = (EditText) findViewById(R.id.edtPhone);

        listview = (ListView) findViewById(R.id.listView);

        sqlDB = myHelper.getReadableDatabase();

        memList = new ArrayList<>();

        try {
            cursor1 = sqlDB.rawQuery("SELECT mname FROM member;", null);
            while(cursor1.moveToNext()) {
                memList.add(cursor1.getString(0));
            }

            cursor1.close();
        } catch (Exception e) {
            myHelper.onCreate(sqlDB);
        }
        sqlDB.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, memList);

        listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selector = memList.get(i);
                selectNum = i;
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getWritableDatabase();

                sqlDB.execSQL("INSERT INTO member VALUES('" + edtName.getText().toString() + "' , '" + edtJob.getText().toString() + "' , '" + edtPhone.getText().toString() + "', '');");
                sqlDB.close();
                memList.add(edtName.getText().toString());
                adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), "회원 " +edtName.getText().toString()+ " 등록 완료", Toast.LENGTH_SHORT).show();
                edtName.setText("");
                edtJob.setText("");
                edtPhone.setText("");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getWritableDatabase();

                sqlDB.execSQL("DELETE FROM member WHERE mname = '" + selector + "';");

                sqlDB.close();
                memList.remove(selectNum);

                adapter.notifyDataSetChanged();
            }
        });

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor2 = sqlDB.rawQuery("SELECT * FROM member WHERE mname = '" + memList.get(selectNum) + "';", null);
                cursor2.moveToNext();

                intent.putExtra("name",cursor2.getString(0));
                intent.putExtra("job",cursor2.getString(1));
                intent.putExtra("phone",cursor2.getString(2));
                intent.putExtra("content",cursor2.getString(3));

                cursor2.close();
                sqlDB.close();
                startActivity(intent);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            String a = data.getStringExtra("upname1");
            memList.clear();
            cursor1 = sqlDB.rawQuery("SELECT mname FROM member;", null);
            while(cursor1.moveToNext()) {
                memList.add(cursor1.getString(0));
            }
            cursor1.close();
        }
    }
}