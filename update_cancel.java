import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Vector;

public class update_cancel extends JFrame {
    Object [] s={"ID","Name","Nationality","Airline","Class","No.Seats","Departure Date","Return Date","Address"};
    JTable table= new JTable();
    DefaultTableModel Df=new DefaultTableModel();

    ImageIcon i=new ImageIcon("D:\\test\\PROJECT\\src\\image3.jpg");

    JButton delete=new JButton("DELETE");
    JButton back=new JButton("BACK");
    JLabel label=new JLabel(i);

    int row=0;

    update_cancel(){
        setTitle("FLIGHT TICKET RESERVATION SYSTEM ->> UPDATE/CANCEL");
        setSize(720,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Df.setColumnIdentifiers(s);
        table.setModel(Df);

        JScrollPane pane=new JScrollPane(table);

        buildtable();

        add(pane);
        add(delete);
        add(back);

        back.setBounds(230,230,80,20);
        delete.setBounds(370,230,80,20);
        pane.setBounds(0,10,700,200);

        back.addActionListener(new listen());
        delete.addActionListener(new listen());
        table.addMouseListener(new mouse());

        back.setForeground(Color.white);
        back.setBackground(Color.BLUE);
        delete.setForeground(Color.white);
        delete.setBackground(Color.BLUE);

        setVisible(true);
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

    private class listen implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==back){
                setVisible(false);
                new home();
                System.gc();
            } else if (e.getSource()==delete) {

                Connection con=DBconnector.createC();
                try {
                    PreparedStatement setter,getter;
                    String q="SELECT * FROM flightreservation";
                    getter=con.prepareStatement(q);
                    ResultSet rs=getter.executeQuery();

                    if (rs.next()){
                        int permission=JOptionPane.showConfirmDialog(null,"Do You Want To Delete","WARNING",JOptionPane.YES_NO_OPTION);
                        if (permission==JOptionPane.YES_OPTION){
                            String query="DELETE  FROM flightreservation WHERE ID=?";
                            setter = con.prepareStatement(query);
                            setter.setString(1,table.getValueAt(table.getSelectedRow(),0).toString());

                            setter.executeUpdate();
                            buildtable();
                        }
                        JOptionPane.showMessageDialog(null,"Deleted Successfully");
                    }
                    else
                        JOptionPane.showMessageDialog(null,"NO DATA");

                    con.close();


                }catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    private class mouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

            row=table.getSelectedRow();
        }

        @Override
        public void mouseExited(MouseEvent e) {


        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        new update_cancel();
    }
}