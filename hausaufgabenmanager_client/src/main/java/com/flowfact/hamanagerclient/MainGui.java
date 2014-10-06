package com.flowfact.hamanagerclient;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MainGui {
	
	public MainGui(Client client){
		build(client.getEntrys());
	}
	
	private void build(ArrayList<HomeworkEntry> entrys){
		JFrame f = new JFrame();
		f.setSize(800, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DetailTabPanel detailTabPanel = new DetailTabPanel();
		ViewPanel viewPanel = new ViewPanel(entrys, detailTabPanel);
		
		f.add(detailTabPanel, BorderLayout.CENTER);
		f.add(viewPanel, BorderLayout.WEST);
		f.setVisible(true);
	}
}
