package org.ict.imageedtprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CpuUsageInfo;
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

            // 가져온 사진에 대해서 컬러매트릭스 생성
            Paint paint = new Paint();
            // 컬러매트릭스 배열의 의미
            // 4 * 5 크기의 배열로 처리.
            // Red(1),       0,      0,       0,      밝기(양수 : 밝게, 음쉬 어둡게)
            // 0,    ,Green(1),      0,       0,      밝기()
            // 0,    ,       0,Blue(1),       0,      밝기()
            // 0,    ,       0,       ,Alpha(1),      0

            // 4 * 5 배열에서 위와 같이 RGB, Alpha를 담당하는 부분은 기준값이 1인데,
            // 그 값을 크거나 작게 주어 특정 색상만 조절이 가능하며,
            // 밝기 역시 0이 기준값인데, 양수값을 주면 더 밝아지고
            // 음수값을 주면 더 진한 어두운 색으로 변경 가능.
            float[] array = { 3, 0, 0, 0, -25,
                              0, -2, 0, 0, -25,
                              0, 0, 1, 0, -25,
                              0, 0, 0, 2, 0};
            ColorMatrix cMatrix = new ColorMatrix(array);

            paint.setColorFilter(new ColorMatrixColorFilter(cMatrix));

            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }
}