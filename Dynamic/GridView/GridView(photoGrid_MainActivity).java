package org.ict.photogridviewprj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String [] name = {"개 보기", "독수리 보기", "펭귄 보기", "토끼 보기", "거북이 보기"};
    Integer [] imageId = {R.drawable.dog, R.drawable.eagle, R.drawable.penguin, R.drawable.rabbit,
                            R.drawable.turtle};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridView1);

        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gridView.setAdapter(gAdapter);


    }
    // 내부 클래스
    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context c) {
            context = c;
        }

        // 그리드 뷰에 보여야 하는 그림 갯수를 반환.
        // 추후에는 리턴 구문에 이미지배열.length를 넣어줌.
        public int getCount() {
            return imageId.length * 8;
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        // 그림파일을 각 그리드마다 이미지뷰로 생성.
        public View getView(int i, View v, ViewGroup vg) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            // 추후에는 이미지배열[i]로 넣어줌.

            imageView.setImageResource(imageId[i%5]);

            // 클릭시 dialog가 열리도록 처리
            // 이미지 배열이 생기면 이미지 배열로 처리.
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 다이얼로그 생성
                    View dialog = (View)View.inflate(MainActivity.this, R.layout.dialog, null);
                    // MainActivity에서 사용 할 수 있도록 빌드
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    // 다이얼로그 내부의 ImageView는 별개이므로 재연결
                    ImageView dialogIv = (ImageView)dialog.findViewById(R.id.ivPoster);
                    dlg.setTitle(name[i%5]);
                    dlg.setIcon(R.drawable.ic_launcher_background);
                    dialogIv.setImageResource(imageId[i%5]);
                    dlg.setView(dialog);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();

                }
            });

            // 생성한 이미지뷰를 리턴해서 화면에 띄움.
            return imageView;
        }


    }
}