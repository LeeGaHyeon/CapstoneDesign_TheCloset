package capston.thecloset.controller;

import capston.thecloset.domain.Member;
import capston.thecloset.service.MemberInputDto;
import capston.thecloset.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/new")
    public String register(Model model) {

        model.addAttribute("memberInputDto", new MemberInputDto());
        return "register.html";
    }

    @PostMapping("/new")
    public String registerSubmit(@Valid MemberInputDto memberInputDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "register.html";
        }
        try{
            Member member = Member.createMember(memberInputDto,passwordEncoder);
            memberService.register(member);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "register.html";
        }
        return "redirect:/members/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg","아이디 비밀번호를 확인해주세요.");
        return "login.html";
    }
}
