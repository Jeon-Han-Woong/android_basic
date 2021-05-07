package org.ict.movierank.retrofit_test;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // DAO는 싱글턴으로 생성
    private static RetrofitClient instance = null;
    private static RetrofitInterface retrofitInterface;
    // baseUrl 에는 xxx.com이나 xxx.xx.kr 등의 기본 주소만 적어넣음.
    private static String baseUrl = "http://www.kobis.or.kr";

    // 생성자를 이용해 RetrofitClient를 생성
    private RetrofitClient() {
        // GsonConverterFactory를 등록해야 해당 주소 접속시 받아온 json을
        // 자바 코드로 변경 가능
        // 단 Gson은 처리를 할 수 없는 상황에서도 에러를 뱉지 않기 때문에
        // build() 직전에 설정.
        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(baseUrl)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    // getInstance는 instance(DAO) 객체가 있는지 검사해서
    // null인 경우만 new 키워드로 생성하고
    // 아니라면 return만 해서 2개 이상 생성하는 상황을 막음.
    public static RetrofitClient getInstance() {
        if(instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;
    }
}
