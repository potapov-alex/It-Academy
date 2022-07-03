package xml_parsers.parsers.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DomParser {
    public static DocumentBuilder createDocumentBuilder() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println("Error create document builder.");
            return null;
        }
    }

    public static Document parseXmlDocument(String path) {
        DocumentBuilder documentBuilder = createDocumentBuilder();
        Document document = null;
        if (null != documentBuilder) {
            try {
                document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream(path));
            } catch (Exception e) {
                System.out.println("Error parsing document");
            }
        }
        return document;
    }

    public static NodeList getNodeList(Document document) {
        return document.getDocumentElement().getChildNodes();
    }

    public static Stream<Node> getNodeListStream(NodeList nodeList) {
        return IntStream.range(0, nodeList.getLength()).mapToObj(nodeList::item);
    }
}