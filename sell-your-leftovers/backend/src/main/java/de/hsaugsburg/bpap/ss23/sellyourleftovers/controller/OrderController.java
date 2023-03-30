package de.hsaugsburg.bpap.ss23.sellyourleftovers.controller;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.OrderRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void order(@RequestBody OrderRequest orderRequest){
        orderService.order(orderRequest);
    }

}
