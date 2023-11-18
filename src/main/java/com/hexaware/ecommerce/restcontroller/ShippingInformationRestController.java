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

import com.hexaware.ecommerce.dto.ShippingInformationDTO;
import com.hexaware.ecommerce.entities.ShippingInformation;
import com.hexaware.ecommerce.service.IShippingInformation;

@RestController
@RequestMapping("/api/shipping")
public class ShippingInformationRestController {

	@Autowired
	private IShippingInformation service;

	@PostMapping("/add")
	public ShippingInformation addShippingInformation(@RequestBody ShippingInformationDTO shippingInformationDTO) {
		return service.addShippingInformation(shippingInformationDTO);
	}

	@PutMapping("/update")
	public ShippingInformation updateShippingInformation(@RequestBody ShippingInformationDTO shippingInformationDTO) {
		return service.updateShippingInformation(shippingInformationDTO);
	}

	@DeleteMapping("/delete/{shippingId}")
	public void deleteById(@PathVariable int shippingId)
	{
		service.deleteShippingInformation(shippingId);
	}

	@GetMapping("/get/{shippingId}")
	public ShippingInformationDTO getAdminById(@PathVariable int shippingId) {
		return service.getShippingInformationById(shippingId);
	}
	@GetMapping("/getall")
	public List<ShippingInformation> getAllShippingInformations(){
		return service.getAllShippingInformations();
	}
}
