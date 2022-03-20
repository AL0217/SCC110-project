public class colourCode
{
    private int cCP = 0;
    private int cC = 0;
    public int[] asd;

    /**
     * this matches the colour and the order of users input with the random generated answer 
     * @param ans this contains an array of length 4 which is the answer of the colour code
     * @param order this is an array that contains user input.
     */
    public void matchOrder(int[] ans, int[] order)
    {
        cCP = 0;
        for(int i = 0; i < 4; i++) 
        {
            System.out.println(ans[i]);
            System.out.println(order[i]);
            if(ans[i] == order[i])
            {
                cCP++;
            }
        }
        System.out.println("Order result: " + cCP);
    }

    /**
     * this only matches the colour of users input with the answer
     * @param ans this contains an array of length 4 which is the answer of the colour code
     * @param order this is an array that contains user input.
     */
    public void matchColour(int []ans, int [] order)
    {
        cC = 0;
        for(int i = 0;i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(ans[i] == order[j])
                {
                    cC++;
                    order[j] = 9;
                    break;
                }
            }
        }
        System.out.println("Colour Result: " + cC);
    }

    /**
     * this is a method for another class to call which allows them to obtain the value of correct Colour (i.e. cC)
     * @return the number of correct colour
     */
    public int getCC()
    {
        return cC;
    }

    /**
     * this is a method for another class to call which allows them to obtain the value of correct Colour and order (i.e. cCP)
     * @return the number of input that colour and position are correct
     */
    public int getcCP()
    {
        return cCP;
    }
}
