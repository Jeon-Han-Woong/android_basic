package org.ict.pollprj;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ResultActivity extends AppCompatActivity {



    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btn = (Button) findViewById(R.id.btnReturn);

        // 다른 액티비티에서 보낸 인텐트 데이터를 받아오기.
        Intent intent = getIntent();

        // JSP에서 getInt("파라미터명")으로 받아오듯
        // intent객체.get자료형("파라미터명"); 문법으로
        // 바인딩된 자료를 가져올 수 있음.
        String[] imgName = intent.getStringArrayExtra("imgName");
        int[] voteResult = intent.getIntArrayExtra("voteCount");

        RatingBar []rateList = new RatingBar[voteResult.length];
        int []rateid = {(R.id.rating1), (R.id.rating2), (R.id.rating3), (R.id.rating4), (R.id.rating5), (R.id.rating6), (R.id.rating7), (R.id.rating8), (R.id.rating9)};

        TextView []txtList = new TextView[imgName.length];
        int []textid = {(R.id.table1), (R.id.table2), (R.id.table3), (R.id.table4), (R.id.table5), (R.id.table6), (R.id.table7), (R.id.table8), (R.id.table9)};

        for(int i = 0; i < voteResult.length; i++){
            final int index;
            index = i;
            txtList[index] = (TextView) findViewById(textid[i]);
            txtList[index].setText(imgName[index]);

            rateList[index] = (RatingBar) findViewById(rateid[i]);
            rateList[index].setRating(voteResult[i]);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


//        Toast.makeText(getApplicationContext(), Arrays.toString(voteResult), Toast.LENGTH_SHORT).show();
    }
}
