package de.dhbwka.java.exercise.collections;

/**
 * Created by cem on 23.06.16.
 */
public class Books {

    private final String title;
    private final String autor;
    private final int jahr;
    private final String verlag;

    public Books(String title, String autor, String verlag, int jahr) {
        this.title = title;
        this.autor = autor;
        this.jahr = jahr;
        this.verlag = verlag;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Books && isIdentity((Books) obj);
    }

    private boolean isIdentity(Books b) {
        return b.getJahr() == this.jahr && b.getVerlag().equals(this.verlag)
                && b.getAutor().equals(autor) && b.getTitle().equals(this.title);
    }

    @Override
    public String toString() {
        return getTitle() + " von " + getAutor() + " aus dem Jahr " + getJahr() + " erschienen bei " + getVerlag();
    }

    public String getTitle() {
        return title;
    }

    public String getAutor() {
        return autor;
    }

    public int getJahr() {
        return jahr;
    }

    public String getVerlag() {
        return verlag;
    }
}
