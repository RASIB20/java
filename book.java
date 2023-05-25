import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class book extends JFrame {
    ImageIcon i=new ImageIcon("D:\\test\\PROJECT\\src\\image3.jpg");
    JLabel label= new JLabel(i);
    String[] Airlines={"PIA","EMIRATE AIRLINES","AIR ASIA","ETIHAD AIRLINES","SHAHEEN AIRLINES"};
    String[] tickettype={"ONE WAY","TWO WAY"};
    String[] Class={"ECONOMY","EXECUTIVE","BUSINESS","FIRST CLASS"};

    JLabel airlines= new JLabel("AIRLINES");
    JLabel ticket= new JLabel("Ticket Type");
    JLabel class_type= new JLabel("CLASS");
    JLabel no_of_seats= new JLabel("No.Seats");
    JLabel departure_date= new JLabel("Departure Date");
    JLabel return_date= new JLabel("Return Date");

    JComboBox text1=new JComboBox(Airlines);
    JComboBox text2= new JComboBox(tickettype);
    JComboBox text3= new JComboBox(Class);
    JTextField text4= new JTextField(10);
    JTextField text5= new JTextField(10);
    JTextField text6= new JTextField(10);

    Icon b=new ImageIcon("D:\\test\\PROJECT\\src\\back.png");
    Icon n=new ImageIcon("D:\\test\\PROJECT\\src\\next.png");

    JButton back= new JButton(b);
    JButton next= new JButton(n);

    book(){
        setTitle("FLIGHT TICKET RESERVATION SYSTEM ->> BOOK");
        setSize(550,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(airlines);
        add(ticket);
        add(class_type);
        add(departure_date);
        add(no_of_seats);
        add(return_date);

        add(text1);
        add(text2);
        add(text3);
        add(text4);
        add(text5);
        add(text6);

        add(back);
        add(next);
        add(label);

        airlines.setFont(new Font("Dialogue",Font.BOLD,14));
        class_type.setFont(new Font("Dialogue",Font.BOLD,14));
        ticket.setFont(new Font("Dialogue",Font.BOLD,14));
        departure_date.setFont(new Font("Dialogue",Font.BOLD,14));
        no_of_seats.setFont(new Font("Dialogue",Font.BOLD,14));
        return_date.setFont(new Font("Dialogue",Font.BOLD,14));

        airlines.setBounds(50,20,115,30);
        class_type.setBounds(50,60,115,30);
        no_of_seats.setBounds(50,100,115,30);
        ticket.setBounds(280,20,110,30);
        departure_date.setBounds(280,55,115,30);
        return_date.setBounds(280,95,115,30);
        label.setBounds(0,-40,550,400);

        text1.setBounds(130,25,115,20);
        text3.setBounds(130,65,115,20);
        text5.setBounds(130,105,115,20);
        text2.setBounds(400,25,100,20);
        text4.setBounds(400,60,100,20);
        text6.setBounds(400,100,100,20);;

        back.setBounds(120,160,32,32);
        next.setBounds(320,160,32,32);


        text2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(text2.getSelectedIndex()==1)){
                    text6.setEditable(false);
                }
                if(text2.getSelectedIndex()==0)
                    text6.setEditable(true);
            }
        });

        back.addActionListener(new listen());
        next.addActionListener(new listen());

        ImageIcon i=new ImageIcon("C:\\Users\\~RASIB AFRIDI\\Desktop\\edited.jpg");
        JLabel l = new JLabel(i);
        l.setBounds(0,-40,797,504);
        add(l);

        setVisible(true);
    }
    private class listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==back){
                setVisible(false);
                new home();
                System.gc();
            } else if (e.getSource()==next) {
                userInfoMODEL.airlines=(String)text1.getSelectedItem();
                userInfoMODEL.Class=(String) text3.getSelectedItem();
                userInfoMODEL.no_seats= Integer.parseInt(text5.getText());
                userInfoMODEL.returndate=text6.getText();
                userInfoMODEL.departuredate=text4.getText();

                setVisible(false);
                new book1();
                System.gc();
            }
        }
    }

    public static void main(String[] args) {
        new book();
    }
}
