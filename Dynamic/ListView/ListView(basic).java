package org.ict.listview1prj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.ListView1);

        String[] items = {"가렌", "티모", "베인", "마스터 이", "리 신", "요네", "야스오", "케틀"
                        , "카이사", "렝가", "신드라", "트페", "럼블", "쓰레쉬", "레오나", "다리우스"};

        // String을 ArrayAdapter<String> 타입으로 변환해야
        // ListView에 반복하여 출력 가능
        // 첫 파라미터는 this, 두 번재는 리스트뷰의 형식으로 우선 item1을 선택하고
        // 마지막 파라미터는 반복출력할 목록을 넣음.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        // 위에 생성된 목록을 listView1에 적용.
        listview.setAdapter(adapter);

        // 위임 형식으로 리스트뷰를 클릭했을 때 동작이 이루어지게 연결
        // 따로 문법이 있는 건 아니고 리스트뷰에 setOnItemClick 이벤트만 걸어두면
        // 자동으로 위임 처리가 된 효과가 나옴.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 아래 파라미터 목록의 순서는
            // adapterView => 어댑터뷰 이름
            // view => 뷰 이름
            // i => 클릭한 항목의 인덱스번호
            // l => 클릭한 항목의 아이디 값값
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}