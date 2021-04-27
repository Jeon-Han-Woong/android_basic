package org.ict.listviewboardprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

//        String[] titleList = {"제목1", "제목2", "제목3", "제목4", "제목5", "제목6", "제목7", "제목8", "제목9", "제목10"
//                            , "제목11", "제목12", "제목13", "제목14", "제목15"};

        String[] writerList = {"김기리", "김춘배", "글쓴이3", "글쓴이4", "글쓴이5", "글쓴이6", "글쓴이7", "글쓴이8", "글쓴이9", "글쓴이10"
                , "글쓴이11", "글쓴이12", "글쓴이13", "글쓴이14", "박형순"};

        String[] contentList = {"본문1", "본문2", "본문3", "랄라라", "본문5", "본문아잉", "본문7", "본문임다", "본문9", "본문10"
                , "본문11", "본문12", "점심뭐먹지", "본문14", "본문15"};


        ArrayList<String> titleList = new ArrayList<>(15);

        for (int i = 0; i < 15; i++) {
            titleList.add("제목" + (i + 1));
        }

        Toast.makeText(getApplicationContext(), titleList.toString(), Toast.LENGTH_SHORT).show();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                intent.putExtra("title", titleList.get(i));
                intent.putExtra("writer", writerList[i]);
                intent.putExtra("content", contentList[i]);

                startActivity(intent);
            }
        });
    }
}