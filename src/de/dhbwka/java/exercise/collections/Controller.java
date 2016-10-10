package de.dhbwka.java.exercise.collections;

/**
 * Created by cem on 23.06.16.
 */
public class Controller implements AwesomeController {
    public final String csvPath;
    public final BooksLibrary libary = LibrarySaver.open();


    public Controller(String path) {
        this.csvPath = path;
        new Gui(this).setVisible(true);
        LibrarySaver.open();
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0] != null) new Controller(args[0]);
        else new Controller("");
    }

    @Override
    public Object getSortedBooksBy(LibSort sortBy) {
        switch (sortBy) {
            case AUTOR:
                return libary.sortBy(Books::getAutor).map(Books::toString).reduce("", (a, b) -> a + b + System.lineSeparator());
            case TITLE:
                return libary.sortBy(Books::getTitle).map(Books::toString).reduce("", (a, b) -> a + b + System.lineSeparator());
            case VERLAG:
                return libary.sortBy(Books::getVerlag).map(Books::toString).reduce("", (a, b) -> a + b + System.lineSeparator());
            case JAHR:
                return libary.sortBy(Books::getJahr).map(Books::toString).reduce("", (a, b) -> a + b + System.lineSeparator());
            default:
                return libary.sortBy(Books::getAutor).map(Books::toString).reduce("", (a, b) -> a + b + System.lineSeparator());
        }

    }

    @Override
    public boolean addBooks(String title, String autor, String verlag, int jahr) {
        return libary.add(new Books(title, autor, verlag, jahr));
    }

    @Override
    public void saveState() {
        LibrarySaver.save("", libary);
        System.exit(0);
    }
}
