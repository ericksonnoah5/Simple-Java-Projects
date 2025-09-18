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
    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JFrame window;

    public Projects() {
        window = new JFrame();
        Color greyback = new Color(0x2E2E2E);
        JLabel title = new JLabel("Projects");
        Font font = new Font("SansSerif", Font.BOLD, 24);
        JPanel background = new JPanel();
        JPanel mainPanel = new JPanel();

        button1 = new JButton("Password");
        button2 = new JButton("Bubble Sort");
        button3 = new JButton("Calculator");
        button4 = new JButton("Jokes");

        JButton left = new JButton(">");
        JButton right = new JButton("<");

        ArrayList<JButton> butlist = new ArrayList<>();

        window.setLayout(null);
        window.setBounds(350, 100, 800, 700);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title.setForeground(Color.white);
        title.setLayout(null);
        title.setBounds(100, 25, 100, 50);
        title.setFont(font);

        background.setBackground(greyback);
        background.setBounds(0, 0, 1000, 1000);

        butlist.add(button4);
        butlist.add(button3);
        butlist.add(button2);
        butlist.add(button1);

        left.setBounds(300, 35, 50, 30);
        left.setBackground(Color.white);

        right.setBounds(250, 35, 50, 30);
        right.setBackground(Color.white);

        for (int i = 0; i < 4; i++) {
            butlist.get(i).setPreferredSize(new Dimension(240, 240));
            butlist.get(i).setBackground(Color.white);
            butlist.get(i).setFont(font);
            butlist.get(i).addActionListener(this);
            numProjects += 1;
        }

        mainPanel.setBounds(100, 100, 500, 500);
        mainPanel.setBackground(Color.gray);
        mainPanel.add(button4);
        mainPanel.add(button3);
        mainPanel.add(button2);
        mainPanel.add(button1);

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
        window.add(right);
        window.add(left);
        window.add(mainPanel);
        window.add(title);
        window.add(background);
        window.setVisible(true);
    }

    public int getNumProjects() {
        return numProjects;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            window.setVisible(false);
            Password password = new Password();
        } else if (e.getSource() == button2) {
            window.setVisible(false);
            Bubblesort bubblesort = new Bubblesort();
        } else if (e.getSource() == button3) {
            window.setVisible(false);
            Calculator calculator = new Calculator();
        } else if (e.getSource() == button4) {
            window.setVisible(false);
            Jokes jokes = new Jokes();
        }
    }
}