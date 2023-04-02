package de.hsaugsburg.bpap.ss23.sellyourleftovers.repository;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This defines the repository for the Category model.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
