package gui;

import infrastructure.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class handles the login ui creation and event handling.
 * @author Jiangqi
 */
public class LoginWindow extends JFrame implements ActionListener {
    private JButton submitButton;
    private JPanel panel, submitPanel;
    private JLabel userLabel, pwLabel;
    private JTextField userField, pwField;
    private Authenticator authenticator;
    private GridBagConstraints constraints;
    private boolean loggedIn = false;

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

    /**
     * This class handles taking in the username and password text
     * and determining whether to login or quit.
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        String username = userField.getText();
        String password = pwField.getText();

        loggedIn = authenticator.authenticate(username, password);
        if (!loggedIn)
            JOptionPane.showMessageDialog(this, "Wrong username or password");
        this.dispose();
    }

    /**
     * Adjusts the constraints on the UI
     * @param row
     * @param col
     * @param rowspan
     * @param colspan
     */
    private void setConstraints(int row, int col, int rowspan, int colspan) {
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridy = row;
        constraints.gridx = col;
        constraints.gridheight = rowspan;
        constraints.gridwidth = colspan;
    }
}
