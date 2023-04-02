package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Category;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private Category.CategoryType categoryType;
}


