package Servlets;
import java.io.*;
import Bean.UserBean;
import DAO.RegesterDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/register")
public class RegesterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserBean ub = new UserBean();
        ub.setfName(req.getParameter("firstname"));
        ub.setlName(req.getParameter("lastname"));
        ub.setEmail(req.getParameter("email"));
        ub.setPassword(req.getParameter("password"));
        int check = new RegesterDAO().insert(ub);
        if (check == 1) {
            RequestDispatcher rd = req.getRequestDispatcher("signup.html");
            rd.include(req, res);
        } else {
            PrintWriter out = res.getWriter();
            out.println("<html><body><h3 style=\"color:red;\">Registration failed. Please try again!</h3></body></html>");
            RequestDispatcher rd = req.getRequestDispatcher("signup.html");
            rd.include(req, res);
        }
    }
}
