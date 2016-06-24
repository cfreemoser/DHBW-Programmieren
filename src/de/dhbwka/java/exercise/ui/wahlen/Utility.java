package de.dhbwka.java.exercise.ui.wahlen;

import java.awt.*;

/**
 * Created by cem on 22.06.16.
 */
public class Utility {
    /**
     * @param colorStr e.g. "#FFFFFF"
     * @return
     */
    public static Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }
}
