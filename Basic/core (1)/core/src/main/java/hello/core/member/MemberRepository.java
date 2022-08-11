package hello.core.member;

public interface MemberRepository {
    //맴버를 저장하는 것
    void save(Member member);

    //맴버를 찾는 것
    Member findById(Long memberId);
}
