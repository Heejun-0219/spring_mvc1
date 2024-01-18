package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username"); // 요청 파라미터에서 회원 이름을 조회한다.
        int age = Integer.parseInt(paramMap.get("age")); // 요청 파라미터에서 회원 나이를 조회한다.

        Member member = new Member(username, age); // 회원 저장 로직을 수행한다.
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result"); // Model에 데이터를 보관한다.
        mv.getModel().put("member", member);

        return mv;
    }
}
