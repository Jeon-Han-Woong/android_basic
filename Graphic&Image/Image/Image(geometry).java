package org.ict.imageeditprj2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));

        // 내부 클래스를 MyGrahphicView 설정
        // 내부에 onDraw 세팅
    }

    private static class MyGraphicView extends View {

        MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            // 비트맵 객체 생성
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.myprofileimg);
            // 사진 파일 위치
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            // 절대 좌표로 중간점을 지정.
            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            // 그림 회전
//            canvas.rotate(45, cenX, cenY);
            // 그림 위치 이동
//            canvas.translate(-150, 200);
            // 그림 확대
//            canvas.scale(2, 3, cenX, cenY);
            // 그림 기울이기 (rotate와 다름)
            canvas.skew(0.3f, 0.3f);
            // 그림을 그릴때, drawBitmap
            canvas.drawBitmap(picture, picX, picY, null);

        }
    }
}