package Readers;

import java.util.List;

public class AverageCounter
{
    public static double Average(List<Double> values)
    {
        if(values.isEmpty())
            return new Double(0);

        double counter = 0;
        for (Double item : values)
        {
            counter += item;
        }

        return counter / values.size();
    }
}
