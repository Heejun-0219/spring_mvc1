package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyView {
    private String viewPath; // 논리 이름

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    // 이렇게 하면 논리 이름을 물리 이름으로 바꿔주는 코드가 중복되지 않는다.
    // 논리 이름을 물리 이름으로 바꾸는 것은 컨트롤러에서 담당하고, 물리 이름으로 forward 하는 것은 뷰에서 담당한다.
    // 이렇게 하면 논리 이름과 물리 이름이 중복되는 것도 피할 수 있다.
    // 논리 이름을 사용하는 대신에 물리 이름을 사용해도 된다.
    // 논리 이름을 사용하면 컨트롤러의 코드를 유지보수하기 좋고, 물리 이름을 사용하면 뷰를 실행하는 코드를 유지보수하기 좋다.
    // 논리 이름과 물리 이름을 분리하면 논리 이름을 기준으로 viewPath를 생성하는 코드를 한 곳에서 관리할 수 있다.
    // 논리 이름을 사용하면 컨트롤러 입장에서는 뷰의 내부 구조를 몰라도 되고, 뷰를 실행하는 입장에서는 컨트롤러의 내부 구조를 몰라도 된다.
}
