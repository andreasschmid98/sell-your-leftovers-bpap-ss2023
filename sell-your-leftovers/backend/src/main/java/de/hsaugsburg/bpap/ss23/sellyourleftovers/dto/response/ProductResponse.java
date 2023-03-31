package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    private BigDecimal price;
    private Category.CategoryType categoryType;

}
