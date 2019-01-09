import javax.swing.*;

public class ModeChooser
{
    public static Mode PickMode()
    {
        int selection;
        String[] options = new String[2];
        options[0] = "Small data set - works faster";
        options[1] = "Big data set   - works longer";

        selection = JOptionPane.showOptionDialog(null,
                "What mode should I run?",
                "What mode?",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);

        switch(selection)
        {
            case 0:
                return Mode.FAST;

            case 1:
                return Mode.SLOW;

            default:
                return Mode.FAST;
        }
    }
}
