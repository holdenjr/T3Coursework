import twooter.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
/**
*@author Jack Holden - 34725091
*@version 1.0
 * Represents the GUI of the application Twooter.
 **/
public class TwooterUI extends JFrame implements ActionListener
{
    /**
     * This is the TwooterUI class.
     **/

         /**
         * Declares the different aspects of the UI. 
         **/
    JLabel titleLabel, usrLabel, pswLabel;
    JTextField usrTextInput;
    JButton loginButton, registerButton;
    JPasswordField passwordInput;
    String password;
    String username;
    String[] usrArray; 
    
    TwooterClient client = new TwooterClient();

    public TwooterUI()
    {
         /**
         * Creates a new JFrame for the UI, and a 
         * new JPanel.
         **/
        JFrame frame = new JFrame("Twooter Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Welcome to Twooter.");
        titleLabel.setForeground(Color.blue);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
 
         /**
         * Assigns the areas of the UI with different parameters.
         **/
        usrLabel = new JLabel("Username");
        pswLabel = new JLabel("Password");
        usrTextInput = new JTextField(username);
        passwordInput = new JPasswordField(password);
        loginButton = new JButton("Login");
        registerButton = new JButton("Sign Up");
 
         /**
         * Assigns the dimensions and positions.
         **/
        titleLabel.setBounds(100, 30, 400, 30);
        usrLabel.setBounds(80, 70, 200, 30);
        pswLabel.setBounds(80, 110, 200, 30);
        usrTextInput.setBounds(300, 70, 200, 30);
        passwordInput.setBounds(300, 110, 200, 30);
        loginButton.setBounds(150, 160, 100, 30);
        registerButton.setBounds(320, 160, 100, 30);
 
          /**
         * Adds the different aspects of the UI to the frame.
         **/
        frame.add(titleLabel);
        frame.add(usrLabel);
        frame.add(usrTextInput);
        frame.add(pswLabel);
        frame.add(passwordInput);
        frame.add(loginButton);
        frame.add(registerButton);
 
     
         /**
         * Sets the size of the frame
         **/
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setVisible(true);

        loginButton.addActionListener(this);
    }


         /**
         * Declares the actionlistener.
         **/
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String usrInput = usrTextInput.getText();
        BufferedWriter bfWrite = null;
        
         /**
         * Implements a try/catch in order to print the text of the login to a text document.
         **/
        try(PrintWriter output = new PrintWriter("users.txt"))
        {
            bfWrite = new BufferedWriter(new FileWriter("users.txt"));
            String genToken = client.registerName(usrInput);
            bfWrite.write(usrInput);
            bfWrite.write(genToken);
        }
         /**
         * This catches any errors that can appear, such as an empty field.
         **/
        catch(IOException a){}
        finally
        {
            try
            {
                if (bfWrite != null)
                bfWrite.close();
            }
            catch (IOException z){}
        }
    }

         /**
         * This constructs the user interface.
         **/
    public static void main(String[] args)
    {
        TwooterUI ui = new TwooterUI();
    }
}