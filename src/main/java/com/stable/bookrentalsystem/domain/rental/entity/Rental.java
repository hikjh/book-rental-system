package com.stable.bookrentalsystem.domain.rental.entity;

import com.stable.bookrentalsystem.domain.BaseTimeEntity;
import com.stable.bookrentalsystem.domain.book.entity.Book;
import com.stable.bookrentalsystem.domain.member.entity.Member;
import com.stable.bookrentalsystem.domain.rental.valueobject.RentalStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Table
@Entity
public class Rental extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDateTime rentedAt;
    private boolean isReturned;
    private boolean isOverdue;
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    @Builder
    public Rental(Member member, Book book, LocalDateTime rentedAt, boolean isReturned, boolean isOverdue, RentalStatus rentalStatus) {
        this.member = member;
        this.book = book;
        this.rentedAt = rentedAt;
        this.isReturned = isReturned;
        this.isOverdue = isOverdue;
        this.rentalStatus = rentalStatus;
    }

    public static Rental of(Member member, Book book) {
        return Rental.builder()
                .member(member)
                .book(book)
                .rentedAt(LocalDateTime.now())
                .isReturned(false)
                .isOverdue(false)
                .rentalStatus(RentalStatus.RENTAL)
                .build();
    }
}
