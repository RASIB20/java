import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class book1 extends JFrame {
    ImageIcon i=new ImageIcon("D:\\test\\PROJECT\\src\\image3.jpg");
    JLabel label=new JLabel(i);
    String[] p={"Cash","Debit Card","Online Payment"};
    JLabel name= new JLabel("Name");
    JLabel nationality=new JLabel("Nationality");
    JLabel payment= new JLabel("Payment");
    JLabel phone= new JLabel("Phone");
    JLabel hotel= new JLabel("Hotel");
    JLabel address= new JLabel("Address");
    JLabel hirecar= new JLabel("Hire Car");


    Icon b=new ImageIcon("D:\\test\\PROJECT\\src\\back.png");
    Icon n=new ImageIcon("D:\\test\\PROJECT\\src\\next.png");
    JButton back= new JButton(b);
    JButton next= new JButton(n);

    JTextField text1= new JTextField(10);
    JComboBox text2=new JComboBox(p);
    JTextField text3= new JTextField(10);
    JCheckBox text4= new JCheckBox("HOTEL");
    JTextField text5= new JTextField(10);
    JCheckBox text6= new JCheckBox("Hire Car");

    book1(){
        setTitle("FLIGHT TICKET RESERVATION SYSTEM ->> BOOK");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(name);
        add(payment);
        add(address);
        add(phone);
        add(hotel);
        add(hirecar);
        add(text1);
        add(text2);
        add(text3);
        add(text4);
        add(text5);
        add(text6);

        add(back);
        add(next);
        add(label);

        name.setFont(new Font("Dialogue",Font.BOLD,14));
        payment.setFont(new Font("Dialogue",Font.BOLD,14));
        phone.setFont(new Font("Dialogue",Font.BOLD,14));
        hotel.setFont(new Font("Dialogue",Font.BOLD,14));
        address.setFont(new Font("Dialogue",Font.BOLD,14));
        hirecar.setFont(new Font("Dialogue",Font.BOLD,14));

        name.setBounds(50,20,115,30);
        phone.setBounds(50,60,115,30);
        address.setBounds(50,100,115,30);
        payment.setBounds(300,20,110,30);
        hotel.setBounds(300,55,115,30);
        hirecar.setBounds(300,95,115,30);
        label.setBounds(0,-40,550,400);

        text1.setBounds(130,25,115,20);
        text3.setBounds(130,65,115,20);
        text5.setBounds(130,105,115,20);
        text2.setBounds(400,25,100,20);
        text4.setBounds(400,60,100,20);
        text6.setBounds(400,100,100,20);

        back.setBounds(100,160,32,32);
        next.setBounds(380,160,32,32);

        back.addActionListener(new listen());
        next.addActionListener(new listen());
        text4.addItemListener(new item());
        text6.addItemListener(new item());

        ImageIcon i=new ImageIcon("C:\\Users\\~RASIB AFRIDI\\Desktop\\editedd.jpg");
        JLabel l = new JLabel(i);
        l.setBounds(-90,-80,797,504);

        add(l);

        setVisible(true);
    }
    private class item implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (text4.isSelected()) {
                new hotel();
            }

            if (text6.isSelected()) {
                new hirecar();
            }
        }
    }

    private class listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==back){
                setVisible(false);
                new book();
                System.gc();
            }
            if (e.getSource()==next){
                JOptionPane.showMessageDialog(null,"Room Booked Successfully");

                userInfoMODEL.name= text1.getText();
                userInfoMODEL.address=text5.getText();

                setVisible(false);
                new infoInsertion();
                new home();
                System.gc();
            }
        }
    }

    public static void main(String[] args) {
        new book1();
    }
}
