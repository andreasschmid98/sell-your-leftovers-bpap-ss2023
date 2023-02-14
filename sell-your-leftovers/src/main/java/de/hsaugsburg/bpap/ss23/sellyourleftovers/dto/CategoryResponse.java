package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Category;
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
