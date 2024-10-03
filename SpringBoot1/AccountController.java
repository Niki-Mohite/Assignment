package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/{accountNumber}")
	public ResponseEntity<?> getAccountDetails(@PathVariable String accountNumber) {
		if (accountService.validateAccount(accountNumber)) {
			// Mock account details
			return ResponseEntity.ok(accountService.getBankDetails(accountNumber));
		} else {
			return ResponseEntity.status(404).body("Account not found");
		}
	}
}
