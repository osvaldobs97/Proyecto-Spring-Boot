package com.universalcopy.p_integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.universalcopy.p_integrador.model.OrderCustomization;
import com.universalcopy.p_integrador.model.OrderDetail;
import com.universalcopy.p_integrador.service.OrderCustomizationService;
import com.universalcopy.p_integrador.service.OrderDetailService;
import com.universalcopy.p_integrador.service.OrderService;

@RestController
@RequestMapping("/api/orders/{orderId}/details/{detailId}/customizations")
public class OrderCustomizationController {

    private final OrderCustomizationService customizationService;
    private final OrderDetailService detailService;
    private final OrderService orderService;

    @Autowired
    public OrderCustomizationController(
            OrderCustomizationService customizationService,
            OrderDetailService detailService,
            OrderService orderService) {
        this.customizationService = customizationService;
        this.detailService = detailService;
        this.orderService = orderService;
    }


    @GetMapping
    public List<OrderCustomization> getCustomizations(
            @PathVariable Long orderId,
            @PathVariable Long detailId) {

        orderService.getOrder(orderId); 
        OrderDetail detail = detailService.getDetail(detailId); 

        return customizationService.GetOrderDetailsCustomization(detail);
    }

    @PostMapping
    public OrderCustomization addCustomization(
            @PathVariable Long orderId,
            @PathVariable Long detailId,
            @RequestParam Long productCustomizationId,
            @RequestParam Double value) {

        orderService.getOrder(orderId);
        OrderDetail detail = detailService.getDetail(detailId);

        return customizationService.addCustomization(detail, productCustomizationId, value);
    }
}
