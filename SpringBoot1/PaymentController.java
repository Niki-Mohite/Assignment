package com.example.demo2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/send")
	public ResponseEntity<?> sendPaymentInstruction(@RequestBody PaymentRequest request) {
		System.out.println("Received Payment Request: " + request);
		try {
			List<PaymentInstruction> instructions = paymentService.createPaymentInstruction(request);
			return ResponseEntity.ok(instructions);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
		}
	}
}
