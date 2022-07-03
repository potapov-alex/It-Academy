package xml_parsers.entity;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xml_parsers.parsers.dom.DomParser;

import java.util.ArrayList;
import java.util.List;

public class Article {
    private String id;
    private String title;
    private String author;
    private String url;
    private List<String> hotkeys;

    public Article() {
    }

    public static List<Article> setArticleWithXMLChildNodeValues(NodeList nodeList) {
        List<Article> articles = new ArrayList<>();
        DomParser.getNodeListStream(nodeList).forEach(node -> {
                    if (node instanceof Element) {
                        Article article = new Article();
                        article.setId(node.getAttributes().getNamedItem("ID").getNodeValue());
                        NodeList childNodes = node.getChildNodes();
                        DomParser.getNodeListStream(childNodes).forEach(childNode -> {
                                    if (childNode instanceof Element) {
                                        setArticleWithXMLChildNodeValues(article, childNode);
                                    }
                                }
                        );
                        articles.add(article);
                    }
                }
        );
        return articles;
    }

    public static Article setArticleWithXMLChildNodeValues(Article article, Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        switch (node.getNodeName()) {
            case "title" -> article.setTitle(content);
            case "author" -> article.setAuthor(content);
            case "url" -> article.setUrl(content);
            case "hotkeys" -> {
                List<String> hotkeys = new ArrayList<>();
                NodeList childNodes = node.getChildNodes();
                DomParser.getNodeListStream(childNodes).forEach(childNode -> {
                    if (childNode instanceof Element) {
                        hotkeys.add(setHotkeyWithXMLChildNodeValues(childNode));
                    }
                });
                article.setHotkeys(hotkeys);
            }
        }
        return article;
    }

    private static String setHotkeyWithXMLChildNodeValues(Node node) {
        String content = node
                .getLastChild()
                .getTextContent()
                .trim();
        return content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getHotkeys() {
        return hotkeys;
    }

    public void setHotkeys(List<String> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return "\n         Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkeys=" + hotkeys +
                '}';
    }
}