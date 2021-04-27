package org.ict.photogalleryprj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.nio.channels.GatheringByteChannel;

public class MainActivity extends AppCompatActivity {

    Gallery gallery;
    ImageView ivPoster;

    Integer [] imageId = {R.drawable.dog, R.drawable.eagle, R.drawable.penguin, R.drawable.rabbit,
            R.drawable.turtle};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery) findViewById(R.id.gallery1);
        ivPoster = (ImageView) findViewById(R.id.ivPoster);

        MyGalleryAdapter gAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(gAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter {

        Context context;

        public MyGalleryAdapter (Context c) {
            context = c;
        }

        // 그림 갯수를 정해줘야 하고, 보통은
        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        // 사용될 이미지뷰 정의
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(imageId[i%5]);

            // 내부 요소 클릭시 생기는 이벤트는 return 하기 전에 설정
            // 클릭시 내부 요소가 고정되기 때문에 onTouch로 처리
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ivPoster.setImageResource(imageId[i%5]);
                    return false;
                }
            });

            return imageView;
        }
    }
}