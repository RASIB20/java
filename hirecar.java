import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hirecar extends JFrame {
    ImageIcon i=new ImageIcon("D:\\test\\PROJECT\\src\\image3.jpg");
    JLabel label=new JLabel(i);
    String[] p={"Cash","Debit Card","Online Payment"};
    JLabel pick= new JLabel("Pick Up");
    JLabel dropOff= new JLabel("Drop Off");
    JLabel time= new JLabel("Time");
    JLabel time1= new JLabel("Time");

    Icon b=new ImageIcon("D:\\test\\PROJECT\\src\\back.png");
    Icon n=new ImageIcon("D:\\test\\PROJECT\\src\\next.png");
    JButton back= new JButton(b);
    JButton next= new JButton(n);

    JTextField text1= new JTextField(10);
    JTextField text2=new JTextField(10);
    JTextField text3= new JTextField(10);
    JTextField text4= new JTextField(10);

    hirecar(){
        setTitle("FLIGHT TICKET RESERVATION SYSTEM ->> HIRE CAR");
        setSize(550,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(pick);
        add(dropOff);
        add(time);
        add(time1);

        add(text1);
        add(text2);
        add(text3);
        add(text4);

        add(back);
        add(next);
        add(label);


        pick.setFont(new Font("Dialogue",Font.BOLD,14));
        dropOff.setFont(new Font("Dialogue",Font.BOLD,14));
        time.setFont(new Font("Dialogue",Font.BOLD,14));
        time1.setFont(new Font("Dialogue",Font.BOLD,14));
        back.setFont(new Font("Dialogue",Font.BOLD,14));
        next.setFont(new Font("Dialogue",Font.BOLD,14));

        pick.setBounds(50,20,115,30);
        dropOff.setBounds(50,60,115,30);
        time.setBounds(310,60,115,30);
        time1.setBounds(310,20,110,30);
        label.setBounds(0,-40,550,400);

        text1.setBounds(130,25,115,20);
        text3.setBounds(130,65,115,20);
        text2.setBounds(370,25,100,20);
        text4.setBounds(370,60,100,20);

        back.setBounds(130,130,32,32);
        next.setBounds(330,130,32,32);

        ImageIcon i=new ImageIcon("C:\\Users\\~RASIB AFRIDI\\Desktop\\edited.jpg");
        JLabel l = new JLabel(i);
        l.setBounds(0,-40,797,504);
        add(l);

        back.addActionListener(new listen());
        next.addActionListener(new listen());

        setVisible(true);

    }

    private class listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==back)
                setVisible(false);
                System.gc();

            if (e.getSource()==next) {
                JOptionPane.showMessageDialog(null,"Added Successfully.");
                setVisible(false);
                System.gc();
            }
        }
    }

    public static void main(String[] args) {
        new hirecar();
    }
}
