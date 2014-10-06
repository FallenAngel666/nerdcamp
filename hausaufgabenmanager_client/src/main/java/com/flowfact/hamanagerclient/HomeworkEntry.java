package com.flowfact.hamanagerclient;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="entry")
public class HomeworkEntry {

	private int id;
	private String ownerName;
	private String title;
	private String content;
	private String subject;
	private Date date;
	
	public HomeworkEntry(){
	
	}

	public String getOwnerName(){
		return ownerName;
	}

	public String getTitle(){
		return title;
	}

	public String getContent(){
		return content;
	}

	public Date getDate(){
		return date;
	}
	
	public int getId(){
		return id;
	}

	@XmlElement(name="owner")
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@XmlAttribute
	public void setId(int id){
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@XmlElement(name="expires")
	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String toString() {
		return "[ENTTRY] id = " + id + ", title = " + title + ", subject = " + subject + ", content = " + content + ", owner = " + ownerName + ", date = " + date;
	}
}
