package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    @BeforeEach // 각 테스트 실행전에 호출되는 어노테이션
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join(){
        //give
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        //Assertions는 검증을 위한 것이다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
