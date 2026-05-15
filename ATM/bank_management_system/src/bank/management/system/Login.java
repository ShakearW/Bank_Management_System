package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener{
    
    //Button Constructor
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setLayout(null);
        
        //Title
        setTitle("AUTOMATED TELLER MACHINE");
        
        //Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        //Header
        JLabel header = new JLabel("Welcome to ATM");
        header.setFont( new Font("Osward", Font.BOLD, 38));
        header.setBounds(220, 40, 400, 40);
        add(header);
        
        //Label + Input Fields
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont( new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 400, 40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 160, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 400, 40);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 230, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        //Buttons
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(450, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(350, 200);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource() == login){
            
            Conn c = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            
            try{
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card A Number or PIN");
                }
                
                
            }catch (Exception e){
                System.out.println();
            }
            
            
        }else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
    }
    
    public static void main(String args[]){
        new Login();
        
    }
}
