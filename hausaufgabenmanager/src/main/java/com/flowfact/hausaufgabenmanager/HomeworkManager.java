package com.flowfact.hausaufgabenmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HomeworkManager {

	private List<Homework> tasks = new LinkedList<Homework>();
	private final AuthenticationService service;
	
	public HomeworkManager(AuthenticationService service) {
		this.service = service;
	}
	
	public void createDummyTasks() {
		tasks.add(new Homework("GE", "Seite 100, A42", new Date(),
				service.getUserRepository().getUser("test1")));
		tasks.add(new Homework("GE", "Seite 100, A43", new Date(),
				service.getUserRepository().getUser("test1"),
				true));
		tasks.add(new Homework("GE", "Seite 100, A44", new Date(),
				service.getUserRepository().getUser("test2")));

	}

	public void set(int index, String subject, String task, Date date, User user, boolean done) {
		addHomework(new Homework(subject, task, date, user, done));
	}
	
	public void set(int index, String subject, String task, Date date, User user) {
		addHomework(new Homework(subject, task, date, user));
	}
	
	public void setHomework(int index, Homework task) {
		tasks.add(task);
	}
	
	public void add(String subject, String task, Date date, User user, boolean done) {
		addHomework(new Homework(subject, task, date, user, done));
	}
	
	public void add(String subject, String task, Date date, User user) {
		addHomework(new Homework(subject, task, date, user));
	}
	
	public void addHomework(Homework task) {
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
