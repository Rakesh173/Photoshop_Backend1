package DAO;
import java.sql.*;
import Bean.UserBean;
import Database.DBconnection;

public class LoginDAO {
    UserBean ub = null;
    public UserBean extract(String uname, String pass) {
        try {
            Connection con = DBconnection.getConnect();
            PreparedStatement ps = con.prepareStatement("select * from photoshop where lname = ? and password = ?");
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ub = new UserBean();
                ub.setfName(rs.getString("fname"));
                ub.setlName(rs.getString("lname"));
                ub.setEmail(rs.getString("email"));
                ub.setPassword(rs.getString("password"));
                return ub;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
