package SmallProjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	public JFrame window;
	JPanel panel;
	JButton but0, but1, but2, but3, but4, but5, but6, but7, but8, but9, butAdd, butSub, butMul, butDiv, butEmpty, butClear, butFun, butDelete,
			butEnter, butDec;
	Font font;
	JTextField textScreen;
	int count = 0;
	int endCount = 0;
	double num1 = 0.0;
	double num2 = 0.0;
	double result = 0.0;
	String operation = "";
	boolean boolFunButton;
	Color cBlueGreen, cCyan, cDarkBlue;

	public Calculator() {
		window = new JFrame("Calculator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(500, 150, 420, 550);
		window.setResizable(false);
		window.setLayout(null);

		cBlueGreen = Color.decode("#7CCBC4");
		cCyan = Color.decode("#A5DAD5");
		cDarkBlue = Color.decode("#1D63C6");

		panel = new JPanel();
		panel.setBounds(0, 100, 405, 415);
		panel.setLayout(new java.awt.GridLayout(5, 4));
		panel.setBackground(Color.BLACK);

		font = new Font("Arial", Font.BOLD, 30);
		textScreen = new JTextField();
		textScreen.setBounds(10, 10, 380, 80);
		textScreen.setEditable(false);
		textScreen.setFont(font);

		but0 = new JButton("0");
		but1 = new JButton("1");
		but2 = new JButton("2");
		but3 = new JButton("3");
		but4 = new JButton("4");
		but5 = new JButton("5");
		but6 = new JButton("6");
		but7 = new JButton("7");
		but8 = new JButton("8");
		but9 = new JButton("9");
		butAdd = new JButton("+");
		butSub = new JButton("-");
		butDiv = new JButton("/");
		butMul = new JButton("*");
		butDec = new JButton(".");
		butEnter = new JButton("Enter");
		butClear = new JButton("Clear");
		butEmpty = new JButton("");
		butFun = new JButton("FUN");
		butDelete = new JButton("Delete");

		JButton[] allButtons = { butClear, butDelete, butFun, butDiv, but7, but8, but9, butMul, but4, but5, but6, butSub, but1, but2,
				but3, butAdd, butEmpty, but0, butDec, butEnter };

		for (int i = 0; i < allButtons.length; i++) {
			allButtons[i].addActionListener(this);
			panel.add(allButtons[i]);
			allButtons[i].setBackground(Color.white);
		}

		window.add(textScreen);
		window.add(panel);
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!textScreen.getText().equals("Infinity")) {
			if (e.getSource() == but0) {
				textScreen.setText(textScreen.getText() + "0");
				count += 1;
			}
			if (e.getSource() == but1) {
				textScreen.setText(textScreen.getText() + "1");
				count += 1;
			}
			if (e.getSource() == but2) {
				textScreen.setText(textScreen.getText() + "2");
				count += 1;
			}
			if (e.getSource() == but3) {
				textScreen.setText(textScreen.getText() + "3");
				count += 1;
			}
			if (e.getSource() == but4) {
				textScreen.setText(textScreen.getText() + "4");
				count += 1;
			}
			if (e.getSource() == but5) {
				textScreen.setText(textScreen.getText() + "5");
				count += 1;
			}
			if (e.getSource() == but6) {
				textScreen.setText(textScreen.getText() + "6");
				count += 1;
			}
			if (e.getSource() == but7) {
				textScreen.setText(textScreen.getText() + "7");
				count += 1;
			}
			if (e.getSource() == but8) {
				textScreen.setText(textScreen.getText() + "8");
				count += 1;
			}
			if (e.getSource() == but9) {
				textScreen.setText(textScreen.getText() + "9");
				count += 1;
			}

			if (e.getSource() == butAdd) {
				if (count == 0 || textScreen.getText().substring(0).equals(".")
						|| textScreen.getText().substring(0).equals("-")) {
				} else {
					if (textScreen.getText().contains("/") || textScreen.getText().contains("*")
							|| textScreen.getText().contains("+")) {
					} else if (textScreen.getText().contains("-")) {
						if (textScreen.getText().substring(0, 1).equals("-")) {
							num1 = Double.parseDouble(textScreen.getText());
							operation += "+";
							count += 1;
							endCount = count;
							textScreen.setText(textScreen.getText() + "+");
						}
					} else {
						num1 = Double.parseDouble(textScreen.getText());
						operation += "+";
						count += 1;
						endCount = count;
						textScreen.setText(textScreen.getText() + "+");
					}
				}
			}

			if (e.getSource() == butSub) {
				if (count == 0) {
					textScreen.setText("-");
					count += 1;
				} else {
					if (textScreen.getText().substring(0).equals(".") || textScreen.getText().substring(0).equals("-")) {
					} else {
						if (textScreen.getText().contains("+") || textScreen.getText().contains("/")
								|| textScreen.getText().contains("*")) {
						} else if (textScreen.getText().contains("-")) {
							if (textScreen.getText().substring(0, 1).equals("-")
									&& !(textScreen.getText().substring(1).contains("-"))) {
								num1 = Double.parseDouble(textScreen.getText());
								operation += "-";
								count += 1;
								endCount = count;
								textScreen.setText(textScreen.getText() + "-");
							}
						} else {
							num1 = Double.parseDouble(textScreen.getText());
							operation = "-";
							count += 1;
							endCount = count;
							textScreen.setText(textScreen.getText() + "-");
						}
					}
				}
			}

			if (e.getSource() == butMul) {
				if (count == 0 || textScreen.getText().substring(0).equals(".")
						|| textScreen.getText().substring(0).equals("-")) {
				} else {
					if (textScreen.getText().contains("/") || textScreen.getText().contains("*")
							|| textScreen.getText().contains("+")) {
					} else if (textScreen.getText().contains("-")) {
						if (textScreen.getText().substring(0, 1).equals("-")) {
							num1 = Double.parseDouble(textScreen.getText());
							operation += "/";
							count += 1;
							endCount = count;
							textScreen.setText(textScreen.getText() + "/");
						}
					} else {
						num1 = Double.parseDouble(textScreen.getText());
						operation = "*";
						count += 1;
						endCount = count;
						textScreen.setText(textScreen.getText() + "*");
					}
				}
			}

			if (e.getSource() == butDiv) {
				if (count == 0 || textScreen.getText().substring(0).equals(".")
						|| textScreen.getText().substring(0).equals("-")) {
				} else {
					if (textScreen.getText().contains("+") || textScreen.getText().contains("/")
							|| textScreen.getText().contains("*")) {
					} else if (textScreen.getText().contains("-")) {
						if (textScreen.getText().substring(0, 1).equals("-")) {
							num1 = Double.parseDouble(textScreen.getText());
							operation += "/";
							count += 1;
							endCount = count;
							textScreen.setText(textScreen.getText() + "/");
						}
					} else {
						num1 = Double.parseDouble(textScreen.getText());
						operation = "/";
						count += 1;
						endCount = count;
						textScreen.setText(textScreen.getText() + "/");
					}
				}
			}

			if (e.getSource() == butDec) {
				if (textScreen.getText().contains(".")) {
					if (operation == "" || (textScreen.getText().substring(endCount)).contains(".")) {
					} else {
						textScreen.setText(textScreen.getText() + ".");
						count += 1;
					}
				} else {
					textScreen.setText(textScreen.getText() + ".");
					count += 1;
				}
			}

			if (e.getSource() == butDelete) {
				if (count == 0) {
				} else {
					textScreen.setText(textScreen.getText().substring(0, count - 1));
					count -= 1;
				}
			}

			if (e.getSource() == butEnter) {
				if (count == endCount || textScreen.getText().substring(count).equals("/")
						|| textScreen.getText().substring(count).equals("+") || textScreen.getText().substring(count).equals("-")
						|| textScreen.getText().substring(count).equals("*")
						|| textScreen.getText().substring(count - 1).equals(".")) {
				} else {
					if (operation.contains("+")) {
						num2 = Double.parseDouble(textScreen.getText().substring(endCount));
						result = num1 + num2;
						textScreen.setText(Double.toString(result));
						if (textScreen.getText().substring(textScreen.getText().length() - 2).equals(".0")) {
							textScreen.setText(textScreen.getText().substring(0, textScreen.getText().length() - 2));
						}
						count = 0;
						endCount = 0;
						num2 = 0.0;
						result = 0.0;
						operation = "";
						for (int i = 0; i < textScreen.getText().length(); i++) {
							count += 1;
						}
						num1 = Double.parseDouble(textScreen.getText());
					} else if (operation.contains("-")) {
						num2 = Double.parseDouble(textScreen.getText().substring(endCount));
						result = num1 - num2;
						textScreen.setText(Double.toString(result));
						if (textScreen.getText().substring(textScreen.getText().length() - 2).equals(".0")) {
							textScreen.setText(textScreen.getText().substring(0, textScreen.getText().length() - 2));
						}
						count = 0;
						endCount = 0;
						num1 = Double.parseDouble(textScreen.getText());
						num2 = 0.0;
						result = 0.0;
						operation = "";
						for (int i = 0; i < textScreen.getText().length(); i++) {
							count += 1;
						}
					} else if (operation.contains("*")) {
						num2 = Double.parseDouble(textScreen.getText().substring(endCount));
						result = num1 * num2;
						textScreen.setText(Double.toString(result));
						if (textScreen.getText().substring(textScreen.getText().length() - 2).equals(".0")) {
							textScreen.setText(textScreen.getText().substring(0, textScreen.getText().length() - 2));
						}
						count = 0;
						endCount = 0;
						num1 = Double.parseDouble(textScreen.getText());
						num2 = 0.0;
						result = 0.0;
						operation = "";
						for (int i = 0; i < textScreen.getText().length(); i++) {
							count += 1;
						}
					} else if (operation.contains("/")) {
						num2 = Double.parseDouble(textScreen.getText().substring(endCount));
						result = num1 / num2;
						textScreen.setText(Double.toString(result));
						if (textScreen.getText().substring(textScreen.getText().length() - 2).equals(".0")) {
							textScreen.setText(textScreen.getText().substring(0, textScreen.getText().length() - 2));
						}
						count = 0;
						endCount = 0;
						num1 = Double.parseDouble(textScreen.getText());
						num2 = 0.0;
						result = 0.0;
						operation = "";
						for (int i = 0; i < textScreen.getText().length(); i++) {
							count += 1;
						}
					}
				}
			}

			if (e.getSource() == butFun) {
				if (boolFunButton = false) {
					boolFunButton = true;
				} else {
					boolFunButton = true;
				}
				if (boolFunButton == true) {
					window.dispose();
					new Jokes();
				}
			}

			if (e.getSource() == butEmpty) {
				textScreen.setText(textScreen.getText());
			}

			if (e.getSource() == butClear) {
				textScreen.setText("");
				count = 0;
				endCount = 0;
				num1 = 0.0;
				num2 = 0.0;
				result = 0.0;
				operation = "";
			}
		} else {
			if (e.getSource() == butClear) {
				textScreen.setText("");
				count = 0;
				endCount = 0;
				num1 = 0.0;
				num2 = 0.0;
				result = 0.0;
				operation = "";
			}
		}
	}
}