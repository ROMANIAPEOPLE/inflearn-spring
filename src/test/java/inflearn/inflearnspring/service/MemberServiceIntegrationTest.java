package inflearn.inflearnspring.service;

import inflearn.inflearnspring.domain.Member;
import inflearn.inflearnspring.repository.MemberRepository;
import inflearn.inflearnspring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional //테스트케이스에 이거 달면, 테스트끝나면 롤백해줌(데이터 반영X)

class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired
    MemberRepository repository;


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring"); //hello라는 이름의 멤버로 회원가입을 시도함

        //when
        Long saveId = memberService.join(member); //방금 회원가입한 멤버의 ID를 가져옴

        //then
        Member findMember =memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);

        IllegalStateException e= assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 ID 입니다.");

//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 ID 입니다.");
//        }


        //then
    }

    @Test
    void 모든회원검색() {
    }

    @Test
    void 회원검색() {
    }
}