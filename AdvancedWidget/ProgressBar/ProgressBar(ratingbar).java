package org.ict.explitintentprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    RatingBar rate1, rate2, rate3;
    Button btnInc, btnDec;
    static float x, y, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rate1 = (RatingBar) findViewById(R.id.ratingBar1);
        rate2 = (RatingBar) findViewById(R.id.ratingBar2);
        rate3 = (RatingBar) findViewById(R.id.ratingBar3);

        btnInc = (Button) findViewById(R.id.btnInc);
        btnDec = (Button) findViewById(R.id.btnDec);

        z = rate3.getRating();

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 별점 증가 로직
                // .setRating()으로 별점 세팅.
                // .getRating()으로 기존 별점 받아옴.
                // .getStepSize()로 최소 별점 증가, 감소량을 구할 수 있음.
                rate1.setRating(rate1.getRating() + rate1.getStepSize());
                rate2.setRating(rate2.getRating() + rate2.getStepSize());
                rate3.setRating(rate3.getRating() + rate3.getStepSize());
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 별점 증가 로직
                // .setRating()으로 별점 세팅.
                // .getRating()으로 기존 별점 받아옴.
                // .getStepSize()로 최소 별점 증가, 감소량을 구할 수 있음.
                rate1.setRating(rate1.getRating() - rate1.getStepSize());
                rate2.setRating(rate2.getRating() - rate2.getStepSize());
                rate3.setRating(rate3.getRating() - rate3.getStepSize());
            }
        });

    }
}