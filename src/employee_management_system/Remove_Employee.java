package employee_management_system;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Remove_Employee extends JFrame implements ActionListener{
    JTextField t;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b,b1,b2,b3;
    
    Remove_Employee(){
        super("Remove Employee");
        getContentPane().setBackground(Color.green);
        setLayout(null);
        
        l5 = new JLabel();
        l5.setBounds(0,0,500,500);
        l5.setLayout(null);
        ImageIcon img = new ImageIcon("src/icons/remove.jpg");
        l5.setIcon(img);
        add(l5);
        
        l1 = new JLabel("Employee Id");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.white);
        Font f2 = new Font("serif",Font.BOLD,25);
        l1.setFont(f2);
        l5.add(l1);
        
        t=new JTextField();
        t.setBounds(250,50,150,30);
        l5.add(t);

        b=new JButton("Search");
        b.setBounds(200,100,100,30);
        b.addActionListener(this);
        l5.add(b);

        b3=new JButton("back");
        b3.setBounds(360,100,100,30);   
        b3.addActionListener(this);
        l5.add(b3);


        l2=new JLabel("Name:"); 
        l2.setBounds(50,150,250,30);
        l2.setForeground(Color.white);
        Font f3 = new Font("serif",Font.BOLD,20); 
        l2.setFont(f3);
        l5.add(l2);

        l6=new JLabel();    
        l6.setBounds(200,150,350,30);
        l6.setForeground(Color.white);
        Font F6=new Font("serif",Font.BOLD,20); 
        l6.setFont(F6);
        l5.add(l6);

        l3=new JLabel("Mobile No:");
        l3.setBounds(50,200,250,30);
        l3.setForeground(Color.white);
        Font f4 = new Font("serif",Font.BOLD,20); 
        l3.setFont(f4);
        l5.add(l3);

        l7=new JLabel();
        l7.setBounds(200,200,350,30);
        l7.setForeground(Color.white);
        Font F7=new Font("serif",Font.BOLD,20); 
        l7.setFont(F7);
        l5.add(l7);

        l4=new JLabel("Email Id:");
        l4.setBounds(50,250,250,30);
        l4.setForeground(Color.white);
        Font F5=new Font("serif",Font.BOLD,20); 
        l4.setFont(F5);
        l5.add(l4);

        l8=new JLabel();
        l8.setBounds(200,250,350,30);
        l8.setForeground(Color.white);
        Font f8=new Font("serif",Font.BOLD,20); 
        l8.setFont(f8);
        l5.add(l8);
        
        b1 = new JButton("Remove");
        b1.setBounds(120,300,100,30);
        b1.addActionListener(this);
        l5.add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(300,300,100,30);
        b2.addActionListener(this);
        l5.add(b2);
        
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);
        
        setBounds(430,30,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            try{
                conn con = new conn();
                String str="select name,phone,email from employee where emp_id='"+t.getText()+"';";
                ResultSet rs = con.s.executeQuery(str);
                
                int i=0;
                if(rs.next()){
                    String name = rs.getString(1);
                    String mob = rs.getString(2);
                    String email = rs.getString(3);
                    
                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    b1.setVisible(true);
                    b2.setVisible(true);
                    
                    i=1;
                    
                    l6.setText(name);
                    l7.setText(mob);
                    l8.setText(email);
                }
                if(i==0){
                    JOptionPane.showMessageDialog(null,"Id not availabel");
                }
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        if(ae.getSource()==b1){
            try{
                conn con = new conn();
                String str = "delete from employee where emp_id='"+t.getText()+"';";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Deleted Succcessfully");
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                b1.setVisible(false);
                b2.setVisible(false);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if(ae.getSource()==b2){
            setVisible(false);
            new details().setVisible(true);
        }
        if(ae.getSource()==b3){
            setVisible(false);
            new details().setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new Remove_Employee().setVisible(true);
    }
}
