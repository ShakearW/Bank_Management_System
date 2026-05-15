package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    JButton change, back;
    JTextField pin, repin;
    String pinnumber;
    
    
    PinChange(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 310, 300, 35);
        image.add(text);
        
        JLabel newpin = new JLabel("New PIN");
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("System", Font.BOLD, 16));
        newpin.setBounds(165, 350, 180, 25);
        image.add(newpin);
        
        pin = new JTextField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 350, 180, 25);
        image.add(pin);
        
        
        JLabel reenter = new JLabel("Re-Enter New PIN");
        reenter.setForeground(Color.WHITE);
        reenter.setFont(new Font("System", Font.BOLD, 16));
        reenter.setBounds(165, 390, 180, 25);
        image.add(reenter);
        
        repin = new JTextField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 390, 180, 25);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(165, 485, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = pin.getText();
            
                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match !!");
                    return;
                }
                
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "PIN is empty!!");
                    return;
                }
                
                Conn c = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            }catch (Exception e){
                
            System.out.println(e);
            }   
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
