package Readers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaxReader implements XmlReader // works
{
    public Method GetMethod()
    {
        return Method.SAX;
    }

    public double CountAverage(String pathToFile, Color color)
    {
        String wantedColor = Color.WhatToLookFoor(color);

        try
        {
            File inputFile = new File(pathToFile);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler(wantedColor);
            saxParser.parse(inputFile, userhandler);

            return AverageCounter.Average(userhandler.values);
        } catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public class UserHandler extends DefaultHandler
    {
        private String wantedColor;
        private List<Double> values;
        private boolean read;

        UserHandler(String color)
        {
            wantedColor = color;
            values = new ArrayList<>();
            read = false;
        }

        public List<Double> getValues()
        {
            return values;
        }

        @Override
        public void startElement(
                String uri, String localName, String qName, Attributes attributes)
        {
//            System.out.println("\nStart tag: " + qName);
            String color = attributes.getValue("color");
//            System.out.println("Color: " + color);
            if(qName.equals("value") && wantedColor.equals(color))
                read = true;
        }

        @Override
        public void endElement(String uri,
                               String localName, String qName)
        {
//            System.out.println("End tag: " + qName);
            if(qName.equals("value"))
                read = false;
        }

        @Override
        public void characters(char ch[], int start, int length)
        {
            if (read)
            {
                String tmp = new String(ch, start, length);
                if (!tmp.isEmpty())
                {
                    values.add(Double.parseDouble(tmp));
//                    System.out.println(tmp);
                }
            }
        }
    }
}
