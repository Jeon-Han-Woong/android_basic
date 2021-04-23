package org.ict.lunchrecommend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button [] food = new Button[4];
    int [] foodid = {(R.id.food1), (R.id.food2), (R.id.food3), (R.id.food4)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < foodid.length; i++){
            final int index;
            index = i;
            food[index] = (Button) findViewById(foodid[index]);

            food[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), Food1Activity.class);
                    intent.putExtra("category", food[index].getText().toString());
                    intent.putExtra("sel", index + 1);
                    startActivity(intent);
                }
            });
        }

//        food1 = (Button) findViewById(R.id.food1);
//        food2 = (Button) findViewById(R.id.food2);
//        food3 = (Button) findViewById(R.id.food3);
//        food4 = (Button) findViewById(R.id.food4);
//
//        food1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Food1Activity.class);
//                intent.putExtra("category", food1.getText().toString());
//                intent.putExtra("sel", 1);
//                startActivity(intent);
//            }
//        });
//
//        food2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Food1Activity.class);
//                intent.putExtra("category", food2.getText().toString());
//                intent.putExtra("sel", 2);
//                startActivity(intent);
//            }
//        });
//
//        food3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Food1Activity.class);
//                intent.putExtra("category", food3.getText().toString());
//                intent.putExtra("sel", 3);
//                startActivity(intent);
//            }
//        });
//
//        food4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Food1Activity.class);
//                intent.putExtra("category", food4.getText().toString());
//                intent.putExtra("sel", 4);
//                startActivity(intent);
//            }
//        });


    }
}