package com.flowfact.hausaufgabenmanager;

public class AuthenticationService {

	private UserRepository userRepository = new UserRepository();

	public boolean authenticate(String username, String password) {
		User user = userRepository.getUser(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

}
