package de.dhbwka.java.exercise.xml;

import org.w3c.dom.Document;

/**
 * Created by cem on 14.07.16.
 */
public interface XMLLoaderCallback {

    void onXMLLoaded(Document document);
}
