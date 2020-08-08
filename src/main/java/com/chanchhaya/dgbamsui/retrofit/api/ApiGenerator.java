package com.chanchhaya.dgbamsui.retrofit.api;

import com.chanchhaya.dgbamsui.retrofit.interceptor.BasicAuthenticationInterceptor;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.util.StringUtils;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiGenerator {

    private static final String BASE_URL = "http://localhost:8080/api/v1/";

    private static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S createApi(Class<S> serviceClass) {
        return createApi(serviceClass, null, null);
    }

    public static <S> S createApi(
            Class<S> serviceClass, String username, String password) {
        if (!StringUtils.isEmpty(username)
                && !StringUtils.isEmpty(password)) {
            String authToken = Credentials.basic(username, password);
            return createApi(serviceClass, authToken);
        }

        return createApi(serviceClass, null);
    }

    public static <A> A createApi(Class<A> className, String authToken) {

        if (!StringUtils.isEmpty(authToken)) {

            BasicAuthenticationInterceptor interceptor =
                    new BasicAuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptor)) {

                httpClient.addInterceptor(interceptor);
                builder.client(httpClient.build());
                retrofit = builder.build();

            }

        }

        return retrofit.create(className);
    }

}
