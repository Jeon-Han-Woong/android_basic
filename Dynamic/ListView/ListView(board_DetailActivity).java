package org.ict.listviewboardprj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    TextView detailTitle, detailWriter, detailContent;
    Button returnBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailTitle = (TextView)findViewById(R.id.detailTitle);
        detailWriter = (TextView)findViewById(R.id.detailWriter);
        detailContent = (TextView)findViewById(R.id.detailContent);
        returnBtn = (Button)findViewById(R.id.returnBtn);

        Intent intent = getIntent();

        detailTitle.setText(intent.getStringExtra("title"));
        detailWriter.setText(intent.getStringExtra("writer"));
        detailContent.setText(intent.getStringExtra("content"));

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
