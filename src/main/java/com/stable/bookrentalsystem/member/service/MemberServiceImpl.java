package com.stable.bookrentalsystem.member.service;

import com.stable.bookrentalsystem.member.domain.entity.Member;
import com.stable.bookrentalsystem.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.stable.bookrentalsystem.member.domain.entity.Member.createMember;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long signUp(String name, String email, String password) {
        Member member = createMember(name, email, password);
        return memberRepository.save(member).getId();
    }
}
