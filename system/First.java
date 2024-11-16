package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class First extends JFrame implements ActionListener
{
    First()
    {
        setLayout(null);
        JLabel heading=new JLabel("EMPLOYEE");
        heading.setBounds(140,35,1200,60);
        heading.setFont(new Font("ROG Fonts",Font.PLAIN,60));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel heading1=new JLabel("MANAGEMENT");
        heading1.setBounds(80,125,1200,60);
        heading1.setFont(new Font("ROG Fonts",Font.PLAIN,60));
        heading1.setForeground(Color.BLACK);
        add(heading1);
        
        JLabel heading2=new JLabel("SYSTEM");
        heading2.setBounds(170,225,1200,60);
        heading2.setFont(new Font("ROG Fonts",Font.PLAIN,60));
        heading2.setForeground(Color.BLACK);
        add(heading2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front8.jpg"));
        Image i2=i1.getImage().getScaledInstance(670,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,670,650);
        add(image);
        
        JButton clickhere =new JButton("CLICK HERE TO CONTINUE");
        clickhere.setFont(new Font("Arial",Font.PLAIN,15));
        clickhere.setBounds(170,400,300,70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        clickhere.setFocusable(false);
        image.add(clickhere);
        
        setSize(670,650);
        setLocation(400,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String[] args)
    {
        new First();
    }
}
