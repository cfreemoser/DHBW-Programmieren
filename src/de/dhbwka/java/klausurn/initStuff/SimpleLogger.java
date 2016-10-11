package de.dhbwka.java.klausurn.initStuff;

import java.io.*;
import java.util.Calendar;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by cfreemoser on 11.10.16.
 */
public interface SimpleLogger {
    /**
     * This method is used for setting the logfile name
     *
     * @return logfile name
     */
    String setLogFileName();

    /**
     * Opens the logfile. Default is a file with the name von setLogFile in Project path.
     *
     * @return the logfile
     */
    default File getLogFile() {
        return new File(setLogFileName());
    }

    /**
     * Save a line to the logFile which is set with setLogFileName
     *
     * @param msg the message to save
     */
    default void log(String msg) {
        try (PrintStream ps = new PrintStream(new FileOutputStream(getLogFile(), true))) {
            ps.println(msg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save a line to the logFile which is set with setLogFileName
     *
     * @param msg   the message to save
     * @param place Position of current time
     */
    default void log(String msg, DatumPlace place) {
        try (PrintStream ps = new PrintStream(new FileOutputStream(getLogFile(), true))) {
            String baseLine = place == DatumPlace.LEFT ? "%date% %msg%" : "%msg% %date%";
            String date = "(" + Calendar.getInstance().getTime().toString() + ")";
            ps.println(baseLine.replace("%date%", date).replace("%msg%", msg));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Trys to read the logfile line by line
     *
     * @return maybe returns a Stream of lines
     */
    default Optional<Stream<String>> readLogFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getLogFile()))) {
            return Optional.of(reader.lines());
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * Where should the date be?
     */
    enum DatumPlace {
        LEFT, RIGHT
    }
}
