package org.ict.imageeditprj4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
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

        MyGraphicView (Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.myprofileimg);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;

            // 페인트 객체 생성(그림 파일을 가져오지 않고 그림을 그대로 그림)
            Paint paint = new Paint();
            paint.setColor(Color.GRAY);

            // 엠보싱 효과 필터 생성
            EmbossMaskFilter eMask;
            // EmbossMaskFilter(빛의 x y z 방향 (배열), 빛의 밝기, 반사정도, 블러링크기);
            eMask = new EmbossMaskFilter(
                    new float[] {10, 10, 3}, 0.5f, 5, 10);

            // 옵션 설정 완료
            paint.setMaskFilter(eMask);
            // drawBitmap이 입력받았던 그림을 그리는 것이라면
            // drawCircle은 원을 그려주는 명령어.
            // drawCircle(중심점 X, 중심점 Y, 반지름, 옵션);
            canvas.drawCircle(cenX, cenY, 150, paint);
        }
    }


}