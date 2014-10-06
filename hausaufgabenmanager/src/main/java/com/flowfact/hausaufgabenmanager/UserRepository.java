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
		User a = new User("test1","testpass");
		User b = new User("test2","testpass");
		User c = new User("test3","testpass");
		a.setIndex(0);
		b.setIndex(1);
		c.setIndex(2);
		userList.add(a);
		userList.add(b);
		userList.add(c);
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
