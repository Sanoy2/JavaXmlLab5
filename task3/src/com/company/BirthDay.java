package com.company;

public class BirthDay
{
    private int day;
    private int month;
    private int year;

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    @Override
    public String toString()
    {
        return "Birthday (dd.mm.yyyy): " + Day() + "." + Month() + "." + year;
    }

    private String Day()
    {
        if(day < 10)
            return "0" + day;
        return Integer.toString(day);
    }

    private String Month()
    {
        if(month < 10)
            return "0" + month;
        return Integer.toString(month);
    }
}
