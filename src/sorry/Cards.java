package sorry;
public class Cards {
    private static int times[] = new int[11];
    private static int vals[] = new int[11];
    private static int cardVal;
    public static void Reset()
    {
        for (int i=0; i < 11; i++)
            times[i] = 0;
        for (long i=0, j=0; j < 11; i++, j++)
        {
            if (i == 6 || i == 9)
                i++;
            vals[(int)j] = (int)i;
        }
        PullCard();
    }
    public static void PullCard()
    {
        int val = (int) (Math.random() * 11);
        {
            cardVal = vals[val];
            System.out.println(cardVal);
        }
    }
    public static int getVal()
    {
        return cardVal;
    }
}
