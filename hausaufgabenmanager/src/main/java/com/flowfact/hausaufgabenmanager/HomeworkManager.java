package com.flowfact.hausaufgabenmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HomeworkManager {

	private List<Homework> tasks = new LinkedList<Homework>();
	
	public void createDummyTasks(AuthenticationService service) {
		add(new Homework("GE","", "Seite 100, A42", new Date(),
				service.getUserRepository().getUser("test1")));
		add(new Homework("GE","", "Seite 100, A43", new Date(),
				service.getUserRepository().getUser("test1"),
				true));
		add(new Homework("GE","", "Seite 100, A44", new Date(),
				service.getUserRepository().getUser("test2")));

	}

	public void set(int index, String subject, String title, String task, Date date, User user, boolean done) {
		set(index, new Homework(subject, title, task, date, user, done));
	}
	
	public void set(int index, String subject, String title, String task, Date date, User user) {
		set(index, new Homework(subject, title, task, date, user));
	}
	
	public void set(int index, Homework task) {
		task.setIndex(index);
		tasks.set(index,task);
	}
	
	public void add(String subject, String title, String task, Date date, User user, boolean done) {
		add(new Homework(subject, title, task, date, user, done));
	}
	
	public void add(String subject, String title, String task, Date date, User user) {
		add(new Homework(subject, title, task, date, user));
	}
	
	public void add(Homework task) {
		task.setIndex(tasks.size());
		tasks.add(task);
	}
	
	public List<Homework> readAll() {
		return tasks;
	}

	// alle aufgaben bei mir
	public List<Homework> read(String username) {
		List<Homework> deinErgebnis = new ArrayList<Homework>();
		for (Homework homework : tasks) {
			if (homework.getUser().getUsername().equalsIgnoreCase(username)) {
				deinErgebnis.add(homework);
			}

		}
		return deinErgebnis;

	}

	// unerledigt/erledigt bei mir
	public List<Homework> read(String username, boolean done) {
		List<Homework> deinErgebnis = new ArrayList<Homework>();
		for (Homework homework : tasks) {
			if (homework.getUser().getUsername().equalsIgnoreCase(username)
					&& (done == homework.isDone())) {
				deinErgebnis.add(homework);
			}
		}
		return deinErgebnis;
	}

	// unerledigt/erledigt bei allen
	public List<Homework> read(boolean done) {
		List<Homework> deinErgebnis = new ArrayList<Homework>();
		for (Homework homework : tasks) {
			if (done == homework.isDone()) {
				deinErgebnis.add(homework);
			}
		}
		return deinErgebnis;
	}
}
