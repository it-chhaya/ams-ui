package com.chanchhaya.dgbamsui.controller.ajax;

import com.chanchhaya.dgbamsui.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ajax")
public class AjaxCategoryController {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("related-categories")
    public String getRelatedCategories(ModelMap modelMap) {

        modelMap.addAttribute("categories", categoryService.getCategories().getData());

        return "ajax/categories-related";
    }

}
