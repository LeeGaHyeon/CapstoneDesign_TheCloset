package capston.thecloset.service;

import capston.thecloset.domain.Item;
import capston.thecloset.domain.Member;
import capston.thecloset.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@WebAppConfiguration
@SpringBootTest
@Transactional
@Slf4j
class ItemServiceTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ItemService itemService;
    @Autowired
    MemberService memberService;

    @Autowired
    ItemRepository itemRepository;

    @Transactional
    @Test
    @DisplayName("카테고리별 아이템찾기")
    void findCategoryItem() {
        //given
        Member member = createMember();
        member = memberService.register(member);

        Item item = new Item("filename","filePath","Pullover");
        item.setMember(member);
        itemService.saveItem(item);

        //when
        List<Item> itemList = itemService.findCategoryItem(item.getMember().getUserId(),item.getCategory());
        List<ItemCategoryDto> itemCategoryDtoList = ItemCategoryDto.of(itemList);
        //the
        if(!itemList.isEmpty()) {
            Item findItem = itemList.get(0);
            assertThat(item.getCategory()).isEqualTo(findItem.getCategory());
            assertThat(item.getMember().getUserId()).isEqualTo(findItem.getMember().getUserId());
            assertThat(item.getFilepath()).isEqualTo(findItem.getFilename());

            //List -> Dto로 변환 검증
            ItemCategoryDto itemCategoryDto = itemCategoryDtoList.get(0);
            assertThat(findItem.getCategory()).isEqualTo(itemCategoryDto.getCategory());
            assertThat(findItem.getFilepath()).isEqualTo(itemCategoryDto.getFilePath());
        }
    }

    @Test
    @DisplayName("유저 아이템 찾기")
    void findUserItem() {
        //given
        Item item1 = createItem();
        //when
        List<Item> itemList = itemService.findUserItem(item1.getMember().getUserId());
        List<ItemCategoryDto> itemCategoryDtoList = ItemCategoryDto.of(itemList);

        if(!itemList.isEmpty()) {
            Item findItem = itemList.get(0);
            assertThat(item1.getMember().getUserId()).isEqualTo(findItem.getMember().getUserId());
            assertThat(item1.getFilepath()).isEqualTo(findItem.getFilepath());

            ItemCategoryDto itemCategoryDto = itemCategoryDtoList.get(0);
            //assertThat(findItem.getMember().getUserId()).isEqualTo(itemCategoryDto.getUserId());
            assertThat(findItem.getCategory()).isEqualTo(itemCategoryDto.getCategory());
            assertThat(findItem.getFilepath()).isEqualTo(itemCategoryDto.getFilePath());
        }
    }

    private Item createItem() {
        Member member1 = createMember();
        member1 = memberService.register(member1);
        Item item1 = new Item("filename1","filePath1","Pullover");
        item1.setMember(member1);
        itemService.saveItem(item1);
        return item1;
    }


    public Member createMember(){
        MemberInputDto memberInputDto = new MemberInputDto("adf155","홍길동","adf555@naver.com","1234");
        return Member.createMember(memberInputDto,passwordEncoder);
    }

}