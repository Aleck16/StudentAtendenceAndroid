package com.iti.android.studentatendence.http;

import com.google.gson.Gson;
import com.iti.android.studentatendence.entity.BaseJson;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;


/**
 * Created by Aleck_ on 2017/4/2.
 */

public abstract class BaseCallBack extends Callback<BaseJson> {
    @Override
    public BaseJson parseNetworkResponse(Response response, int id) throws Exception {
        String str = response.body().string();
        BaseJson baseJson = new Gson().fromJson(str, BaseJson.class);
        return baseJson;
    }
}
