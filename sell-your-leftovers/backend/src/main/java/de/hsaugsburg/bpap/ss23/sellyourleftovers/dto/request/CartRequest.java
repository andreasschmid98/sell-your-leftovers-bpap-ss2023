package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartRequest {
    private Long productId;
}