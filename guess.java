import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class guess implements ActionListener
{
    //variables for the result section
    public JPanel panel3 = new JPanel();
    public JLabel[][] result = new JLabel[6][4];
    private Picture score1 = new Picture("Score_0.png");
    private Picture score2 = new Picture("Score_1.png");

    //the colourCode class
    private colourCode c = new colourCode();
    //integers that used to represents the choices of the users
    private int[] ans = new int[4];
    public int[] order = new int[4];
    
 
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
    
    /**
     * this is a method to generate a set of answer and store it in an array
     * @return the correct answer of colour code
     */
    public int[] ans()
    {
        for(int i = 0; i < 4; i++)
        {
            ans[i] = rand.nextInt(7);
            System.out.println(ans[i]);
        } 
        return ans;
    } 

    /**
     * this generates a set of correct answer
     */
    private int[] colourSet = ans();

    /**
     * this is a function creates the button section
     */
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

    

    /**
     * a function that When the buttons are pressed the current label will change to the colour that the user selected
     * @param r the row of current position
     * @param c the column of current position
     * @param e the button that the user pressed
     */ 
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

    /**
     * this is a function that changes the image of the result section
     * according to amount of correct colour and amount of correct position and colour
     * @param r the row of the current position
     * @param cC the number of correct colour
     * @param cCP the number of input that colour and position are correct
     */
    public void resultCheck(int r, int cC, int cCP)
    {
        int i;
        if(cCP != 0 || cC != 0)
        {
            for(i = 0; i < cCP; i++)
            {
                result[r][i].setIcon(score1);
            }
            int j;
            System.out.println("this is " + i);
            for(j = i;j < cC ; j++)
            {
                result[r][j].setIcon(score2);
            }
            System.out.println("this is " + j);
        }
    }

    //flag1 checks whether the user won
    public int flag = 0;
    //flag2 checks whether the user has run out of attempts
    public int flag2 = 0;
    

    /**
     * when the button is pressed it will use the changeIcon function and change the icon of current position
     * this method will always check whether the user has won or run out of attempts
     * and if either situation happened flag1 or flag2 will change its value and popup the message
     * for each column completed it will check the answer
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        changeIcon(row_counter, column_counter, e);
        column_counter++;
        if(column_counter == 4)
        {
            if(row_counter == 0)
            {
                flag2 = 1;
            }
            column_counter = 0;
            c.matchOrder(colourSet, order);
            c.matchColour(colourSet, order);
            resultCheck(row_counter, c.getCC(), c.getcCP());
            row_counter--;
            if(c.getcCP() == 4)
            {
                flag = 1;
            }
        }
    }
}
