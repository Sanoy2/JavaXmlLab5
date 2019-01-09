package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler
{
    @Override
public void startElement(
        String uri, String localName, String qName, Attributes attributes)
{
    System.out.println("Start tag: " + qName);
}

    @Override
    public void endElement(String uri,
                           String localName, String qName)
    {
        System.out.print("End tag: " + qName);
    }

    @Override
    public void characters(char ch[], int start, int length)
    {
        String tmp = new String(ch, start, length);
        if(!tmp.isEmpty())
            System.out.println(tmp.split(" ")[0].trim());  // first word of body content
    }
}
