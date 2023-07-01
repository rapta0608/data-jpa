package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Transactional
@SpringBootTest
@Rollback(false)
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;


    @Test
    void testMember(){
        Member member=new Member("memeberA");
        Member findMember = memberRepository.save(member);

        Member member1 = memberRepository.findById(member.getId()).get();


        assertThat(findMember.getId()).isEqualTo(member1.getId());
        assertThat(findMember).isEqualTo(member1);


    }

}