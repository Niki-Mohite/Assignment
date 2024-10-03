package com.example.demo2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	@Autowired
	private AccountService accountService;

	public List<PaymentInstruction> createPaymentInstruction(PaymentRequest request) {
		if (!accountService.validateAccount(request.getDebitAccount())
				|| !accountService.validateAccount(request.getCreditAccount())) {
			throw new IllegalArgumentException("Invalid account details");
		}

		List<PaymentInstruction> instructions = new ArrayList<>();

		PaymentInstruction debitInstruction = new PaymentInstruction();
		debitInstruction.setAccountNumber(request.getDebitAccount());
		debitInstruction.setCurrency("USD");
		debitInstruction.setInstructionType("Debit");
		debitInstruction.setAmount(request.getAmount());
		String bankDetails = accountService.getBankDetails(request.getDebitAccount());
		debitInstruction.setBank(bankDetails);
		debitInstruction.setBranch(bankDetails);
		instructions.add(debitInstruction);

		PaymentInstruction creditInstruction = new PaymentInstruction();
		creditInstruction.setAccountNumber(request.getCreditAccount());
		creditInstruction.setCurrency("USD");
		creditInstruction.setInstructionType("Credit");
		creditInstruction.setAmount(request.getAmount());
		bankDetails = accountService.getBankDetails(request.getCreditAccount());
		creditInstruction.setBank(bankDetails);
		creditInstruction.setBranch(bankDetails);
		instructions.add(creditInstruction);

		return instructions;
	}
}
