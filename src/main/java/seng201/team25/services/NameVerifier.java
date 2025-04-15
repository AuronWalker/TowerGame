package seng201.team25.services;

/**
 * Verify whether a name is suitable for the program
 */
public class NameVerifier {

    /**
     * Verify whether a name meets parameters. Returns 1 if OK, -1 if contains symbols, -2 if invalid length.
     * @param name name to verify
     * @return state of name validation
     */
    public static int verifyName(String name) {
        int minLength = 3;
        int maxLength = 15;
        if (name.length() >= minLength && name.length() <= maxLength) {
            // Check name has no special characters
            if (name.matches("[A-Za-z0-9]+")) {
                return 1;
            } else {
                return -1;
            }
        } else {
           return -2;
        }
    }

}
