package com.flowfact.hausaufgabenmanager;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	List<User> userList = new ArrayList<User>();

	public UserRepository() {
		createDummyObjects();
	}
	
	/**
	 * Method to create dummy data for testing
	 */
	public void createDummyObjects() {
		userList.add(new User("test1", "testpass"));
		userList.add(new User("test2", "testpass"));
		userList.add(new User("test3", "testpass"));
	}

	public User getUser(String username) {
		for (User user : userList) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return user;
			}
		}
		return null;
	}
}
