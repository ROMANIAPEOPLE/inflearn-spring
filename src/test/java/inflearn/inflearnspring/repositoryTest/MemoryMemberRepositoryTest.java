package inflearn.inflearnspring.repositoryTest;

import inflearn.inflearnspring.domain.Member;
import inflearn.inflearnspring.repository.MemberRepository;
import inflearn.inflearnspring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //메서드가 한번 실행될때마다 실행되도록 설정하는 어노테이션
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member  member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(result,member);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member mem1 = new Member();
        mem1.setName("spring1");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setName("spring2");
        repository.save(mem2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(mem1);
    }

    @Test
    public void findAll(){
        Member mem1 = new Member();
        mem1.setName("spring1");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setName("spring2");
        repository.save(mem2);

        List<Member> list = repository.findAll();

        assertThat(list.size()).isEqualTo(2);

    }


}
