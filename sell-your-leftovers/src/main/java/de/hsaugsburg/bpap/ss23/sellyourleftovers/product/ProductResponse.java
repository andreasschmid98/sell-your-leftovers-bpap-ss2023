package de.hsaugsburg.bpap.ss23.sellyourleftovers.product;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.category.Category;
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
    private String skuCode;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private Category category;

}
