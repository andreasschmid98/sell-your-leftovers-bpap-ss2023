package de.hsaugsburg.bpap.ss23.sellyourleftovers.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles;
    @OneToMany
    private List<Product> orders = new ArrayList<>();

    @ManyToMany
    @Column
    private List<Product> cartItems = new ArrayList<>();

    @OneToMany
    @Column
    private List<Product> uploads = new ArrayList<>();

    public void addCartItem(Product product) {
        this.cartItems.add(product);
    }

    public void removeCartItem(Product product) {
        this.cartItems.remove(product);
    }

    public void addOrder(Product product) {
        orders.add(product);
    }

    public void addUpload(Product product){
        uploads.add(product);
    }

}