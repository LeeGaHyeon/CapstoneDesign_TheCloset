package capston.thecloset.service;

import capston.thecloset.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional//데이터베이스에 롤백
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;

    public Member createMember(){
        MemberInputDto memberInputDto = new MemberInputDto("adf155","고지연","adf555@naver.com","1234");
        return Member.createMember(memberInputDto);
    }


    @Test
    @DisplayName("회원가입 테스트")
   public void registerTest() {
        //given
        Member member = createMember();
        //when
        Member registerMember = memberService.register(member);
        //then
        assertThat(member).isEqualTo(registerMember);
        assertThat(member.getUserSn()).isEqualTo(registerMember.getUserSn());
        assertThat(member.getUserId()).isEqualTo(registerMember.getUserId());
        assertThat(member.getUserName()).isEqualTo(registerMember.getUserName());
        assertThat(member.getPassword()).isEqualTo(registerMember.getPassword());
        assertThat(member.getEmail()).isEqualTo(registerMember.getEmail());
        assertThat(member.getRegdt()).isEqualTo(registerMember.getRegdt());
        assertThat(member.getRole()).isEqualTo(registerMember.getRole());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMember(){
        Member member1 = createMember();
        Member member2 = createMember();
        memberService.register(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            memberService.register(member2);
        });
        assertThat("이미 가입된 회원입니다.").isEqualTo(e.getMessage());
    }
}