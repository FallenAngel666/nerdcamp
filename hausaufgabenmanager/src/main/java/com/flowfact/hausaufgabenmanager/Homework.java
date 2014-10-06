package com.flowfact.hausaufgabenmanager;

import java.util.Date;

public class Homework {
	
	private String subject;
	private String title;
	private String task;
	private Date date;
	private final User user;
	private boolean done = false;
	private int index = -1;
	
	public Homework(String subject, String title, String task, Date date, User user) {
		this.subject = subject;
		this.date = date;
		this.task = task;
		this.title = title;
		this.user = user;
	}
	public Homework(String subject, String title, String task, Date date, User user, boolean done) {
		this.subject = subject;
		this.date = date;
		this.task = task;
		this.title = title;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

}

