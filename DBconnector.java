import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBconnector {
    static Connection connect;

    public static Connection createC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/rasib";
            String username = "root";
            String pass = "rasib";


            connect=DriverManager.getConnection(url,username,pass);


        } catch (Exception e) {
            System.out.println(e);
        }
        return connect;
    }
}



