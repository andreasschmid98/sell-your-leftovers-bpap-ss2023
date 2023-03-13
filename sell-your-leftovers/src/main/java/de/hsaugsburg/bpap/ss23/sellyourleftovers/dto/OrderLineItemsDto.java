package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto;

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
