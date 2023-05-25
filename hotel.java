import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hotel extends JFrame {
    String[] p={"Cash","Debit Card","Online Payment"};
    JLabel hotelName= new JLabel("Hotel Name");
    JLabel adults= new JLabel("Adults");
    JLabel checkIn= new JLabel("check In");
    JLabel childern= new JLabel("Childern");
    JLabel checkOut= new JLabel("Check Out");
    JLabel no_days= new JLabel("No.Days");

    ImageIcon i=new ImageIcon("D:\\test\\PROJECT\\src\\image3.jpg");
    JLabel label=new JLabel(i);
    Icon b=new ImageIcon("D:\\test\\PROJECT\\src\\back.png");
    Icon n=new ImageIcon("D:\\test\\PROJECT\\src\\next.png");

    JButton back= new JButton(b);
    JButton next= new JButton(n);


    JTextField text1= new JTextField(10);
    JTextField text2=new JTextField(10);
    JTextField text3= new JTextField(10);
    JTextField text4= new JTextField(10);
    JTextField text5= new JTextField(10);
    JTextField text6= new JTextField(10);

    hotel(){
        setTitle("FLIGHT TICKET RESERVATION SYSTEM ->> HOTEL");
        setSize(550,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(hotelName);
        add(adults);
        add(checkIn);
        add(checkOut);
        add(childern);
        add(no_days);

        add(text1);
        add(text2);
        add(text3);
        add(text4);
        add(text5);
        add(text6);

        add(back);
        add(next);
        add(label);

        hotelName.setFont(new Font("Dialogue",Font.BOLD,14));
        checkIn.setFont(new Font("Dialogue",Font.BOLD,14));
        checkOut.setFont(new Font("Dialogue",Font.BOLD,14));
        adults.setFont(new Font("Dialogue",Font.BOLD,14));
        childern.setFont(new Font("Dialogue",Font.BOLD,14));
        no_days.setFont(new Font("Dialogue",Font.BOLD,14));

        hotelName.setBounds(50,20,115,30);
        checkIn.setBounds(50,60,115,30);
        checkOut.setBounds(50,100,115,30);
        adults.setBounds(300,20,110,30);
        childern.setBounds(300,55,115,30);
        no_days.setBounds(300,95,115,30);
        label.setBounds(0,-40,550,400);

        text1.setBounds(130,25,115,20);
        text3.setBounds(130,65,115,20);
        text5.setBounds(130,105,115,20);
        text2.setBounds(400,25,100,20);
        text4.setBounds(400,60,100,20);
        text6.setBounds(400,100,100,20);

        back.setBounds(150,160,32,32);
        next.setBounds(320,160,32,32);

        back.addActionListener(new listen());
        next.addActionListener(new listen());

        setVisible(true);
    }
    private class listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==back){
                setVisible(false);
                System.gc();
            }

            if (e.getSource()==next){
                JOptionPane.showMessageDialog(null,"Added Successfully.");
                setVisible(false);
                System.gc();
            }
        }
    }

    public static void main(String[] args) {
        new hotel();
    }
}
