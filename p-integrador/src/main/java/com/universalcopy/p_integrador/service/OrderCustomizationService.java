package com.universalcopy.p_integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universalcopy.p_integrador.model.OrderCustomization;
import com.universalcopy.p_integrador.model.OrderDetail;
import com.universalcopy.p_integrador.model.ProductCustomization;
import com.universalcopy.p_integrador.repository.OrderCustomizationRepository;
import com.universalcopy.p_integrador.repository.ProductCustomizationRepository;

@Service
public class OrderCustomizationService {

    @Autowired
    private OrderCustomizationRepository repository;

    @Autowired
    private ProductCustomizationRepository productCustomizationRepository;

   
    public OrderCustomization addCustomization(OrderDetail detail, Long productCustomizationId, Double value) {
        ProductCustomization pc = productCustomizationRepository.findById(productCustomizationId)
                .orElseThrow(() -> new IllegalArgumentException("Personalización no válida"));

        OrderCustomization oc = new OrderCustomization();
        oc.setOrderDetail(detail);
        oc.setCustomizationType(pc.getCustomizationType());
        oc.setExtraPrice(pc.getExtraPrice());
        oc.setValue(value);

        return repository.save(oc);
    }


    public List<OrderCustomization> GetOrderDetailsCustomization(OrderDetail detail) {
        return repository.findByOrderDetail(detail);
    }

  
    public OrderCustomization GetOrderDetailCustomization(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OrderCustomization no existe"));
    }
}
