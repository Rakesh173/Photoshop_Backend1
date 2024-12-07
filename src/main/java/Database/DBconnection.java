package Database;
import java.sql.*;

public class DBconnection {
    private DBconnection(){};
    private static Connection con;
    static {
        try{
            Class.forName(DBinfo.driver);
            con = DriverManager.getConnection(DBinfo.dbURL,DBinfo.dbUserName,DBinfo.dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnect(){
        return con;
    }
}
