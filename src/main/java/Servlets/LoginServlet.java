package Servlets;
import java.io.*;
import DAO.LoginDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import Bean.UserBean;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        Boolean remember = req.getParameter("remember") != null;
        UserBean ub = new LoginDAO().extract(uname,pass);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        if (ub != null) {
            if(remember != null) {
                HttpSession hs = req.getSession();
                hs.setAttribute("ubean", ub);
            }
            resp.sendRedirect("index.html?message=success");
        }else {
            resp.sendRedirect("signup.html?message=invalid");
        }
    }
}
