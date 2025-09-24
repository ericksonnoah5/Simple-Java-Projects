package SmallProjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bubblesort implements ActionListener {

	public JButton butEnter;
	public JTextField textNumbers;
	public String strNumbers = "";

	public Bubblesort() {
		JFrame window = new JFrame();
		Color cGrey = new Color(0x2E2E2E);
		JLabel header = new JLabel("Bubble Sort");
		Font font = new Font("SansSerif", Font.BOLD, 24);
		JPanel background = new JPanel();
		JLabel instructions = new JLabel("Enter numbers separated by commas (e.g., 33,55,42):");

		textNumbers = new JTextField();
		butEnter = new JButton("Enter");

		window.setLayout(null);
		window.setBounds(350, 100, 800, 700);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		header.setForeground(Color.white);
		header.setLayout(null);
		header.setBounds(100, 25, 200, 50);
		header.setFont(font);

		instructions.setForeground(Color.white);
		instructions.setLayout(null);
		instructions.setBounds(100, 100, 700, 150);
		instructions.setFont(font);

		background.setBackground(cGrey);
		background.setBounds(0, 0, 1000, 1000);

		textNumbers.setEditable(true);
		textNumbers.setBounds(100, 200, 500, 50);
		textNumbers.setFont(font);
		textNumbers.setLayout(null);

		butEnter.setBackground(Color.white);
		butEnter.setFont(font);
		butEnter.setBounds(100, 300, 100, 50);
		butEnter.addActionListener(this);

		window.add(butEnter);
		window.add(textNumbers);
		window.add(instructions);
		window.add(header);
		window.add(background);
		window.setVisible(true);
	}

	public ArrayList<Integer> sortList(ArrayList<Integer> list) {
		int temp = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				temp = list.get(i);
				list.set(i, list.get(i + 1));
				list.set(i + 1, temp);
				sortList(list);
			}
		}
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == butEnter) {
			strNumbers = textNumbers.getText();
			ArrayList<Integer> list = new ArrayList<>();
			String strthisNumber = "";
			int number = 0;

			for (int i = 0; i < strNumbers.length(); i++) {
				if (i == strNumbers.length() - 1 && (strNumbers.charAt(i) == '0' || strNumbers.charAt(i) == '1'
						|| strNumbers.charAt(i) == '2' || strNumbers.charAt(i) == '3'
						|| strNumbers.charAt(i) == '4' || strNumbers.charAt(i) == '5'
						|| strNumbers.charAt(i) == '6' || strNumbers.charAt(i) == '7'
						|| strNumbers.charAt(i) == '8' || strNumbers.charAt(i) == '9')) {

					strthisNumber += strNumbers.charAt(i);
					number = Integer.parseInt(strthisNumber);
					list.add(number);
					strthisNumber = "";
					number = 0;
				} else if (strNumbers.charAt(i) == ',') {
					number = Integer.parseInt(strthisNumber);
					list.add(number);
					strthisNumber = "";
				} else if (strNumbers.charAt(i) == '0' || strNumbers.charAt(i) == '1'
						|| strNumbers.charAt(i) == '2' || strNumbers.charAt(i) == '3'
						|| strNumbers.charAt(i) == '4' || strNumbers.charAt(i) == '5'
						|| strNumbers.charAt(i) == '6' || strNumbers.charAt(i) == '7'
						|| strNumbers.charAt(i) == '8' || strNumbers.charAt(i) == '9') {

					strthisNumber += strNumbers.charAt(i);
				} else {
					strthisNumber = "Error";
					break;
				}
			}

			sortList(list);

			if (strthisNumber == "Error") {
			} else {
				strthisNumber = "";
				for (int i = 0; i < list.size(); i++) {
					if (i == list.size() - 1) {
						strthisNumber += Integer.toString(list.get(i));
					} else {
						strthisNumber += Integer.toString(list.get(i)) + ",";
					}
				}
			}

			textNumbers.setText(strthisNumber);
		}
	}
}