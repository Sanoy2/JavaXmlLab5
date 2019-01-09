package Readers;

public enum Color
{
    RED, BLUE, GREEN;

    public static String WhatToLookFoor(Color color)
    {
        switch(color)
        {
            case RED:
                return "red";

            case BLUE:
                return "blue";

            case GREEN:
                return "green";

            default:
                return null;
        }
    }
}
