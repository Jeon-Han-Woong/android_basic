package org.ict.movierank.retrofit_test;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    // Retrofit2는 인터페이스와 클라이언트로 구성
    // 인터페이스에는 호출방식, 호출할 베이스 주소, 붙일 파라미터를 정의할 수 있음.

    @GET("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    // 요청 결과는 Call<자료형>이 마치 ResponseEntity<자료형>처럼 작동.
    // 요청 주소에 붙일 파라미터는 내부 어노테이션 @Query("파라미터명") 자료형 값
    // 순서로 정의.
    Call<Example> getBoxOffice(@Query("key") String key,
                               @Query("targetDt") String targetDt);
}
