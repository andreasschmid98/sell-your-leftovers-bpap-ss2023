package de.hsaugsburg.bpap.ss23.sellyourleftovers.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
