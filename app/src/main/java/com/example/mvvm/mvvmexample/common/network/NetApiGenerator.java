package com.example.mvvm.mvvmexample.common.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author KangSungWoo
 * @since 2017-03-05
 */
public final class NetApiGenerator {
	// TODO : update base url
	private static String BASEURL = "";

	private static OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
		.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

	private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
		.baseUrl(BASEURL)
		.addConverterFactory(GsonConverterFactory.create())
		.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
		.client(okHttpClientBuilder.build());

	public static <T> T generateApi(Class<T> api) {
		return retrofitBuilder.build().create(api);
	}
}
