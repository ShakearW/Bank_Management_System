package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JTextField socialTextField, idTextField;
    JRadioButton savings, checking, hys, cd;
    JButton submit,cancel;
    String formno;
    JCheckBox atm, mobile, cheque, internet, emailalert, estate, terms;

    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(180, 40, 100, 100);
        add(label);
        
        //
        JLabel form = new JLabel("Form No.:" + formno);
        form.setFont(new Font("Raleway",Font.BOLD, 14));
        form.setBounds(700, 40, 600, 40);
        add(form);
        
        //
        JLabel finalDetails = new JLabel("Page 3 : Finalizing Account");
        finalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        finalDetails.setBounds(290, 80, 400, 30);
        add(finalDetails);
        
        JLabel account = new JLabel("Account Type:");
        account.setFont(new Font("Raleway",Font.BOLD, 22));
        account.setBounds(100, 160, 200, 30);
        add(account);
        
        checking = new JRadioButton("Checking");
        checking.setBounds(100, 200, 200, 30);
        checking.setFont(new Font("Raleway",Font.BOLD, 20));
        checking.setBackground(Color.WHITE);
        add(checking);
        
        savings = new JRadioButton("Savings");
        savings.setBounds(100, 260, 100, 30);
        savings.setFont(new Font("Raleway",Font.BOLD, 20));
        savings.setBackground(Color.WHITE);
        add(savings);
        
        hys = new JRadioButton("High Yield Savings");
        hys.setBounds(400, 200, 250, 30);
        hys.setFont(new Font("Raleway",Font.BOLD, 20));
        hys.setBackground(Color.WHITE);
        add(hys);
        
        cd = new JRadioButton("Cerifate Deposit");
        cd.setBounds(400, 260, 250, 30);
        cd.setFont(new Font("Raleway",Font.BOLD, 20));
        cd.setBackground(Color.WHITE);
        add(cd);
        
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(checking);
        accountgroup.add(savings);
        accountgroup.add(hys);
        accountgroup.add(cd);
        
        //
        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway",Font.BOLD, 20));
        cardno.setBounds(100, 330, 300, 30);
        add(cardno);
        
        JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-5783");
        cnumber.setFont(new Font("Raleway",Font.BOLD, 20));
        cnumber.setBounds(400, 330, 300, 30);
        add(cnumber);
        
        JLabel carddesc = new JLabel("(Your 16-digit Card Number)");
        carddesc.setFont(new Font("Raleway",Font.BOLD, 12));
        carddesc.setBounds(100, 350, 300, 30);
        add(carddesc);
        
        JLabel numdesc = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        numdesc.setFont(new Font("Raleway",Font.BOLD, 12));
        numdesc.setBounds(400, 350, 400, 30);
        add(numdesc);
        
        //
        JLabel pinno = new JLabel("PIN:");
        pinno.setFont(new Font("Raleway",Font.BOLD, 20));
        pinno.setBounds(100, 390, 300, 30);
        add(pinno);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD, 20));
        pnumber.setBounds(400, 390, 300, 30);
        add(pnumber);
        
        JLabel pindesc = new JLabel("(4-digit password)");
        pindesc.setFont(new Font("Raleway",Font.BOLD, 12));
        pindesc.setBounds(100, 410, 300, 30);
        add(pindesc);
        
       
        //
        JLabel service = new JLabel("Service Required:");
        service.setFont(new Font("Raleway",Font.BOLD, 20));
        service.setBounds(100, 460, 300, 30);
        add(service);
        
        atm = new JCheckBox("ATM Card");
        atm.setBounds(100, 500, 200, 30);
        atm.setBackground(Color.WHITE);
        atm.setFont(new Font("Raleway",Font.BOLD, 20));
        add(atm);
        
        mobile = new JCheckBox("Mobile Banking");
        mobile.setBounds(100, 540, 200, 30);
        mobile.setBackground(Color.WHITE);
        mobile.setFont(new Font("Raleway",Font.BOLD, 20));
        add(mobile);
        
        cheque = new JCheckBox("Cheque Book");
        cheque.setBounds(100, 580, 200, 30);
        cheque.setBackground(Color.WHITE);
        cheque.setFont(new Font("Raleway",Font.BOLD, 20));
        add(cheque);
        
        internet = new JCheckBox("Internet Banking");
        internet.setBounds(400, 500, 200, 30);
        internet.setBackground(Color.WHITE);
        internet.setFont(new Font("Raleway",Font.BOLD, 20));
        add(internet);
        
        emailalert = new JCheckBox("Email Alert");
        emailalert.setBounds(400, 540, 200, 30);
        emailalert.setBackground(Color.WHITE);
        emailalert.setFont(new Font("Raleway",Font.BOLD, 20));
        add(emailalert);
        
        estate = new JCheckBox("E-Statement");
        estate.setBounds(400, 580, 200, 30);
        estate.setBackground(Color.WHITE);
        estate.setFont(new Font("Raleway",Font.BOLD, 20));
        add(estate);
        
        terms = new JCheckBox("I heareby declares that the above entered details correct to the best of my knowledge.");
        terms.setBounds(120, 640, 500, 30);
        terms.setBackground(Color.WHITE);
        terms.setFont(new Font("Raleway",Font.BOLD, 10));
        add(terms);
        
        
        
        
        
       
        
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD, 14));
        submit.setBounds(220, 680, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD, 14));
        cancel.setBounds(400, 680, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String account = "";
            if (savings.isSelected()){
                account = "Saving Account";
            }else if (checking.isSelected()){
                account = "Checking";
            }else if (hys.isSelected()){
                account = "High Yeild Savings";
            }else if (cd.isSelected()){
                account = "Certifate Deposit";
            }
            
            Random random = new Random();
            String cnumber = "" + Math.abs((random.nextLong() % 900000000000L)) + 5783L;
            String pnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String services = "";
            if(atm.isSelected()){
                services = services + "ATM Card";
            } else if(mobile.isSelected()){
                services = services + "Mobile Banking";
            } else if(internet.isSelected()){
                services = services + "Internet Banking";
            } else if(cheque.isSelected()){
                services = services + "Cheque Book";
            } else if(emailalert.isSelected()){
                services = services + "Email Alert";
            } else if(estate.isSelected()){
                services = services + "E-Statement";
            } 
            
            String term = "";
            
            if(terms.isSelected()){
                term = "Selected";
            }
            
            try {
                if(account.equals("")){
                JOptionPane.showMessageDialog(null, "Account Type Required !!");
                }else if(term.equals("")){
                JOptionPane.showMessageDialog(null, "Terms & Conditions Required !!");
                }else{
    
                    Conn c = new Conn();
                    String query = "insert into signupthree values ('"+formno+"', '"+account+"', '"+cnumber+"', '"+pnumber+"', '"+services+"')";
                    String query2 = "insert into login values ('"+formno+"', '"+cnumber+"', '"+pnumber+"')"; 
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cnumber + "\n Pin: " +pnumber);
                    //Home switchS
                    setVisible(false);
                    new Deposit(pnumber).setVisible(true);
                }
                
            
            }catch (Exception e){
                System.out.println(e);
            }
                
            
        }else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
            
    }
    public static void main(String args[]){
        new SignupThree("");
    }        
}

