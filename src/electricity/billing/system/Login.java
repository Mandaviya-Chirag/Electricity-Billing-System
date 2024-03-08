package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField userText, passText;
    Choice loginChoice;

    JButton loginButton, cancelButton, signupButton;

    Login() {
        super("Login");
        getContentPane().setBackground(Color.lightGray);

        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTwo = profileOne.getImage().getScaledInstance(310, 310, Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTwo);

        JLabel profileLabel = new JLabel(fprofileOne);
        profileLabel.setBounds(5, 7, 250, 250);
        add(profileLabel);


        JLabel username = new JLabel("Username");
        username.setBounds(300, 60, 100, 20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400, 60, 150, 20);
        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300, 100, 100, 20);
        add(password);

        passText = new JTextField();
        passText.setBounds(400, 100, 150, 20);
        add(passText);

        JLabel loggin = new JLabel("Loggin In AS");
        loggin.setBounds(300, 140, 100, 20);
        add(loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400, 140, 150, 20);
        add(loginChoice);

        loginButton = new JButton("Login");
        loginButton.setBounds(315, 192, 100, 20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(440, 192, 100, 20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(375, 230, 100, 20);
        signupButton.addActionListener(this);
        add(signupButton);


        setSize(640, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginButton)) {

            try {
                Connection c = new Connection();
                String user = userText.getText();
                String pass = passText.getText();

                String q = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Splash();
                } else {
                    JOptionPane.showConfirmDialog(null, "invalid");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource().equals(cancelButton)) {
            setVisible(false);
        } else if (e.getSource().equals(signupButton)) {
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
