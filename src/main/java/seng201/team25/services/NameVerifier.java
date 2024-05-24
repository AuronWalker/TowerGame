package seng201.team25.services;

public class NameVerifier {
    private static int maxLength = 15;
    private static int minLength = 3;

    public static int verifyName(String name) {
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
