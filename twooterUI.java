import twooter.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;


public class TwooterUI extends JFrame implements ActionListener
{
    JLabel titleLabel, usrLabel, pswLabel;
    JTextField usrTextInput;
    JButton loginButton, registerButton;
    JPasswordField passwordInput;
    String password;
    String username;
    
    TwooterClient client = new TwooterClient();


    public TwooterUI()
    {
        JFrame frame = new JFrame("Twooter Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Welcome to Twooter.");
        titleLabel.setForeground(Color.blue);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
 
        usrLabel = new JLabel("Username");
        pswLabel = new JLabel("Password");
        usrTextInput = new JTextField(username);
        passwordInput = new JPasswordField(password);
        loginButton = new JButton("Login");
        registerButton = new JButton("Sign Up");
 
        titleLabel.setBounds(100, 30, 400, 30);
        usrLabel.setBounds(80, 70, 200, 30);
        pswLabel.setBounds(80, 110, 200, 30);
        usrTextInput.setBounds(300, 70, 200, 30);
        passwordInput.setBounds(300, 110, 200, 30);
        loginButton.setBounds(150, 160, 100, 30);
        registerButton.setBounds(320, 160, 100, 30);
 
        frame.add(titleLabel);
        frame.add(usrLabel);
        frame.add(usrTextInput);
        frame.add(pswLabel);
        frame.add(passwordInput);
        frame.add(loginButton);
        frame.add(registerButton);
 
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String usrInput = usrTextInput.getText();
        BufferedWriter bfWrite = null;
        try(PrintWriter output = new PrintWriter("users.txt"))
        {
            bfWrite = new BufferedWriter(new FileWriter("users.txt"));
            String genToken = client.registerName(usrInput);
            bfWrite.write(usrInput);
            bfWrite.write(genToken);
        }
        catch(IOException a){}
        finally
        {
            try{
                if (bfWrite != null)
                bfWrite.close();
            }
            catch (IOException z){}
        }
    }

    public static void main(String[] args)
    {
        TwooterUI ui = new TwooterUI();
    }
}