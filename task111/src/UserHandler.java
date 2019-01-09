import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler
{
    int i = 0;

    boolean bRow = false;
    boolean bNumber = false;
    boolean bFields = false;
    boolean bField = false;
    boolean bLetter = false;
    boolean bChessman = false;
    boolean bType = false;
    boolean bColor = false;

    String row = "";
    String col = "";
    String chessmanType = "";
    String chessmanColor = "";

    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("row")) {
            bRow = true;
        } else if (qName.equalsIgnoreCase("number")) {
            bNumber = true;
        } else if (qName.equalsIgnoreCase("fields")) {
            bFields = true;
        } else if (qName.equalsIgnoreCase("field")) {
            bField = true;
        } else if (qName.equalsIgnoreCase("letter")) {
            bLetter = true;
        } else if (qName.equalsIgnoreCase("chessman")) {
            bChessman = true;
        } else if (qName.equalsIgnoreCase("type")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("color")) {
            bColor = true;
        }
    }



    @Override
    public void characters(char ch[], int start, int length) throws SAXException
    {
        if (bNumber)
        {
            row = new String(ch, start, length);
            bNumber = false;
        } else if (bLetter)
        {
            col = new String(ch, start, length);
            bLetter = false;
        } else if (bType)
        {
            chessmanType = new String(ch, start, length);
            bType = false;
        } else if (bColor)
        {
            chessmanColor = new String(ch, start, length);
            bColor = false;
            Print();
        }

    }

    private void Print()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(chessmanColor + " ");
        builder.append(chessmanType);
        builder.append(": ");
        builder.append(col);
        builder.append(row);
        System.out.println(builder.toString());
        i++;
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("chessboard")) {
            System.out.println(i + " Chess pieces on board");
        }
    }
}
