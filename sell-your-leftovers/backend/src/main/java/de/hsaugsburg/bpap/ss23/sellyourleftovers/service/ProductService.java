package de.hsaugsburg.bpap.ss23.sellyourleftovers.service;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.error.exception.ResourceNotFoundException;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.mapper.ProductMapper;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.ProductRepository;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This defines the service class for managing the Product model.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findProductByAvailable(true);
        return products.stream().map(ProductMapper::map).toList();
    }

    public ResponseEntity<ProductResponse> getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " NOT Found"));
        return ResponseEntity.ok().body(ProductMapper.map(product));
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

}
