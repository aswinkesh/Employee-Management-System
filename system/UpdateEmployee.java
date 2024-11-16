package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener
{
    
    JTextField tfeducation,tfname,tffname,tfsalary,tfaddress,tfphone,tfaadhar,tfemail;
    JTextField tfdesignation;
    JLabel lblempid;
    JButton add,back;
    String empid;
    
    UpdateEmployee(String empid)
    {
        this.empid=empid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/front8.jpg"));
        Image m2=m1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon m3=new ImageIcon(m2);
        JLabel image1=new JLabel(m3);
        image1.setBounds(0,0,900,700);
        add(image1);
        
        JLabel heading=new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("Arial",Font.BOLD,25));
        image1.add(heading);
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        image1.add(lblname);
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labelfname);
        
        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        image1.add(tffname);
        
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labeldob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        image1.add(lbldob);
        
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        image1.add(tfsalary);
        
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labeladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        image1.add(tfaddress);
        
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        image1.add(tfphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        image1.add(tfemail);
        
        JLabel labeleducation=new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labeleducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        image1.add(tfeducation);
        
        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        image1.add(tfdesignation);
        
        JLabel labelaadhar=new JLabel("Aadhar NO");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labelaadhar);
        
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        image1.add(lblaadhar);
        
        JLabel labelempid=new JLabel("Employee id");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(labelempid);
        
        
        lblempid=new JLabel();
        lblempid.setBounds(200,400,150,30);
        lblempid.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(lblempid);
        try
        {
            Conn c=new Conn();
            String query="select * from addemployee where empid = '"+empid+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempid.setText(rs.getString("empid"));
                tfdesignation.setText(rs.getString("designation"));
            }    
        }
        catch(Exception e)
        {
           e.printStackTrace(); 
        }
        add=new JButton("Update details");
        add.setBounds(230,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image1.add(add);
        
        back=new JButton("Back");
        back.setBounds(500,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        image1.add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {           
            String fname=tffname.getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=tfeducation.getText();
            String designation=tfdesignation.getText();
           
            try
            {
                Conn conn=new Conn();
                String query = "update addemployee set fname = '"+fname+"' , salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where empid = '"+empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated successfully");
                setVisible(false);
                new ViewEmployee();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new ViewEmployee();
        }
    }
    public static void main(String[] args)
    {
        new UpdateEmployee("");
    }
    
}

