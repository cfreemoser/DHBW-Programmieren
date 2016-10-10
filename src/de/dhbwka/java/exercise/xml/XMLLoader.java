package de.dhbwka.java.exercise.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class XMLLoader implements Runnable {
    private static final String BASE_URL = "http://maps.googleapis.com/maps/api/geocode/xml?address=%data%&sensor=false";
    private final String argument;
    private final XMLLoaderCallback callback;

    public XMLLoader(String arg, XMLLoaderCallback callback) {
        this.argument = arg;
        this.callback = callback;
    }


    @Override
    public void run() {
        callback.onXMLLoaded(getXML());
    }

    private Document getXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder parser = factory.newDocumentBuilder();
            String url = BASE_URL.replace("%data%", argument.replace(" ", "_"));
            return parser.parse(url);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return null;
        }
    }
}
