package com.example.stockscreening.net;

import android.util.Log;

import com.example.stockscreening.bean.EventMessage;
import com.example.stockscreening.bean.ReflectIndexToStockBean;
import com.example.stockscreening.bean.StockBean;
import org.greenrobot.eventbus.EventBus;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ResponseInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        // 以下两句还有点问题
        MediaType mediaType = response.body().contentType();
        // 获取网页源码
        String content = response.body().string();

        try {

            Log.d("flag--", "intercept(ResponseInterceptor.java:39)-->>" + content);
            // check(response);
            convertedData(content);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.newBuilder()
                .body(ResponseBody.create(mediaType, content))
                .build();
    }

    public void convertedData(String data) {
   //     v_sh600660 = "1~福耀玻璃~600660~38.92~39.04~39.06~12257~5278~6979~38.93~1~38.92~42~38.91~108~38.90~994~38.89~179~38.94~15~38.95~90~38.99~12~39.00~9~39.03~14~~20220809094905~-0.12~-0.31~39.34~38.85~38.92/12257/47897608~12257~4790~0.06~32.12~~39.34~38.85~1.26~779.56~1015.71~4.14~42.94~35.14~1.13~1184~39.08~29.15~32.28~~~0.95~4789.7608~0.0000~0~ ~GP-A~-15.65~-2.82~2.57~11.65~6.74~53.90~29.23~-5.74~-6.17~6.34~2002986332~2609743532~80.87~-15.96~2002986332~~~-27.12~-0.13~";
        EventBus.getDefault().post(new EventMessage<>("StockToData", data));


    }

}
