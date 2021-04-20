package org.ict.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button btnGo, btnPrev;
    WebView wView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = (EditText) findViewById(R.id.editUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        wView = (WebView) findViewById(R.id.webBrowser);

        // 아래에 정의한 내부 클래스를 선언해주고, 웹뷰에 대입.
        wView.setWebViewClient(new CookWebViewClient());

        // 버튼 컨트롤이 화면에 보이도록 추가 작업을 진행.
        WebSettings webSet = wView.getSettings();
        webSet.setBuiltInZoomControls(true);

        // 웹뷰에서 자바스크립트코드 실행을 허용.
        // 안드로이드 브라우저는 기본적으로 자바스크립트 실행이 막혀있음.
        webSet.setJavaScriptEnabled(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 만약 버튼이 클릭된다면 EditText에 입력된 url로 WebView를 이동.
                // 단, 실제로는 접속 허가 코드를 추가하지 않았기 때문에,
                // 명목상으로만 브라우저 역할을 수행.
                // 접속허가는 AndroidManifest에서 처리.
                wView.loadUrl(edt.getText().toString());
            }
        });

        // 뒤로가기 버튼도 처리
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wView.goBack();
            }
        });
    }

    // 웹 브라우저는 WebViewClient를 상속받아 본 어플과는 별개로 동작.
    // 내부에 shouldOverrideUrlLoading() 메서드를 오버라이딩 해 주면
    // 입력받은 url로 브라우저를 이동
    // 직접 작성하지 않고 메뉴바를 이용해 자동 작성을 시킴
    class CookWebViewClient extends WebViewClient {
        // 자동 작성은 현재 이 라인에 커서를 두고
        // 상단 Code -> Override Methods를 선택한 다음
        // 선택지들 중 shouldOverrideUrlLoading을 선택.
        // 파라미터가 WebView view, String url 인 것으로 선택.

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}