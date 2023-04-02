package de.hsaugsburg.bpap.ss23.sellyourleftovers.mapper;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.CategoryResponse;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Category;

/**
 * This provides a helper function for mapping a Category object to a CategoryResponse object.
 */
public class CategoryMapper {
    public static CategoryResponse map(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .categoryType(category.getCategoryType())
                .build();
    }
}
