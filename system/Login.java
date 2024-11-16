package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener    
{
    JTextField tusername;
    JPasswordField tpassword;
    JCheckBox showPassword;

    Login()
    {
        ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("icons/front8.jpg"));
        Image m2=m1.getImage().getScaledInstance(650,650,Image.SCALE_DEFAULT);
        ImageIcon m3=new ImageIcon(m2);
        JLabel image1=new JLabel(m3);
        image1.setBounds(0,0,650,650);
        add(image1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel username=new JLabel("USERNAME");
        username.setBounds(40,20,100,30);
        username.setForeground(Color.BLACK);
        image1.add(username);
        
        tusername=new JTextField();
        tusername.setBounds(150,20,150,30);
        image1.add(tusername);
        
        tpassword=new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        image1.add(tpassword);
        
        JLabel password=new JLabel("PASSWORD");
        password.setBounds(40,70,100,30);
        password.setForeground(Color.BLACK);
        image1.add(password);
        
        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(150, 110, 150, 30);
        showPassword.setOpaque(false);
        showPassword.addActionListener(this);
        showPassword.setFocusable(false);
        image1.add(showPassword);
        
        JButton login =new JButton("LOGIN");
        login.setFont(new Font("Arial",Font.PLAIN,15));
        login.setBounds(150,160,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFocusable(false);
        image1.add(login);
        

        
        setSize(400,300);
        setLocation(550,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
  
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == showPassword)
        {
         if (showPassword.isSelected()) 
            {
                tpassword.setEchoChar((char) 0); 
            } else 
            {
                tpassword.setEchoChar('*'); 
            }
        }
        else
        {
        try
        {
           String username=tusername.getText();
           String password=tpassword.getText();
           Conn c=new Conn();
           String query="select * from login where username= '"+username+"' and password= '"+password+"'";
           
           ResultSet rs=c.s.executeQuery(query);
           if(rs.next())
           {
               setVisible(false);
               new Home();
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Invalid username or password");
               setVisible(false);
               new First();
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
}
