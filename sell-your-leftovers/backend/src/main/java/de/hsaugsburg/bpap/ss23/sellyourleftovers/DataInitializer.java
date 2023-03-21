package de.hsaugsburg.bpap.ss23.sellyourleftovers;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Category;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.User;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.CategoryRepository;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.ProductRepository;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Category beer = new Category(1L, Category.CategoryType.BEER, "Bier");
        Category wine = new Category(2L, Category.CategoryType.WINE, "Wein");
        Category spirits = new Category(3L, Category.CategoryType.SPIRITS, "Spirituosen");
        Category nonAlcoholic = new Category(4L, Category.CategoryType.NONALCOHOLIC, "Nicht-alkoholische Getränke");

        categoryRepository.save(beer);
        categoryRepository.save(wine);
        categoryRepository.save(spirits);
        categoryRepository.save(nonAlcoholic);

        productRepository.save(new Product(1L,"A1","Coca Cola", "https://picsum.photos/200/300","0.5 Liter originale Coca Cola",new BigDecimal(2), 10, Category.CategoryType.NONALCOHOLIC));
        productRepository.save(new Product(2L,"B2","Riegele Urhell", "https://picsum.photos/200/300","0.5 Liter originales Riegele Helles",new BigDecimal(1.7), 5, Category.CategoryType.BEER));
        productRepository.save(new Product(3L,"C3","Sonnenhof Samtrot fruchtsüß","https://picsum.photos/200/300","0.7 Liter Sonnenhofer Rotwein",new BigDecimal(4.99), 20, Category.CategoryType.WINE));
        productRepository.save(new Product(4L,"D4","Absolut Vodka", "https://picsum.photos/200/300","Hochprozentiger Wodka",new BigDecimal(9.99), 2, Category.CategoryType.SPIRITS));

        userRepository.save(new User(1L, "Andreas","Schmid", "schmidandreas.ul@gmail.com", passwordEncoder.encode("test"), null, new ArrayList<>()));
        userRepository.save(new User(2L, "Andreas","Schmid", "test@test.com",passwordEncoder.encode("test"),null, new ArrayList<>()));
    }
}