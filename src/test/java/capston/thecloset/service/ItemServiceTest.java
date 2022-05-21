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
import static org.assertj.core.api.InstanceOfAssertFactories.map;

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
        List<Item> itemList = itemService.findCategoryItem(item.getMember().getUserId(),item.getCategory().getValue());
        //then
        if(!itemList.isEmpty()) {
            Item findItem = itemList.get(0);
            assertThat(item.getCategory().getValue()).isEqualTo(findItem.getCategory().getValue());
            assertThat(item.getMember().getUserId()).isEqualTo(findItem.getMember().getUserId());
            assertThat(item.getFilepath()).isEqualTo(findItem.getFilename());
        }
    }

    @Test
    @DisplayName("유저 아이템 찾기")
    void findUserItem() {
        //given
        Member member1 = createMember();
        member1 = memberService.register(member1);

        Item item1 = new Item("filename1","filePath1","Pullover1");
        item1.setMember(member1);
        itemService.saveItem(item1);

        log.info("#####################!!!!!!!!!!################################");
        log.info("##########################"+item1.getMember().getUserId()+"\\\\\\");
        //when
        List<Item> itemList = itemService.findUserItem(item1.getMember().getUserId());

        if(!itemList.isEmpty()) {
            Item findItem = itemList.get(0);
            log.info("##########################"+findItem.getCategory().getValue()+"\\\\\\");
            assertThat(item1.getMember().getUserId()).isEqualTo(findItem.getMember().getUserId());
            assertThat(item1.getFilepath()).isEqualTo(findItem.getFilepath());
        }

    }



    public Member createMember(){
        MemberInputDto memberInputDto = new MemberInputDto("adf155","홍길동","adf555@naver.com","1234");
        return Member.createMember(memberInputDto,passwordEncoder);
    }

}