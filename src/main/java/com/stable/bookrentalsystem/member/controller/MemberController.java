package com.stable.bookrentalsystem.member.controller;

import com.stable.bookrentalsystem.member.controller.dto.MemberRequestDTO;
import com.stable.bookrentalsystem.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Long signUp(@RequestBody MemberRequestDTO dto) {
        return memberService.signUp(dto.name(), dto.email(), dto.password());
    }
}
