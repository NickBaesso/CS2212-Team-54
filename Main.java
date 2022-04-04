import gui.LoginWindow;
import gui.MainUI;
import infrastructure.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static void showMainUI() {
        MainUI ui = MainUI.getInstance();
        ArrayList<Trader> traderList = new ArrayList<Trader>();


        ui.setTraderList(traderList);

        ui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ui.setVisible(true);
    }

    public static void main(String[] args) {
        Authenticator auth = new Authenticator("pw.txt");
        LoginWindow loginWindow = new LoginWindow(auth);
        loginWindow.setVisible(true);

        loginWindow.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (auth.isLoggedIn()) {
                    System.out.println("hi");
                    showMainUI();
                }
                else {
                    System.exit(0);
                }
            }
        });

    }
}
