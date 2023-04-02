package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This defines the structure of a CategoryResponse.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryResponse {
    private Long id;
    private Category.CategoryType categoryType;
    private String name;
}
