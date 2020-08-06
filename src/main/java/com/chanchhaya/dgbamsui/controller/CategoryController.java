package com.chanchhaya.dgbamsui.controller;

import com.chanchhaya.dgbamsui.retrofit.model.ApiResponse;
import com.chanchhaya.dgbamsui.retrofit.model.Category;
import com.chanchhaya.dgbamsui.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ExecutionException;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String index() {



        return "pages/category";
    }


}
