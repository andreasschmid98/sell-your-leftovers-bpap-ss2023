package de.hsaugsburg.bpap.ss23.sellyourleftovers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CategoryType categoryType;
    private String name;

    @Override
    public String toString() {
        return this.name;
    }

    public enum CategoryType {
        SPIRITS, WINE, BEER, NONALCOHOLIC,
    }
}
