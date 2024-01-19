package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;

// 스프링 빈에 등록되는 이름 : /springmvc/old-controller
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");
    }

    // 스프링 빈에 등록되는 이름 : /WEB-INF/views/new-form.jsp
//    @Bean
//    InternalResourceView internalResourceView() {
//        return new InternalResourceView("/WEB-INF/views/new-form.jsp");
//    }
}
