package utils;

import java.text.SimpleDateFormat;

public class Date {
    public static String getFetcherDate() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());
    }

    public static String getResultDate() {
        return new SimpleDateFormat("dd-MMMM-yyyy").format(new java.util.Date());
    }
}
