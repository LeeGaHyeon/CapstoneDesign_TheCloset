package capston.thecloset.domain;

import capston.thecloset.service.MemberInputDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @Column(unique = true, name = "user_id")
    private String userId; //로그인아이디,식별

    private String userName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
   private List<Item> ItemList = new ArrayList<>();

    @Column(name = "RegDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime regdt;//회원정보 등록

    @Column(name = "UptDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime udtDt;//회원정보 수정



    //createMember를 위한 생성자 , 다른 클래스에서 호출 불가능
    private Member(String userId, String userName, String email,String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = Role.ROLE_MEMBER;
        this.regdt = LocalDateTime.now();
    }

    //dto -> entity
    public static Member createMember(MemberInputDto parameter,PasswordEncoder passwordEncoder){
        String password = passwordEncoder.encode(parameter.getPassword());
        return new Member(parameter.getUserId(),parameter.getUserName(),parameter.getEmail(),password);
    }
}
