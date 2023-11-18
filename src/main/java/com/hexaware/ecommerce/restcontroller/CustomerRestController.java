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

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entities.Customer;
import com.hexaware.ecommerce.exception.CustomerNotFoundException;
import com.hexaware.ecommerce.service.ICustomerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;


@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	@Autowired
	private ICustomerService service;

	@PostMapping("/add")
	public Customer createCustomer(@RequestBody CustomerDTO customerDTO) {
		return service.createCustomer(customerDTO);
	}

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody CustomerDTO customerDTO) {
		return service.updateCustomer(customerDTO);
	}

	@DeleteMapping("/delete/{customerId}")
	public void deleteById(@PathVariable int customerId)
	{
		service.deleteCustomer(customerId);
	}


	 @GetMapping("/get/{customerId}")
	 public CustomerDTO getCustomerById(@PathVariable @Valid  @Min(1) int customerId) throws CustomerNotFoundException{

		 if(customerId==0) {
				throw new CustomerNotFoundException(HttpStatus.BAD_REQUEST,"customer not found"+customerId);
			}
		 return service.getCustomerById(customerId);
		 }

	@GetMapping("/getall")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}

}
