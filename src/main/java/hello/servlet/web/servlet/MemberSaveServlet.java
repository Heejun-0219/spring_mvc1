package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberSaveServlet.service");
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();

        writer.write("<html>\n");
        writer.write("<head>\n");
        writer.write("    <meta charset=\"UTF-8\">\n");
        writer.write("    <title>Save</title>\n");
        writer.write("</head>\n");
        writer.write("<body>\n");
        writer.write("    <h1>성공</h1>\n");
        writer.write("    <ul>\n");
        writer.write("        <li>id="+member.getId()+"</li>\n");
        writer.write("        <li>username="+member.getUsername()+"</li>\n");
        writer.write("        <li>age="+member.getAge()+"</li>\n");
        writer.write("    </ul>\n");
        writer.write("    <a href=\"/index.html\">메인</a>\n");
        writer.write("</body>\n");
        writer.write("</html>\n");
    }
}
