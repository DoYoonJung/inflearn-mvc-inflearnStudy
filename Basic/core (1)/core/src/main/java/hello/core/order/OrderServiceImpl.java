package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final들을 바탕으로 자동으로 생성자를 만들어 주는 lombok의 어노테이션
public class OrderServiceImpl implements OrderService{

    private  final MemberRepository memberRepository;
    private  final DiscountPolicy discountPolicy;
    //위는 널 값을 가진다.
    //final은 값을 꼭 넣어줘야 된다.

    // 자동 의존관계 주입, ac.getBean(MemberRepository.class)하는 것과 같음
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;

    }
    // 생성자가 딱 하나 있으면 @Autowired를 생략할 수 있다.


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
