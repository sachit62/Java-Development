import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firstServlet")
public class FirstServletApp extends HttpServlet {

    public FirstServletApp() {
        System.out.println("Servlet object created");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String userCity = request.getParameter("userCity");

        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello " + userName + "</h1>");
        writer.println("<p>Your city is " + userCity + "</p>");
        writer.close();
    }
}