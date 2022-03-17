import javax.swing.*;
import java.awt.*;


public class gui
{
    private guess G = new guess();

    //a main panel contain other panels
    private JPanel mainPanel = new JPanel();
    //variables for options to select
    private JFrame a = new JFrame();

    //variables for display section
    private JPanel panel2 = new JPanel();
    private Picture pics = new Picture("Empty.png");
    


    //this is the panel2 for the display sections
    private void display(){
        for(int k = 0; k < 6; k++)
        {
            for(int j = 0; j < 4; j++)
            {
                G.l[k][j] = new JLabel(pics);
                G.l[k][j].setSize(70,70);
                panel2.add(G.l[k][j]);
            }
        }
        panel2.setLayout(new GridLayout(6,4));
        mainPanel.add(panel2, "Center");
    }

    //this is the panel3 for the results
    private void results(){
        for(int m = 0; m < 6; m++)
        {
            for(int n = 0; n < 4; n++)
            {
                G.result[m][n] = new JLabel(pics);
                G.result[m][n].setSize(35,35);
                G.panel3.add(G.result[m][n]);
            }
        }

        G.panel3.setLayout(new GridLayout(12,2));
    }

    public void finalGUI()
    {
        mainPanel.setLayout(new BorderLayout()); //let the mainPanel be border layout to handle the position of other panels
        G.buttons();
        display();
        results();
        mainPanel.add(G.panel1, "South");
        mainPanel.add(panel2, "Center");
        mainPanel.add(G.panel3, "East");
        a.setContentPane(mainPanel);
        a.setTitle("SCC110 Project");
        a.setSize(700,700);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);

    }
}