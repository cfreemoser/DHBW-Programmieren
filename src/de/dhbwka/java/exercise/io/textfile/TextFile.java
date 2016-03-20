package de.dhbwka.java.exercise.io.textfile;

import java.io.*;
import java.util.Optional;


/**
 * Created by cem on 19.03.16.
 */
public class TextFile {


    private final File myfile;
    private String[] lines;

    public TextFile(File myfile) throws FileNotFoundException {
        this.myfile = myfile;
        lines = readLine();
    }

    public TextFile(String path) throws FileNotFoundException {
        this.myfile = new File(path);
        lines = readLine();
    }

    private String[] readLine() throws FileNotFoundException {
        FileReader fileReader = new FileReader(myfile);
        BufferedReader myBufferedReader = new BufferedReader(fileReader);
        return myBufferedReader.lines().toArray(String[]::new);


    }

    public void read() {
        try {
            this.lines = readLine();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void write() {
        Optional<FileOutputStream> fileOutputStream = Optional.empty();
        try {
            fileOutputStream = Optional.of(new FileOutputStream(myfile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        PrintStream ps = (fileOutputStream.isPresent()) ? new PrintStream(fileOutputStream.get()) : System.out;
        for (String line : lines)
            ps.println(line);


        try {
            fileOutputStream.get().close();
            ps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int availableLines() {
        return lines.length;
    }

    public String[] getLines() {
        return lines;
    }

    public String getLine(int lineNumber) throws LineNumberOutOfBoundsException {
        if (lineNumber > lines.length || lineNumber < 0)
            throw new LineNumberOutOfBoundsException();
        else return lines[lineNumber];
    }

    public void setLine(int i, String s) throws LineNumberOutOfBoundsException {
        if (i > availableLines() || i <= 0) throw new LineNumberOutOfBoundsException();
        else lines[i - 1] = s;
    }

    public void replaceAll(String regexp, String ersatz) {
        for (int i = 0; i < lines.length; i++)
            lines[i] = lines[i].replaceAll(regexp, ersatz);
    }

    public void close() {
        write();
    }

}


