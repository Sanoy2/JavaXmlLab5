import javax.swing.*;

public class NumberOfRepeatsChooser
{
    public static int HowManyRepeats()
    {
        int selection;
        String[] options = new String[10];
        options[0] = "red";
        options[1] = "green";
        options[2] = "blue";
        for (int i = 0; i < options.length; i++)
        {
            options[i] = Integer.toString(i+1);
        }

        selection = JOptionPane.showOptionDialog(null,
                "How many times do you want to perform the test for each data set?",
                "How many repeats",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);

        switch(selection)
        {
            case 0:
                return 1;

            case 1:
                return 2;

            case 2:
                return 3;

            case 3:
                return 4;

            case 4:
                return 5;

            case 5:
                return 6;

            case 6:
                return 7;

            case 7:
                return 8;

            case 8:
                return 9;

            case 9:
                return 10;

            default:
                return 1;
        }
    }
}
