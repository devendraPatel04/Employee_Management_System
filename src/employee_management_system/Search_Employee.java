package employee_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Search_Employee extends JFrame implements ActionListener{
    JTextField t;
    JLabel l,l5;
    JButton b,b2;

    Search_Employee(){
        super("search");
        getContentPane().setBackground(Color.green);
        setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon("src/icons/view.jpg");
        l5.setIcon(img);


        l=new JLabel("Employee Id");
        l.setVisible(true);
        l.setBounds(40,50,250,30);
        l.setForeground(Color.white);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1); 
        l5.add(l);
        add(l5);

        t=new JTextField();
        t.setBounds(240,50,220,30);
        l5.add(t);

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        l5.add(b);


        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        setSize(500,270);
        setLocation(450,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b){
            new Update_Employee(t.getText());
            setVisible(false);
        }

    }
    
    public static void main(String[]ar){
        new Search_Employee().setVisible(true);
    } 	
}

