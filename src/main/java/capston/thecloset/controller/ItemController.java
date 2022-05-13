package capston.thecloset.controller;

import capston.thecloset.service.ItemService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public String ItemUploadSubmit(@RequestParam MultipartFile file, Principal principal) throws Exception{

        String memberId = principal.getName();

        itemService.upload(memberId,file);

        //----item 리스트로 바로 가기로 변경하기
        return "redirect:/";
    }

}
