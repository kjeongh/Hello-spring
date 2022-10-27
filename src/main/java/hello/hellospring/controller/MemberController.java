package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
    public class MemberController {

        private final MemberService memberService;

        @Autowired //컨트롤러는 스프링 컨테이너가 처음 뜰때 생성이 되고, 그때 이 생성자 실행
        public MemberController(MemberService memberService) { //애노테이션
            this.memberService = memberService;
        }

    @GetMapping("/members/new")
    public String createForm() {

        return "members/createMemberForm";

    }


    @PostMapping("/members/new")
    public String create(MemberForm form) {

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return"redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}

