package org.ict.contextmenuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btnBg, btnBtn;
    LinearLayout baseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBg = (Button) findViewById(R.id.changeBgBtn);
        btnBtn = (Button) findViewById(R.id.changeBtnBtn);
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);

        // 버튼에 메뉴 연결을 위해 버튼이 메뉴용으로 사용될 것을 표현.
        registerForContextMenu(btnBg);
        registerForContextMenu(btnBtn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // MenuInflater 생성.
        MenuInflater mInflater = getMenuInflater();

        // View v를 이용해서 registerforContextMenu에 등록된 요소 중
        // 어떤 요소가 클릭되었는지를 확인할 수 있음.
        if(v == btnBg) {
            menu.setHeaderTitle("배경색을 변경해줘");
            mInflater.inflate(R.menu.menu1, menu);
        } else if (v == btnBtn) {
            menu.setHeaderTitle("버튼을 조정해줘");
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == (R.id.colorRed)) {
            baseLayout.setBackgroundColor(Color.RED);
        } else if(item.getItemId() == (R.id.colorBlue)) {
            baseLayout.setBackgroundColor(Color.BLUE);
        } else if(item.getItemId() == (R.id.colorGreen)) {
            baseLayout.setBackgroundColor(Color.GREEN);
        } else if(item.getItemId() == (R.id.rotateBtn)){
            btnBg.setRotation(45);
            btnBtn.setRotation(45);
        } else if (item.getItemId() == (R.id.sizeUpBtn)) {
            btnBg.setScaleY(2);
            btnBtn.setScaleY(2);
        }
        return true;
    }
}