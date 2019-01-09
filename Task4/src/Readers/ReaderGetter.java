package Readers;

public class ReaderGetter
{
    public static XmlReader GetReader(Method method)
    {
        switch (method)
        {
            case DOM:
                return new DomReader();

            case SAX:
                return new SaxReader();

            case STAX:
                return new StaxReader();

            default:
                return null;
        }
    }
}
