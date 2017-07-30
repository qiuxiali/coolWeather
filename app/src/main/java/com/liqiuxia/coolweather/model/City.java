package com.liqiuxia.coolweather.model;

/**
 * Created by Administrator on 2017/7/30 0030.
 */

public class City {
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    public void setId(int id) {
        this.id = id;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getId() {
        return id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCityName() {
        return cityName;
    }
}
