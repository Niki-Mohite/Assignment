package com.example.assign;

import com.example.assign.Account;
import com.example.assign.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
		return accountRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
		return accountRepository.findById(id).map(account -> {
			account.setCurrency(accountDetails.getCurrency());
			account.setBank(accountDetails.getBank());
			account.setBranch(accountDetails.getBranch());
			return ResponseEntity.ok(accountRepository.save(account));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
		return accountRepository.findById(id).map(account -> {
			accountRepository.delete(account);
			return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
