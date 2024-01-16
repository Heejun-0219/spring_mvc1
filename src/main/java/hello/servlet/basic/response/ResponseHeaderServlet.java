package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // [status-line]
        resp.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
//        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 캐시 무효화
        resp.setHeader("Pragma", "no-cache"); // 캐시 무효화
        resp.setHeader("my-header", "hello"); // 임의의 헤더 추가

        // [Header 편의 메서드]
        content(resp);
        cookie(resp);
        redirect(resp);

        // [message body]
        resp.getWriter().write("ok");
    }

    private void content(HttpServletResponse resp) {
        // Content-Type: text/plain;charset=utf-8
        // Content-Length: 2
        // resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        // resp.setContentLength(2); // (생략시 자동 생성)
    }

    private void cookie(HttpServletResponse resp) {
        // Set-Cookie: myCookie=good; Max-Age=600;
        // resp.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        resp.addCookie(new jakarta.servlet.http.Cookie("myCookie", "good"));
        resp.addHeader("Set-Cookie", "myCookie=good; Max-Age=600");
    }

    private void redirect(HttpServletResponse resp) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html
        // resp.setStatus(HttpServletResponse.SC_FOUND); // 302
        // resp.setHeader("Location", "/basic/hello-form.html");
        resp.sendRedirect("/basic/hello-form.html");
    }
}
