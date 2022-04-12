package capston.thecloset.service;

import capston.thecloset.domain.Member;
import capston.thecloset.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;


    @Override
    public Member register(Member member) {
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> findMember = memberRepository.findByUserId(member.getUserId());
        if(findMember.isPresent()){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
