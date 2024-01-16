package hello.servlet.basic;

import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends jakarta.servlet.http.HttpServlet {

    @Override
    protected void service(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, java.io.IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
