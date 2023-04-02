package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request;

import lombok.*;

import java.util.List;

/**
 * This defines the structure of an OrderRequest.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private List<Long> productIds;
}
