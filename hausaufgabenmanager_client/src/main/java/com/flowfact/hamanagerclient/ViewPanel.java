package com.flowfact.hamanagerclient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class ViewPanel extends JPanel {

	public ViewPanel(ArrayList<HomeworkEntry> entrys, final DetailTabPanel tabPanel){
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(250, 0));
		ArrayList<String> titles = new ArrayList<>();
		
		final JList<String> list = new JList<>();
		for(int i = 0; i < entrys.size(); i++){
			list.putClientProperty(i, entrys.get(i));
			titles.add(entrys.get(i).getTitle());
		}
		list.setListData(titles.toArray(new String[titles.size()]));
		list.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				if(e.getClickCount() == 2){
					HomeworkEntry entry = (HomeworkEntry) list.getClientProperty(list.locationToIndex(e.getPoint()));
					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					JTextArea area = new JTextArea();
					area.setRows(30);
					area.setColumns(20);
					area.setBorder(new CompoundBorder(new EmptyBorder(20,20,20,20), BorderFactory.createDashedBorder(Color.GRAY)));
					area.setText(entry.getContent());
					panel.add(area);
					tabPanel.addTab(entry.getTitle(), panel);
					
				}
			}
		});
		add(list);
	}
}
