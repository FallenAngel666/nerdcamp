package com.flowfact.hausaufgabenmanager;

public class AuthenticationService {

	private UserRepository userRepository;

	public boolean authenticate(String username, String password) {
		User user = userRepository.getUser(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}

		return false;
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}
}