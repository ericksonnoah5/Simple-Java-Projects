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

    JFrame frame;
    JTextField uText, pText;
    public JButton enterBut;
    public JLabel header, errorMsg, newerrorMsg;
    Font font;
    public String Password;
    public String Username;
    JPanel background, frontpanel;
    public Color color1, color2, color3;
    public Scanner scnr;
    public JButton create;
    public String user;
    public String pass;
    public File file = new File("passwordholder.txt");
    public String current;
    public boolean username;
    public boolean password;
    public boolean createaccount = false;

    public Password() {
        frame = new JFrame("Password");
        pText = new JTextField();
        uText = new JTextField();
        enterBut = new JButton("Enter");
        header = new JLabel("Enter a Username and Password");
        errorMsg = new JLabel("Error Incorrect Username or Password");
        newerrorMsg = new JLabel("Account has already been created");
        font = new Font("Serif", Font.BOLD, 18);
        background = new JPanel();
        frontpanel = new JPanel();
        create = new JButton("Create New Account");

        color1 = Color.decode("#7CCBC4");
        color2 = Color.decode("#A5DAD5");
        color3 = Color.decode("#1D63C6");

        background.setBackground(color1);
        background.setBounds(0, 0, 500, 550);
        frontpanel.setBackground(color2);
        frontpanel.setBounds(50, 50, 375, 375);

        frame.setResizable(false);
        frame.setLayout(null);
        frame.setBounds(500, 150, 500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pText.setBounds(75, 250, 300, 50);
        pText.setFont(font);

        uText.setFont(font);
        uText.setBounds(75, 150, 300, 50);

        enterBut.setFont(font);
        enterBut.setBounds(75, 325, 100, 40);
        enterBut.addActionListener(this);
        enterBut.setBackground(Color.white);

        header.setFont(font);
        header.setBounds(75, 100, 500, 40);
        header.setForeground(Color.black);

        errorMsg.setFont(font);
        errorMsg.setBounds(75, 2000, 500, 40);

        newerrorMsg.setFont(font);
        newerrorMsg.setBounds(75, 2000, 500, 40);

        create.setFont(font);
        create.setBounds(175, 325, 210, 40);
        create.addActionListener(this);
        create.setBackground(Color.white);

        frame.add(newerrorMsg);
        frame.add(create);
        frame.add(errorMsg);
        frame.add(header);
        frame.add(enterBut);
        frame.add(pText);
        frame.add(uText);
        frame.add(frontpanel);
        frame.add(background);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(enterBut)) {
            user = uText.getText();
            pass = pText.getText();
            username = false;
            password = false;
            current = "";

            try {
                scnr = new Scanner(file);
            } catch (FileNotFoundException er) {
                System.out.print("Error");
                er.printStackTrace();
            }

            while (true) {
                if (!scnr.hasNext()) {
                    break;
                }
                current = scnr.next();

                if (current.equals("User:" + user)) {
                    username = true;
                    current = scnr.next();
                    if (current.equals("Pass:" + pass)) {
                        password = true;
                    }
                    break;
                }
            }

            if (username == true && password == true) {
                frame.dispose();
                new Calculator();
            } else {
                errorMsg.setBounds(75, 380, 500, 40);
            }
        } else if (e.getSource().equals(create)) {
            user = uText.getText();
            pass = pText.getText();

            try {
                scnr = new Scanner(file);
            } catch (FileNotFoundException er) {
                System.out.print("Error");
                er.printStackTrace();
            }

            while (true) {
                if (!scnr.hasNext()) {
                    break;
                }
                current = scnr.next();

                if (current.equals("User:" + user)) {
                    newerrorMsg.setBounds(75, 360, 500, 40);
                    createaccount = true;
                    break;
                }
            }

            if (createaccount == false) {
                try {
                    FileWriter writer = new FileWriter("passwordholder.txt", true);
                    writer.write("\n");
                    writer.write("User:" + user + " Pass:" + pass);
                    writer.close();
                } catch (IOException err) {
                    err.printStackTrace();
                }
                createaccount = true;
            }
        }
    }
}