package capston.thecloset.controller;

import capston.thecloset.domain.Category;
import capston.thecloset.domain.Item;
import capston.thecloset.service.ItemCategoryDto;
import capston.thecloset.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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

        String userId = principal.getName();
        itemService.upload(category,userId,file);

        //----item 리스트로 바로 가기로 변경하기
        return "redirect:/";
    }

  @GetMapping("/Item/Product/{category}")
    public String ItemList( Principal principal, Model model, @PathVariable("category") String category ){
        String userId = principal.getName();
        List<Item> itemList = null;
        List<ItemCategoryDto> itemCategoryDtoList=null;

        if(category.equals("ALL")){
           itemList = itemService.findUserItem(userId);
        }else {
            Category categoryEnum = Category.valueOf(category.toUpperCase());
            itemList = itemService.findCategoryItem(userId,categoryEnum);
        }
        itemCategoryDtoList=ItemCategoryDto.of(itemList);
       // model.addAttribute("items", itemCategoryDtoList);
        if(itemCategoryDtoList != null){
            model.addAttribute("items", itemCategoryDtoList);
            return "redirect:/Item/Product/"+category;
        }
        return  "product";
    }




}
