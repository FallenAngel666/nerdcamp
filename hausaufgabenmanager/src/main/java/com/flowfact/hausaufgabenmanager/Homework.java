package com.flowfact.hausaufgabenmanager;

import java.util.Date;

public class Homework {
	
	private String subject;
	private String task;
	private Date date;
	private final User user;
	private boolean done = false;
	
	public Homework(String subject, String task, Date date, User user) {
		this.subject = subject;
		this.date = date;
		this.task = task;
		this.user = user;
	}
	public Homework(String subject, String task, Date date, User user, boolean done) {
		this.subject = subject;
		this.date = date;
		this.task = task;
		this.user = user;
		this.setDone(done);
	}
	
	public Date getAbgabe() {
		return date;
	}
	public void setAbgabe(Date abgabe) {
		this.date = abgabe;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getFach() {
		return subject;
	}
	public void setFach(String fach) {
		this.subject = fach;
	}

	public User getUser() {
		return user;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}

}

