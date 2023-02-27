package practice.rn.toy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import practice.rn.toy.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
