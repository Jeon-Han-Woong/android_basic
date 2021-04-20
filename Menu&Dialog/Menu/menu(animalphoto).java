package org.ict.animalphotoprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button rotateBtn;
    ImageView setImg;
    EditText edt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = (EditText) findViewById(R.id.edttext);
        rotateBtn = (Button) findViewById(R.id.rotateBtn);
        setImg = (ImageView) findViewById(R.id.setImg);

        rotateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer rotate = Integer.parseInt(edt.getText().toString());
                setImg.setRotation(rotate);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == (R.id.cat)) {
            setImg.setImageResource(R.drawable.cat);
        } else if (item.getItemId() == (R.id.dog)) {
            setImg.setImageResource(R.drawable.dog);
        } else if (item.getItemId() == (R.id.eagle)) {
            setImg.setImageResource(R.drawable.eagle);
        } else if (item.getItemId() == (R.id.penguin)) {
            setImg.setImageResource(R.drawable.penguin);
        } else if (item.getItemId() == (R.id.lizard)) {
            setImg.setImageResource(R.drawable.lizard);
        } else if (item.getItemId() == (R.id.turtle)) {
            setImg.setImageResource(R.drawable.turtle);
        }

        return true;
    }
}