import Readers.Color;

import javax.swing.*;

public class ColorChooser
{
    public static Color PickColor()
    {
        int selection;
        String[] options = new String[3];
        options[0] = "red";
        options[1] = "green";
        options[2] = "blue";

        selection = JOptionPane.showOptionDialog(null,
                "What color should I look for?",
                "Choose a color",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);

        switch(selection)
        {
            case 0:
                return Color.RED;

            case 1:
                return Color.GREEN;

            case 2:
                return Color.BLUE;

            default:
                return Color.RED;
        }
    }

}
