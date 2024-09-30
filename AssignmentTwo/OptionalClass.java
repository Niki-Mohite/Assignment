package com.nikita.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class User {
	private Long id;
	private String name;
	private String email;

	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}

class UserData {
	private Map<Long, User> userDetails = new HashMap<>();

	public UserData() {
		userDetails.put(3L, new User(3L, "Nikita", "mohitenik@techies.com"));
		userDetails.put(2L, new User(2L, "Abhishek", "akulkarni@techies.com"));
	}

	public Optional<User> findUserById(Long id) {
		return Optional.ofNullable(userDetails.get(id));
	}
}

class UserService {
	private UserData userData = new UserData();

	public String getUserEmailById(Long id) {
		return userData.findUserById(id).map(User::getEmail).orElse("User not found");
	}
}

public class OptionalClass {
	public static void main(String[] args) {
		UserService userService = new UserService();
		System.out.println(userService.getUserEmailById(2L));
		System.out.println(userService.getUserEmailById(1L));
	}
}
