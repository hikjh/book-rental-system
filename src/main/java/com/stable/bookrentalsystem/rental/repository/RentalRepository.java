package com.stable.bookrentalsystem.rental.repository;

import com.stable.bookrentalsystem.rental.domain.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
