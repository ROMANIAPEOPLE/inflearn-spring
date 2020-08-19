package inflearn.inflearnspring.repository;

import inflearn.inflearnspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long> , MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
