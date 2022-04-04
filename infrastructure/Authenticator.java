package infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Authenticator {
    Boolean loggedIn = false;
    String username;
    String password;
    String fileLoc;

    public Authenticator(String loc) {
        fileLoc = loc;
    }

    public Boolean isLoggedIn() {
        return loggedIn;
    }

    public Boolean authenticate(String username, String password) {
        this.username = username;
        this.password = password;

        // io here
        try {
            File db = new File(fileLoc);
            Scanner scanner = new Scanner(db);
            while (scanner.hasNextLine()) {
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
