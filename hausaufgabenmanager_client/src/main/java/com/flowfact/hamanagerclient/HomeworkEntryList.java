package com.flowfact.hamanagerclient;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="homeworks")
public class HomeworkEntryList {
	
	private ArrayList<HomeworkEntry> entrys;

	public ArrayList<HomeworkEntry> getEntrys(){
		return entrys;
	}

	@XmlElement(name="entry")
	public void setEntrys(ArrayList<HomeworkEntry> entrys){
		this.entrys = entrys;
	}
}
