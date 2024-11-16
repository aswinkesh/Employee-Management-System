package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener
{
    Choice cEmpId;
    JButton delete,back;
RemoveEmployee()
{
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/front8.jpg"));
    Image m2=m1.getImage().getScaledInstance(1000,400,Image.SCALE_DEFAULT);
    ImageIcon m3=new ImageIcon(m2);
    JLabel image1=new JLabel(m3);
    image1.setBounds(0,0,1000,400);
    add(image1);
    
    JLabel labelempid=new JLabel("Employee Id");
    labelempid.setBounds(50,50,100,30);
    image1.add(labelempid);

    cEmpId=new Choice();
    cEmpId.setBounds(200,50,150,30);
    image1.add(cEmpId);
 
    try
    {
        Conn c=new Conn();
        String query="select * from addemployee";
        ResultSet rs=c.s.executeQuery(query);
        while(rs.next())
        {
            cEmpId.add(rs.getString("empid"));
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    JLabel labelname=new JLabel("Name");
    labelname.setBounds(50,100,100,30);
    image1.add(labelname);
    
    JLabel lblname=new JLabel();
    lblname.setBounds(200,100,100,30);
    image1.add(lblname);
    
    JLabel labelphone=new JLabel("Phone");
    labelphone.setBounds(50,150,100,30);
    image1.add(labelphone);
    
    JLabel lblphone=new JLabel();
    lblphone.setBounds(200,150,100,30);
    image1.add(lblphone);
        
    JLabel labelemail=new JLabel("Email");
    labelemail.setBounds(50,200,100,30);
    image1.add(labelemail);

    JLabel lblemail=new JLabel();
    lblemail.setBounds(200,200,100,30);
    image1.add(lblemail);
 
    try
    {
        Conn c=new Conn();
        String query="select * from addemployee where empid = '"+cEmpId.getSelectedItem()+"'";
        ResultSet rs=c.s.executeQuery(query);
        while(rs.next())
        {
            cEmpId.add(rs.getString("empid"));
            lblname.setText(rs.getString("name"));
            lblphone.setText(rs.getString("phone"));
            lblemail.setText(rs.getString("email"));
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    cEmpId.addItemListener(new ItemListener()
    {
    public void itemStateChanged(ItemEvent ie)
    {
        try
        {
            Conn c=new Conn();
            String query="select * from addemployee where empid ='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
});

    delete=new JButton("Delete");
    delete.setBounds(80,300,100,30);
    delete.setBackground(Color.BLACK);
    delete.setForeground(Color.WHITE);
    delete.addActionListener(this);
    image1.add(delete);


    back=new JButton("back");
    back.setBounds(220,300,100,30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    image1.add(back); 
        
    setSize(400,400);
    setLocation(550,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getSource() ==delete)
    {
        try
        {
            Conn c=new Conn();
            String query="delete from addemployee where empid='"+cEmpId.getSelectedItem()+"'";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee Information Deleted Sucessfully");
            setVisible(false);
            new Home();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    else
    {
        setVisible(false);
        new Home();
    }
}
    public static void main(String[] args)
    {
        new RemoveEmployee();
    }
}
