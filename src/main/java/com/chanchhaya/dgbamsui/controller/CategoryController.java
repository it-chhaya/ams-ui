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
    public String index(ModelMap map) {

        System.out.println("DATA = " + categoryService.getCategories());

        map.addAttribute("api", categoryService.getCategories().getData());

        return "index";
    }

    @GetMapping("/categories/{id}")
    public String getCategoryByIdView(ModelMap map, @PathVariable int id) {

        ApiResponse<Category> category = new ApiResponse<>();

        System.out.println("CONTROLLER");

        try {
            category = categoryService.getCategoryById(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        map.addAttribute("api", category.getData());

        System.out.println("END CONTROLLER");

        return "index";

    }

}
