public class colourCode
{
    private int cCP = 0;
    private int cC = 0;
    public int[] asd;
    
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

    public int getCC()
    {
        return cC;
    }

    public int getcCP()
    {
        return cCP;
    }
}
