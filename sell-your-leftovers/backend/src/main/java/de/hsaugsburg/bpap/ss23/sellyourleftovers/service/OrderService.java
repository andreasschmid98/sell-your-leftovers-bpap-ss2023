package de.hsaugsburg.bpap.ss23.sellyourleftovers.service;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.OrderRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This defines the service class for managing the order functionality.
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserService userService;
    private final ProductService productService;
    private final CartService cartService;
    private final EmailService emailService;

    public void order(OrderRequest orderRequest) {

        List<Product> products = new ArrayList<>();

        for (Long productId : orderRequest.getProductIds()) {
            Product product = productService.findProductById(productId);
            products.add(product);
        }

        placeOrder(products);
        emailService.send(products);
        cartService.refreshCarts(products);

    }

    private void placeOrder(List<Product> products) {

        User user = userService.getCurrentUser();

        for (Product product : products) {
            user.addOrder(product);
            product.setAvailable(false);
            productService.save(product);
        }

        userService.save(user);
    }

}
