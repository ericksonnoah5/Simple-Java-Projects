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

public class Bubblesort implements ActionListener{

	public JButton Enter;
	public JTextField numberField;
	public String numbersString = "";
	
	public Bubblesort(){
		JFrame window = new JFrame();
		Color greyback = new Color(0x2E2E2E);
		JLabel title = new JLabel("Bubble Sort");
		Font font = new Font("SansSerif", Font.BOLD, 24);
		JPanel background = new JPanel();
		JLabel instructions = new JLabel("Enter numbers separated by commas (e.g., 33,55,42):");
		numberField = new JTextField();
		Enter = new JButton("Enter");
		
		window.setLayout(null);
		window.setBounds(350, 100, 800, 700);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		title.setForeground(Color.white);
		title.setLayout(null);
		title.setBounds(100, 25, 200, 50);
		title.setFont(font);
		
		instructions.setForeground(Color.white);
		instructions.setLayout(null);
		instructions.setBounds(100, 100, 700, 150);
		instructions.setFont(font);
		
		background.setBackground(greyback);
		background.setBounds(0, 0, 1000, 1000);
		
		numberField.setEditable(true);
		numberField.setBounds(100, 200, 500, 50);
		numberField.setFont(font);
		numberField.setLayout(null);
		
		Enter.setBackground(Color.white);
		Enter.setFont(font);
		Enter.setBounds(100, 300, 100, 50);
		Enter.addActionListener(this);
		
		window.add(Enter);
		window.add(numberField);
		window.add(instructions);
		window.add(title);
		window.add(background);
		window.setVisible(true);
		
	}
	
	public ArrayList <Integer> sortList(ArrayList <Integer> list){
		int temp=0;
		for (int i=0;i<list.size()-1;i++) {
			if(list.get(i)>list.get(i+1)) {	
				temp=0;
				temp=list.get(i);
				list.set(i, list.get(i+1));
				list.set(i+1, temp);
				sortList(list);
			}
		}
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==(Enter)) {
			numbersString=numberField.getText();
			ArrayList <Integer> list = new ArrayList <Integer>();
			String Snumber = "";
			int Inumber =0;
			
			for(int i=0;i<numbersString.length();i++) {
				if(i==numbersString.length()-1 && (
						numbersString.charAt(i)=='0'||
						numbersString.charAt(i)=='1'||
						numbersString.charAt(i)=='2'||
						numbersString.charAt(i)=='3'||
						numbersString.charAt(i)=='4'||
						numbersString.charAt(i)=='5'||
						numbersString.charAt(i)=='6'||
						numbersString.charAt(i)=='7'||
						numbersString.charAt(i)=='8'||
						numbersString.charAt(i)=='9')) {
					Snumber+=numbersString.charAt(i);
					Inumber =Integer.parseInt(Snumber);
					list.add(Inumber);
					Snumber = "";
					Inumber=0;
				}
				else if(numbersString.charAt(i)==(',')) {
					Inumber =Integer.parseInt(Snumber);
					list.add(Inumber);
					Snumber = "";
				}
				else if(numbersString.charAt(i)=='0'||
						numbersString.charAt(i)=='1'||
						numbersString.charAt(i)=='2'||
						numbersString.charAt(i)=='3'||
						numbersString.charAt(i)=='4'||
						numbersString.charAt(i)=='5'||
						numbersString.charAt(i)=='6'||
						numbersString.charAt(i)=='7'||
						numbersString.charAt(i)=='8'||
						numbersString.charAt(i)=='9') {
					Snumber+=numbersString.charAt(i);
				}
				else {
					Snumber="Error";
					break;
				}
			}
			sortList(list);
			if(Snumber=="Error") {
			}
			else {
				Snumber="";
				for(int i=0;i<list.size();i++) {
				if(i==list.size()-1) {
					Snumber+=Integer.toString(list.get(i));
				}
				else {
				Snumber+=Integer.toString(list.get(i))+",";
				}
				}
			}
			numberField.setText(Snumber);
		}
	}
}