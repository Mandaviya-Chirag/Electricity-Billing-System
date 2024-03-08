package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener {
    Choice loginAsCho;
    JTextField meterText,employerText,userNameText,nameText,passwordText;

    JButton create,back;
    Signup(){

        super("Signup");

        getContentPane().setBackground(new Color(168,230,255));

        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        loginAsCho = new Choice();
        loginAsCho.add("Admin");
        loginAsCho.add("Customer");
        loginAsCho.setBounds(170,50,125,20);
        add(loginAsCho);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,101,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new JTextField();
        meterText.setBounds(170,101,125,20);
        meterText.setVisible(false);
        add(meterText);

        JLabel Employer = new JLabel("Employer ID");
        Employer.setBounds(30,101,125,20);
        Employer.setVisible(true);
        add(Employer);

        employerText = new JTextField();
        employerText.setBounds(170,101,125,20);
        employerText.setVisible(true);
        add(employerText);

        JLabel userName = new JLabel("UserName");
        userName.setBounds(30,141,125,20);
        add(userName);

        userNameText = new JTextField();
        userNameText.setBounds(170,141,125,20);
        add(userNameText);

        JLabel name = new JLabel("Name");
        name.setBounds(30,181,125,20);
        add(name);

        nameText = new JTextField();
        nameText.setBounds(170,181,125,20);
        add(nameText);

        JLabel password = new JLabel("Password");
        password.setBounds(30,221,125,20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(170,221,125,20);
        add(passwordText);

        loginAsCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAsCho.getSelectedItem();
                if (user.equals("Customer")){
                    Employer.setVisible(false);
                    employerText.setVisible(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                }else{
                    Employer.setVisible(true);
                    employerText.setVisible(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });

        create = new JButton("Create");
        create.setBounds(50,275,100,25);
        create.setBackground(new Color(66, 127, 219));
        create.setForeground(Color.black);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBounds(170,275,100,25);
        back.setBackground(new Color(66, 127, 219));
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

        ImageIcon signupIcon = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image  signupImg = signupIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon signupImg2 = new ImageIcon(signupImg);
        JLabel signupLabel = new JLabel(signupImg2);
        signupLabel.setBounds(310,40,250,250);
        add(signupLabel);

        setSize(600,380);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create){
            
        } else if (e.getSource().equals(back)) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();

    }
}
