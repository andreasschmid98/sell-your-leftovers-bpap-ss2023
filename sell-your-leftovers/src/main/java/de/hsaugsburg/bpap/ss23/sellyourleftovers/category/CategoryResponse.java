package de.hsaugsburg.bpap.ss23.sellyourleftovers.category;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryResponse {
    private Long id;
    private Category.CategoryType categoryType;
    private String name;
}
