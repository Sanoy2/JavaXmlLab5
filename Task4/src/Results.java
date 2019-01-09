import java.util.ArrayList;
import java.util.List;

public class Results
{
    private int[] NumberOfElements;
    private long[] TimeOfDOM;
    private long[] TimeOfSAX;
    private long[] TimeOfSTAX;

    public int[] getNumberOfElements()
    {
        return NumberOfElements;
    }

    public void setNumberOfElements(int[] numberOfElements)
    {
        NumberOfElements = numberOfElements;
    }

    public long[] getTimeOfDOM()
    {
        return TimeOfDOM;
    }

    public void setTimeOfDOM(long[] timeOfDOM)
    {
        TimeOfDOM = timeOfDOM;
    }

    public long[] getTimeOfSAX()
    {
        return TimeOfSAX;
    }

    public void setTimeOfSAX(long[] timeOfSAX)
    {
        TimeOfSAX = timeOfSAX;
    }

    public long[] getTimeOfSTAX()
    {
        return TimeOfSTAX;
    }

    public void setTimeOfSTAX(long[] timeOfSTAX)
    {
        TimeOfSTAX = timeOfSTAX;
    }
}
