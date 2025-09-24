package SmallProjects;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Jokes implements ActionListener {

	public JFrame window;
	public Random rand = new Random();
	public int randJoke;
	public Scanner scnr;
	public File file = new File("myTextFilex.txt");
	public String strJoke = "";
	public JTextField textJoke;
	public JButton butJoke;
	public JPanel background2, background1;
	public Color cBlueGreen, cCyan, cDarkBlue;

	public Jokes() {
		window = new JFrame("Fun");
		window.setLayout(null);
		window.setBounds(450, 200, 600, 250);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		background2 = new JPanel();
		background1 = new JPanel();

		cBlueGreen = Color.decode("#7CCBC4");
		cCyan = Color.decode("#A5DAD5");
		cDarkBlue = Color.decode("#1D63C6");

		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.print("Error");
			e.printStackTrace();
		}

		randJoke = rand.nextInt(100) + 1;

		while (true) {
			if (!scnr.hasNext()) {
				break;
			}
			if (Integer.toString(randJoke).equals(scnr.next())) {
				while (true) {
					if (!scnr.hasNext()) {
						break;
					}
					strJoke += scnr.next() + " ";
					if (strJoke.contains(".")) {
						break;
					}
				}
			} else if (scnr.hasNext()) {
			} else {
				break;
			}
		}

		textJoke = new JTextField();
		textJoke.setEditable(false);
		textJoke.setBounds(0, 0, 1000, 50);
		textJoke.setLayout(null);
		textJoke.setText(strJoke);
		textJoke.setBackground(Color.white);

		background2.setBackground(cBlueGreen);
		background2.setBounds(0, 0, 600, 250);

		background1.setBackground(cCyan);
		background1.setBounds(50, 75, 475, 100);

		butJoke = new JButton("New Joke");
		butJoke.setBounds(200, 100, 150, 50);
		butJoke.setLayout(null);
		butJoke.addActionListener(this);
		butJoke.setBackground(Color.white);

		window.add(butJoke);
		window.add(textJoke);
		window.add(background1);
		window.add(background2);
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException ee) {
			System.out.print("Error");
			ee.printStackTrace();
		}

		randJoke = rand.nextInt(100) + 1;
		file = new File("myTextFilex.txt");
		strJoke = "";

		while (true) {
			if (!scnr.hasNext()) {
				break;
			}
			if (Integer.toString(randJoke).equals(scnr.next())) {
				while (true) {
					if (!scnr.hasNext()) {
						break;
					}
					strJoke += scnr.next() + " ";
					if (strJoke.contains(".")) {
						break;
					}
				}
			} else if (scnr.hasNext()) {
			} else {
				break;
			}
		}

		textJoke.setText(strJoke);
	}
}