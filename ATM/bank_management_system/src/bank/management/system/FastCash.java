package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton twenty, forty, sixity, eighty, hundred, onetwenty, back;
    String pinnumber;

    FastCash(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
         setTitle("Welcome to our ATM");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Options");
        text.setBounds(230, 320, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        twenty = new JButton("$20");
        twenty.setBounds(170, 450, 150, 30);
        twenty.addActionListener(this);
        image.add(twenty);
        
        forty = new JButton("$40");
        forty.setBounds(355, 450, 150, 30);
        forty.addActionListener(this);
        image.add(forty);
        
        sixity = new JButton("$60");
        sixity.setBounds(170, 485, 150, 30);
        sixity.addActionListener(this);
        image.add(sixity);
        
        eighty = new JButton("$80");
        eighty.setBounds(355, 485, 150, 30);
        eighty.addActionListener(this);
        image.add(eighty);
        
        hundred = new JButton("$100");
        hundred.setBounds(170, 520, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);
        
        onetwenty = new JButton("$120");
        onetwenty.setBounds(355, 520, 150, 30);
        onetwenty.addActionListener(this);
        image.add(onetwenty);
        
        back = new JButton("Back");
        back.setBounds(355, 560, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(1);
            Conn c = new Conn();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                   if (rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                       
                   } else{
                       balance -= Integer.parseInt(rs.getString("amount"));
                       
                   }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "$" +amount+ " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                
            }catch(Exception e){
             System.out.println(e);
            }
            
        }
    }
    
    public static void main(String args[]) {
       new FastCash(""); 
    }
}
