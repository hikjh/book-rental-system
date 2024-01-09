package com.stable.bookrentalsystem.rental.controller;

import com.stable.bookrentalsystem.rental.controller.dto.RentalRequestDTO;
import com.stable.bookrentalsystem.rental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/rentals")
@RestController
public class RentalController {

    private final RentalService rentalService;

    @PostMapping
    public Long rentBook(@RequestBody RentalRequestDTO dto) {
        return rentalService.rentBook(dto.memberId(), dto.bookId());
    }
}
