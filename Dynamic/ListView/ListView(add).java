package org.ict.listview3prj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtItem;
    Button btnAdd;
    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtItem = (EditText)findViewById(R.id.edtItem);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        listView1 = (ListView)findViewById(R.id.listView1);

        final ArrayList<String> itemList = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);

        listView1.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 아이템 리스트에 추가
                itemList.add(edtItem.getText().toString());
                // 바뀐 데이터셋을 어댑터에 인식
                adapter.notifyDataSetChanged();

                edtItem.setText("");
            }
        });

        // 추가된 목록을 삭제할 때는 길게 눌러야 삭제되게 설정.
        // setOnItemLongClickListener를 사용
        // new View... 이 아닌 new AdapterView...을 이용
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            // 아래 파라미터의 i는 리스트의 인덱스번호
            // l은 리스트의 id값
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemList.remove(i);

                adapter.notifyDataSetChanged();

                return false;
            }
        });
    }
}