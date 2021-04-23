package org.ict.lunchrecommend;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Random;

public class Food1Activity extends AppCompatActivity {

    TextView name1, select1, list1;

    ImageView image;

    Button btn;

    String[] food1List = {"부대찌개", "만둣국", "보쌈정식"};
    String[] food2List = {"파스타", "스테이크", "피자"};
    String[] food3List = {"짬뽕", "간짜장", "볶음밥"};
    String[] food4List = {"돈카츠", "카레", "냉모밀"};
    int[] food1image = {(R.drawable.korea1), (R.drawable.korea2), (R.drawable.korea3)};
    int[] food2image = {(R.drawable.america1), (R.drawable.america2), (R.drawable.america3)};
    int[] food3image = {(R.drawable.china1), (R.drawable.china2), (R.drawable.china3)};
    int[] food4image = {(R.drawable.japan1), (R.drawable.japan2), (R.drawable.japan3)};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food1);
        Random random = new Random();

        name1 = (TextView) findViewById(R.id.name1);
        select1 = (TextView) findViewById(R.id.select1);
        list1 = (TextView) findViewById(R.id.list1);
        image = (ImageView) findViewById(R.id.image1);

        btn = (Button) findViewById(R.id.return1);

        int ranNum = random.nextInt(3);

        Intent intent = getIntent();

        String mycategory = intent.getStringExtra("category");
        int sel = intent.getIntExtra("sel", 0);

        if (sel == 1){
            name1.setText(intent.getStringExtra("category"));

            select1.setText(food1List[ranNum]);

            list1.setText(Arrays.toString(food1List));

            image.setImageResource(food1image[ranNum]);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } else if (sel == 2){
            name1.setText(intent.getStringExtra("category"));

            select1.setText(food2List[ranNum]);

            list1.setText(Arrays.toString(food2List));

            image.setImageResource(food2image[ranNum]);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } else if (sel == 3){
            name1.setText(intent.getStringExtra("category"));

            select1.setText(food3List[ranNum]);

            list1.setText(Arrays.toString(food3List));

            image.setImageResource(food3image[ranNum]);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } else if (sel == 4){
            name1.setText(intent.getStringExtra("category"));

            select1.setText(food4List[ranNum]);

            list1.setText(Arrays.toString(food4List));

            image.setImageResource(food4image[ranNum]);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }




    }
}
