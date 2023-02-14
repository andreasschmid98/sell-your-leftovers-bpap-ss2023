package de.hsaugsburg.bpap.ss23.sellyourleftovers.controller;


import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.ProductRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.ProductResponse;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.service.ProductService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }
}
