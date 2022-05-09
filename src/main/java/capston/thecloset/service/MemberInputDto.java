package capston.thecloset.service;

import capston.thecloset.domain.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
public class MemberInputDto {

    private String  userId;
    private String email;
    private String userName;

    @Length(min=8,max = 12,message = "비밀번호 8자 이상, 12자 이하로 입력해주세요")
    private String password;


    public MemberInputDto(String userId,String userName, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    //entity -> dto
    public static MemberInputDto of(Member member){
        return MemberInputDto.builder()
                .userId(member.getUserId())
                .userName(member.getUserName())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }

}
