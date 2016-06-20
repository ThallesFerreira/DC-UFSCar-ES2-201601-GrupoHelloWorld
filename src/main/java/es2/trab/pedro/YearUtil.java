package es2.trab.pedro;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class YearUtil {

    private static final int OLDEST_POSSIBLE = 1950;

    /**
     * @param year Year instance to be tested
     * @return if year is above the defined bottom limit and under current year
     */
    public static boolean validate(String value) {
        int year = Integer.parseInt(value);
        int top_limit = new GregorianCalendar().get(GregorianCalendar.YEAR);

        try {
            if ((year >= OLDEST_POSSIBLE) && (year <= top_limit)) {
                return true;
            } else {
                throw new YearException("Year value is invalid. Should be between " + top_limit + " and " + OLDEST_POSSIBLE);
            }
        } catch (YearException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid Publication Year", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
