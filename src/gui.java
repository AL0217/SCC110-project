import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui implements ActionListener
{
    private guess G = new guess();

    
    //A starting ui  
    private JPanel SPanel = new JPanel();
    private JButton SButton = new JButton("Click Here To Start");

    //a main panel that contain beginning, in game and ending
    private JPanel panelCont = new JPanel();

    //a panel contain other panels
    public JPanel mainPanel = new JPanel();
    
    //variables for options to select
    private JFrame a = new JFrame();

    //variables for display section
    private JPanel panel2 = new JPanel();
    private Picture pics = new Picture("Empty.png");
    
    //instance of Card Layout
    public static CardLayout card = new CardLayout();

    /**
     * this function create the panel2 for the display sections 
     */ 
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

    /**
     * this function create the results section
     */
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

    /**
     * this function creates a main panel which is where the user plays the game
     */
    private void createMPanel()
    {
        mainPanel.setLayout(new BorderLayout()); //let the mainPanel be border layout to handle the position of other panels
        G.buttons();
        display();
        results();
        mainPanel.add(G.panel1, "South");
        mainPanel.add(panel2, "Center");
        mainPanel.add(G.panel3, "East"); 
    }

    /**
     * This is a start Panel that contains a Button and some text message
     */
    private void createSPanel()
    {
        SPanel.add(SButton);
        SButton.setFont(new Font("Arial", Font. PLAIN, 40));
        SButton.setLocation(350,350);
        SPanel.setBackground(Color.BLACK);
    }

    /**
     * this is a function for the main programme to call
     * through this method we can put the correct starting panel and create the frame for user to play the game
     */
    public void finalGUI()
    {
        createMPanel();
        createSPanel();

        panelCont.setLayout(card);
        
        panelCont.add(SPanel, "1");
        panelCont.add(mainPanel, "2");
        card.show(panelCont, "1");
        SButton.addActionListener(this);
        a.setContentPane(panelCont);
        a.setTitle("SCC110 Project");
        a.setSize(700,700);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true); 
        
        while(true)
        {
            System.out.printf(""); //I don't know why but I need this printf to make this works
            if(G.flag == 1)
            {
                int res = JOptionPane.showOptionDialog(null, "Congratulation!!! you win!!", "Test", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(res == 0 || res == -1)
                {
                    System.exit(0);
                }
                break;
            }
            else if(G.flag2 == 1)
            {
                int res = JOptionPane.showOptionDialog(null, "Run out of attempts...You lose.. TAT", "Test", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(res == 0 || res == -1)
                {
                    System.exit(0);
                }
                break;
            }
        }
    }

    /**
     * if the start button is clicked jumped to the main Panel and start the game
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SButton)
        {
            card.show(panelCont, "2");
        }
    }
}