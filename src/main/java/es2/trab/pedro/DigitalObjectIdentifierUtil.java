package es2.trab.pedro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class DigitalObjectIdentifierUtil {

    /**
     *  Parts of a DOI:
     *      Directory Identifier: 10
     *      Registrant code: . + [0-9]{4,}
     *      Registrant subdivision (optional): . + [0-9]+
     *      Suffix: / + any character, case insensitive for ASCII chars (but capitalised in the registry), with some characters that should be escaped
     */
    private static final String doiRegex = "(10[.][0-9]{4,}(?:[.][0-9]+)*/(?:(?![%\"#? ])\\S)+)";


    /**
     * @param doi Digital Object Identifier instance to be tested
     * @return if the given DOI is within the International DOI Foundation standards
     */
    public static boolean validate(String doi) {
        Pattern pattern = Pattern.compile(doiRegex);
        Matcher matcher = pattern.matcher(doi);

        try {
            if (matcher.find()) {
                return true;
            } else {
                throw new DigitalObjectIdentifierException("Digital Object Identifier (DOI) is invalid.\n"
                        + "DOI numbers begin with a \"10\" and contain a prefix and a suffix separated by a slash.\n"
                        + "The prefix is a unique number of four or more digits assigned to organizations.\n"
                        + "The suffix is assigned by the publisher and was designed to be flexible with publisher identification standards.");
            }
        } catch (DigitalObjectIdentifierException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid Digital Object Identifier",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
