package de.hsaugsburg.bpap.ss23.sellyourleftovers.service;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.mapper.CategoryMapper;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Category;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.CategoryRepository;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::map).toList();
    }

}
