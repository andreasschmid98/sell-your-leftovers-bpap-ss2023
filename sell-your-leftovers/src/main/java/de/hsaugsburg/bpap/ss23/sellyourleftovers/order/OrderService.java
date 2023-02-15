package de.hsaugsburg.bpap.ss23.sellyourleftovers.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();

        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(orderLineItem -> mapOrderLineItemsDtoToOrderLineItems(orderLineItem))
                .toList();

        order.setOrderLineItemList(orderLineItemList);

        orderRepository.save(order);
    }

    private OrderLineItem mapOrderLineItemsDtoToOrderLineItems(OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItem.builder()
                .quantity(orderLineItemsDto.getQuantity())
                .skuCode(orderLineItemsDto.getSkuCode())
                .build();
    }


}
