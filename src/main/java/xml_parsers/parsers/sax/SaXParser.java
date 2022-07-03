package xml_parsers.parsers.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xml_parsers.entity.Article;
import xml_parsers.entity.Journal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaXParser extends DefaultHandler {

    public Journal journal = null;
    public Map<String, String> contacts = null;
    List<Article> articles = null;
    Article article = null;
    List<String> hotkeys = null;
    String content = null;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes)
            throws SAXException {
        System.out.println("startElement for :" + qName);
        switch (qName) {
            //Create a new journal object when the start tag is found
            case "journal" -> journal = new Journal();
            case "contacts" -> contacts = new HashMap<>();
            case "articles" -> articles = new ArrayList<>();
            case "article" -> {
                article = new Article();
                article.setId(attributes.getValue("ID"));
            }
            case "hotkeys" -> hotkeys = new ArrayList<>();
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName)
            throws SAXException {
        System.out.println("endElement for :" + qName);
        switch (qName) {
            case "title" -> {
                if (null == journal.getTitle()) {
                    journal.setTitle(content);
                } else {
                    article.setTitle(content);
                }
            }
            case "address" -> contacts.put(qName, content);
            case "tel" -> contacts.put(qName, content);
            case "email" -> contacts.put(qName, content);
            case "url" -> {
                if (null == contacts.get("url")) {
                    contacts.put(qName, content);
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

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("characters ");
        content = String.copyValueOf(ch, start, length).trim();
    }
}