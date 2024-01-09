package com.stable.bookrentalsystem.rental.domain.valueobject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RentalStatus {

    RENTAL("대여"),
    RETURNED("반납"),
    OVERDUE("연체");

    private final String description;
}
