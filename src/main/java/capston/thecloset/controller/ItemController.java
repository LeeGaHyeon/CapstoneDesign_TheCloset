package capston.thecloset.controller;

import capston.thecloset.service.ItemService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {


    private final ItemService itemService;

    @GetMapping("/Item/upload")
    public String itemUpload(Model model){
        return "upload";
    }

    @PostMapping("/Item/upload")
    public String ItemUploadSubmit(@RequestParam String category, @RequestParam MultipartFile file,Principal principal) throws Exception{

        String memberId = principal.getName();

        itemService.upload(category,memberId,file);

        //----item 리스트로 바로 가기로 변경하기
        return "redirect:/";
    }

    @GetMapping({"/Item/Product/{Category}","/Item/Product"})
    public String ItemList(Principal principal, Model model, @PathVariable String Category){




       return  "product";
    }

}
