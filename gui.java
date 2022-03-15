import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class gui implements ActionListener
{

    //a main panel contain other panels
    private JPanel mainPanel = new JPanel();
    //variables for options to select
    private JFrame a = new JFrame();
    private JPanel panel1 = new JPanel();
    private JButton[] b = new JButton[7];
    private Picture[] p = new Picture[7];
        
    //variables for display section
    private JPanel panel2 = new JPanel();
    private JLabel[][] l = new JLabel[6][4];
    private Picture pics = new Picture("Empty.png");
    
    //variables for result section
    private JPanel panel3 = new JPanel();
    private JLabel[] result = new JLabel[24];

    //this is the panel1 for the buttons
    private void buttons(){
        for(int i = 0; i < 7; i++)
        {
            p[i] = new Picture("Colour_" + i + ".png");
            b[i] = new JButton(p[i]);
            b[i].setSize(70, 70);
            panel1.add(b[i], "South");
            b[i].addActionListener(this);
        }

        panel1.setLayout(new GridLayout(1, 7));
    }


    //this is the panel2 for the display sections
    private void display(){
        for(int k = 0; k < 6; k++)
        {
            for(int j = 0; j < 4; j++)
            {
                l[k][j] = new JLabel(pics);
                l[k][j].setSize(70,70);
                panel2.add(l[k][j]);
            }
        }
        panel2.setLayout(new GridLayout(6,4));
        mainPanel.add(panel2, "Center");
    }

    //this is the panel3 for the results
    private void results(){
        int m;

        for(m = 0; m < 24; m++)
        {
            result[m] = new JLabel(pics);
            result[m].setSize(35,35);
            panel3.add(result[m]);
        }

        panel3.setLayout(new GridLayout(12,2));
    }


    public void finalGUI()
    {
        mainPanel.setLayout(new BorderLayout()); //let the mainPanel be border layout to handle the position of other panels
        buttons();
        display();
        results();
        mainPanel.add(panel1, "South");
        mainPanel.add(panel2, "Center");
        mainPanel.add(panel3, "East");
        a.setContentPane(mainPanel);
        a.setTitle("SCC110 Project");
        a.setSize(700,700);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);

    }

    private int row_counter = 5;
    private int column_counter = 0;

    private void changeIcon(int r, int c, ActionEvent e)
    {
        if(e.getSource() == b[0])
        {
            l[r][c].setIcon(p[0]);
        }
        if(e.getSource() == b[1])
        {
            l[r][c].setIcon(p[1]);
        }
        if(e.getSource() == b[2])
        {
            l[r][c].setIcon(p[2]);
        }
        if(e.getSource() == b[3])
        {
            l[r][c].setIcon(p[3]);
        }
        if(e.getSource() == b[4])
        {
            l[r][c].setIcon(p[4]);
        }
        if(e.getSource() == b[5])
        {
            l[r][c].setIcon(p[5]);
        }
        if(e.getSource() == b[6])
        {
            l[r][c].setIcon(p[6]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        changeIcon(row_counter, column_counter, e);
        
        column_counter++;
        if(column_counter == 4)
        {
            column_counter = 0;
            row_counter--;
        }
    }
}