package de.hsaugsburg.bpap.ss23.sellyourleftovers.service;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.OrderRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.User;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserService userService;
    private final ProductRepository productRepository;

    public void order(OrderRequest orderRequest){
        List<Product> products = new ArrayList<>();

        for (Long productId : orderRequest.getProductIds()) {
            Product product = productRepository.findProductById(productId);
            products.add(product);
        }

        placeOrder(products);
        refreshCarts(products);
    }

    private void placeOrder(List<Product> products) {
        User user = userService.getCurrentUser();

        for( Product product : products) {
            user.addOrder(product);
            product.setAvailable(false);
            productRepository.save(product);
        }

        userService.save(user);
    }

    private void refreshCarts(List<Product> products) {
        List<User> users = userService.getAllUsers();

        for(User user : users) {
            user.getCartItems().removeIf(products::contains);
            userService.save(user);
        }
    }
}
