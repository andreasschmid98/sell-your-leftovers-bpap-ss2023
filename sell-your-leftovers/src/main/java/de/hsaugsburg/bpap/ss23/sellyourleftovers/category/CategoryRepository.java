package de.hsaugsburg.bpap.ss23.sellyourleftovers.category;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
