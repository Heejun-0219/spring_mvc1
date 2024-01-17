package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MvcMemberSaveServlet.service");

        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        req.setAttribute("member", member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        req.getRequestDispatcher(viewPath).forward(req, resp);

        // req 객체에 데이터를 보관하고, RequestDispatcher를 사용해서 다른 서블릿이나 JSP로 이동할 수 있다.
        // 이때 RequestDispatcher를 사용하는 방법은 두 가지가 있다.
        // 1. RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //    dispatcher.forward(request, response);
        // 2. RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //    dispatcher.include(request, response);

        // forward
        // 다른 서블릿이나 JSP로 이동할 수 있다.
        // 서버 내부에서 다시 호출이 발생한다.
        // 클라이언트가 인지하지 못한다.
        // request, response 정보를 그대로 유지한다.
        // 서블릿에서 동적으로 HTML을 만들어서 응답으로 전달할 때 사용한다.
        // 서블릿이나 JSP가 공유하는 모델 데이터가 있으면 해당 데이터도 함께 전달할 수 있다.
        // MVC 패턴에서 주로 사용한다.

    }
}
