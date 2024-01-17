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
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberListServlet.service");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        resp.getWriter().write("<html>\n");
        resp.getWriter().write("<head>\n");
        resp.getWriter().write("    <meta charset=\"UTF-8\">\n");
        resp.getWriter().write("    <title>Save</title>\n");
        resp.getWriter().write("</head>\n");
        resp.getWriter().write("<body>\n");
        resp.getWriter().write("    <a href=\"/index.html\">메인</a>\n");
        resp.getWriter().write("    <table>\n");
        resp.getWriter().write("        <thead>\n");
        resp.getWriter().write("            <th>id</th>\n");
        resp.getWriter().write("            <th>username</th>\n");
        resp.getWriter().write("            <th>age</th>\n");
        resp.getWriter().write("        </thead>\n");
        resp.getWriter().write("        <tbody>\n");
        memberRepository.findAll().forEach(member -> {
            try {
                resp.getWriter().write("        <tr>\n");
                resp.getWriter().write("            <td>"+member.getId()+"</td>\n");
                resp.getWriter().write("            <td>"+member.getUsername()+"</td>\n");
                resp.getWriter().write("            <td>"+member.getAge()+"</td>\n");
                resp.getWriter().write("        </tr>\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
//        List<Member> members = memberRepository.findAll();
//        for (Member member : members) {
//            resp.getWriter().write("        <tr>\n");
//            resp.getWriter().write("            <td>"+member.getId()+"</td>\n");
//            resp.getWriter().write("            <td>"+member.getUsername()+"</td>\n");
//            resp.getWriter().write("            <td>"+member.getAge()+"</td>\n");
//            resp.getWriter().write("        </tr>\n");
//        }
        resp.getWriter().write("        </tbody>\n");
        resp.getWriter().write("    </table>\n");
        resp.getWriter().write("</body>\n");
        resp.getWriter().write("</html>\n");
    }
}
