package com.hexaware.ecommerce.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.OrderDTO;
import com.hexaware.ecommerce.entities.Order;
import com.hexaware.ecommerce.exception.OrderNotFoundException;
import com.hexaware.ecommerce.service.IOrderService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

	@Autowired
	private IOrderService service;

	@PostMapping("/add")
	public Order createOrder(@RequestBody OrderDTO orderDTO) {
		return service.createOrder(orderDTO);
	}

	@PutMapping("/update")
	public Order updateOrder(@RequestBody OrderDTO orderDTO) {
		return service.updateOrder(orderDTO);
	}

	@DeleteMapping("/delete/{orderId}")
	public void deleteById(@PathVariable int orderId)
	{
		service.deleteOrder(orderId);
	}

	@GetMapping("/get/{orderId}")
	public OrderDTO getOrderById(@PathVariable @Valid @Min(1) int orderId)throws OrderNotFoundException {
		if(orderId==0) {
			throw new OrderNotFoundException(HttpStatus.BAD_REQUEST,"order not found"+orderId);
		}
		return service.getOrderById(orderId);
	}

	@GetMapping("/getall")
	public List<Order> getAllOrders(){
		return service.getAllOrders();
	}
}
