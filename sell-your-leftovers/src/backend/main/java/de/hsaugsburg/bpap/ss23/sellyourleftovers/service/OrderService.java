package de.hsaugsburg.bpap.ss23.sellyourleftovers.service;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.OrderLineItemsDto;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.dto.request.OrderRequest;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.Order;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.model.OrderLineItem;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public ResponseEntity<?> placeOrder(OrderRequest orderRequest){
        Order order = new Order();

        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(orderLineItem -> mapOrderLineItemsDtoToOrderLineItems(orderLineItem))
                .toList();

        order.setOrderLineItemList(orderLineItemList);

        orderRepository.save(order);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    private OrderLineItem mapOrderLineItemsDtoToOrderLineItems(OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItem.builder()
                .quantity(orderLineItemsDto.getQuantity())
                .skuCode(orderLineItemsDto.getSkuCode())
                .build();
    }


}
