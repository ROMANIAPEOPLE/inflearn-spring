package inflearn.inflearnspring.Controller;

import inflearn.inflearnspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;


    //멤버 컨트롤러가 생성이 될떄 스프링빈에 등록되어있는 멤버서비스를 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
