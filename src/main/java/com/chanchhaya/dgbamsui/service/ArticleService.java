package com.chanchhaya.dgbamsui.service;

import com.chanchhaya.dgbamsui.retrofit.api.ApiGenerator;
import com.chanchhaya.dgbamsui.retrofit.api.ArticleApi;
import com.chanchhaya.dgbamsui.retrofit.model.ApiResponse;
import com.chanchhaya.dgbamsui.retrofit.model.Article;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class ArticleService {

    public ApiResponse<List<Article>> getPopularArticles() {

        ArticleApi articleApi = ApiGenerator.createApi(ArticleApi.class);

        ApiResponse<List<Article>> popularArticles = new ApiResponse<>();

        try {

            Response<ApiResponse<List<Article>>> response =
                    articleApi.getPopularArticles().execute();

            popularArticles = response.body();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return popularArticles;

    }

    public ApiResponse<List<Article>> getRecentArticles() {

        ArticleApi articleApi = ApiGenerator.createApi(ArticleApi.class);

        ApiResponse<List<Article>> recentArticles = new ApiResponse<>();

        try {

            Response<ApiResponse<List<Article>>> response =
                    articleApi.getRecentArticles().execute();

            recentArticles = response.body();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recentArticles;

    }

}
