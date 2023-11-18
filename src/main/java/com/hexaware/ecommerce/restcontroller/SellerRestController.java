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

import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entities.Seller;
import com.hexaware.ecommerce.service.ISellerService;

@RestController
@RequestMapping("/api/seller")
public class SellerRestController {


	@Autowired
	private ISellerService service;

	@PostMapping("/add")
	public Seller createSeller(@RequestBody SellerDTO sellerDTO) {
		return service.createSeller(sellerDTO);
	}

	@PutMapping("/update")
	public Seller updateSeller(@RequestBody SellerDTO sellerDTO) {
		return service.updateSeller(sellerDTO);
	}

	@DeleteMapping("/delete/{sellerId}")
	public void deleteById(@PathVariable int sellerId)
	{
		service.deleteSeller(sellerId);
	}

	@GetMapping("/get/{sellerId}")
	public SellerDTO getAdminById(@PathVariable int sellerId) {
		return service.getSellerById(sellerId);
	}
	@GetMapping("/getall")
	public List<Seller> getAllSellers(){
		return service.getAllSellers();
	}
}
