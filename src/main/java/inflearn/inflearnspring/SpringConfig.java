package inflearn.inflearnspring;

import inflearn.inflearnspring.repository.MemberRepository;
import inflearn.inflearnspring.repository.MemoryMemberRepository;
import inflearn.inflearnspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
