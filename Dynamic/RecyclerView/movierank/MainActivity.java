package org.ict.movierank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.ict.movierank.retrofit_test.BoxOfficeResult;
import org.ict.movierank.retrofit_test.DailyBoxOffice;
import org.ict.movierank.retrofit_test.Example;
import org.ict.movierank.retrofit_test.RetrofitClient;
import org.ict.movierank.retrofit_test.RetrofitInterface;
import org.xml.sax.helpers.XMLReaderAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    // AJAX호출을 위한 Retrofit 관련 선언
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    // 발급받은 API키
    private String API_KEY = "키가 들어갈 자리";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 변수와 위젯 연결
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // 리사이클러뷰 내부적 설정은 LinearLayoutManager 객체로 함.
        // 2번째 파라미터를 이용해 수직, 수평, 그리드, 불균형 그리드 설정을 함.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()
                                                                    ,LinearLayoutManager.VERTICAL, false);
        // 레이아웃 매니저 리사이클러뷰에 적용해 수직 배치 설정 완료
        recyclerView.setLayoutManager(layoutManager);

        // 레트로핏 객체를 생성해 DB와 통신 준비 완료
        retrofitClient = RetrofitClient.getInstance();

        // 레트로핏 인터페이스를 생성해 DB와 통신시 요청할 메서드 준비
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        // $.ajax에 대응하는 레트로핏 문법을 작성.
        retrofitInterface.getBoxOffice(API_KEY, "20210505").enqueue(new Callback<Example>() {

            // 요청이 전달되었을 경우 처리할 내용은
            // onResponse 메서드를 오버라이드해 만듬.
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                // 응답 객체의 body부분에 json데이터가 존재
                Example example = response.body();
                // 전체 데이터 중 boxOffice 관련 정보만 빼옴
                BoxOfficeResult boxOfficeResult = example.getBoxOfficeResult();
                // boxOffice 데이터 중 영화 정보만 빼 온 다음
                // 어댑터 객체를 생성할 때 사용
                mAdapter = new MovieAdapter(boxOfficeResult.getDailyBoxOfficeList());

                // 리사이클러 뷰에 어댑터 적용
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this, "호출 실패", Toast.LENGTH_SHORT).show();
            }
        });
    }
}