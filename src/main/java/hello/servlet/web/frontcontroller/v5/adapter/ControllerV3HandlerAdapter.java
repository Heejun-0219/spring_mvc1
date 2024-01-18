package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(Object handler, HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        final ControllerV3 controller = (ControllerV3) handler;
        final Map<String, String> paramMap = createParamMap(request);

        return controller.process(paramMap);
    }

    private Map<String, String> createParamMap(final jakarta.servlet.http.HttpServletRequest request) {
        final Map<String, String> paramMap = new java.util.HashMap<>();
        request.getParameterNames().asIterator()
            .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
