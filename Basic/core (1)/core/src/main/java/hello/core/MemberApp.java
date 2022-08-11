package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

/*
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //Spring은 모두 ApplicationContext라는 걸로 시작함, 이게 Spring container라고 보면 됨 (즉, Appconfig에 있는 객체들,
        // @Bean들을 관리해 주는 것으로 생각하며 됨)

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //getBean() 안에는 첫번째로 메서드 이름이 두번째는 타입이 들어간다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}