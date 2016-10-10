package de.dhbwka.java.exercise.xml;

import org.w3c.dom.Document;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cem on 14.07.16.
 */
public class Gazetteer implements XMLLoaderCallback, RequestJobSchedule {
    private final ExecutorService downloadService;


    public Gazetteer() {
        downloadService = Executors.newFixedThreadPool(3);
    }

    public static void main(String[] args) {
        Gazetteer gazetteer = new Gazetteer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            gazetteer.newRequest(scanner.nextLine());

        }

    }

    @Override
    public void onXMLLoaded(Document document) {
        XMLHelper.analyzeDocument(document);
    }

    @Override
    public void newRequest(String argument) {
        downloadService.execute(new XMLLoader(argument, this));
    }
}
