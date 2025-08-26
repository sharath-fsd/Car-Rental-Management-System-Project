package com.example.Carapp.Service;

import com.example.Carapp.Model.BookingRequest;
import com.example.Carapp.Repositorie.BookingRequestRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRequestRepositorie bookingRepo;

    public BookingRequest saveBooking(BookingRequest booking) {
        return bookingRepo.save(booking);
    }

    public List<BookingRequest> getAllBookings() {
        return bookingRepo.findAll();
    }

    public BookingRequest getBookingById(Long id) {
        return bookingRepo.findById(id).orElse(null);
    }

    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }
}
