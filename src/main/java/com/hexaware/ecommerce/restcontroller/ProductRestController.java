package com.hexaware.ecommerce.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.client.RestTemplate;

import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.entities.Product;
import com.hexaware.ecommerce.exception.ProductNotFoundException;
import com.hexaware.ecommerce.service.IProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	Logger logger = LoggerFactory.getLogger(ProductRestController.class);
	@Autowired
	private IProductService service;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/add")
	public Product addProduct(@RequestBody ProductDTO productDTO) {
		return service.addProduct(productDTO);
	}

	@PutMapping("/update")
	public Product updateProduct(@RequestBody ProductDTO productDTO) {
		return service.updateProduct(productDTO);
	}

	@DeleteMapping("/delete/{productId}")
	public void deleteById(@PathVariable int productId) {
		service.deleteProduct(productId);
		logger.info("Product Deleted Successfully");
	}

	@GetMapping("/get/{productId}")
	public ProductDTO getByproductById(@PathVariable @Valid @Min(1) int productId) throws ProductNotFoundException {
		if (productId == 0) {
			throw new ProductNotFoundException(HttpStatus.BAD_REQUEST, "product not found" + productId);
		}
		return service.getByproductId(productId);
	}

	@GetMapping("/getall")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

}
