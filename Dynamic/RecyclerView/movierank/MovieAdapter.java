package org.ict.movierank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ict.movierank.retrofit_test.DailyBoxOffice;

import java.util.List;

// 어댑터가 리사이클러뷰를 상속하게 만들어줌.
// 세부사항은 상속시 익명 클래스를 정의해 처리.
// RecyclerView는 내무적으로 표현하는 자료가 여러개이므로
// 뷰홀더 라는 것을 이용해 처리하는데
// 뷰홀더를 먼저 선언을 해 주고 시작.
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    // 개별 영화정보 VO인 DailyBoxOffice를 list로 선언.
    private List<DailyBoxOffice> items;

    // 생성자는 반드시 영화목록을 입력받아야 어댑터를 생성.
    public MovieAdapter(List<DailyBoxOffice> items) {
        this.items = items;
    }

    // 여러 뷰가 묶인 뷰홀더가 생성될 때, item과 연도시킴.
    // Code의 override methods... 옵션을 이용해 onCreateViewHolder를 검색한 다음
    // 검색결과로 자동완성 시키면 편함.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item.xml의 내용물을 이용해서 ViewHolder 객체를 생성
        // 이 단계에서는, 데이터를 주입받은 상태는 아니고,
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DailyBoxOffice item = items.get(position);
        holder.setItem(item);
    }

    // 3. 아이템 갯수를 쉽게 확인할 수 있도록 getter 생성
    public int getItemCount() {
        return items.size();
    }

    // 1. 뷰홀더를 먼저 만듬.
    // 뷰홀더는 static 선언을 해 프로그램이 실행되면 바로 생성하게 만들어줌.
    // 생성자는 RecyclerView에서 사용할 위젯들을 연결.
    // setItem메서드는 이제 그 위젯들에게 실 데이터를 연결시킴.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView rankZone, nameZone, dataZone;

        public ViewHolder(View itemView) {
            super(itemView);
            rankZone = itemView.findViewById(R.id.rankZone);
            nameZone = itemView.findViewById(R.id.nameZone);
            dataZone = itemView.findViewById(R.id.dataZone);
        }

        public void setItem(DailyBoxOffice item) {
            rankZone.setText(item.getRank());
            nameZone.setText(item.getMovieNm());
            dataZone.setText(item.getOpenDt());
        }
    }
}
