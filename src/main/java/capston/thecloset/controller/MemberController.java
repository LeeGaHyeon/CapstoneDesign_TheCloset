package capston.thecloset.controller;

import capston.thecloset.service.MemberInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/members/new")
    public String register(Model model) {
        model.addAttribute("memberInput",new MemberInputDto());
        return "members/register";
    }

    @PostMapping("/members/new")
    public String registerSubmit(){
        return "members/register";
    }
}
