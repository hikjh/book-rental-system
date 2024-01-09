package com.stable.bookrentalsystem.rental.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CustomRentalRepositoryImpl implements CustomRentalRepository {

    private final JPAQueryFactory jpaQueryFactory;
}
