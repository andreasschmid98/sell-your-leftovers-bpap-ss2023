package de.hsaugsburg.bpap.ss23.sellyourleftovers.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * This defines the structure of a Role.
 * This class is necessary to work with Spring Security.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "t_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "name")
    private String name;
}
