package org.ict.miniphotoshopprj;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout iconLayout, pictureLayout;
    Button zoominBtn, zoomoutBtn, rotateBtn, brightBtn, darkBtn, grayBtn;

    // activity_main에 사진만 추가할 것이기 때문에
    // xml파일과 java생성 뷰를 연동하기 위해 선언.
    MyGraphicView graphicView;

    // 축척 관련 전역 변수 선언
    static float scaleX=1, scaleY=1, rotate=0, color=1, satur=1;

    // onCreate 내부에 작성하면 코드가 길어지고 가독성이 안 좋기 때문에
    // 외부 메서드를 작성해놓고 onCreate내부에서 호출하도록 처리
    private void clickIcons() {
        // 줌인 버튼 설정
        zoominBtn = (Button) findViewById(R.id.zoominBtn);
        // 줌인 버튼 클릭시
        zoominBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // X, Y값을 0.2씩 더해서 저장.
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                // 기존 배율 설정값을 해제.
                // 설정값 해제 이후 추가할 내용은 onDraw에서 컨트롤.
                graphicView.invalidate();
            }
        });

        zoomoutBtn = (Button) findViewById(R.id.zoomoutBtn);

        zoomoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;

                graphicView.invalidate();
            }
        });

        rotateBtn = (Button) findViewById(R.id.rotateBtn);

        rotateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotate = rotate + 20;

                graphicView.invalidate();
            }
        });

        brightBtn = (Button) findViewById(R.id.brightBtn);

        brightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = color + 0.2f;

                graphicView.invalidate();
            }
        });

        darkBtn = (Button) findViewById(R.id.darkBtn);

        darkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = color - 0.2f;

                graphicView.invalidate();
            }
        });

        grayBtn = (Button) findViewById(R.id.grayBtn);

        grayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(satur == 0) {
                    satur = 1;
                } else if (satur == 1) {
                    satur = 0;
                }

                graphicView.invalidate();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconLayout = (LinearLayout) findViewById(R.id.iconLayout);
        pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);

        // activity_main.xml과 MyGraphicView 연동.
        // 1. 먼저 graphicView 객체에 MyGraphView 정보 입력.
        graphicView = (MyGraphicView)new MyGraphicView(this);

        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private static class MyGraphicView extends View {
        MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            // 확대를 위해 중앙 좌표값을 먼저 구함.
            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            // 중앙 좌표값과 스케일 변수를 이용해 배수 옵션을 설정.
            canvas.scale(scaleX, scaleX, cenX, cenY);
            canvas.rotate(rotate, cenX, cenY);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.myprofileimg);

            Paint paint = new Paint();

            float[] array = { color, 0, 0, 0, 0,
                              0, color, 0, 0, 0,
                              0, 0, color, 0, 0,
                              0, 0, 0, 1, 0};


            ColorMatrix cMatrix = new ColorMatrix(array);
            if (satur == 0) {
                cMatrix.setSaturation(satur);
            }

            paint.setColorFilter(new ColorMatrixColorFilter(cMatrix));

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();

        }
    }
}