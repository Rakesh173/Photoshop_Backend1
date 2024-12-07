package DAO;
import Bean.UserBean;
import Database.*;
import java.sql.*;


public class RegesterDAO {
    int check = 0;
    public int insert(UserBean ub){
        try{
            Connection con = DBconnection.getConnect();
            PreparedStatement ps = con.prepareStatement("INSERT INTO photoshop (fname, lname, email, password) VALUES (?, ?, ?, ?)");
            ps.setString(1, ub.getfName());
            ps.setString(2, ub.getlName());
            ps.setString(3,ub.getEmail());
            ps.setString(4,ub.getPassword());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
