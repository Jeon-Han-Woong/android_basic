package org.ict.toastprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btnToast);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast message = Toast.makeText(getApplicationContext(), "이걸 누르네 ㅋㅋ", Toast.LENGTH_SHORT);

                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                int xOffset = (int)(Math.random() * display.getWidth());
                int yOffset = (int)(Math.random() * display.getHeight());

                message.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);

                message.show();
            }
        });
    }
}