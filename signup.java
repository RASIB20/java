import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signup extends JFrame {
    JPanel panel= new JPanel();
    JPanel panel1=new JPanel();

    String [] countries={"Sri Lanka","Pakistan","India","US","China","Russia","Afghanistan","Canada","UK"};

    JLabel name= new JLabel("NAME");
    JLabel age= new JLabel("AGE");
    JLabel email= new JLabel("E-Mail");
    JLabel nationality= new JLabel("NATIONALITY");
    JLabel phone= new JLabel("PHONE NO.");
    JLabel password= new JLabel("PASSWORD");
    JLabel label=new JLabel();

    JButton back= new JButton("BACK");
    JButton create= new JButton("CREATE ACCOUNT");

    JTextField text1= new JTextField(10);
    JComboBox box=new JComboBox(countries);
    JTextField text3= new JTextField(10);
    JTextField text4 =new JTextField(10);
    JTextField text5= new JTextField(10);
    JTextField text6= new JTextField(10);

    signup(){
        setTitle("Flight Reservation System ->> SIGN UP");
        setSize(550,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel1build();
        panel2build();

        add(panel,BorderLayout.NORTH);
        add(panel1,BorderLayout.CENTER);
        add(label,BorderLayout.EAST);

        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLUE);
        create.setForeground(Color.WHITE);
        create.setBackground(Color.BLUE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new welcome();
                System.gc();
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new welcome();
                welcome.count+=1;
                System.gc();

            }
        });
        setVisible(true);
    }

    public void panel1build(){
        panel.setLayout(new GridLayout(3,4));
        panel.setSize(550,400);
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Sign Up"),BorderFactory.createRaisedBevelBorder()));

        panel.add(name);
        panel.add(text1);
        panel.add(nationality);
        panel.add(box);
        panel.add(age);
        panel.add(text3);
        panel.add(phone);
        panel.add(text4);
        panel.add(email);
        panel.add(text5);
        panel.add(password);
        panel.add(text6);

    }
    private void panel2build(){
        panel1.add(back);
        panel1.add(create);
    }

    public static void main(String[] args) {
        new signup();
    }
}
