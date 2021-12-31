package employee_management_system;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener{
    JTextField t;
    JLabel l1,l2;
    JButton b1,b2;
    
    View_Employee(){
        super("View");
        getContentPane().setBackground(Color.green);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400,50,500,270);
        
        l1 = new JLabel();
        l1.setBounds(0,0,500,270);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon("src/icons/view.jpg");
        l1.setIcon(img);
        add(l1);
        
        l2 = new JLabel("Employee Id");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(Color.WHITE);
        Font f1 = new Font("serif",Font.BOLD,30);
        l2.setFont(f1);
        l1.add(l2);
        
        t = new JTextField();
        t.setBounds(240,60,220,30);
        l1.add(t);
        
        b1 = new JButton("Search");
        b1.setBounds(240,150,100,30);
        l1.add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        l1.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource()==b2){
            setVisible(false);
            new details().setVisible(true);
        }
        if(ae.getSource()==b1){
        conn con;
        ResultSet rs;
            
        try{
            con = new conn();
            String str = "select * from employee where emp_id='"+t.getText()+"';";
            rs = con.s.executeQuery(str);
            if(rs.next()){
                setVisible(false);
                Print_Data p = new Print_Data(t.getText());
            }else{
                JOptionPane.showMessageDialog(null,"Invalid ID");
            }
         }catch(Exception ee){
            JOptionPane.showMessageDialog(null,ee);
        }
        }
    }
    
    public static void main(String args[]){
        new View_Employee().setVisible(true);
    }
}
