package de.hsaugsburg.bpap.ss23.sellyourleftovers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * This defines the structure of a Product.
 */
@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "t_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "category_type")
    private Category.CategoryType categoryType;

}
