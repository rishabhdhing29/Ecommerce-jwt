package com.hexaware.ecommerce.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.CartDTO;
import com.hexaware.ecommerce.entities.Cart;
import com.hexaware.ecommerce.service.ICartService;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

	@Autowired
	private ICartService service;

	@PostMapping("/add")
	public Cart createCart(@RequestBody CartDTO cartDTO) {
		return service.createCart(cartDTO);
	}

	@PutMapping("/update")
	public Cart updateCart(@RequestBody CartDTO cartDTO) {
		return service.updateCart(cartDTO);
	}

	@DeleteMapping("/delete/{cartId}")
	public void deleteById(@PathVariable int cartId)
	{
		service.deleteCart(cartId);
	}

	@GetMapping("/get/{cartId}")
	public CartDTO getAdminById(@PathVariable int cartId) {
		return service.getCartById(cartId);
	}
	@GetMapping("/getall")
	public List<Cart> getAllCarts(){
		return service.getAllCarts();
	}
}
