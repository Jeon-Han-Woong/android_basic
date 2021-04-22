package org.ict.imageedtprj3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {

        MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.myprofileimg);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            // 블러링 효과를 주기 위해서
            // Paint 클래스와, BlurMaskFilter 클래스 필요.
            Paint paint = new Paint();
            BlurMaskFilter bMask;
            // 블러 설정은 NORMAL, INNER, OUTER, SOLID 4가지.
            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.SOLID);
            // 그림 파일에 필터 적용
            paint.setMaskFilter(bMask);

            canvas.drawBitmap(picture, picX, picY, paint);
        }
    }
}