package de.hsaugsburg.bpap.ss23.sellyourleftovers.service;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.ProductRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.ProductResponse;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.mapper.ProductMapper;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * This defines the service class for managing the upload functionality.
 */
@Service
@RequiredArgsConstructor
public class UploadService {

    private final UserService userService;
    private final ProductService productService;

    public List<ProductResponse> getAllUploads() {
        User user = userService.getCurrentUser();
        List<ProductResponse> uploads = new ArrayList<>();

        for (Product upload : user.getUploads()) {
            uploads.add(ProductMapper.map(upload));
        }

        return uploads;
    }

    public ResponseEntity<?> uploadProduct(ProductRequest productRequest) {
        Product product = ProductMapper.map(productRequest);
        productService.save(product);

        User user = userService.getCurrentUser();
        user.addUpload(product);
        userService.save(user);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
