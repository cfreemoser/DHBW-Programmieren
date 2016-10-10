package de.dhbwka.java.exercise.xml;

import org.w3c.dom.Document;

/**
 * Created by cem on 14.07.16.
 */
public class XMLHelper {

    public static void analyzeDocument(Document document) {
        StringBuilder builder = new StringBuilder();

        builder.append("Adresse: ")
                .append(document.getElementsByTagName("formatted_address").item(0).getTextContent())
                .append(System.lineSeparator())
                .append("Long Name: ")
                .append(document.getElementsByTagName("long_name").item(0).getTextContent())
                .append(System.lineSeparator())
                .append("Location: ")
                .append("(latitude=")
                .append(document.getElementsByTagName("lat").item(0).getTextContent())
                .append(",").append(" longitude=")
                .append(document.getElementsByTagName("lng").item(0).getTextContent())
                .append(")");

        System.out.println(builder.toString());
    }


}
