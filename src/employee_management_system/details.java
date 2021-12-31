package employee_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class details extends JFrame implements ActionListener{
    JLabel l1,l2;
    JButton b1,b2,b3,b4;
    
    details(){
        super("Employee Details");
        setBounds(400,50,700,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        ImageIcon i1 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\Employee_Management_system\\src\\icons\\details.jpg");
        l1.setIcon(i1);
        add(l1);
        
        l2 = new JLabel("Employee Details");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        
        b1 = new JButton("Add");
        b1.setBounds(420,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        l1.add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("View");
        b2.setBounds(530,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        l1.add(b2);
        b2.addActionListener(this);
        
        b3=new JButton("Remove");
        b3.setBounds(420,140,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update");
        b4.setBounds(530,140,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);

        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            setVisible(false);
            new Add_Employee().setVisible(true);
        }
        if(ae.getSource()==b2){
            setVisible(false);
            new View_Employee().setVisible(true);
        }
        if(ae.getSource()==b3){
            setVisible(false);
            new Remove_Employee().setVisible(true);
        }
        if(ae.getSource()==b4){
            setVisible(false);
            new Search_Employee().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new details().setVisible(true);
    }
}
