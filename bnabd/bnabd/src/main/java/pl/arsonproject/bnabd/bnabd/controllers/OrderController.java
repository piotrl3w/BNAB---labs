package pl.arsonproject.bnabd.bnabd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.arsonproject.bnabd.bnabd.model.Orders;
import pl.arsonproject.bnabd.bnabd.repository.OrderRepository;
import pl.arsonproject.bnabd.bnabd.repository.OrdersProductsRepository;
import pl.arsonproject.bnabd.bnabd.repository.ProductRepository;

@RestController
@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("place")
    public Orders PlaceOrder(@RequestBody Orders order){
        orderRepository.save(order);
        
        return order;
    }

}
