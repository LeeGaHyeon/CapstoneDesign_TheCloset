package capston.thecloset.service;

import capston.thecloset.domain.Category;
import capston.thecloset.domain.Item;
import capston.thecloset.domain.Member;
import capston.thecloset.repository.ItemRepository;
import capston.thecloset.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
@Transactional
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;


    @Transactional
    public void upload(String category,String memberId,MultipartFile file) throws Exception{
        //file을 local에 저장
        String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid +"_"+file.getOriginalFilename();//

        File saveFile = new File(projectPath,fileName); // 컴퓨터에 이미지 저장
        file.transferTo(saveFile);

        String filePath="/files/"+fileName;

        // item 생성 및 연관 관계 주입
        Item item =  new Item(fileName,filePath,category);
        OptionalMember(memberId, item);

        saveItem(item);
    }

    public void OptionalMember(String memberId, Item item) {
        Optional<Member> findMember = memberRepository.findById(memberId);
        if(findMember.isPresent()){
            Member member = findMember.get();
            item.setMember(member);
        }
    }

    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> findCategoryItem(String userId, Category category){

       return itemRepository.findItemByCategoryAndUserId(userId,category);
    }
    public List<Item> findUserItem(String userId){
        return itemRepository.findItemByUserId(userId);
    }

}
