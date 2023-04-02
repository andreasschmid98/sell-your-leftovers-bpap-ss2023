package de.hsaugsburg.bpap.ss23.sellyourleftovers.mapper;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.ProductRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.ProductResponse;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;

public class ProductMapper {
    public static ProductResponse map(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .imageUrl(product.getImageUrl())
                .description(product.getDescription())
                .categoryType(product.getCategoryType())
                .price(product.getPrice())
                .build();
    }

    public static Product map(ProductRequest productRequest){
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