package de.hsaugsburg.bpap.ss23.sellyourleftovers.repository;


import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
