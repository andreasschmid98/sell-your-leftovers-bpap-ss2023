package de.hsaugsburg.bpap.ss23.sellyourleftovers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "t_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_type")
    private CategoryType categoryType;

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return this.name;
    }

    public enum CategoryType {
        SPIRITS, WINE, BEER, NONALCOHOLIC,
    }
}
