import Readers.Color;
import Readers.Method;
import Readers.ReaderGetter;
import Readers.XmlReader;
import org.w3c.dom.Document;

import javax.swing.*;

public class Tester
{
    public Results RunTestes() throws Exception
    {
        Mode mode = ModeChooser.PickMode();
        System.out.println("Running " + mode + " mode");
        int[] numberOfElements = DataSetSizeGetter.PickDataSetSize(mode);

        Color color = ColorChooser.PickColor();
        System.out.println("Looking for " + color.toString() + " elements");

        int numberOfRepeats = NumberOfRepeatsChooser.HowManyRepeats();
        System.out.println("Repeating every test " + numberOfRepeats + " times");

        long[] domTimes = new long[numberOfElements.length];
        long[] saxTimes = new long[numberOfElements.length];
        long[] staxTimes = new long[numberOfElements.length];

        XmlReader domReader = ReaderGetter.GetReader(Method.DOM);
        XmlReader saxReader = ReaderGetter.GetReader(Method.SAX);
        XmlReader staxReader = ReaderGetter.GetReader(Method.STAX);


        long tmp;
        boolean firstAttemp = true;

        Thread.sleep(1000);

        for (int i = 0; i < numberOfElements.length; i++)
        {
            System.out.println("Data set: " + numberOfElements[i]);

            CreateSourceFile(numberOfElements[i]);

            tmp = 0;
            firstAttemp = true;
            for(int j = 0; j < numberOfRepeats; j++)
            {
                tmp += Test(domReader, color, firstAttemp);
                firstAttemp = false;
            }
            domTimes[i] = tmp/10;
            System.out.println(", average time: " + domTimes[i] + " ms");

            tmp = 0;
            firstAttemp = true;
            for(int j = 0; j < numberOfRepeats; j++)
            {
                tmp += Test(saxReader, color, firstAttemp);
                firstAttemp = false;
            }
            saxTimes[i] = tmp/10;
            System.out.println(", average time: " + saxTimes[i] + " ms");

            tmp = 0;
            firstAttemp = true;
            for(int j = 0; j < numberOfRepeats; j++)
            {
                tmp += Test(staxReader, color, firstAttemp);
                firstAttemp = false;
            }
            staxTimes[i] = tmp/10;
            System.out.println(", average time: " + staxTimes[i] + " ms");
        }

        Results results = new Results();
        results.setNumberOfElements(numberOfElements);
        results.setTimeOfDOM(domTimes);
        results.setTimeOfSAX(saxTimes);
        results.setTimeOfSTAX(staxTimes);

        System.out.println("Test completed");

        return results;
    }

    private void CreateSourceFile(int numberOfElements)
    {
        Document doc = XmlMaker.CreateDocument(numberOfElements);
        XmlSaver.SaveXml("values.xml", doc);
    }

    private long Test(XmlReader reader, Color color, boolean firstAttemp)
    {
        String path = "values.xml";
        Timer timer = new Timer();

        timer.Start();
        // CODE STARTS HERE
        double average = reader.CountAverage(path, color);
        // CODE ENDS HERE
        timer.Finish();

        if(firstAttemp)
            System.out.print(reader.GetMethod() + " found average: " + average);

        return timer.TimeInMS();
    }
}
