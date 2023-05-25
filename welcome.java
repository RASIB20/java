import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome extends JFrame {
    static int count = 0;// counter for sign in.
    JLabel label = new JLabel();// label for warning if no sign in.
    JButton login = new JButton("SIGN IN");
    JLabel label1 = new JLabel("Welcome To Flight");
    JLabel label2 = new JLabel("Reservation System");
    JButton signup = new JButton("SIGN UP");

    ImageIcon i=new ImageIcon("D:\\test\\PROJECT\\src\\image3.jpg");//background icon.

    JLabel image= new JLabel(i);
    welcome() {
        setTitle("Flight Reservation System");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(label1);    //ADDING THE COMPONENTS
        add(label2);
        add(login);
        add(signup);
        add(label);
        add(image);

        //SETTING BOUNDS OF THE COMPONENTS.
        image.setBounds(0,-40,550,400);
        login.addActionListener(new Listen());
        signup.addActionListener(new Listen());
        label.setBounds(220, 280, 100, 20);
        label.setForeground(Color.red);

        //SETTING FONT AND COLOR.
        label1.setFont(new Font("Dialogue",Font.BOLD,24));
        label2.setFont(new Font("Dialogue",Font.BOLD,24));
        label1.setForeground(Color.green);
        label2.setForeground(Color.GREEN);
        label1.setBounds(170, 20, 220, 40);
        label2.setBounds(166, 50, 240, 40);
        login.setBounds(220, 180, 80, 40);
        signup.setBounds(220, 230, 80, 40);

        login.setBackground(Color.blue);
        signup.setBackground(Color.blue);

        login.setForeground(Color.white);
        signup.setForeground(Color.white);

        setVisible(true);
    }

    //ACTION LISTENERS FOR THE BUTTONS.
    private class Listen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "SIGN IN") {
                if (count == 0) {
                    label.setText("Create Account First");
                } else if (count != 0) {
                    setVisible(false);
                    new signin();
                    System.gc();// it would destroy the object if not in use.
                }
            }

            if (e.getActionCommand() == "SIGN UP") {
                label.setText("");
                setVisible(false);
                new signup();
                System.gc(); // it would destroy the object if not in use.
            }
        }
    }

    public static void main(String[] args) {
        new welcome();
    }
}
