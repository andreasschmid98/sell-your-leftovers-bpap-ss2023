package de.hsaugsburg.bpap.ss23.sellyourleftovers.service;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.CartRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.ProductResponse;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.mapper.ProductMapper;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Product;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.User;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final UserService userService;
    private final ProductService productService;


    public List<ProductResponse> getAllCartItems() {

        User user = userService.getCurrentUser();
        List<ProductResponse> cartItems = new ArrayList<>();

        for ( Product product : user.getCartItems()) {
            cartItems.add(ProductMapper.map(product));
        }

        return  cartItems;
    }

    public void addCartItem(CartRequest cartRequest) {
        User user = userService.getCurrentUser();
        Product product = productService.findProductById(cartRequest.getProductId());
        user.addCartItem(product);
        userService.save(user);

    }

    public void removeCartItem(CartRequest cartRequest) {
        User user = userService.getCurrentUser();
        Product product = productService.findProductById(cartRequest.getProductId());
        user.removeCartItem(product);
        userService.save(user);
    }

}
