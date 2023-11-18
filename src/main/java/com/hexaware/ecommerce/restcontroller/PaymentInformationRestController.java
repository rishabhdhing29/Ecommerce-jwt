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

import com.hexaware.ecommerce.dto.PaymentInformationDTO;
import com.hexaware.ecommerce.entities.PaymentInformation;
import com.hexaware.ecommerce.exception.PaymentNotFoundException;
import com.hexaware.ecommerce.service.IPaymentInformationService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;



@RestController
@RequestMapping("/api/paymentinfo")
public class PaymentInformationRestController {

	@Autowired
	private IPaymentInformationService service;

	@PostMapping("/add")
	public PaymentInformation addPaymentInformation(@RequestBody PaymentInformationDTO paymentInformationDTO) {
		return service.addPaymentInformation(paymentInformationDTO);
	}

	@PutMapping("/update")
	public PaymentInformation updatePaymentInformation(@RequestBody PaymentInformationDTO paymentInformationDTO) {
		return service.updatePaymentInformation(paymentInformationDTO);
	}

	@DeleteMapping("/delete/{paymentId}")
	public void deleteById(@PathVariable int paymentId) {
		service.deletePaymentInformation(paymentId);
	}

	@GetMapping("/get/{paymentId}")
	public PaymentInformationDTO getBypaymentId(@PathVariable @Valid @Min(1) int paymentId) throws PaymentNotFoundException {
		if(paymentId==0) {
			throw new PaymentNotFoundException(HttpStatus.BAD_REQUEST,"payment not found"+paymentId);
		}
		return service.getBypaymentId(paymentId);
	}

	@GetMapping("/getall")
	public List<PaymentInformation> getAllPayments() {
		return service.getAllPayments();
	}
}
