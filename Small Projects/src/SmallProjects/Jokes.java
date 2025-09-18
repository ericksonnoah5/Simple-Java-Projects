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



public class Jokes implements ActionListener{
	
	private JFrame frame;
	private Random rand = new Random();
	private int randomJoke;
	private Scanner scnr;
	private File file = new File("myTextFilex.txt");
	private String joke = "";
	private JTextField myjoketext;
	private JButton button;
	private JPanel background, frontpanel;
	Color color1,color2,color3;
	
	
	public Jokes(){
		frame = new JFrame("Fun");
		frame.setLayout(null);
		frame.setBounds(450, 200, 600, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		background = new JPanel();
		frontpanel = new JPanel();
		
		color1 = Color.decode("#7CCBC4");
		color2 = Color.decode("#A5DAD5");
		color3 = Color.decode("#1D63C6");
		
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.print("Error");
			e.printStackTrace();
		}
		
		randomJoke = rand.nextInt(100)+1;
		
		while(true) {
			if(!scnr.hasNext()) {
				break;
			}
			
		if(Integer.toString(randomJoke).equals(scnr.next())) {
			while(true) {
				if(!scnr.hasNext()) {
					break;
				}
				joke+=scnr.next()+" ";
				if(joke.contains(".")) {
					break;
				}
			}
		}
		else if (scnr.hasNext()){
		}
		else {
			break;
		}
	}
		
		myjoketext = new JTextField();
		myjoketext.setEditable(false);
		myjoketext.setBounds(0, 0, 1000, 50);
		myjoketext.setLayout(null);
		myjoketext.setText(joke);
		myjoketext.setBackground(Color.white);
		
		background.setBackground(color1);
		background.setBounds(0, 0, 600, 250);
		frontpanel.setBackground(color2);
		frontpanel.setBounds(50, 75, 475, 100);
		
		button = new JButton("New Joke");
		button.setBounds(200, 100, 150, 50);
		button.setLayout(null);
		button.addActionListener(this);
		button.setBackground(Color.white);
		
		frame.add(button);
		frame.add(myjoketext);
		frame.add(frontpanel);
		frame.add(background);
		frame.setVisible(true);
	}	
	
	  @Override
	    public void actionPerformed(ActionEvent e) {
		  try {
				scnr = new Scanner(file);
			} catch (FileNotFoundException ee) {
				System.out.print("Error");
				ee.printStackTrace();
			}
		  randomJoke = rand.nextInt(100)+1;
		  file = new File("myTextFilex.txt");
		  joke = "";
		  
		  while(true) {
			  if(!scnr.hasNext()) {
					break;
				}
				if(Integer.toString(randomJoke).equals(scnr.next())) {
					while(true) {
						if(!scnr.hasNext()) {
							break;
						}
						joke+=scnr.next()+" ";
						if(joke.contains(".")) {
							break;
						}
					}	
				}
				else if (scnr.hasNext()){
				}
				else {
					break;
				}
			}
		  myjoketext.setText(joke);
	    }
	}			
		
		
	
