package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// * == 하위의 어떤 값이 있던 상관없이 모두 매핑
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    // 생성자에서 매핑 정보를 저장
    // 미리 저장해놓고 사용
    // 키 값 : URL, 값 : 컨트롤러
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }


    // URL 매핑 정보에서 컨트롤러를 찾아서 호출
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        // 요청 URL을 가져온다.
         String requestURI = req.getRequestURI();

        // 매핑 정보에서 컨트롤러를 찾는다.
        // 각 객체 인스턴스 반환
        // 인터페이스를 사용한 이유는 다형성 때문
        // 인터페이스를 구현한 객체를 다형성으로 인터페이스 타입으로 참조 가능
        ControllerV1 controller = controllerMap.get(requestURI);

        // 컨트롤러가 없으면 404 상태코드 반환
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 컨트롤러 호출
        // 오버라이드된 인스턴스의 메서드가 호출된다.
        controller.process(req, resp);
    }
}
