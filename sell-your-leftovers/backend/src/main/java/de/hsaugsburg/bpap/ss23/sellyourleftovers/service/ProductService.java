package de.hsaugsburg.bpap.ss23.sellyourleftovers.service;


import de.hsaugsburg.bpap.ss23.sellyourleftovers.error.exception.ResourceNotFoundException;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.ProductRepository;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.ProductRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ResponseEntity<?> createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .skuCode(UUID.randomUUID().toString())
                .imageUrl(productRequest.getImageUrl())
                .description(productRequest.getDescription())
                .categoryType(productRequest.getCategoryType())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapProductToProductResponse).toList();
    }


    public ResponseEntity<ProductResponse> getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " NOT Found"));
        return ResponseEntity.ok().body(mapProductToProductResponse(product));
    }

    private ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .imageUrl(product.getImageUrl())
                .skuCode(product.getSkuCode())
                .description(product.getDescription())
                .categoryType(product.getCategoryType())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .build();
    }
}
