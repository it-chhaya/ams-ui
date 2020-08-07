package com.chanchhaya.dgbamsui.controller;

import com.chanchhaya.dgbamsui.retrofit.model.ApiResponse;
import com.chanchhaya.dgbamsui.retrofit.model.Article;
import com.chanchhaya.dgbamsui.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private ArticleService articleService;

    @Value("${api.image-uri}")
    private String imageUri;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String viewHomePage(ModelMap modelMap) {

        ApiResponse<List<Article>> recentArticles = articleService.getRecentArticles();
        ApiResponse<List<Article>> popularArticles = articleService.getPopularArticles();

        System.out.println("RECENT ARTICLES = " + recentArticles);
        System.out.println("POPULAR ARTICLES = " + popularArticles);

        modelMap.addAttribute("recentArticles", recentArticles.getData());
        modelMap.addAttribute("popularArticles", popularArticles.getData());
        modelMap.addAttribute("imageUri", imageUri);

        return "pages/index";

    }

}
