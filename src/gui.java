import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class gui extends guess
{
    //a main panel contain other panels
    public JPanel mainPanel = new JPanel();
    //variables for options to select
    private JFrame a = new JFrame();

    //variables for display section
    private JPanel panel2 = new JPanel();
    private Picture pics = new Picture("Empty.png");
    
    //variables for result section
    private JPanel panel3 = new JPanel();
    private JLabel[] result = new JLabel[24];


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
}