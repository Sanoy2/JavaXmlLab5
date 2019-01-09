public class DataSetSizeGetter
{
    public static int[] PickDataSetSize(Mode mode)
    {
        if(mode == Mode.FAST)
        {
            int[] numberOfElements = {10, 50, 100, 500, 1000, 5000, 10000, 20000, 30000, 40000, 50000, 75000, 100000};
            return numberOfElements;
        }
        else
        {
            int[] numberOfElements = {10, 20, 30, 40, 50, 60, 70, 80, 90,
                    100, 200, 300, 400, 500, 600, 700, 800, 900,
                    1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000,
                    10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000,
                    100000, 150000, 200000, 250000, 300000, 350000, 400000, 450000, 500000};
            return numberOfElements;
        }
    }
}
