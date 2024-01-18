package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username"); // 회원가입 폼에서 전달받은 username을 꺼낸다.
        int age = Integer.parseInt(request.getParameter("age")); // 회원가입 폼에서 전달받은 age를 꺼낸다.

        // 회원 저장 로직을 수행한다.
        Member member = new Member(username, age);
        memberRepository.save(member);

        request.setAttribute("member", member); // Model에 데이터를 보관한다.

        // 논리 이름을 반환한다.
        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
