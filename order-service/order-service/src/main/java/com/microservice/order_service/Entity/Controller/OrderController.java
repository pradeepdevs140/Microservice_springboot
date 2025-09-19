package com.microservice.order_service.Entity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.order_service.DTO.OrderResponseDTO;
import com.microservice.order_service.DTO.ProductDTO;
import com.microservice.order_service.Entity.Order;
import com.microservice.order_service.Repository.OrderRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@PostMapping("/placeorder")
	public Mono<ResponseEntity<OrderResponseDTO>> placeorder(@RequestBody Order order) {
	    return webClientBuilder.build()
	            .get()
	            .uri("http://localhost:8081/product/" + order.getProductId())
	            .retrieve()
	            .bodyToMono(ProductDTO.class)
	            .map(productDTO -> {
	                // Save the order in DB
	                Order savedOrder = orderRepository.save(order);

	                // Prepare response DTO
	                OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
	                orderResponseDTO.setOrderId(savedOrder.getId()); // use generated ID
	                orderResponseDTO.setProductId(savedOrder.getProductId());
	                orderResponseDTO.setQuantity(savedOrder.getQuantity());
	                orderResponseDTO.setProductName(productDTO.getName());
	                orderResponseDTO.setProductPrice(productDTO.getPrice());
	                orderResponseDTO.setTotalprice(savedOrder.getQuantity() * productDTO.getPrice());

	                return ResponseEntity.ok(orderResponseDTO);
	            });
	}

	@GetMapping
	public List<Order> getorders(){
		return orderRepository.findAll();
	}
	
}
