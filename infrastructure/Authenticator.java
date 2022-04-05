package infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is responsible for verifying that the
 * information inputted into the login window is
 * correct.
 *
 * @author Jiangqi
 */
public class Authenticator {
    private boolean loggedIn = false; // Returns if the user was successful or failed.
    private String fileLoc; // File location.

    public Authenticator(String loc) {
        fileLoc = loc;
    }

    /**
     * @return whether or not the user is logged In
     */
    public boolean isLoggedIn() { return loggedIn; }

    /**
     * Check that the given password and name match
     * what is stored in the file.
     * @param username
     * @param password
     * @return true or false depending on the results of the match.
     */
    public boolean authenticate(String username, String password) {
        // io here
        try {
            File db = new File(fileLoc);
            Scanner scanner = new Scanner(db);
            while (scanner.hasNextLine()) { // Read from file while data can still be read.
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts[0].equals(username) && parts[1].equals(password)) {  // match
                    loggedIn = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return loggedIn;
    }
}
