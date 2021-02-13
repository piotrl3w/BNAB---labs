package pl.arsonproject.bnabd.bnabd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("Place")
    public Orders PlaceOrder(Orders order){
        orderRepository.save(order);

        order.getOrderProductsList().forEach(x -> {
            productRepository.delete(x.getProduct());
        });
        
        return order;
    }

}
