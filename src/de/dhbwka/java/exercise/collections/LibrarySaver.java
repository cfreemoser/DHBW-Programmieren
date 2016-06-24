package de.dhbwka.java.exercise.collections;

import org.w3c.dom.*;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by cem on 23.06.16.
 */
public class LibrarySaver {
    private static final String DTD_FILE = "bookslib.dtd";
    private static final String FILE_NAME = "lib.xml";


    public static void save(String path, BooksLibrary libary) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            //Add DTD
            DOMImplementation domImplementation = doc.getImplementation();
            DocumentType documentType = domImplementation.createDocumentType("BOOKSLIBRARY", "SYSTEM", DTD_FILE);
            // doc.appendChild(documentType);
            Element books = doc.createElement("BOOKS");
            for (Books book : libary.getAll()) {
                Element xBook = doc.createElement("BOOK");

                Element title = doc.createElement("TITLE");
                title.setTextContent(book.getTitle());

                Element autor = doc.createElement("AUTOR");
                autor.setTextContent(book.getAutor());

                Element verlag = doc.createElement("VERLAG");
                verlag.setTextContent(book.getVerlag());

                Element jahr = doc.createElement("JAHR");
                jahr.setTextContent(String.valueOf(book.getJahr()));

                System.out.println(book);

                xBook.appendChild(title);
                xBook.appendChild(autor);
                xBook.appendChild(verlag);
                xBook.appendChild(jahr);
                books.appendChild(xBook);
            }

            doc.appendChild(books);


            //write XML
            DOMImplementationLS domImplementationLS = (DOMImplementationLS) doc.getImplementation().getFeature("LS", "3.0");
            LSOutput lsOutput = domImplementationLS.createLSOutput();
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            lsOutput.setByteStream(outputStream);
            LSSerializer lsSerializer = domImplementationLS.createLSSerializer();
            lsSerializer.write(doc, lsOutput);
            outputStream.close();

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    public static BooksLibrary open() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document dom;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            dom = builder.parse(FILE_NAME);
            dom.getDocumentElement().normalize();
            NodeList nodeList = dom.getElementsByTagName("BOOK");

            BooksLibrary libary = new BooksLibrary();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("TITLE").item(0).getTextContent();
                    String autor = element.getElementsByTagName("AUTOR").item(0).getTextContent();
                    String verlag = element.getElementsByTagName("VERLAG").item(0).getTextContent();
                    String jahr = element.getElementsByTagName("JAHR").item(0).getTextContent();
                    libary.add(new Books(title, autor, verlag, Integer.parseInt(jahr)));
                }
            }

            return libary;
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
        return new BooksLibrary();
    }
}
