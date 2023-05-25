import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signin extends JFrame {
    JPanel panel11= new JPanel();
    JLabel username= new JLabel("USER NAME");
    JLabel pass=new JLabel("PASSWORD");
    JTextField text1= new JTextField(10);
    JTextField text2= new JTextField(10);

    JButton login= new JButton("SIGN IN");

    signin(){
        setTitle("FLIGHT TICKET RESERVATION SYSTEM ->> SIGN IN");
        setSize(550,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel11.setLayout(null);
        panel11.setBorder(BorderFactory.createTitledBorder("SIGN IN"));

        JPanel panel1= new JPanel();
        JPanel panel2= new JPanel();

        panel1.setLayout(new FlowLayout());
        panel1.add(username);
        panel1.add(text1);

        panel2.setLayout(new FlowLayout());
        panel2.add(pass);
        panel2.add(text2);

        panel1.setBounds(155,100,200,50);
        panel2.setBounds(155,140,200,50);
        login.setBounds(225,200,80,20);
        login.setBackground(Color.blue);
        login.setForeground(Color.WHITE);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand()=="SIGN IN"){
                    if (true) {
                        setVisible(false);
                        new home();
                        System.gc();
                    }
                }
            }
        });

        panel11.add(panel1);
        panel11.add(panel2);
        panel11.add(login);

        add(panel11);


        setVisible(true);
    }

    public static void main(String[] args) {
        new signin();
    }

}
