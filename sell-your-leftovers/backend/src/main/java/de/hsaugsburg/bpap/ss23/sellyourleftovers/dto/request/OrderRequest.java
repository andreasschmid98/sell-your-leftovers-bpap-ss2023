package de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request;

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
    private List<Long> productIds;
}
