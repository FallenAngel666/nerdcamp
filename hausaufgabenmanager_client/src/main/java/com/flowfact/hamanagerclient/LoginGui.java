package com.flowfact.hamanagerclient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginGui {

	private Font font;
	private JFrame frame;
	private EmptyBorder emptyBorder;
	private InputPanel userInput;
	private InputPanel passwordInput;

	public LoginGui(final Client client) {
		this.frame = new JFrame();
		frame.setSize(300, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		font = new Font("Calibri", Font.BOLD, 15);
		emptyBorder = new EmptyBorder(20, 0, 20, 0);

		JPanel content = new JPanel(new FlowLayout(FlowLayout.CENTER));
		content.setBackground(Color.DARK_GRAY);

		userInput = new InputPanel("username", false);
		passwordInput = new InputPanel("password", true);
		content.add(userInput);
		content.add(passwordInput);
		 content.add(buildButton("login", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userInput.getValue();
				String password = passwordInput.getValue();
				if (username.equalsIgnoreCase(Client.USER)
						&& password.equals(Client.PASSWORD)) {
					client.setLoggedInUser(new User(username));
					new MainGui(client);
					frame.dispose();
				} 
				else {
					JOptionPane.showMessageDialog(null, "Benutzername und/oder Passwort falsch!", "", JOptionPane.ERROR_MESSAGE);
				}
			}
		}));
		content.add(buildButton("register", null));

		frame.add(content);
		frame.setVisible(true);
	}

	private JButton buildButton(String name, ActionListener listener) {
		JButton button = new JButton(name);
		button.setFocusPainted(false);
		button.addActionListener(listener);
		button.setPreferredSize(new Dimension(150, 25));
		return button;
	}

	class InputPanel extends JPanel {

		private JTextField inputField;

		public InputPanel(String name, boolean inputHidden) {
			setBorder(emptyBorder);
			setLayout(new GridLayout(1, 2));
			setBackground(Color.DARK_GRAY);
			JLabel label = new JLabel(name + ":");
			label.setForeground(Color.WHITE);
			label.setFont(font);
			if (inputHidden){
				this.inputField = new JPasswordField();
			}
			else{
				this.inputField = new JTextField();
			}
			inputField.setColumns(10);
			inputField.setFont(font.deriveFont(Font.PLAIN));
			add(label);
			add(inputField);
		}

		public String getValue() {
			if(inputField instanceof JPasswordField){
				return new String(((JPasswordField) inputField).getPassword());
			}
			return inputField.getText();
		}
	}
}
