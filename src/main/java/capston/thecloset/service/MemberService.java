package capston.thecloset.service;

import capston.thecloset.domain.Member;
import capston.thecloset.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService implements UserDetailsService {


    private final MemberRepository memberRepository;


   @Transactional
    public Member register(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> findMember = memberRepository.findMemberByUserId(member.getUserId());
        if(findMember.isPresent()){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

  @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

      Optional<Member> optionalMember=memberRepository.findMemberByUserId(userId);
      if(optionalMember.isEmpty()){
          throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
      }
      Member member =optionalMember.get();

      List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
      grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

      return new User(member.getUserId(),member.getPassword(),grantedAuthorities);
    }
}