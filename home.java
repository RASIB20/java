import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class home extends JFrame {
    JPanel table=new JPanel();
    JTable data= new JTable();

    ImageIcon i=new ImageIcon("D:\\test\\PROJECT\\src\\image3.jpg");
    JLabel label=new JLabel(i);
    JButton book= new JButton("BOOK");
    JButton update= new JButton("UPDATE");
    JButton cancel= new JButton("CANCEL");
    JButton logout= new JButton("LOG OUT");

    home(){
        setTitle("FLIGHT TICKET RESERVATION SYSTEM ->> HOME");
        setSize(550,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(book);
        add(update);
        add(cancel);
        add(logout);
        add(label);

        book.setBounds(210,80,115,40);
        update.setBounds(210,140,115,40);
        cancel.setBounds(210,200,115,40);
        logout.setBounds(210,260,115,40);
        label.setBounds(0,-40,550,400);

        book.setFont(new Font("Dialogue",Font.BOLD,14));
        update.setFont(new Font("Dialogue",Font.BOLD,14));
        cancel.setFont(new Font("Dialogue",Font.BOLD,14));
        logout.setFont(new Font("Dialogue",Font.BOLD,14));

        book.addActionListener(new listen());
        update.addActionListener(new listen());
        cancel.addActionListener(new listen());
        logout.addActionListener(new listen());

        book.setForeground(Color.WHITE);
        book.setBackground(Color.BLUE);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLUE);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLUE);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.BLUE);

        setVisible(true);

    }
    private class listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand()=="BOOK"){
                setVisible(false);
                new book();
                System.gc();
            } else if (e.getActionCommand()=="UPDATE") {
                setVisible(false);
                new update();
                System.gc();

            } else if (e.getActionCommand()=="CANCEL") {
                setVisible(false);
                new update_cancel();
                System.gc();
            } else if (e.getActionCommand()=="LOG OUT") {
                setVisible(false);
                new welcome();
                System.gc();
            }
        }
    }

    public static void main(String[] args) {
        new home();
    }
}
