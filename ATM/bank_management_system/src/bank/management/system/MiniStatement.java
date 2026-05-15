package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class MiniStatement extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton back;
   

    MiniStatement(String pinnumber){
        
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
       
        JLabel bank = new JLabel("US Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(80, 80, 300, 20);
        add(card);
        
        JLabel bal = new JLabel();
        bal.setBounds(20, 400, 300, 20);
        add(bal);
        
        back = new JButton("Back");
        back.setBounds(20, 500, 100, 20);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX"+ rs.getString("cardnumber").substring(12));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c = new Conn();
            int balance = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$" + rs.getString("amount")+ "<br><br><html>");
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                       
                } else{
                   balance -= Integer.parseInt(rs.getString("amount"));       
                }
            }
            
            bal.setText("Your current account balance is : $"+balance);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
    }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
