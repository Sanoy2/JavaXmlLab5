package Readers;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.namespace.QName;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxReader implements XmlReader
{
    public Method GetMethod()
    {
        return Method.STAX;
    }

    public double CountAverage(String pathToFile, Color color)
    {
        String wantedColor = Color.WhatToLookFoor(color);
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        List<Double> values = new ArrayList<>();

        try
        {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(pathToFile));
            while (xmlEventReader.hasNext())
            {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement())
                {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("value"))
                    {
                        //Get the 'color' attribute from value element
                        Attribute colotAttr = startElement.getAttributeByName(new QName("color"));
                        if (colotAttr != null)
                        {
                            if(colotAttr.getValue().equals(wantedColor))
                            {
                                xmlEvent = xmlEventReader.nextEvent();
                                String inStringValue = xmlEvent.asCharacters().getData();
                                values.add(Double.parseDouble(inStringValue));
                            }
                        }

                    }
                }
            }

            return AverageCounter.Average(values);
        } catch (Exception e)
        {

        }

        return 0;
    }
}
