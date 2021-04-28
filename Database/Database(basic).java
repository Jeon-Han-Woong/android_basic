package org.ict.usingdbprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button reset, register, search;
    EditText edtName, edtAge, edt1, edt2;

    myDBHelper myHelper;

    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset = (Button) findViewById(R.id.btnReset);
        register = (Button) findViewById(R.id.btnRegister);
        search = (Button) findViewById(R.id.btnSearch);

        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);

        myHelper = new myDBHelper(this);

        // 초기화버튼 클릭시 이벤트 연결
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getWritableDatabase();
                // onUpgrade 메서드를 호출. 버전은 전버전 후버전 임의의 숫자.
                myHelper.onUpgrade(sqlDB,1,2);
                // DB갱신이 완료되었으므로 닫음.
                sqlDB.close();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력 역시 DB내용 변경이므로 쓰기 권한
                sqlDB = myHelper.getWritableDatabase();
                // sqlDB.execSQL() 내부는 쿼리문을 작성
                // 중간에 값이 동적으로 바뀌는 부분을 고려
                sqlDB.execSQL("INSERT INTO peopleTBL values ('" + edtName.getText().toString() + "' , " + edtAge.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력 완료", 0).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 읽기 기능이므로 Readable로 만듬.
                sqlDB = myHelper.getReadableDatabase();
                // 조회구문은 커서를 이용해 결과물을 받아올 수 있음.
                // jsp의 resultSEt과 유사.
                Cursor cursor;
                // SELECT구문은 rawQuery()를 이용해 조회.
                cursor = sqlDB.rawQuery("SELECT * FROM peopleTBL;", null);

                // 개행시 \r\n을 사용.
                String strNames = "이름 목록" + "\r\n" + "-----------" + "\r\n";
                String strNumbers = "나이 목록" + "\r\n" + "-----------" + "\r\n";

                while(cursor.moveToNext()) {
                    // cursor.get자료형() 의 경우
                    // 칼럼 인덱스번호(첫 번째로 선언한 컬럼 = 0, 이후 1, 2... 순순)
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }
                edt1.setText(strNames);
                edt2.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }
        });

    }

    public class myDBHelper extends SQLiteOpenHelper{

        // 생성자는 직접 생성
        public myDBHelper(Context contenxt) {
            super(contenxt, "peopleDB", null, 1);
        }


        @Override
        // 테이블 생성
        public void onCreate(SQLiteDatabase db) {
            // DB에 명령어를 전달하기 위해 sqLiteDatabase 객체를 활용.
            // 단, 명령어가 너무 길기 때문에 파라미터명을 db로 바꿈.
            // 아래 코드는 DB에 테이블 생성 쿼리문을 전송.
            db.execSQL("CREATE TABLE peopleTBL(pname CHAR(20) PRIMARY KEY, pNum INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            // DROP TABLE을 먼저 실행후 onCreate를 다시 호출.
            // i는 구버전 DB, i1은 새로 생성된 DB를 가리킴.
            db.execSQL("DROP TABLE IF EXISTS peopleTBL;");
            onCreate(db);
        }
    }
}