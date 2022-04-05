package utils;

import java.text.SimpleDateFormat;

/**
 * Gets the date when called for.
 * @author Jiangqi
 */
public class Date {
    /**
     * @return the current date
     */
    public static String getResultDate() {
        return new SimpleDateFormat("dd-MMMM-yyyy").format(new java.util.Date());
    }
}
