package com.universalcopy.p_integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universalcopy.p_integrador.model.Order;
import com.universalcopy.p_integrador.model.OrderDetail;
import com.universalcopy.p_integrador.model.Product;
import com.universalcopy.p_integrador.repository.OrderDetailRepository;
import com.universalcopy.p_integrador.repository.ProductRepository;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private ProductRepository productRepository;

	public OrderDetail addProduct(Order order, Long productId, Integer quantity) {

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new IllegalArgumentException("Producto no existe"));


		OrderDetail detail = new OrderDetail();
		detail.setOrder(order);
		detail.setProduct(product);
		detail.setQuantity(quantity);
		detail.setUnitPrice(product.getPrice());

		return orderDetailRepository.save(detail);
	}//addProduct

    public List<OrderDetail> getDetailsByOrder(Order order) {
        return orderDetailRepository.findByOrder(order);
    }//getDetailsByOrder

    public OrderDetail getDetail(Long id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OrderDetail no existe"));
    }//getDetail
}
