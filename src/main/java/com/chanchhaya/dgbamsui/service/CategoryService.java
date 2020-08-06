package com.chanchhaya.dgbamsui.service;

import com.chanchhaya.dgbamsui.retrofit.api.ApiGenerator;
import com.chanchhaya.dgbamsui.retrofit.api.CategoryApi;
import com.chanchhaya.dgbamsui.retrofit.model.ApiResponse;
import com.chanchhaya.dgbamsui.retrofit.model.Category;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CategoryService {

    public CompletableFuture<ApiResponse<Category>> getCategoryById(int id) {

        CompletableFuture<ApiResponse<Category>> categoryCompleted =
                new CompletableFuture<>();

        CategoryApi categoryApi = ApiGenerator.createApi(CategoryApi.class);

        categoryApi.getCategoryById(id).enqueue(new Callback<ApiResponse<Category>>() {
            @Override
            public void onResponse(Call<ApiResponse<Category>> call, Response<ApiResponse<Category>> response) {
                System.out.println("SERVICE");
                categoryCompleted.complete(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse<Category>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return categoryCompleted;

    }

    public ApiResponse<List<Category>> getCategories() {

        CategoryApi categoryApi = ApiGenerator.createApi(CategoryApi.class);

        ApiResponse<List<Category>> categories = new ApiResponse<>();

        try {
            Response<ApiResponse<List<Category>>> categoriesResponse = categoryApi.getCategories().execute();
            categories = categoriesResponse.body();
            System.out.println("SERVICE = " + categories);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return categories;

    }



}
