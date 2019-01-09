package Readers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomReader implements XmlReader // works
{
    public Method GetMethod()
    {
        return Method.DOM;
    }

    public double CountAverage(String pathToFile, Color color)
    {
        String wantedColor = Color.WhatToLookFoor(color);

        try
        {
            File fXmlFile = new File(pathToFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            return CountAverage(doc, wantedColor);
        }
        catch(Exception e)
        {
            return -1;
        }
    }

    private double CountAverage(Document doc, String wantedColor)
    {
        List<Double> values = new ArrayList<>();

        String inStringValue = "";

        NodeList bunchOfNodes = doc.getElementsByTagName("value");

        for (int i = 0; i < bunchOfNodes.getLength(); i++)
        {
            Node node = bunchOfNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {

                Element element = (Element) node;
                if(element.getAttribute("color").equals(wantedColor))
                {
                    inStringValue = element.getTextContent();
//                    System.out.println(inStringValue);
                    values.add(Double.parseDouble(inStringValue));
                }

            }

        }

        return AverageCounter.Average(values);
    }
}
