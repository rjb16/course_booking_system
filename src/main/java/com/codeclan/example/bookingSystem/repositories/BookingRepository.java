package com.codeclan.example.bookingSystem.repositories;

import com.codeclan.example.bookingSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
