package com.example.__DoCongChien_Lab03.Controller;

import com.example.__DoCongChien_Lab03.model.Product;
import org.springframework.ui.Model;
import com.example.__DoCongChien_Lab03.service.CategoryService;
import com.example.__DoCongChien_Lab03.model.Catelogy;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Catelogy());
        return "/add-category";
    }
    @PostMapping("/add")
    public String addCategory(@Valid Catelogy category, BindingResult result) {
        if (result.hasErrors()) {
            return "/add-category";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("")
    public String listCategories(Model model) {
        List<Catelogy> categories = categoryService.getAlCatologies();
        model.addAttribute("categories", categories);
        return "/categories-list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Catelogy category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid categoryId:" + id));
        model.addAttribute("category", category);
        return "/update-category";
    }
    // POST request to update category
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @Valid Catelogy
            category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            category.setId(Math.toIntExact(id));
            return "/update-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories", categoryService.getAlCatologies());
        return "redirect:/categories";
    }
    // GET request for deleting category
    @GetMapping("/delete/{id}")
    public String deleteCatelogy(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
