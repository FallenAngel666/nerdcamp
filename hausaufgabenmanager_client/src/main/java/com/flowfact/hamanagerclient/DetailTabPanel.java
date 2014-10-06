package com.flowfact.hamanagerclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DetailTabPanel extends JPanel {

	private JTabbedPane pane;
	
	public DetailTabPanel(){
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		this.pane = new JTabbedPane();
		add(pane);
	}
	
	public void addTab(String title, Component content){
		pane.addTab(title, content);
	}
}
