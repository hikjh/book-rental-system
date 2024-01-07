package com.stable.bookrentalsystem.repository.rental;

import com.stable.bookrentalsystem.domain.rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
