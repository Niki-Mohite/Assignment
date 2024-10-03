package com.example.demo2;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

	public boolean validateAccount(String accountNumber) {

		return accountNumber != null && accountNumber.matches("ACC\\d{6}");
	}

	public String getBankDetails(String accountNumber) {
		if (validateAccount(accountNumber)) {

			return "Bank of India, Branch of Bangalore";
		}
		return "Unknown Bank";
	}
}
