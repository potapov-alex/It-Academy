package xml_parsers;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xml_parsers.entity.Journal;
import xml_parsers.parsers.dom.DomParser;
import xml_parsers.parsers.sax.SaXParser;
import xml_parsers.parsers.stax.StAXParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;

import static xml_parsers.entity.Journal.setJournalWithXMLNodeValues;
import static xml_parsers.parsers.dom.DomParser.parseXmlDocument;


public class XMLParser {
    public static String XML_PATH = "journal.xml";
    public static Journal journal = new Journal();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
        int actionCode;
        do {
            printMenu();
            actionCode = new Scanner(System.in).nextInt();
            switch (actionCode) {
                case 1:
                    Document document = parseXmlDocument(XML_PATH);
                    NodeList nodeList = DomParser.getNodeList(document);
                    journal = setJournalWithXMLNodeValues(nodeList);
                    System.out.println(journal.toString());
                    break;
                case 2:
                    SAXParserFactory parserFactory = SAXParserFactory.newInstance();
                    SAXParser parser = parserFactory.newSAXParser();
                    SaXParser handler = new SaXParser();
                    parser.parse(ClassLoader.getSystemResourceAsStream(XML_PATH), handler);
                    System.out.println(handler.journal);
                    break;
                case 3:
                    StAXParser.parser();
                    break;
                case 5:
                    System.out.println("Thanks for using the program!");
                    break;
                default:
                    System.out.println("Unknown option. Please enter again");
            }
        } while (actionCode == 5);
    }

    public static void printMenu() {
        System.out.println("\nPlease select an action");
        System.out.println("1 - Use dom parser");
        System.out.println("2 - Use sax parser");
        System.out.println("3 - Use stax parser");
        System.out.println("5 - quit\n");
    }
}