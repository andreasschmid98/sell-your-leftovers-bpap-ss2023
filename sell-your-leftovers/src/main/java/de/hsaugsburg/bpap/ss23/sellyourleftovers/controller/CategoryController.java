package de.hsaugsburg.bpap.ss23.sellyourleftovers.controller;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.CategoryResponse;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

}
