package org.ict.pollprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    ImageView image[] = new ImageView[9];

    Integer id[] = {(R.id.img1), (R.id.img2), (R.id.img3), (R.id.img4), (R.id.img5), (R.id.img6), (R.id.img7), (R.id.img8), (R.id.img9) };

    // 별점 정보를 서브액티비티에 넘겨야 하기 때문에
    // 별점을 담을 배열 생성.
    int voteCount[] = new int[9];

    // 특정 그림의 제목도 같이 전송하도록 처리.
    String imgName[] = {"펭귄1", "펭귄2", "펭귄3", "펭귄4", "펭귄5", "펭귄6", "펭귄7", "펭귄8", "펭귄9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.myBtn);

        for (int i = 0; i < 9; i++) {
            voteCount[i] = 0;
        }

        // 각 이미지뷰와 점수, 그림제목 정보 연결
        for (int i = 0; i < image.length; i++) {
            final int index;
            index = i;
            // 이미지뷰와 아이디 연결
            image[index] = (ImageView) findViewById(id[index]);
            // 특정 이미지뷰를 클릭
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 특정 그림 클릭시 해당 그림의 득표수 1 증가
                    voteCount[index]++;

                    Toast.makeText(getApplicationContext(), imgName[index] + ": 총 " + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("imgName", imgName);
                intent.putExtra("voteCount", voteCount);
                startActivity(intent);
            }
        });
    }
}