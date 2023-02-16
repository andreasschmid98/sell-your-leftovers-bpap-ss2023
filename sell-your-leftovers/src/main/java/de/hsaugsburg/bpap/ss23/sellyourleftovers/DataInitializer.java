package de.hsaugsburg.bpap.ss23.sellyourleftovers;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.category.Category;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.category.CategoryRepository;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.category.CategoryService;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.product.Product;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.product.ProductRepository;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.product.ProductService;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.security.user.User;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(
                new User(1L,
                        "Andreas",
                        "Schmid",
                        "schmidandreas.ul@gmail.com",
                        passwordEncoder.encode("test"),
                        null)
        );

        Category beer = new Category(1L, Category.CategoryType.BEER, "Bier");
        Category wine = new Category(2L, Category.CategoryType.WINE, "Wein");
        Category spirits = new Category(3L, Category.CategoryType.SPIRITS, "Spirituosen");
        Category nonAlcoholic = new Category(4L, Category.CategoryType.NONALCOHOLIC, "Nicht-alkoholische Getränke");

        categoryRepository.save(beer);
        categoryRepository.save(wine);
        categoryRepository.save(spirits);
        categoryRepository.save(nonAlcoholic);

        productRepository.save(new Product(1L,"A1","Coca Cola", "0.5 Liter originale Coca Cola",new BigDecimal(2), 10,nonAlcoholic));
        productRepository.save(new Product(2L,"B2","Riegele Urhell", "0.5 Liter originales Riegele Helles",new BigDecimal(1.7), 5, beer));
        productRepository.save(new Product(3L,"C3","Sonnenhof Samtrot fruchtsüß","0.7 Liter Sonnenhofer Rotwein",new BigDecimal(4.99), 20,wine));
        productRepository.save(new Product(4L,"D4","Absolut Vodka", "Hochprozentiger Wodka",new BigDecimal(9.99), 2,spirits));
    }
}