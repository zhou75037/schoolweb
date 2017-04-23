package net.qiujuer.italker.factory.net;

import net.qiujuer.italker.common.Common;
import net.qiujuer.italker.factory.Factory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求的封装
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class Network {

    // 构建一个Retrofit
    public static Retrofit getRetrofit(){
        // 得到一个OK Client

        OkHttpClient client = new OkHttpClient.Builder()
                .build();


        Retrofit.Builder builder = new Retrofit.Builder();

        // 设置电脑链接
        return builder.baseUrl(Common.Constance.API_URL)
                // 设置client
                .client(client)
                // 设置Json解析器
                .addConverterFactory(GsonConverterFactory.create(Factory.getGson()))
                .build();

    }

}