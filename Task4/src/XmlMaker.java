import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.DecimalFormat;
import java.util.List;

public class XmlMaker
{
    public static Document CreateDocument(int numberOfValues)
    {
        try
        {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();

            Element root = doc.createElement("values");
            doc.appendChild(root);

            for (int i = 0; i < numberOfValues; i++)
            {
                AddElement(doc);
            }

            return doc;
        } catch (Exception e)
        {
        }
        return null;
    }

    private static void AddElement(Document doc)
    {
        double value = ColorMaker.GetValue();
        String inStringValue = new DecimalFormat("#.0#").format(value).replace(",", ".");

        String color = ColorMaker.GetColor();

        Element element = doc.createElement("value");
        element.appendChild(doc.createTextNode(inStringValue));
        element.setAttribute("color", color);

        Element root = doc.getDocumentElement();
        root.appendChild(element);
    }
}
