package com.company;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class People
{
    private List<Person> people;

    public People()
    {
        people = new ArrayList<>();
    }

    public List<Person> GetPeople()
    {
        return people;
    }

    public void Add(Person person)
    {
        people.add(person);
    }

    public void Print()
    {
        for (Person person : people)
        {
            System.out.println(person.toString());
        }
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public void ReadFromXml(String path) throws Exception
    {
        Person person = null;
        BirthDay birthDay = null;
        HomeAddress homeAddress = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
        while (xmlEventReader.hasNext())
        {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.isStartElement())
            {
                StartElement startElement = xmlEvent.asStartElement();
                if (startElement.getName().getLocalPart().equals("person"))
                {
                    person = new Person();
                }
                else if (startElement.getName().getLocalPart().equals("name"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    person.setName(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("surname"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    person.setSurname(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("homeAddress"))
                {
                    homeAddress = new HomeAddress();
                }
                else if (startElement.getName().getLocalPart().equals("city"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    homeAddress.setCity(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("zipCode"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    homeAddress.setZipCode(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("street"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    homeAddress.setStreet(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("number"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    homeAddress.setNumber(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("country"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    homeAddress.setCountry(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("phone"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    person.setPhone(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("mobile"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    person.setMobile(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("job"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    person.setJob(xmlEvent.asCharacters().getData());
                }
                else if (startElement.getName().getLocalPart().equals("birthDay"))
                {
                    birthDay = new BirthDay();
                }
                else if (startElement.getName().getLocalPart().equals("day"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    birthDay.setDay(Integer.parseInt(xmlEvent.asCharacters().getData()));
                }
                else if (startElement.getName().getLocalPart().equals("month"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    birthDay.setMonth(Integer.parseInt(xmlEvent.asCharacters().getData()));
                }
                else if (startElement.getName().getLocalPart().equals("year"))
                {
                    xmlEvent = xmlEventReader.nextEvent();
                    birthDay.setYear(Integer.parseInt(xmlEvent.asCharacters().getData()));
                }
            }
            if(xmlEvent.isEndElement())
            {
                EndElement endElement = xmlEvent.asEndElement();
                if(endElement.getName().getLocalPart().equals("person"))
                {
                    person.setHomeAddress(homeAddress);
                    person.setBirthDay(birthDay);
                    people.add(person);

                }
            }
        }
    }
}

