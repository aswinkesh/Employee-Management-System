package employee.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener
{
    Random ran=new Random();
    int number=ran.nextInt(999999);
    
    JTextField tfname,tffname,tfsalary,tfaddress,tfphone,tfaadhar,tfemail;
    JTextField tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempid;
    JButton add,back;
    AddEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/front8.jpg"));
        Image m2=m1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon m3=new ImageIcon(m2);
        JLabel image1=new JLabel(m3);
        image1.setBounds(0,0,900,700);
        add(image1);
        
        JLabel heading=new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("Arial",Font.BOLD,25));
        image1.add(heading);
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labelname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        image1.add(tfname);
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labelfname);
        
        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        image1.add(tffname);
        
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labeldob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        image1.add(dcdob);
        
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        image1.add(tfsalary);
        
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labeladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        image1.add(tfaddress);
        
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        image1.add(tfphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        image1.add(tfemail);
        
        JLabel labeleducation=new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labeleducation);
        
        String courses[]={"BTECH","BCA","MCA","B.COM","BBA","MBA","BA","MA","MTECH"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        image1.add(cbeducation);
        
        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        image1.add(tfdesignation);
        
        JLabel labelaadhar=new JLabel("Aadhar no");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labelaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        image1.add(tfaadhar);
        
        JLabel labelempid=new JLabel("Employee ID");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("Arial",Font.PLAIN,18));
        image1.add(labelempid);
        
        
        lblempid=new JLabel(""+number);
        lblempid.setBounds(200,400,150,30);
        lblempid.setFont(new Font("Arial",Font.PLAIN,20));
        image1.add(lblempid);
        
        add=new JButton("Add details");
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
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=(String) cbeducation.getSelectedItem(); 
            String designation=tfdesignation.getText();
            String aadhar=tfaadhar.getText();
            String empid=lblempid.getText();
            
            try
            {
                Conn conn=new Conn();
                String query= "insert into addemployee values('"+name+"', '"+fname+"' ,'"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
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
        new AddEmployee();
    }
    
}
