package com.chanchhaya.dgbamsui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @GetMapping("/articles")
    public String viewArticlePage() {

        return "pages/article";
    }

}
