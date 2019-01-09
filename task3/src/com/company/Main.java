package com.company;
public class Main {

    public static void main(String[] args) throws Exception
    {
        System.out.println("Program started");

        String path = "task1.xml";

        People people = new People();
        people.ReadFromXml(path);
        people.Print();

        System.out.println("Program finished");
    }
}
