package org.ict.imageeditprj1;

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

        // 단순 이미지 출력은 내부클래스로 GraphicView를 새로 생성해서 사용.
        setContentView(new MyGraphicView( this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }
        // 그림이 출력되는 시점에 실행하게 만드는 메서드는 onDraw로 역시
        // 오버라이드 해서 사용.
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            // res -> drawable 폴더에 있는 이미지를 가져다가 출력.
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.myprofileimg);

            // 사진 위치를 잡기 위해 좌표 설정.
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            // 해당 좌표에 사진 표출
            canvas.drawBitmap(picture, picX, picY, null);
            // 비트맵 객체 종료.
            picture.recycle();
        }
    }
}