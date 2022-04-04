package gui;

import infrastructure.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame implements ActionListener {
    JButton submitButton;
    JPanel panel, submitPanel;
    JLabel userLabel, pwLabel;
    JTextField userField, pwField;
    Authenticator authenticator;
    GridBagConstraints constraints;
    Boolean loggedIn = false;

    public LoginWindow(Authenticator auth) {
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
        loginLayout.columnWidths = new int[]{100, 100, 100};
        loginLayout.rowHeights = new int[]{40, 40, 40};

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

        loggedIn = authenticator.authenticate(username, password);

        if (!loggedIn) {
            JOptionPane.showMessageDialog(this, "Wrong username or password");
            this.dispose();
        }
        this.dispose();
    }

    private void setConstraints(int row, int col, int rowspan, int colspan) {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridy = row;
        constraints.gridx = col;
        constraints.gridheight = rowspan;
        constraints.gridwidth = colspan;
    }
}
