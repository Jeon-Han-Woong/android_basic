package org.ict.movierank.retrofit_test;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BoxOfficeResult {

    @SerializedName("boxofficeType")
    @Expose
    private String boxofficeType;
    @SerializedName("showRange")
    @Expose
    private String showRange;
    @SerializedName("dailyBoxOfficeList")
    @Expose
    private List<DailyBoxOffice> dailyBoxOfficeList = null;

    public String getBoxofficeType() {
        return boxofficeType;
    }

    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    public List<DailyBoxOffice> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList(List<DailyBoxOffice> dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }

}