package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private List<Long> productIds;
}
