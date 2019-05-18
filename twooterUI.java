import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class twooterUI extends JFrame 
{
    JLabel label1, usrLabel, pswLabel;
    JTextField usrTextInput;
    JButton loginButton;
    JPasswordField passwordInput;

    public twooterUI()
    {
        JFrame frame = new JFrame("Twooter Login");
        label1 = new JLabel("Login Form");
        label1.setForeground(Color.blue);
        label1.setFont(new Font("Serif", Font.BOLD, 20));
 
        usrLabel = new JLabel("Username");
        pswLabel = new JLabel("Password");
        usrTextInput = new JTextField();
        passwordInput = new JPasswordField();
        loginButton = new JButton("Login");
 
        label1.setBounds(100, 30, 400, 30);
        usrLabel.setBounds(80, 70, 200, 30);
        pswLabel.setBounds(80, 110, 200, 30);
        usrTextInput.setBounds(300, 70, 200, 30);
        passwordInput.setBounds(300, 110, 200, 30);
        loginButton.setBounds(150, 160, 100, 30);
 
        frame.add(label1);
        frame.add(usrLabel);
        frame.add(usrTextInput);
        frame.add(pswLabel);
        frame.add(passwordInput);
        frame.add(loginButton);
 
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new twooterUI();
    }
}