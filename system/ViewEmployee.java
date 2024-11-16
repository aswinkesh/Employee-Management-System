package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener
{
    JTable table;
    Choice cemployeeId;
    JButton search,print,update,back;
    
    ViewEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/front8.jpg"));
        Image m2=m1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon m3=new ImageIcon(m2);
        JLabel image1=new JLabel(m3);
        image1.setBounds(0,0,900,700);
        add(image1);
        
        JLabel searchlb1=new JLabel("Search by Employee ID");
        searchlb1.setBounds(20,20,150,20);
        searchlb1.setFont(new Font("Arial",Font.BOLD,12));
        image1.add(searchlb1);
        
        cemployeeId=new Choice();
        cemployeeId.setBounds(180,20,150,20);
        image1.add(cemployeeId);
        
          try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from addemployee");
           
           while(rs.next())
           {
               cemployeeId.add(rs.getString("empid"));
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        table=new JTable();
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from addemployee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        image1.add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setFocusable(false);
        search.addActionListener(this);
        image1.add(search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setFocusable(false);
        print.addActionListener(this);
        image1.add(print);
        
        update=new JButton("Update");
        update.setBounds(220,70,80,20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFocusable(false);
        update.addActionListener(this);
        image1.add(update);
        
        back=new JButton("Back");
        back.setBounds(320,70,80,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.addActionListener(this);
        image1.add(back);
        
        setSize(900,700);
        setLocation(300,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
            String query="select * from addemployee where empid = '"+cemployeeId.getSelectedItem()+"'";
            try
            {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print)
        {
            try
            {
                table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
               
        }
         else if(ae.getSource()==update)
        {
             setVisible(false);
             new UpdateEmployee(cemployeeId.getSelectedItem());
        }
         else
        {
            setVisible(false);
            new Home();
        }
        
    }
    
    public static void main(String[] args)
    {
        new ViewEmployee();
    }
    
}
