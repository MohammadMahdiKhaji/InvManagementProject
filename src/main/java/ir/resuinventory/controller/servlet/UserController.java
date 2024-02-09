package ir.resuinventory.controller.servlet;

import ir.resuinventory.model.entity.Role;
import ir.resuinventory.model.entity.User;
import ir.resuinventory.model.service.UserService;
import ir.resuinventory.model.utils.MailUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "UserController", urlPatterns = "/userController/*")
public class UserController extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String url = "/";
        if (requestURI.endsWith("/signupUser")) {
            url = signupUser(req, resp);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        String url = "/";
        if (requestURI.endsWith("/deleteCookies")) {
            url = deleteCookies(req, resp);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(req, resp);
    }

    private String signupUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setEmailActive(false);
        user.setRole(Role.Client);

        req.setAttribute("user", user);

        String url;
        String message;
        String temp = UserService.getUserService().userExists(user);

        if (temp.equals("username-password")) {
            message = "This user already exists. <br>"
                    + "Please enter another user info.";
            req.setAttribute("message", message);
            url = "/user/index.jsp";
        } else if (temp.equals("username")) {
            message = "This username already exists. <br>"
                    + "Please enter another username.";
            req.setAttribute("message", message);
            url = "/user/index.jsp";
        } else if (temp.equals("password")) {
            message = "This password already exists. <br>"
                    + "Please enter another password.";
            req.setAttribute("message", message);
            url = "/user/index.jsp";
        } else {
            UserService.getUserService().insert(user);
            message = "";
            MailUtil
                    .getMailUtil()
                    .sendMail(user.getEmail(),"email activation", "http://localhost:8080/api/userAPI/activeEmail/"+user.getPassword(), false);
            req.setAttribute("message", message);
            url = "/user/thanks.jsp";
        }
        return url;
    }

    private String deleteCookies(HttpServletRequest req, HttpServletResponse resp) {

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
        }
        return "/delete_cookies.jsp";
    }


}
