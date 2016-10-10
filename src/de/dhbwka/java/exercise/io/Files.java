package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by cem on 14.03.16.
 */
public class Files {

    public static void main(String[] args) {
        if (args[0] != null) {
            File folder = new File(args[0], "mydir");
            folder.deleteOnExit();

            if (folder.mkdir()) {
                System.out.println("mydir: " + folder.getAbsolutePath());

                try {

                    for (int i = 0; i < 3; i++) {
                        File file = new File(folder, "foo" + (i + 1));
                        if (file.createNewFile())
                            file.deleteOnExit();
                        System.out.println("foo" + (i + 1) + ": " + file.getAbsolutePath());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
