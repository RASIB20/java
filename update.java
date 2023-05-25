import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class update extends JFrame {
    Object [] s={"ID","Name","Nationality","Airline","Class","No.Seats","Departure Date","Return Date","Address"};
    JTable table= new JTable();
    DefaultTableModel Df=new DefaultTableModel();
    ImageIcon i=new ImageIcon("D:\\test\\PROJECT\\src\\image3.jpg");
    JLabel label=new JLabel(i);

    JButton back=new JButton("BACK");
    JButton update=new JButton("UPDATE");

    JLabel name= new JLabel("Name");
    JLabel nationality=new JLabel("Nationality");
    JLabel airlines= new JLabel("AIRLINES");
    JLabel class_type= new JLabel("CLASS");
    JLabel no_of_seats= new JLabel("No.Seats");
    JLabel departure_date= new JLabel("Departure Date");
    JLabel return_date= new JLabel("Return Date");
    JLabel address= new JLabel("Address");


    JTextField Ntext=new JTextField(10);
    JTextField nationtext=new JTextField(10);
    JTextField Airtext=new JTextField(10);
    JTextField Ctext=new JTextField(10);
    JTextField n_seatText=new JTextField(10);
    JTextField Departext=new JTextField(10);
    JTextField Returntext=new JTextField(10);
    JTextField Addtext=new JTextField(10);



    update(){
        setTitle("FLIGHT TICKET RESERVATION SYSTEM ->> UPDATE/CANCEL");
        setSize(1000,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Df.setColumnIdentifiers(s);
        table.setModel(Df);
        JScrollPane pane=new JScrollPane(table);
        buildtable();

        add(pane);
        add(back);
        add(update);

        add(name);
        add(nationality);
        add(airlines);
        add(class_type);
        add(no_of_seats);
        add(departure_date);
        add(return_date);
        add(address);

        add(Ntext);
        add(nationtext);
        add(Airtext);
        add(Ctext);
        add(n_seatText);
        add(Departext);
        add(Returntext);
        add(Addtext);

        label.setBounds(0,-40,1000,400);

        name.setBounds(740,10,70,20);
        nationality.setBounds(740,40,70,20);
        airlines.setBounds(740,70,70,20);
        class_type.setBounds(740,100,70,20);
        no_of_seats.setBounds(740,130,70,20);
        departure_date.setBounds(740,160,70,20);
        return_date.setBounds(740,190,70,20);
        address.setBounds(740,220,70,20);

        Ntext.setBounds(830,10,70,20);
        nationtext.setBounds(830,40,70,20);
        Airtext.setBounds(830,70,70,20);
        Ctext.setBounds(830,100,70,20);
        n_seatText.setBounds(830,130,70,20);
        Departext.setBounds(830,160,70,20);
        Returntext.setBounds(830,190,70,20);
        Addtext.setBounds(830,220,70,20);



        pane.setBounds(0,10,700,200);
        back.setBounds(230,230,80,20);
        update.setBounds(370,230,80,20);

        back.addActionListener(new listen());
        update.addActionListener(new listen());

        back.setBackground(Color.BLUE);
        back.setForeground(Color.white);
        update.setBackground(Color.BLUE);
        update.setForeground(Color.white);


        setVisible(true);
    }
    private class listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==back){
                setVisible(false);
                new home();
                System.gc();
            }
            if (e.getSource()==update){
                String name,nationality,airlines,Class,no_seats,departure_date,return_date,address;

                name=Ntext.getText();
                nationality=nationtext.getText();
                airlines=Airtext.getText();
                Class=Ctext.getText();
                no_seats=n_seatText.getText();
                departure_date=Departext.getText();
                return_date=Returntext.getText();
                address=Addtext.getText();

                Connection con=DBconnector.createC();

                try {

                    String q="UPDATE flightreservation SET Name=? , Nationality=? , Airline=? , Class=? , `No.Seats`=? , `Departure Date`=? , `Return Date`=? , Address=? WHERE ID=?";

                    PreparedStatement pstmt=con.prepareStatement(q);

                    pstmt.setString(1,name);
                    pstmt.setString(2,nationality);
                    pstmt.setString(3,airlines);
                    pstmt.setString(4,Class);
                    pstmt.setString(5,no_seats);
                    pstmt.setString(6,departure_date);
                    pstmt.setString(7,return_date);
                    pstmt.setString(8,address);
                    pstmt.setString(9,table.getValueAt(table.getSelectedRow(),0).toString());

                    pstmt.executeUpdate();
                    buildtable();
                    con.close();
                    JOptionPane.showMessageDialog(null,"Successfully Updated");

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }

        }
    }
    private void buildtable() {
        int c=0;
        Connection con=DBconnector.createC();

        try {
            PreparedStatement pstmt=con.prepareStatement("SELECT * FROM flightreservation");

            ResultSet rs=pstmt.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            c=rss.getColumnCount();

            Df.setRowCount(0);

            DefaultTableModel Df=(DefaultTableModel) table.getModel();

            while (rs.next()){
                Vector v2=new Vector<>();
                for (int a=1;a<=c;a++){
                    v2.add(rs.getString("ID"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Nationality"));
                    v2.add(rs.getString("Airline"));
                    v2.add(rs.getString("Class"));
                    v2.add(rs.getString("No.Seats"));
                    v2.add(rs.getString("Departure Date"));
                    v2.add(rs.getString("Return Date"));
                    v2.add(rs.getString("Address"));
                }
                Df.addRow(v2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new update();

    }
}
