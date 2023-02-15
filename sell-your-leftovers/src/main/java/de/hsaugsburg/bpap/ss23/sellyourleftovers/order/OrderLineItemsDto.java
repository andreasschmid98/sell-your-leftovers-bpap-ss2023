package de.hsaugsburg.bpap.ss23.sellyourleftovers.order;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.product.Product;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderLineItemsDto {
    private String skuCode;
    private Integer quantity;
}
