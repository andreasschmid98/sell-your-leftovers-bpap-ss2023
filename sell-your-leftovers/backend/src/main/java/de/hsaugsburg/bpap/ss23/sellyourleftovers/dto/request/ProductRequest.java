package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request;

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
public class ProductRequest {
    private String name;
    private String skuCode;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private Category.CategoryType categoryType;
    private Integer quantity;
}


