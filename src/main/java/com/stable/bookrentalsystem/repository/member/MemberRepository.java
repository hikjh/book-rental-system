package com.stable.bookrentalsystem.repository.member;

import com.stable.bookrentalsystem.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
