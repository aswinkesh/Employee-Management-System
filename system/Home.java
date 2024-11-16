package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener
{
    JButton view,add,remove;
    Home()
    {
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front8.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading =new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(370,140,400,40);
        heading.setFont(new Font("Arial",Font.BOLD,20));
        image.add(heading);
        
        add=new JButton("Add Employee");
        add.setBounds(350,200,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add.setFocusable(false);
        image.add(add);

        view=new JButton("View Employees");
        view.setBounds(600,200,150,40);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        view.setFocusable(false);
        image.add(view);
 
        remove=new JButton("Remove Employee");
        remove.setBounds(475,260,150,40);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        remove.setFocusable(false);
        image.add(remove);

         
        setSize(1120,630);
        setLocation(250,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource() == view)
        {
            setVisible(false);
            new ViewEmployee();
        }
        else
        {
            setVisible(false);
            new RemoveEmployee();
        }
    }
 
    public static void main(String[] args) 
    {
        new Home();
 
    } 
}