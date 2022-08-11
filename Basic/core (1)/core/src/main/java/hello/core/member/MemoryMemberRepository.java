package hello.core.member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//MemberRepository의 구현체, 원래 같은 패키지 보다 다른 패키지에 따로 두는 것이 좋다.
@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
