package capston.thecloset.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {


    @GetMapping({"/",""})
    public String home(){

        return "index.html";
    }

}
