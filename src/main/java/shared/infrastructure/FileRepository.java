package shared.infrastructure;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import shared.domain.Author;
import shared.domain.Book;
import shared.domain.DataRepository;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRepository implements DataRepository {
    private List<Book> books;
    private String filepath;

    public FileRepository(String filepath) {
        this.filepath = filepath;
    }

    private Book buildBook(Element node) {
        String title = node.getElementsByTagName("title").item(0).getTextContent();

        Element authorNode = (Element) node.getElementsByTagName("author").item(0);
        String authorName = authorNode.getElementsByTagName("name").item(0).getTextContent();
        String authorSurname = authorNode.getElementsByTagName("surname").item(0).getTextContent();

        return new Book(title, new Author(authorName, authorSurname));
    }

    private synchronized List<Book> readFile() throws ParserConfigurationException, IOException, SAXException {
        File file = new File(filepath);
        List<Book> books = new ArrayList<Book>();

        //Parse file into a document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();

        //Get all books nodes
        NodeList nodeList = doc.getElementsByTagName("book");

        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                books.add(this.buildBook((Element) node));
            }
        }

        return books;
    }

    @Override
    public Book getBook(String title) throws IOException, SAXException, ParserConfigurationException {
        Stream<Book> books = readFile().stream();
        return books.filter(book -> title.toLowerCase().equals(book.getTitle().toLowerCase())).findAny().orElse(null);
    }

    @Override
    public List<Book> getAuthor(String name, String surname) throws IOException, SAXException, ParserConfigurationException {
        String fullName = name + " " + surname;
        Stream<Book> books = readFile().stream();
        return books.filter(book -> {
            Author author = book.getAuthor();
            return fullName.toLowerCase().equals(author.getFullName().toLowerCase());
        }).collect(Collectors.toList());
    }

    @Override
    public List<Book> getLibrary(String name) throws IOException, SAXException, ParserConfigurationException {
        return readFile();
    }
}
