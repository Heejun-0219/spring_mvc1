package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
        printEtc(req);
    }

    // start line 정보
    private void printStartLine(HttpServletRequest req) {
        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("req.getMethod() = " + req.getMethod()); // GET
        System.out.println("req.getProtocal() = " + req.getProtocol()); // HTTP/1.1
        System.out.println("req.getScheme() = " + req.getScheme()); // http

        // http://localhost:8080/request-header
        System.out.println("req.getRequestURL() = " + req.getRequestURL());

        // /request-test
        System.out.println("req.getRequestURI() = " + req.getRequestURI());

        // username=hi
        System.out.println("req.getQueryString() = " + req.getQueryString());

        // https 사용 유무
        System.out.println("req.isSecure() = " + req.isSecure());

        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("--- Headers - start ---");

//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + ": " + req.getHeader(headerName));
//        }

        // 위의 while문을 람다식으로 표현
        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + req.getHeader(headerName)));
        
        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("--- Header 편의 조회 start ---");

        System.out.println("[Host 편의 조회]");
        System.out.println("req.getServerName() = " + req.getServerName()); // Host 헤더
        System.out.println("req.getServerPort() = " + req.getServerPort()); // Host 헤더

        System.out.println("[Accept-Language 편의 조회]");
        // req.getLocales()는 Enumeration<Locale>을 반환한다.
        // 주로 사용할 언어 정보 순서대로 반환한다.
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("req.getLocale() = " + req.getLocale());

        System.out.println("[cookie 편의 조회]");
        if (req.getCookies() != null) {
            for (jakarta.servlet.http.Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }

        System.out.println("[Content 편의 조회]");
        System.out.println("req.getContentType() = " + req.getContentType());
        System.out.println("req.getContentLength() = " + req.getContentLength());
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());

        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }

    private void printEtc(HttpServletRequest req) {
        System.out.println("--- 기타 조회 start ---");

        System.out.println("[Remote 정보]");
        System.out.println("req.getRemoteHost() = " + req.getRemoteHost()); // 클라이언트 IP
        System.out.println("req.getRemoteAddr() = " + req.getRemoteAddr()); // 클라이언트 IP
        System.out.println("req.getRemotePort() = " + req.getRemotePort()); // 클라이언트 IP

        System.out.println("[Local 정보]");
        System.out.println("req.getLocalName() = " + req.getLocalName()); // 내 서버 IP
        System.out.println("req.getLocalAddr() = " + req.getLocalAddr()); // 내 서버 IP
        System.out.println("req.getLocalPort() = " + req.getLocalPort()); // 내 서버 IP

        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }
}
