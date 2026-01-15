package com.universalcopy.p_integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universalcopy.p_integrador.model.Order;
import com.universalcopy.p_integrador.model.OrderDetail;
import com.universalcopy.p_integrador.service.OrderDetailService;
import com.universalcopy.p_integrador.service.OrderService;

@RestController
@RequestMapping("/api/orders/{orderId}/details")
public class OrderDetailsController {

    private final OrderDetailService detailService;
    private final OrderService orderService;

    @Autowired
    public OrderDetailsController(OrderDetailService detailService, OrderService orderService) {
        this.detailService = detailService;
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDetail> getDetails(@PathVariable Long orderId) {
        Order order = orderService.getOrder(orderId);
        return detailService.getDetailsByOrder(order);
    }

    @GetMapping("/{detailId}")
    public OrderDetail getDetail(@PathVariable Long orderId, @PathVariable Long detailId) {
        orderService.getOrder(orderId); 
        return detailService.getDetail(detailId);
    }
    
    @PostMapping
    public OrderDetail addProduct(
            @PathVariable Long orderId,
            @RequestParam(name = "productId") Long productId,
            @RequestParam(name = "quantity") Integer quantity) {

        Order order = orderService.getOrder(orderId);
        return detailService.addProduct(order, productId, quantity);
    }

}
