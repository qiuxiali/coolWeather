package com.liqiuxia.coolweather.util;

/**
 * Created by Administrator on 2017/7/30 0030.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
