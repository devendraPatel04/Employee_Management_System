package employee_management_system;

import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;
public class Front_Page extends JFrame {
    JLabel l1;
    JButton b;
    Front_Page(){
        super("Employee Management System");
        getRootPane().setBackground(Color.RED);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(0,0,1367,730);
        
        JLabel l3 = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        l3.setBounds(500,20,700,100);
        l3.setFont(new Font("sarif",Font.BOLD,20));
        l3.setForeground(Color.WHITE);
        add(l3);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\dev\\Documents\\NetBeansProjects\\Employee_Management_system\\src\\icons\\front.jpg");
        Image i2 = i1.getImage().getScaledInstance(1367,730,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        l1 = new JLabel(i3);
        l1.setBounds(0,0,1367,730);
        add(l1);
        
        b = new JButton("Continue");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(600,600,200,40);
        l1.add(b);
        
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
                new login().setVisible(true);
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        while(true){
            l3.setVisible(true);
            try{
                Thread.sleep(500); //1000 = 1sec
            }catch(Exception e){
               e.printStackTrace();
            }
            l3.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
    }
    
    public static void main(String args[]){
        new Front_Page().setVisible(true);
    }
}
