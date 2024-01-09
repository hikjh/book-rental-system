package com.stable.bookrentalsystem.rental.controller.dto;

public record RentalRequestDTO(
    Long memberId,
    Long bookId
) {}
