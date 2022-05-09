package capston.thecloset.controller;

import capston.thecloset.domain.Member;
import capston.thecloset.service.MemberInputDto;
import capston.thecloset.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private MockMvc mockMvc;

    public Member createMember(String userId,String password){
        MemberInputDto memberInputDto = new MemberInputDto(userId,"고지연","adf555@naver.com",password);
        Member member = Member.createMember(memberInputDto,passwordEncoder);
        return memberService.register(member);
    }

    @Test
    @DisplayName("로그인 성공테스트")
    public void loginSuccessTest() throws Exception{
        String userId="adf155";
        String password="1234";
        this.createMember(userId,password);

        mockMvc.perform(formLogin().userParameter("userId")
                .loginProcessingUrl("/members/login")
                .user(userId).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }

    @Test
    @DisplayName("로그인 실패 테스트")
    public void loginFailTest() throws Exception{
        String userId="adf155";
        String password="1234";
        this.createMember(userId,password);
        mockMvc.perform(formLogin().userParameter("userId")
                .loginProcessingUrl("/members/login")
                .user(userId).password("11111"))
                .andExpect(SecurityMockMvcResultMatchers.unauthenticated());
    }
}