package com.stable.bookrentalsystem.member.controller.dto;

public record MemberRequestDTO(
    String name,
    String email,
    String password
) {}
