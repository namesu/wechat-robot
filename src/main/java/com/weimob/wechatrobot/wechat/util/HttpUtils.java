package com.weimob.wechatrobot.wechat.util;

import com.weimob.wechatrobot.wechat.receive.ResultGetToken;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

@Slf4j
public class HttpUtils {
    private static OkHttpClient client = new OkHttpClient().newBuilder().build();

    @SneakyThrows
    public static String post(String url, String json){
        log.info("post url: {},json: {}",url,json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @SneakyThrows
    public static String get(String url){
        log.info("http get url: {}",url);
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String res = "";
        try{
            final ResponseBody responseBody = response.body();
            if(responseBody == null){
                log.info("responseBody is null");
                return res;
            }
            /**
             *  okhttp3的 responseBody.string() 只能调用一次
             */
            String jsonResponseStr = responseBody.string();
            log.info("--> get token response: {}",jsonResponseStr);
            ResultGetToken resultGetToken = JsonUtils.toObj(jsonResponseStr, ResultGetToken.class);
            if(resultGetToken.getErrcode() == 0 && resultGetToken.getErrmsg().equals("ok")){
                res = resultGetToken.getAccess_token();
            }
        }catch (Exception e){
            log.info("http get occur exception: ",e);
        }
        return res;
    }

}
