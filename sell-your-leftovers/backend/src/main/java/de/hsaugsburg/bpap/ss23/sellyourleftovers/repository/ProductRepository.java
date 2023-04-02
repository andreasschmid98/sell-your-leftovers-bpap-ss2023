package de.hsaugsburg.bpap.ss23.sellyourleftovers.repository;


import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This defines the repository for the Product model.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);

    List<Product> findProductByAvailable(Boolean available);
}
