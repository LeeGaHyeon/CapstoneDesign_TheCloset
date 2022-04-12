package capston.thecloset.service;

import capston.thecloset.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class MemberInputDto {

    private String  userId; //name
    private String email;
    private String userName;
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
