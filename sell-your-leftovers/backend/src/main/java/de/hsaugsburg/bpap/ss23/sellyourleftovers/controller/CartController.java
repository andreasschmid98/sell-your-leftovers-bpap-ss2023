package de.hsaugsburg.bpap.ss23.sellyourleftovers.controller;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.CartRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.response.ProductResponse;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addCartItem(@RequestBody CartRequest cartRequest) {
        cartService.addCartItem(cartRequest);
    }

    @PostMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public void removeCartItem( @RequestBody CartRequest cartRequest) {
        cartService.removeCartItem(cartRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllCartItems(){
        return cartService.getAllCartItems();
    }
}
