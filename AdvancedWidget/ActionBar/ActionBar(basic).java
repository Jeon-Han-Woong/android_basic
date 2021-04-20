package org.ict.widgetprj11;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
// AcionBar는 인터페이스와 TabListener 인터페이스를 구현해 만듬.
public class MainActivity extends AppCompatActivity
                                    implements ActionBar.TabListener{
    // 액션바 3개 선언
    ActionBar.Tab tabSong, tabSinger, tabAlbum;
    // 프래그먼트 3개를 배열로 저장
    MyTabFragment myFrags[] = new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 액션바 관련 설정을 먼저 수행.
        // androidx.appcompat.app.ActionBar 임포트
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // 각 탭별로 명칭설정과 액션바 자체에 연결.
        tabSong = bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);
        bar.addTab(tabSong);

        tabSinger = bar.newTab();
        tabSinger.setText("가수별");
        tabSinger.setTabListener(this);
        bar.addTab(tabSinger);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }
    // 인터페이스 구현 메서드
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // 위에 준비된 3개의 탭과 3개의 프래그먼트를 조합해주는 부분
        MyTabFragment myTabFrag = null;

        // 현재 선택된 탭이 선택된 적이 없다면, 새로 생성
        if (myFrags[tab.getPosition()] == null) {
            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        } else {
            // 선택된 적이 있다면, 기존에 생성된 탭 가져오기.
            myTabFrag = myFrags[tab.getPosition()];
        }
        // 현재 표출중인 화면을 선택된 탭과 연관된 화면으로 대체체
        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    // 내부 클래스를 선언해서 Fragment에 대한 설정.
    // Fragment 설정은 Fragment를 상속받은 객체로 생성해서 진행.
    public static class MyTabFragment extends androidx.fragment.app.Fragment {
        // 각각의 탭을 클릭할 때마다 다른 프래그먼트(하단의 화면)이 나올 수 있도록,
        // 탭을 클릭할 때 지정한 프래그먼트를 연결.
        String tabName;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // LinearLayout 생성
            ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if(tabName == "음악별") {
                baseLayout.setBackgroundColor(Color.RED);
            } else if (tabName == "가수별") {
                baseLayout.setBackgroundColor(Color.GREEN);
            } else if (tabName == "앨범별") {
                baseLayout.setBackgroundColor(Color.BLUE);
            }

            return baseLayout;
        }
    }
}