package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LoginWindow extends JFrame implements ActionListener {
    JButton submitButton;
    JPanel panel, submitPanel;
    JLabel userLabel, pwLabel;
    JTextField userField, pwField;
    Authenticator authenticator;
    GridBagConstraints constraints;

    LoginWindow(Authenticator auth) {
        authenticator = auth;
        constraints = new GridBagConstraints();

        userLabel = new JLabel();
        userLabel.setText("Username");
        userField = new JTextField(20);

        pwLabel = new JLabel();
        pwLabel.setText("Password");
        pwField = new JTextField(20);

        submitPanel = new JPanel(new FlowLayout());
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        submitPanel.add(new JLabel(""));
        submitPanel.add(submitButton);
        submitPanel.add(new JLabel(""));

        // setting layout
        GridBagLayout loginLayout = new GridBagLayout();
        loginLayout.columnWidths = new int[] {100, 100, 100};
        loginLayout.rowHeights = new int[] {40, 40, 40};

        panel = new JPanel(loginLayout);
        setConstraints(0, 0, 1, 1);
        panel.add(userLabel, constraints);

        setConstraints(0, 1, 1, 2);
        panel.add(userField, constraints);

        setConstraints(1, 0, 1, 1);
        panel.add(pwLabel, constraints);

        setConstraints(1, 1, 1, 2);
        panel.add(pwField, constraints);

        setConstraints(2, 1, 1, 1);
        panel.add(submitPanel, constraints);

        add(panel, BorderLayout.CENTER);

        setTitle("gui.Login");
        //setPreferredSize(new Dimension(400, 120));
        setMinimumSize(new Dimension(400, 150));
        setMaximumSize(new Dimension(400, 150));
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String username = userField.getText();
        String password = pwField.getText();
        JButton b;
        if (authenticator.authenticate(username, password)) {
            b = new JButton("true");
        } else {
            b = new JButton("false");
        }

        JFrame frame = new JFrame("Demo program for JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setSize(10, 10);

        frame.add(b);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setConstraints(int row, int col, int rowspan, int colspan) {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridy = row;
        constraints.gridx = col;
        constraints.gridheight = rowspan;
        constraints.gridwidth = colspan;
    }
}

class Authenticator {
    Boolean loggedIn = false;
    String username;
    String password;
    String fileLoc;

    Authenticator(String loc) {
        fileLoc = loc;
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

public class Login {
    public static void main(String[] args) {
        Authenticator authenticator = new Authenticator("pw.txt");
        LoginWindow loginWindow = new LoginWindow(authenticator);
        loginWindow.setVisible(true);
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
