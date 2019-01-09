import org.w3c.dom.Document;
import org.w3c.dom.Element;


import java.util.Random;

public class ColorMaker
{
    private static String[] data = {"red", "green", "blue"};
    private static Random random = new Random();

    public static void RandomColor(Document doc)
    {
        String color = GetColor();
        double value = GetValue();

    }

    public static double GetValue()
    {
        return random.nextDouble() * 255;
    }

    public static String GetColor()
    {
        return data[random.nextInt(data.length)];
    }
}
