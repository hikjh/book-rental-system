package com.stable.bookrentalsystem.rental.service;

import com.stable.bookrentalsystem.book.domain.entity.Book;
import com.stable.bookrentalsystem.book.repository.BookRepository;
import com.stable.bookrentalsystem.member.domain.entity.Member;
import com.stable.bookrentalsystem.member.repository.MemberRepository;
import com.stable.bookrentalsystem.rental.domain.entity.Rental;
import com.stable.bookrentalsystem.rental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.stable.bookrentalsystem.rental.domain.entity.Rental.createRental;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final RentalRepository rentalRepository;

    @Override
    @Transactional
    public Long rentBook(Long memberId, Long bookId) {

//        Member member = memberRepository.findById(memberId)
//                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
        Member member = Member.createMember("홍길동", "홍길동이메일", "홍길동비번");

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 도서입니다."));

        Rental rental = createRental(member, book);
        return rentalRepository.save(rental).getId();
    }
}
