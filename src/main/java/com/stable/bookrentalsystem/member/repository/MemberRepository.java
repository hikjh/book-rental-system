package com.stable.bookrentalsystem.member.repository;

import com.stable.bookrentalsystem.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
