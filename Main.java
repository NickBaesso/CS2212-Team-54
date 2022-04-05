import gui.GenericUI;
import gui.LoginWindow;
import gui.MainUI;
import infrastructure.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This is the main class of the program that sets everything off.
 * @author Jiangqi
 */
public class Main {
    public static void main(String[] args) {
        Authenticator auth = new Authenticator("pw.txt");
        GenericUI proxy = new LoginWindow(auth);
        proxy.setVisible(true);

        proxy.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (auth.isLoggedIn()) {
                    System.out.println("hi");
                    proxy.request();
                }
                else {
                    System.exit(0);
                }
            }
        });

    }
}
