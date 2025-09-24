package SmallProjects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Projects implements ActionListener {

	int numProjects;
	public JButton butPassword;
	public JButton butBubble;
	public JButton butCalc;
	public JButton butJoke;
	public JFrame window;

	public Projects() {
		window = new JFrame();
		Color greyColor = new Color(0x2E2E2E);
		JLabel header = new JLabel("Projects");
		Font font = new Font("SansSerif", Font.BOLD, 24);
		JPanel background = new JPanel();
		JPanel mainPanel = new JPanel();

		butPassword = new JButton("Password");
		butBubble = new JButton("Bubble Sort");
		butCalc = new JButton("Calculator");
		butJoke = new JButton("Jokes");

		JButton butLeft = new JButton(">");
		JButton butRight = new JButton("<");

		ArrayList<JButton> butList = new ArrayList<>();

		window.setLayout(null);
		window.setBounds(350, 100, 800, 700);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		header.setForeground(Color.white);
		header.setLayout(null);
		header.setBounds(100, 25, 100, 50);
		header.setFont(font);

		background.setBackground(greyColor);
		background.setBounds(0, 0, 1000, 1000);

		butList.add(butJoke);
		butList.add(butCalc);
		butList.add(butBubble);
		butList.add(butPassword);

		butLeft.setBounds(300, 35, 50, 30);
		butLeft.setBackground(Color.white);

		butRight.setBounds(250, 35, 50, 30);
		butRight.setBackground(Color.white);

		for (int i = 0; i < 4; i++) {
			butList.get(i).setPreferredSize(new Dimension(240, 240));
			butList.get(i).setBackground(Color.white);
			butList.get(i).setFont(font);
			butList.get(i).addActionListener(this);
			numProjects += 1;
		}

		mainPanel.setBounds(100, 100, 500, 500);
		mainPanel.setBackground(Color.gray);
		mainPanel.add(butJoke);
		mainPanel.add(butCalc);
		mainPanel.add(butBubble);
		mainPanel.add(butPassword);

		JLabel numberOfProjects = new JLabel(Integer.toString(numProjects));
		numberOfProjects.setForeground(Color.white);
		numberOfProjects.setLayout(null);
		numberOfProjects.setBounds(400, 25, 100, 50);
		numberOfProjects.setFont(font);

		JLabel currentNumberOfProjects = new JLabel(Integer.toString(numProjects) + " /");
		currentNumberOfProjects.setForeground(Color.white);
		currentNumberOfProjects.setLayout(null);
		currentNumberOfProjects.setBounds(370, 25, 100, 50);
		currentNumberOfProjects.setFont(font);

		window.add(currentNumberOfProjects);
		window.add(numberOfProjects);
		window.add(butRight);
		window.add(butLeft);
		window.add(mainPanel);
		window.add(header);
		window.add(background);
		window.setVisible(true);
	}

	public int getNumProjects() {
		return numProjects;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == butPassword) {
			window.setVisible(false);
			Password password = new Password();
		} else if (e.getSource() == butBubble) {
			window.setVisible(false);
			Bubblesort bubblesort = new Bubblesort();
		} else if (e.getSource() == butCalc) {
			window.setVisible(false);
			Calculator calculator = new Calculator();
		} else if (e.getSource() == butJoke) {
			window.setVisible(false);
			Jokes jokes = new Jokes();
		}
	}
}