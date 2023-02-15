package de.hsaugsburg.bpap.ss23.sellyourleftovers.product;


import de.hsaugsburg.bpap.ss23.sellyourleftovers.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
