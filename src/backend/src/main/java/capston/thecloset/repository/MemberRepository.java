package capston.thecloset.repository;

import capston.thecloset.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,String> {


   Optional<Member> findMemberByUserId(String userId);
}
