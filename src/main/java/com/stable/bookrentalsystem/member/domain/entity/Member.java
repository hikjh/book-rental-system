package com.stable.bookrentalsystem.member.domain.entity;

import com.stable.bookrentalsystem.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Table
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private String email;
    private String password;
    private int point;

    @Builder
    public Member(String name, String email, String password, int point) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.point = point;
    }

    public static Member createMember(String name, String email, String password) {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .point(10)
                .build();
    }

    public void pointUp(int point) {
        this.point += point;
    }
}
