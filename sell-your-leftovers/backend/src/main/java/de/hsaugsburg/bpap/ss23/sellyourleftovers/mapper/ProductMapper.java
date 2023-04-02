package de.hsaugsburg.bpap.ss23.sellyourleftovers.mapper;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.ProductRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.ProductResponse;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;

/**
 * This provides helper functions for mapping a Product object to a ProductResponse object
 * and a ProductRequest object to a Product object.
 */
public class ProductMapper {
    public static ProductResponse map(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .imageUrl(product.getImageUrl())
                .description(product.getDescription())
                .categoryType(product.getCategoryType())
                .price(product.getPrice())
                .available(product.getAvailable())
                .build();
    }

    public static Product map(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .imageUrl(productRequest.getImageUrl())
                .description(productRequest.getDescription())
                .categoryType(productRequest.getCategoryType())
                .price(productRequest.getPrice())
                .available(true)
                .build();
    }
}
