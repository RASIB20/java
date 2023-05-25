import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class infoInsertion {
    infoInsertion(){
        try
        {
            Connection con=DBconnector.createC();

            String query="INSERT INTO flightreservation(Name,Nationality,AirLine,Class,`No.Seats`,`Departure Date`,`Return Date`,Address) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(query);

            pstmt.setString(1, userInfoMODEL.name);
            pstmt.setString(2,userInfoMODEL.nationality);
            pstmt.setString(3,userInfoMODEL.airlines);
            pstmt.setString(4, userInfoMODEL.Class);
            pstmt.setString(5, String.valueOf(userInfoMODEL.no_seats));
            pstmt.setString(6,userInfoMODEL.departuredate);
            pstmt.setString(7,userInfoMODEL.returndate);
            pstmt.setString(8,userInfoMODEL.address);

            pstmt.executeUpdate();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
            System.out.println(e);
        }
    }
}
