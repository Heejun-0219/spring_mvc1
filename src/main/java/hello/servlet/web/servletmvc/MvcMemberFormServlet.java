package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 서블릿에서 jsp를 호출할 수 있도록 해주는 객체
        // 리다이렉트가 아닌 서버 내부에서 호출하는 것이기 때문에 WEB-INF 폴더 내부에 있는 jsp 파일을 호출할 수 있다.

        // WEB-INF 폴더 내부에 있는 jsp 파일은 외부에서 직접 호출할 수 없다. WAS가 호출할 수 있도록 설정되어 있다.
        dispatcher.forward(request, response);
    }
}
