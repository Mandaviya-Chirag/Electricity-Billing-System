package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/splash.gif"));
        Image imageOne = imageIcon.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageOne);

        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);

        getContentPane().setBackground(Color.black);
        setSize(600,400);
        setLocation(450,200);
        setVisible(true);

        try{
            Thread.sleep(5000);
            setVisible(false);

            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
      new Splash();
    }
}
