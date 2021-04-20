package org.ict.menuprj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 메뉴로 바꾸기");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        btn1 = (Button) findViewById(R.id.btn1);
    }

    // onCreate 바깥쪽에 옵션 메뉴가 추가되었을 때 실행할 코드를 작성.
    // 역시 커서를 아래에 두고 메뉴의 Code -> Override Methods를 선택해서
    // onCreateOptionsMenu를 오버라이딩함.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 자동완성된 코드 내부에, 아까 생성한 메뉴를 연결.
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        // res/menu의 menu1.xml을 menu 목록에 등록
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    // 메뉴창의 아이템이 선택되었을 때, 실행할 이벤트는
    // opOptionsItemSelected()을 이용해 코딩.


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 현재 이 메서드는 옵션창에서 뭔가를 선택하기만 해도 바로 작동.
        // 뭘 선택했는지는, 해당 옵션 메뉴의 id 값으로 구분.
        // 아이디 값은 item.getItemId()로 얻어올 수 있음.
        // 선택한 색상으로 backgroundcolor가 바뀌게 처리
        if (item.getItemId() == (R.id.itemRed)){
            baseLayout.setBackgroundColor(Color.RED);
        } else if (item.getItemId() == (R.id.itemBlue)){
            baseLayout.setBackgroundColor(Color.BLUE);
        } else if (item.getItemId() == (R.id.itemGreen)) {
            baseLayout.setBackgroundColor(Color.GREEN);
        } else if (item.getItemId() == (R.id.rotateBtn)) {
            btn1.setRotation(45);
        } else if (item.getItemId() == (R.id.sizeUp)) {
            btn1.setScaleY(2);
        }
        return true;
    }
}