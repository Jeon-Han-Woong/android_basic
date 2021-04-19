package org.ict.widgetprj10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

// TabActivity를 상속해서 MainActivity를 구현해야 TabHost 구현이 가능.
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        // TabSpec을 이용해 탭 이름 변경 가능
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        // 버튼과 연결해 탭 1이 작동하도록 마무리
        tabSpecSong.setContent(R.id.tabSong);
        // 1번 버튼 정보를 탭 호스트에 추가
        tabHost.addTab(tabSpecSong);
        TabHost.TabSpec tabSpecSinger = tabHost.newTabSpec("SINGER").setIndicator("가수별");
        tabSpecSinger.setContent(R.id.tabSinger);
        tabHost.addTab(tabSpecSinger);
        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);
    }
}