package org.ict.lottoprj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button lotto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();

        lotto = (Button) findViewById(R.id.lottoBtn);

        lotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List arr = new ArrayList();


                while (arr.size() < 6) {
                    int num = random.nextInt(45) + 1;
                    if (!arr.contains(num)){
                        arr.add(num);
                    }

                }
                Collections.sort(arr);

                Toast.makeText(getApplicationContext(), "" + arr , Toast.LENGTH_SHORT).show();

            }
        });
    }
}