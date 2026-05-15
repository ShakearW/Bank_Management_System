package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

    JTextField socialTextField, idTextField;
    JRadioButton Vyes, Vno, Cyes, Cno;
    JButton next;
    String formno;
    JComboBox religionBox, raceBox, incomeBox, eduBox, occupationBox;

    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
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
        JLabel additionalDetails = new JLabel("Page 2 : Additional Info");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD, 20));
        religion.setBounds(100, 160, 100, 30);
        add(religion);
        
        
        String valReligion[] = {"Christianity", "Islam", "Hinduism", "Buddhism", "Judaism", "Other", "None"};
        religionBox = new JComboBox(valReligion);
        religionBox.setBounds(320, 160, 400, 30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);
        
       
         
        //
        JLabel race = new JLabel("Race:");
        race.setFont(new Font("Raleway",Font.BOLD, 20));
        race.setBounds(100, 210, 200, 30);
        add(race);
        
        String valRace[] = {"Black", "White", "Asian", "Hispanic", "Native American", "Pacific", "Other"};
        raceBox = new JComboBox(valRace);
        raceBox.setBounds(320, 210, 400, 30);
        raceBox.setBackground(Color.WHITE);
        add(raceBox);
        

       
        //
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD, 20));
        income.setBounds(100, 260, 150, 30);
        add(income);
        
        String valIncome[] = {"Under 35,000", "35,000 - 50,000", "50,000 - 75,000 ", "75,000 - 100,000", "Over 100,000", "Other"};
        incomeBox = new JComboBox(valIncome);
        incomeBox.setBounds(320, 260, 400, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
     
        
        //
        JLabel education = new JLabel("Education Level:");
        education.setFont(new Font("Raleway",Font.BOLD, 20));
        education.setBounds(100, 310, 250, 30);
        add(education);
        
        String valEdu[] = {"Non-Graduate", "H.S Graduate", "GED", "Undergraduate", "Graduate", "Other"};
        eduBox = new JComboBox(valEdu);
        eduBox.setBounds(320, 310, 400, 30);
        eduBox.setBackground(Color.WHITE);
        add(eduBox); 
        
        //
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD, 20));
        occupation.setBounds(100, 360, 300, 30);
        add(occupation);
        
        String valOcc[] = {"Salaried", "Self-Employmed", "Business", "Student", "Retired", "Other"};
        occupationBox = new JComboBox(valOcc);
        occupationBox.setBounds(320, 360, 400, 30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox); 
        
       
        //
        JLabel social = new JLabel("Social Security No.:");
        social.setFont(new Font("Raleway",Font.BOLD, 20));
        social.setBounds(100, 410, 300, 30);
        add(social);
        
        socialTextField = new JTextField();
        socialTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        socialTextField.setBounds(320, 410, 400, 30);
        add(socialTextField);
        
        //
        JLabel id = new JLabel("State ID No:");
        id.setFont(new Font("Raleway",Font.BOLD, 20));
        id.setBounds(100, 460, 300, 30);
        add(id);
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        idTextField.setBounds(320, 460, 400, 30);
        add(idTextField);

        //
        //
        JLabel veteran = new JLabel("Military Veteran:");
        veteran.setFont(new Font("Raleway",Font.BOLD, 20));
        veteran.setBounds(100, 510, 250, 30);
        add(veteran);
       
        Vyes = new JRadioButton("Yes");
        Vyes.setBounds(320, 510, 100, 30);
        Vyes.setBackground(Color.WHITE);
        add(Vyes);
        
        Vno = new JRadioButton("No");
        Vno.setBounds(470, 510, 100, 30);
        Vno.setBackground(Color.WHITE);
        add(Vno);
       
        
        ButtonGroup veterangroup = new ButtonGroup();
        veterangroup.add(Vyes);
        veterangroup.add(Vno);
        
        //
        //
        JLabel citizen = new JLabel("U.S Citizen:");
        citizen.setFont(new Font("Raleway",Font.BOLD, 20));
        citizen.setBounds(100, 560, 250, 30);
        add(citizen);
       
        Cyes = new JRadioButton("Yes");
        Cyes.setBounds(320, 560, 150, 30);
        Cyes.setBackground(Color.WHITE);
        add(Cyes);
        
        Cno = new JRadioButton("No");
        Cno.setBounds(470, 560, 150, 30);
        Cno.setBackground(Color.WHITE);
        add(Cno);
       
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(Cyes);
        citizengroup.add(Cno);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        String religion = (String) religionBox.getSelectedItem();
        String race = (String) raceBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String education = (String) eduBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();
        
        String social = socialTextField.getText();
        String id = idTextField.getText();
        
        String veteran = null;
        if(Vyes.isSelected()){
            veteran = "Yes";
        } else if (Vno.isSelected()){
            veteran = "No";
        }
        
        String citizen = null;
        if(Cyes.isSelected()){
            citizen = "Yes";
        } else if (Cno.isSelected()){
            citizen = "No";
        }
        
        try {
            
                Conn c = new Conn();
                String query = "insert into signuptwo values ('"+formno+"', '"+religion+"', '"+race+"', '"+income+"', '"+education+"', '"+occupation+"', '"+social+"', '"+id+"', '"+veteran+"', '"+citizen+"')"; 
                c.s.executeUpdate(query);
                
                //Sign3 switch
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }catch (Exception e){
            System.out.println(e);
        }
            
    }
    public static void main(String args[]){
        new SignupTwo("");
    }        
}
