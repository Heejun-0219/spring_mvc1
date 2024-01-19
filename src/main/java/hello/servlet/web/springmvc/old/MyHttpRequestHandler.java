package hello.servlet.web.springmvc.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestHandler;

public class MyHttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, java.io.IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
