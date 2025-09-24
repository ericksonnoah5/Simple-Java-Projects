package SmallProjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Password implements ActionListener {

	public JFrame window;
	public JTextField textUser, textPass;
	public JButton butEnter;
	public JLabel header, errMsgWrong, errMsgDone;
	public Font font;
	public JPanel background1, background2;
	public Color cBlueGreen, cCyan, cDarkBlue;
	public Scanner scnr;
	public JButton butCreate;
	public String strUser;
	public String strPass;
	public File file = new File("passwordholder.txt");
	public String strCurrent;
	public boolean boolUsername;
	public boolean boolPassword;
	public boolean boolCreateAccount = false;

	public Password() {
		window = new JFrame("Password");
		textPass = new JTextField();
		textUser = new JTextField();
		butEnter = new JButton("Enter");
		header = new JLabel("Enter a Username and Password");
		errMsgWrong = new JLabel("Error Incorrect Username or Password");
		errMsgDone = new JLabel("Account has already been created");
		font = new Font("Serif", Font.BOLD, 18);
		background1 = new JPanel();
		background2 = new JPanel();
		butCreate = new JButton("Create New Account");

		cBlueGreen = Color.decode("#7CCBC4");
		cCyan = Color.decode("#A5DAD5");
		cDarkBlue = Color.decode("#1D63C6");

		background1.setBackground(cBlueGreen);
		background1.setBounds(0, 0, 500, 550);
		background2.setBackground(cCyan);
		background2.setBounds(50, 50, 375, 375);

		window.setResizable(false);
		window.setLayout(null);
		window.setBounds(500, 150, 500, 550);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textPass.setBounds(75, 250, 300, 50);
		textPass.setFont(font);

		textUser.setFont(font);
		textUser.setBounds(75, 150, 300, 50);

		butEnter.setFont(font);
		butEnter.setBounds(75, 325, 100, 40);
		butEnter.addActionListener(this);
		butEnter.setBackground(Color.white);

		header.setFont(font);
		header.setBounds(75, 100, 500, 40);
		header.setForeground(Color.black);

		errMsgWrong.setFont(font);
		errMsgWrong.setBounds(75, 2000, 500, 40);

		errMsgDone.setFont(font);
		errMsgDone.setBounds(75, 2000, 500, 40);

		butCreate.setFont(font);
		butCreate.setBounds(175, 325, 210, 40);
		butCreate.addActionListener(this);
		butCreate.setBackground(Color.white);

		window.add(errMsgDone);
		window.add(butCreate);
		window.add(errMsgWrong);
		window.add(header);
		window.add(butEnter);
		window.add(textPass);
		window.add(textUser);
		window.add(background2);
		window.add(background1);
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(butEnter)) {
			strUser = textUser.getText();
			strPass = textPass.getText();
			boolUsername = false;
			boolPassword = false;
			strCurrent = "";

			try {
				scnr = new Scanner(file);
			} catch (FileNotFoundException err) {
				System.out.print("Error");
				err.printStackTrace();
			}

			while (true) {
				if (!scnr.hasNext()) {
					break;
				}
				strCurrent = scnr.next();

				if (strCurrent.equals("User:" + strUser)) {
					boolUsername = true;
					strCurrent = scnr.next();
					if (strCurrent.equals("Pass:" + strPass)) {
						boolPassword = true;
					}
					break;
				}
			}

			if (boolUsername == true && boolPassword == true) {
				window.dispose();
				new Calculator();
			} else {
				errMsgWrong.setBounds(75, 380, 500, 40);
			}
		} else if (e.getSource().equals(butCreate)) {
			strUser = textUser.getText();
			strPass = textPass.getText();

			try {
				scnr = new Scanner(file);
			} catch (FileNotFoundException err) {
				System.out.print("Error");
				err.printStackTrace();
			}

			while (true) {
				if (!scnr.hasNext()) {
					break;
				}
				strCurrent = scnr.next();

				if (strCurrent.equals("User:" + strUser)) {
					errMsgDone.setBounds(75, 360, 500, 40);
					boolCreateAccount = true;
					break;
				}
			}

			if (boolCreateAccount == false) {
				try {
					FileWriter writer = new FileWriter("passwordholder.txt", true);
					writer.write("\n");
					writer.write("User:" + strUser + " Pass:" + strPass);
					writer.close();
				} catch (IOException err) {
					err.printStackTrace();
				}
				boolCreateAccount = true;
			}
		}
	}
}