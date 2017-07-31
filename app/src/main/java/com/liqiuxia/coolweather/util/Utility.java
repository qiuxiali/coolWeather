package com.liqiuxia.coolweather.util;

import android.text.TextUtils;

import com.liqiuxia.coolweather.db.CoolWheatherDB;
import com.liqiuxia.coolweather.model.City;
import com.liqiuxia.coolweather.model.County;
import com.liqiuxia.coolweather.model.Province;

/**
 * Created by Administrator on 2017/7/30 0030.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public synchronized static boolean handleProvincesResponse(CoolWheatherDB coolWheatherDB,String response){
        if (!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    //将解析出来的数据存储到Province表
                    coolWheatherDB.saveProvince(province);
                }
                return  true;
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCitiesResponse(CoolWheatherDB coolWheatherDB,String response,
                                               int provinceId) {
        if (!TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if (allCities !=null && allCities.length>0){
                for (String c : allCities){
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    coolWheatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountiesResponse(CoolWheatherDB coolWheatherDB,
                                                 String response , int cityId){
        if (!TextUtils.isEmpty(response)){
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0){
                for (String c : allCounties){
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    coolWheatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
}
