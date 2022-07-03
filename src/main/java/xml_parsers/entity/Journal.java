package xml_parsers.entity;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import xml_parsers.parsers.dom.DomParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static xml_parsers.entity.Article.setArticleWithXMLChildNodeValues;

public class Journal {
    private String title;
    private Map<String, String> contacts;
    private List<Article> articles;

    public static Journal setJournalWithXMLNodeValues(NodeList nodeList) {
        Journal journal = new Journal();
        DomParser.getNodeListStream(nodeList).forEach(node -> {
                    if (node instanceof Element) {
                        String content = node.getLastChild().getTextContent().trim();

                        switch (node.getNodeName()) {
                            case "title" -> journal.setTitle(content);
                            case "contacts" -> {
                                Map<String, String> contacts = new HashMap<>();
                                NodeList childNodes = node.getChildNodes();
                                DomParser.getNodeListStream(childNodes).forEach(childNode -> {
                                            if (childNode instanceof Element) {
                                                contacts.put(childNode.getNodeName(), childNode.getTextContent());
                                            }
                                        }
                                );
                                journal.setContacts(contacts);
                            }
                            case "articles" -> {
                                NodeList childNodes = node.getChildNodes();
                                DomParser.getNodeListStream(childNodes).forEach(childNode -> {
                                            if (childNode instanceof Element) {
                                                journal.setArticle(setArticleWithXMLChildNodeValues(node.getChildNodes()));
                                            }
                                        }
                                );
                            }
                        }
                    }
                }
        );
        return journal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, String> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, String> contacts) {
        this.contacts = contacts;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticle(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal{\n" +
                "      title='" + title + '\'' + ",\n" +
                "      contacts=" + contacts + ",\n" +
                "      articles=" + articles +
                "\n}";
    }
}