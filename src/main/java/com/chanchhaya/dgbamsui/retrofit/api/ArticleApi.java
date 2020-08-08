package com.chanchhaya.dgbamsui.retrofit.api;

import com.chanchhaya.dgbamsui.retrofit.model.ApiResponse;
import com.chanchhaya.dgbamsui.retrofit.model.Article;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ArticleApi {

    @GET("articles/recent-post")
    Call<ApiResponse<List<Article>>> getRecentArticles();

    @GET("articles/popular-post")
    Call<ApiResponse<List<Article>>> getPopularArticles();

    @GET("articles")
    Call<ApiResponse<List<Article>>> getArticles(@Query("limit") int limit,
                                                 @Query("offset") int offset);

}
