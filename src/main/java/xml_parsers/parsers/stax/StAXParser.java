package xml_parsers.parsers.stax;

import xml_parsers.entity.Journal;
import xml_parsers.entity.Article;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StAXParser {
    public static void parser() throws XMLStreamException {
        Journal journal = null;
        Map<String, String> contacts = null;
        List<Article> articles = null;
        Article article = null;
        List<String> hotkeys = null;
        String content = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader =
                factory.createXMLStreamReader(
                        ClassLoader.getSystemResourceAsStream("journal.xml"));

        while (reader.hasNext()) {

            int event = reader.next();

            switch (event) {

                case XMLStreamConstants.START_ELEMENT -> {
                    if ("journal".equals(reader.getLocalName())) {
                        journal = new Journal();
                    }
                    if ("contacts".equals(reader.getLocalName())) {
                        contacts = new HashMap<>();
                    }
                    if ("articles".equals(reader.getLocalName())) {
                        articles = new ArrayList<>();
                    }
                    if ("article".equals(reader.getLocalName())) {
                        article = new Article();
                        article.setId(reader.getAttributeValue(0));
                    }
                    if ("hotkeys".equals(reader.getLocalName())) {
                        hotkeys = new ArrayList<>();
                    }
                }

                case XMLStreamConstants.CHARACTERS -> {
                    content = reader.getText().trim();
                }

                case XMLStreamConstants.END_ELEMENT -> {
                    switch (reader.getLocalName()) {
                        case "title" -> {
                            if (null == journal.getTitle()) {
                                journal.setTitle(content);
                            } else {
                                article.setTitle(content);
                            }
                        }
                        case "address" -> contacts.put(reader.getLocalName(), content);
                        case "tel" -> contacts.put(reader.getLocalName(), content);
                        case "email" -> contacts.put(reader.getLocalName(), content);
                        case "url" -> {
                            if (null == contacts.get("url")) {
                                contacts.put(reader.getLocalName(), content);
                            } else {
                                article.setUrl(content);
                            }
                        }
                        case "contacts" -> journal.setContacts(contacts);
                        case "author" -> article.setAuthor(content);
                        case "hotkey" -> hotkeys.add(content);
                        case "hotkeys" -> article.setHotkeys(hotkeys);
                        case "article" -> articles.add(article);
                        case "articles" -> journal.setArticle(articles);
                    }
                }
            }
        }
        assert journal != null;
        System.out.println(journal);
    }
}