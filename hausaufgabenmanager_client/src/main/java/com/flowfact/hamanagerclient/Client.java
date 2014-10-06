package com.flowfact.hamanagerclient;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIManager;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Client {
	
	public static final String USER = "TEST";
	public static final String PASSWORD = "1234";
	
	private User loggedInUser;
	
	public Client(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e){
			e.printStackTrace();
		}
		new LoginGui(this);
	}
	
	public ArrayList<HomeworkEntry> getEntrys(){
		HomeworkEntryList  homeworkList = new HomeworkEntryList();
		ArrayList<HomeworkEntry> entrys = new ArrayList<>();
		
		HomeworkEntry entry = new HomeworkEntry();
		entry.setId(0);
		entry.setContent("seite test");
		entry.setOwnerName("Jakob");
		entry.setDate(new Date());
		entry.setSubject("maths");
		entry.setTitle("Englisch Ha 1");
		
		HomeworkEntry entry2 = new HomeworkEntry();
		entry2.setId(0);
		entry2.setContent("seite test");
		entry2.setOwnerName("Blabla");
		entry2.setDate(new Date());
		entry2.setSubject("english");
		entry2.setTitle("Klausurvorbereitung 2");
		
		entrys.add(entry);
		entrys.add(entry2);
		homeworkList.setEntrys(entrys);
		
		try {
			JAXBContext ctx = JAXBContext.newInstance(HomeworkEntryList.class);
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File f = new File("C:\\Users\\nerd-camp\\test.xml");
			f.createNewFile();
			m.marshal(homeworkList, f);
			m.marshal(homeworkList, System.out);
		
			Unmarshaller unm = ctx.createUnmarshaller();
			HomeworkEntryList entryList = (HomeworkEntryList) unm.unmarshal(f);
			ArrayList<HomeworkEntry> readEntrys = entryList.getEntrys();
			for(HomeworkEntry e : readEntrys){
				System.out.println(e);
			}
			return readEntrys;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setLoggedInUser(User user){
		this.loggedInUser = user;
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
