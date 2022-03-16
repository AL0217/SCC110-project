import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random
;
public class guess implements ActionListener
{

    //integers that used to represents the choices of the users
    private int[] ans = new int[4];
    private int[] order = new int[4];
    private int cCP = 0;
 
    //varaibles for generating random numbers which represents different colours
    Random rand = new Random();

    //counter of which row and column the user at
    private int row_counter = 5;
    private int column_counter = 0;

    //variables for the buttons
    public JPanel panel1 = new JPanel();
    public JButton[] b = new JButton[7];
    public Picture[] p = new Picture[7];

    public JLabel[][] l = new JLabel[6][4];
    

    //this is a function adding the buttons to the panel1
    public void buttons()
    {
        for(int i = 0; i < 7; i++)
        {
            p[i] = new Picture("Colour_" + i + ".png");
            b[i] = new JButton(p[i]);
            b[i].setSize(70, 70);
            panel1.add(b[i]);
            b[i].addActionListener(this);
        }
        panel1.setLayout(new GridLayout(1, 7));
    }


    public void matchAns(int[] order)
    {
        
        for(int i = 0; i < 4; i++)
        {
            ans[i] = rand.nextInt(8);
            System.out.println(ans[i]);
            System.out.println(order[i]);
            if(ans[i] == order[i])
            {
                cCP++;
            }
        }
        System.out.println(cCP);
    }


    //When the buttons are pressed the current label will change to the colour that the use selected 
    private void changeIcon(int r, int c, ActionEvent e)
    {
        
        if(e.getSource() == b[0])
        {
            l[r][c].setIcon(p[0]);
            order[c] = 0;
        }
        if(e.getSource() == b[1])
        {
            l[r][c].setIcon(p[1]);
            order[c] = 1;
        }
        if(e.getSource() == b[2])
        {
            l[r][c].setIcon(p[2]);
            order[c] = 2;
        }
        if(e.getSource() == b[3])
        {
            l[r][c].setIcon(p[3]);
            order[c] = 3;
        }
        if(e.getSource() == b[4])
        {
            l[r][c].setIcon(p[4]);
            order[c] = 4;
        }
        if(e.getSource() == b[5])
        {
            l[r][c].setIcon(p[5]);
            order[c] = 5;
        }
        if(e.getSource() == b[6])
        {
            l[r][c].setIcon(p[6]);
            order[c] = 6;
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
            matchAns(order);
            row_counter--;
        }
    }
}
